/*
 * Copyright 2023 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.internal.http;

import java.util.List;
import org.apache.hc.client5.http.ConnectTimeoutException;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.RequestAbortedException;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.util.TimeValue;

import javax.net.ssl.SSLException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public enum EnumRetryPolicy {

    /**
     * Removed ConnectException, trying to retry if connection refused.
     */
    DEFAULT_RETRY_POLICY(ClientConfiguration.DEFAULT_RETRY_NUMBER, ClientConfiguration.DEFAULT_RETRY_NON_IDEMPOTENT_ENABLE) {
        @Override
        public DefaultHttpRequestRetryStrategy createPolicy(int retryNumber, boolean retry) {
            return new DefaultHttpRequestRetryStrategy(retryNumber, TimeValue.ofSeconds(1), Arrays.asList(
                    InterruptedIOException.class,
                    UnknownHostException.class,
                    SSLException.class), List.of()) {
                @Override
                protected boolean handleAsIdempotent(HttpRequest request) {
                    return super.handleAsIdempotent(request) || retry;
                }
            };
        }
    },

    /**
     * Removed SocketTimeoutException, trying to retry if connection read time out.
     */
    RETRY_READ_TIMEOUT_POLICY(ClientConfiguration.DEFAULT_RETRY_NUMBER, ClientConfiguration.DEFAULT_RETRY_NON_IDEMPOTENT_ENABLE) {
        @Override
        public DefaultHttpRequestRetryStrategy createPolicy(int retryNumber, boolean retry) {
            return new DefaultHttpRequestRetryStrategy(retryNumber, TimeValue.ofSeconds(1), Arrays.asList(
                ConnectTimeoutException.class,
                RequestAbortedException.class,

                UnknownHostException.class,
                ConnectException.class,
                SSLException.class), List.of()) {
                @Override
                protected boolean handleAsIdempotent(HttpRequest request) {
                    return super.handleAsIdempotent(request) || retry;
                }
            };
        }
    },
    ;

    private final AtomicReference<DefaultHttpRequestRetryStrategy> handler = new AtomicReference<>();

    private final int retryNumber;
    private final boolean requestSentRetryEnabled;

    EnumRetryPolicy(int retryNumber, boolean requestSentRetryEnabled) {
        this.retryNumber = retryNumber;
        this.requestSentRetryEnabled = requestSentRetryEnabled;
    }

    public DefaultHttpRequestRetryStrategy getPolicy() {
        DefaultHttpRequestRetryStrategy handlerLocal = handler.get();
        if (handlerLocal == null) {
            synchronized (this) {
                handlerLocal = handler.get();
                if (handlerLocal == null) {
                    handlerLocal = createPolicy(retryNumber, requestSentRetryEnabled);
                    handler.set(handlerLocal);
                }
            }
        }
        return handlerLocal;
    }

    abstract DefaultHttpRequestRetryStrategy createPolicy(int retryNumber, boolean requestSentRetryEnabled);
}
