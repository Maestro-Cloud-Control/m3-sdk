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

package io.maestro3.sdk.internal.http.impl;

import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.http.EnumPoolingConnectionManager;
import io.maestro3.sdk.internal.http.EnumRequestConfig;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.core.M3ApiRequest;
import io.maestro3.sdk.v3.core.M3ServerContext;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class M3AsyncHttpClient extends AbstractM3HttpClient {

    private static final Logger LOG = LoggerFactory.getLogger(M3AsyncHttpClient.class);

    private CloseableHttpAsyncClient asyncHttpClient;

    public M3AsyncHttpClient(M3ServerContext serverContext,
                             EnumRequestConfig requestConfig) {
        this(serverContext, EnumPoolingConnectionManager.DEFAULT_POOLING_CONNECTION_MANAGER,
                requestConfig);
    }

    private M3AsyncHttpClient(M3ServerContext serverContext,
                              EnumPoolingConnectionManager poolingConnectionManager,
                              EnumRequestConfig requestConfig) {
        super(serverContext);
        this.asyncHttpClient = HttpAsyncClients.custom()
                .setConnectionManager(poolingConnectionManager.getAsyncManager())
                .setDefaultRequestConfig(requestConfig.getConfig())
                .build();
    }

    @Override
    public String executePost(M3ApiRequest request) {
        if (!asyncHttpClient.isRunning()) {
            asyncHttpClient.start();
        }
        try {
            final HttpPost httpRequest = getHttpRequest(request, true);
            asyncHttpClient.execute(httpRequest, new FutureCallback<HttpResponse>() {
                @Override
                public void completed(HttpResponse httpResponse) {
                    LOG.info("Finished processing request : {} . Response : {}", request, httpResponse);
                }

                @Override
                public void failed(Exception e) {
                    LOG.error("Failed to process async http request: {}",  request, e);
                }

                @Override
                public void cancelled() {
                    LOG.warn("Canceled async http request.");
                }
            });
            return StringUtils.EMPTY_STRING;
        } catch (Exception ex) {
            throw new M3SdkException("Error during request execution", ex);
        }
    }

}
