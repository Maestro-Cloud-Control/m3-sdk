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

package io.maestro3.sdk;

import com.rabbitmq.client.ConnectionFactory;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.internal.executor.impl.HttpM3ApiActionExecutor;
import io.maestro3.sdk.internal.executor.impl.RabbitMqM3ApiActionExecutor;
import io.maestro3.sdk.internal.http.ClientConfiguration;
import io.maestro3.sdk.internal.provider.IM3AccessKeyProvider;
import io.maestro3.sdk.internal.provider.IM3CredentialsProvider;
import io.maestro3.sdk.internal.provider.IM3ServerContextProvider;
import io.maestro3.sdk.internal.signer.impl.M3Signer;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.client.IM3Client;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * This class provides the basic functionality of m3-sdk.
 * All the clients should be received using this class.
 */
public final class M3Sdk {

    private M3Sdk() {
        throw new UnsupportedOperationException("Instantiation is forbidden.");
    }

    /**
     * Get the latest version of m3-sdk client.
     *
     * @return the latest version of m3-sdk client
     * @throws M3SdkException when client is not found
     */
    public static IM3Client client(IM3ApiActionExecutor actionExecutor) throws M3SdkException {
        return client(M3SdkVersion.latest(), actionExecutor, false);
    }

    /**
     * Get the m3-sdk client by version.
     *
     * @param version of client to be found
     * @return the client by version
     * @throws M3SdkException when client for the specified version is not found,
     *                        or the version is <code>null</code>
     * @see M3SdkVersion
     */
    public static IM3Client client(M3SdkVersion version, IM3ApiActionExecutor actionExecutor, boolean isAsync) throws M3SdkException {
        Assert.notNull(version, "version");
        return version.client(actionExecutor, isAsync);
    }

    public static M3SdkClientBuilder clientBuilder() {
        return new M3SdkClientBuilder();
    }

    public static class M3SdkClientBuilder {

        private M3SdkVersion version;
        private IM3CredentialsProvider credentialsProvider;
        private IM3AccessKeyProvider accessKeyProvider;
        private IM3ApiActionExecutor actionExecutor;
        private boolean isAsync = false;

        public M3SdkClientBuilder withVersion(M3SdkVersion version) {
            Assert.notNull(version, "version");
            this.version = version;
            return this;
        }

        public M3SdkClientBuilder withCredentialsProvider(IM3CredentialsProvider credentialsProvider) {
            Assert.notNull(credentialsProvider, "credentialsProvider");
            this.credentialsProvider = credentialsProvider;
            return this;
        }

        public M3SdkClientBuilder withAccessKeyProvider(IM3AccessKeyProvider accessKeyProvider) {
            Assert.notNull(accessKeyProvider, "accessKeyProvider");
            this.accessKeyProvider = accessKeyProvider;
            return this;
        }

        public M3SdkClientBuilder async() {
            this.isAsync = true;
            return this;
        }

        public M3SdkClientBuilder async(boolean isAsync) {
            this.isAsync = isAsync;
            return this;
        }

        public RabbitExecutorBuilder withRabbitExecutor() {
            validateCommonFields();
            return new RabbitExecutorBuilder(this);
        }

        public HttpExecutorBuilder withHttpExecutor() {
            validateCommonFields();
            return new HttpExecutorBuilder(this);
        }

        private void validateCommonFields() {
            Assert.notNull(version, "version");
            Assert.notNull(credentialsProvider, "credentialsProvider");
            Assert.notNull(accessKeyProvider, "accessKeyProvider");
        }

        public IM3Client build() {
            Assert.notNull(version, "version");
            Assert.notNull(actionExecutor, "actionExecutor");
            return version.client(actionExecutor, isAsync);
        }

        public static class RabbitExecutorBuilder {

            public static final String AMQPS_URI_PLACEHOLDER = "amqps://%s:%s@%s:%d";
            public static final String AMQP_URI_PLACEHOLDER = "amqp://%s:%s@%s:%d";

            private M3SdkClientBuilder clientBuilder;
            private String host;
            private int port = 5672;
            private int timeoutMillis = ClientConfiguration.DEFAULT_RABBIT_CONNECTION_TIMEOUT_MILLIS;
            private String virtualHost = "/";
            private String username;
            private String password;
            private String requestExchangeName = "m3api-exchange";
            private String responseQueue;
            private String syncRequestQueueName = "m3api-sync-request";
            private String asyncRequestQueueName = "m3api-async-request";
            private boolean isPersistent = false;
            private boolean sslEnabled = false;

            private RabbitExecutorBuilder(M3SdkClientBuilder clientBuilder) {
                this.clientBuilder = clientBuilder;
            }

            public RabbitExecutorBuilder withHost(String host) {
                Assert.hasText(host, "host");
                this.host = host;
                return this;
            }

            public RabbitExecutorBuilder withPort(int port) {
                Assert.isPositive(port, "port");
                this.port = port;
                return this;
            }

            public RabbitExecutorBuilder withTimeoutMillis(int timeoutMillis) {
                Assert.isPositive(timeoutMillis, "timeoutMillis");
                this.timeoutMillis = timeoutMillis;
                return this;
            }

            public RabbitExecutorBuilder withVirtualHost(String virtualHost) {
                Assert.hasText(virtualHost, "virtualHost");
                this.virtualHost = virtualHost;
                return this;
            }

            public RabbitExecutorBuilder withUsername(String username) {
                Assert.hasText(username, "username");
                this.username = username;
                return this;
            }

            public RabbitExecutorBuilder withPassword(String password) {
                Assert.hasText(password, "password");
                this.password = password;
                return this;
            }

            public RabbitExecutorBuilder withRequestExchangeName(String requestExchangeName) {
                Assert.hasText(requestExchangeName, "requestExchangeName");
                this.requestExchangeName = requestExchangeName;
                return this;
            }

            public RabbitExecutorBuilder withSyncRequestQueueName(String syncRequestQueueName) {
                Assert.hasText(syncRequestQueueName, "syncRequestQueueName");
                this.syncRequestQueueName = syncRequestQueueName;
                return this;
            }

            public RabbitExecutorBuilder withAsyncRequestQueueName(String asyncRequestQueueName) {
                Assert.hasText(asyncRequestQueueName, "asyncRequestQueueName");
                this.asyncRequestQueueName = asyncRequestQueueName;
                return this;
            }

            public RabbitExecutorBuilder withResponseQueue(String responseQueue) {
                Assert.hasText(responseQueue, "responseQueue");
                this.responseQueue = responseQueue;
                return this;
            }

            public RabbitExecutorBuilder persistent(boolean isPersistent) {
                this.isPersistent = isPersistent;
                return this;
            }

            public RabbitExecutorBuilder sslEnabled(boolean sslEnabled) {
                this.sslEnabled = sslEnabled;
                return this;
            }

            public IM3Client build() {
                Assert.hasText(host, "host");
                Assert.isPositive(port, "port");
                Assert.isPositive(timeoutMillis, "timeoutMillis");
                Assert.hasText(virtualHost, "virtualHost");
                Assert.hasText(username, "username");
                Assert.hasText(password, "password");
                Assert.hasText(requestExchangeName, "requestExchangeName");
                Assert.hasText(responseQueue, "responseQueue");
                Assert.hasText(syncRequestQueueName, "syncRequestQueueName");
                Assert.hasText(asyncRequestQueueName, "asyncRequestQueueName");
                ConnectionFactory connectionFactory = new ConnectionFactory();
                String uriPattern = sslEnabled ? AMQPS_URI_PLACEHOLDER : AMQP_URI_PLACEHOLDER;
                String uri = String.format(uriPattern,
                    URLEncoder.encode(username, StandardCharsets.US_ASCII),
                    URLEncoder.encode(password, StandardCharsets.US_ASCII),
                    host, port);
                try {
                    connectionFactory.setUri(uri);
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
                connectionFactory.setConnectionTimeout(timeoutMillis);
                connectionFactory.setVirtualHost(virtualHost);

                clientBuilder.actionExecutor = new RabbitMqM3ApiActionExecutor(clientBuilder.accessKeyProvider,
                        new M3Signer(clientBuilder.credentialsProvider), connectionFactory, requestExchangeName,
                        responseQueue, syncRequestQueueName, asyncRequestQueueName, timeoutMillis, isPersistent);
                return clientBuilder.build();

            }
        }

        public static class HttpExecutorBuilder {

            private M3SdkClientBuilder clientBuilder;
            private IM3ServerContextProvider serverContextProvider;

            private HttpExecutorBuilder(M3SdkClientBuilder clientBuilder) {
                this.clientBuilder = clientBuilder;
            }

            public HttpExecutorBuilder withServerContextProvider(IM3ServerContextProvider serverContextProvider) {
                Assert.notNull(serverContextProvider, "serverContextProvider");
                this.serverContextProvider = serverContextProvider;
                return this;
            }

            public IM3Client build() {
                Assert.notNull(serverContextProvider, "serverContextProvider");
                clientBuilder.actionExecutor = new HttpM3ApiActionExecutor(clientBuilder.accessKeyProvider,
                        new M3Signer(clientBuilder.credentialsProvider), serverContextProvider);
                return clientBuilder.build();
            }
        }
    }
}
