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

import org.apache.http.client.config.RequestConfig;

import java.util.concurrent.atomic.AtomicReference;

public enum EnumRequestConfig {

    DEFAULT_REQUEST_CONFIG(ClientConfiguration.DEFAULT_CONNECTION_TIMEOUT_MILLIS, ClientConfiguration.DEFAULT_SOCKET_TIMEOUT_MILLIS) {
        @Override
        RequestConfig createConfig(int connectionTimeout, int socketTimeout) {
            return RequestConfig.custom()
                    .setConnectTimeout(connectionTimeout)
                    .setSocketTimeout(socketTimeout).build();
        }
    };

    private final AtomicReference<RequestConfig> config = new AtomicReference<>();

    private final int connectionTimeout;
    private final int socketTimeout;

    EnumRequestConfig(int connectionTimeout, int socketTimeout) {
        this.connectionTimeout = connectionTimeout;
        this.socketTimeout = socketTimeout;
    }

    public RequestConfig getConfig() {
        RequestConfig configLocal = config.get();
        if (configLocal == null) {
            synchronized (this) {
                configLocal = config.get();
                if (configLocal == null) {
                    configLocal = createConfig(connectionTimeout, socketTimeout);
                    config.set(configLocal);
                }
            }
        }
        return configLocal;
    }

    abstract RequestConfig createConfig(int connectionTimeout, int socketTimeout);
}
