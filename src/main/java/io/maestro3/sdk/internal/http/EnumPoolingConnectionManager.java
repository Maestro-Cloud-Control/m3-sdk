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

import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.nio.AsyncClientConnectionManager;

import java.util.concurrent.atomic.AtomicReference;

public enum EnumPoolingConnectionManager {

    DEFAULT_POOLING_CONNECTION_MANAGER(ClientConfiguration.DEFAULT_MAX_CONNECTIONS, ClientConfiguration.DEFAULT_MAX_CONNECTIONS_PER_ROUTE) {
        @Override
        HttpClientConnectionManager createManager(int maxConnections, int maxConnectionsPerRoute) {
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
            connectionManager.setMaxTotal(maxConnections);
            connectionManager.setDefaultMaxPerRoute(maxConnectionsPerRoute);
            return connectionManager;
        }

        @Override
        AsyncClientConnectionManager createAsyncManager(int maxConnections, int maxConnectionsPerRoute) {
            PoolingAsyncClientConnectionManager connectionManager = new PoolingAsyncClientConnectionManager();
            connectionManager.setMaxTotal(maxConnections);
            connectionManager.setDefaultMaxPerRoute(maxConnectionsPerRoute);
            return connectionManager;
        }
    };

    private final AtomicReference<HttpClientConnectionManager> clientConnectionManager = new AtomicReference<>();
    private final AtomicReference<AsyncClientConnectionManager> asyncClientConnectionManager = new AtomicReference<>();

    private final int maxConnections;
    private final int maxConnectionsPerRoute;

    EnumPoolingConnectionManager(int maxConnections, int maxConnectionsPerRoute) {
        this.maxConnections = maxConnections;
        this.maxConnectionsPerRoute = maxConnectionsPerRoute;
    }

    public HttpClientConnectionManager getManager() {
        HttpClientConnectionManager clientConnectionManagerLocal = clientConnectionManager.get();
        if (clientConnectionManagerLocal == null) {
            synchronized (this) {
                clientConnectionManagerLocal = clientConnectionManager.get();
                if (clientConnectionManagerLocal == null) {
                    clientConnectionManagerLocal = createManager(maxConnections, maxConnectionsPerRoute);
                    clientConnectionManager.set(clientConnectionManagerLocal);
                }
            }
        }
        return clientConnectionManagerLocal;
    }

    public AsyncClientConnectionManager getAsyncManager() {
        AsyncClientConnectionManager asyncClientConnectionManagerLocal = asyncClientConnectionManager.get();
        if (asyncClientConnectionManagerLocal == null) {
            synchronized (this) {
                asyncClientConnectionManagerLocal = asyncClientConnectionManager.get();
                if (asyncClientConnectionManagerLocal == null) {
                    asyncClientConnectionManagerLocal = createAsyncManager(maxConnections, maxConnectionsPerRoute);
                    asyncClientConnectionManager.set(asyncClientConnectionManagerLocal);
                }
            }
        }
        return asyncClientConnectionManagerLocal;
    }

    abstract HttpClientConnectionManager createManager(int maxConnections, int maxConnectionsPerRoute);

    abstract AsyncClientConnectionManager createAsyncManager(int maxConnections, int maxConnectionsPerRoute);
}
