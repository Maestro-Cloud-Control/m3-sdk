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

import io.maestro3.sdk.internal.http.impl.M3AsyncHttpClient;
import io.maestro3.sdk.internal.http.impl.M3HttpClient;
import io.maestro3.sdk.internal.provider.IM3ServerContextProvider;
import io.maestro3.sdk.v3.core.M3ServerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public final class CacheableM3HttpClientFactory {

    private static final Logger LOG = LoggerFactory.getLogger(CacheableM3HttpClientFactory.class);

    private static final int MAX_CACHE_SIZE = 100;

    private static Map<M3ServerContext, M3HttpClient> clientCache = new LinkedHashMap<M3ServerContext, M3HttpClient>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry<M3ServerContext, M3HttpClient> eldest) {
            return size() > MAX_CACHE_SIZE;
        }
    };

    private static Map<M3ServerContext, M3AsyncHttpClient> asyncClientCache = new LinkedHashMap<M3ServerContext, M3AsyncHttpClient>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry<M3ServerContext, M3AsyncHttpClient> eldest) {
            return size() > MAX_CACHE_SIZE;
        }
    };

    private CacheableM3HttpClientFactory() {
        throw new UnsupportedOperationException("Instantiation is forbidden.");
    }

    public static IM3HttpClient getClient(IM3ServerContextProvider serverContextProvider,
                                          EnumRetryPolicy retryPolicy,
                                          EnumRequestConfig requestConfig) {
        M3ServerContext m3ServerContext = serverContextProvider.getContext();
        if (clientCache.containsKey(m3ServerContext)) {
            LOG.debug("Giving cached M3HttpClient for server context: {}", m3ServerContext);
            return clientCache.get(m3ServerContext);
        }
        LOG.debug("Creating new M3HttpClient for server context: {}", m3ServerContext);
        return createSync(m3ServerContext, retryPolicy, requestConfig);
    }

    public static IM3HttpClient getAsyncClient(IM3ServerContextProvider serverContextProvider,
                                               EnumRequestConfig requestConfig) {
        M3ServerContext m3ServerContext = serverContextProvider.getContext();
        if (asyncClientCache.containsKey(m3ServerContext)) {
            LOG.debug("Giving cached M3HttpClient for server context: {}", m3ServerContext);
            return asyncClientCache.get(m3ServerContext);
        }
        LOG.debug("Creating new M3HttpClient for server context: {}", m3ServerContext);
        return createAsync(m3ServerContext, requestConfig);
    }

    private static M3HttpClient createSync(M3ServerContext context,
                                           EnumRetryPolicy retryPolicy,
                                           EnumRequestConfig requestConfig) {
        M3HttpClient client = new M3HttpClient(context, retryPolicy, requestConfig);
        clientCache.put(context, client);
        return client;
    }

    private static M3AsyncHttpClient createAsync(M3ServerContext context,
                                                 EnumRequestConfig requestConfig) {
        M3AsyncHttpClient client = new M3AsyncHttpClient(context, requestConfig);
        asyncClientCache.put(context, client);
        return client;
    }
}
