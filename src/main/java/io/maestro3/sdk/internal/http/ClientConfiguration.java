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

public final class ClientConfiguration {

    /**
     * The default timeout for creating new connections.
     */
    public static final int DEFAULT_CONNECTION_TIMEOUT_MILLIS = 10 * 1000;

    /**
     * The default timeout for executing requests via rabbit.
     */
    public static final int DEFAULT_RABBIT_CONNECTION_TIMEOUT_MILLIS = 30 * 1000;

    /**
     * The default timeout for reading from a connected socket.
     */
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 500 * 1000;

    /**
     * The default max connection pool size.
     */
    public static final int DEFAULT_MAX_CONNECTIONS = 150;

    /**
     * The default max connection pool size.
     */
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 50;

    /**
     * The default number of retries.
     */
    public static final int DEFAULT_RETRY_NUMBER = 3;

    /**
     * Retry non-idempotent request.
     */
    public static final boolean DEFAULT_RETRY_NON_IDEMPOTENT_ENABLE = true;

    private ClientConfiguration() {
        throw new UnsupportedOperationException("Instantiation is forbidden.");
    }
}
