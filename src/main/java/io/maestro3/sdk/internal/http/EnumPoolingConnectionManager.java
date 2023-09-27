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

import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.nio.conn.NHttpClientConnectionManager;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;

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
        NHttpClientConnectionManager createAsyncManager(int maxConnections, int maxConnectionsPerRoute) throws IOReactorException {
            ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor();
            PoolingNHttpClientConnectionManager connectionManager = new PoolingNHttpClientConnectionManager(ioReactor);
            connectionManager.setMaxTotal(maxConnections);
            connectionManager.setDefaultMaxPerRoute(maxConnectionsPerRoute);
            return connectionManager;
        }
    };

    private final AtomicReference<HttpClientConnectionManager> clientConnectionManager = new AtomicReference<>();
    private final AtomicReference<NHttpClientConnectionManager> asyncClientConnectionManager = new AtomicReference<>();

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

    public NHttpClientConnectionManager getAsyncManager() {
        NHttpClientConnectionManager asyncClientConnectionManagerLocal = asyncClientConnectionManager.get();
        if (asyncClientConnectionManagerLocal == null) {
            synchronized (this) {
                asyncClientConnectionManagerLocal = asyncClientConnectionManager.get();
                if (asyncClientConnectionManagerLocal == null) {
                    try {
                        asyncClientConnectionManagerLocal = createAsyncManager(maxConnections, maxConnectionsPerRoute);
                        asyncClientConnectionManager.set(asyncClientConnectionManagerLocal);
                    } catch (IOReactorException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
            }
        }
        return asyncClientConnectionManagerLocal;
    }

    abstract HttpClientConnectionManager createManager(int maxConnections, int maxConnectionsPerRoute);

    abstract NHttpClientConnectionManager createAsyncManager(int maxConnections, int maxConnectionsPerRoute) throws IOReactorException;
}
