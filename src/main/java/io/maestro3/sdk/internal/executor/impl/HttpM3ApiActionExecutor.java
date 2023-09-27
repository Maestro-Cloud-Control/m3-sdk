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

package io.maestro3.sdk.internal.executor.impl;

import io.maestro3.sdk.internal.http.CacheableM3HttpClientFactory;
import io.maestro3.sdk.internal.http.EnumRequestConfig;
import io.maestro3.sdk.internal.http.EnumRetryPolicy;
import io.maestro3.sdk.internal.http.IM3HttpClient;
import io.maestro3.sdk.internal.provider.IM3AccessKeyProvider;
import io.maestro3.sdk.internal.provider.IM3ServerContextProvider;
import io.maestro3.sdk.internal.signer.IM3Signer;
import io.maestro3.sdk.v3.core.M3ApiRequest;

public class HttpM3ApiActionExecutor extends AbstractM3ApiActionExecutor {

    private final IM3ServerContextProvider serverContextProvider;
    private final EnumRetryPolicy retryPolicy;
    private final EnumRequestConfig requestConfig;

    public HttpM3ApiActionExecutor(IM3AccessKeyProvider accessKeyProvider,
                                   IM3Signer signer,
                                   IM3ServerContextProvider serverContextProvider) {
        this(accessKeyProvider, signer, serverContextProvider,
                EnumRetryPolicy.DEFAULT_RETRY_POLICY, EnumRequestConfig.DEFAULT_REQUEST_CONFIG);
    }

    public HttpM3ApiActionExecutor(IM3AccessKeyProvider accessKeyProvider,
                                   IM3Signer signer,
                                   IM3ServerContextProvider serverContextProvider,
                                   EnumRetryPolicy retryPolicy,
                                   EnumRequestConfig requestConfig) {
        super(accessKeyProvider, signer);
        this.serverContextProvider = serverContextProvider;
        this.retryPolicy = retryPolicy;
        this.requestConfig = requestConfig;
    }

    @Override
    protected String execute(M3ApiRequest request) {
        return getHttpClient().executePost(request);
    }

    @Override
    protected void executeAsync(M3ApiRequest request) {
        getAsyncHttpClient().executePost(request);
    }

    private IM3HttpClient getHttpClient() {
        return CacheableM3HttpClientFactory.getClient(serverContextProvider, retryPolicy, requestConfig);
    }

    private IM3HttpClient getAsyncHttpClient() {
        return CacheableM3HttpClientFactory.getAsyncClient(serverContextProvider, requestConfig);
    }

    @Override
    public void close() throws Exception {
        // do nothing
    }
}
