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

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.M3SdkConstants;
import io.maestro3.sdk.internal.provider.IM3AccessKeyProvider;
import io.maestro3.sdk.internal.signer.IM3Signer;
import io.maestro3.sdk.v3.core.M3ApiRequest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class RabbitMqM3ApiActionExecutor extends AbstractM3ApiActionExecutor {

    private static final int MAX_RESPONSE_UNAVAILABILITY_MILLIS = 300000;

    private final String requestExchangeName;
    private final String responseQueueName;
    private final String syncRequestQueueName;
    private final String asyncRequestQueueName;
    private final boolean isPersistent;
    private final RabbitConnectionProvider rabbitConnectionProvider;
    private final M3ApiResponsesProvider responseProvider;

    private volatile long lastRequestTimeMillis;
    private volatile long lastResponseTimeMillis;
    private final AtomicInteger requestsInProgressCount = new AtomicInteger(0);
    private volatile boolean closeConnections;

    // inner executors
    private final InternalSyncRabbitMqExecutor internalSyncExecutor;
    private final InternalAsyncRabbitMqExecutor internalAsyncExecutor;

    public RabbitMqM3ApiActionExecutor(IM3AccessKeyProvider accessKeyProvider,
                                       IM3Signer signer,
                                       ConnectionFactory connectionFactory,
                                       String requestExchangeName,
                                       String responseQueueName,
                                       String syncRequestQueueName,
                                       String asyncRequestQueueName,
                                       int timeoutMillis,
                                       boolean isPersistent) {
        super(accessKeyProvider, signer);
        this.requestExchangeName = requestExchangeName;
        this.responseQueueName = responseQueueName;
        this.syncRequestQueueName = syncRequestQueueName;
        this.asyncRequestQueueName = asyncRequestQueueName;
        this.isPersistent = isPersistent;
        this.rabbitConnectionProvider = new RabbitConnectionProvider(connectionFactory);
        this.responseProvider = new M3ApiResponsesProvider(rabbitConnectionProvider, responseQueueName, 128, timeoutMillis);

        this.internalSyncExecutor = new InternalSyncRabbitMqExecutor();
        this.internalAsyncExecutor = new InternalAsyncRabbitMqExecutor();
    }

    @Override
    protected String execute(M3ApiRequest request) {
        return internalSyncExecutor.execute(request);
    }

    @Override
    protected void executeAsync(M3ApiRequest request) {
        internalAsyncExecutor.execute(request);
    }

    @Override
    public void close() throws Exception {
        int inProgress = requestsInProgressCount.get();
        this.closeConnections = true;
        if (inProgress == 0) {
            rabbitConnectionProvider.closeAll();
        }
    }

    private abstract class AbstractInternalRabbitMqActionExecutor {

        protected String execute(M3ApiRequest request) {
            validateExecution();
            String correlationId = UUID.randomUUID().toString();
            prepareForExecution();
            try {
                boolean fullInit = lastRequestTimeMillis - lastResponseTimeMillis > MAX_RESPONSE_UNAVAILABILITY_MILLIS;
                if (rabbitConnectionProvider.init(fullInit)) {
                    closeConnections = false;
                    startResponseConsumer();
                }

                lastRequestTimeMillis = System.currentTimeMillis();
                addResponseWaiter(correlationId);
                sendRequest(request, correlationId, rabbitConnectionProvider.getWriteChannel(), requestExchangeName,
                    getRequestQueueName(), getResponseQueueName());

                String response = receiveResponse(request, correlationId);

                lastResponseTimeMillis = System.currentTimeMillis();
                return response;
            } catch (IOException | TimeoutException ex) {
                throw new M3SdkException("Error during request execution", ex);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                throw new M3SdkException("Error during request execution", ex);
            } finally {
                afterExecution(correlationId);
            }
        }

        private void sendRequest(M3ApiRequest request, String correlationId, Channel channel,
                                 String requestExchangeName, String routingKey, String responseQueueName) throws IOException {
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .correlationId(correlationId)
                    .headers(getHeaders(request, responseQueueName == null))
                    .contentType("text/plain")
                    .deliveryMode(isPersistent ? 2 : 1)
                    .replyTo(responseQueueName)
                    .build();

            channel.basicPublish(requestExchangeName, routingKey, properties, request.getRequestBody().getBytes(StandardCharsets.UTF_8));
        }

        private Map<String, Object> getHeaders(M3ApiRequest request, boolean isAsync) {
            Map<String, Object> headers = new HashMap<>();
            headers.put(M3SdkConstants.AUTHENTICATION_HEADER, request.getSignature());
            headers.put(M3SdkConstants.USER_IDENTIFIER_HEADER, request.getUserIdentifier());
            headers.put(M3SdkConstants.DATE_HEADER, String.valueOf(request.getTimestamp()));
            headers.put(M3SdkConstants.ACCESS_KEY_HEADER, request.getAccessKey());
            headers.put(M3SdkConstants.SDK_VERSION_HEADER, request.getSdkVersion());
            headers.put(M3SdkConstants.IS_ASYNC, String.valueOf(isAsync));
            return headers;
        }

        private void validateExecution() {
            if (closeConnections) {
                throw new M3SdkException("Execution is prohibited: the executor is closed");
            }
        }

        protected abstract void prepareForExecution();

        protected abstract void startResponseConsumer();

        protected abstract void addResponseWaiter(String correlationId);

        protected abstract String getRequestQueueName();

        protected abstract String getResponseQueueName();

        protected abstract String receiveResponse(M3ApiRequest request, String correlationId) throws InterruptedException;

        protected abstract void afterExecution(String correlationId);
    }

    private class InternalSyncRabbitMqExecutor extends AbstractInternalRabbitMqActionExecutor {

        @Override
        protected void prepareForExecution() {
            requestsInProgressCount.incrementAndGet();
        }

        @Override
        protected void startResponseConsumer() {
            responseProvider.startConsumer();
        }

        @Override
        protected void addResponseWaiter(String correlationId) {
            responseProvider.addResponseWaiter(correlationId);
        }

        @Override
        protected String getRequestQueueName() {
            return syncRequestQueueName;
        }

        @Override
        protected String getResponseQueueName() {
            return responseQueueName;
        }

        @Override
        protected String receiveResponse(M3ApiRequest request, String correlationId) throws InterruptedException {
            String response = responseProvider.getResponse(request.getCustomTimeoutMillis(), correlationId);
            if (Objects.isNull(response)) {
                throw new M3SdkException("Response receive timeout");
            }

            return response;
        }

        @Override
        protected void afterExecution(String correlationId) {
            int inProcess = requestsInProgressCount.decrementAndGet();
            responseProvider.removeResponseWaiter(correlationId);
            if (inProcess == 0 && closeConnections) {
                rabbitConnectionProvider.closeAll();
            }
        }
    }

    private class InternalAsyncRabbitMqExecutor extends AbstractInternalRabbitMqActionExecutor {

        @Override
        protected void prepareForExecution() {
            // do nothing
        }

        @Override
        protected void startResponseConsumer() {
            // do nothing
        }

        @Override
        protected void addResponseWaiter(String correlationId) {
            // do nothing
        }

        @Override
        protected String getRequestQueueName() {
            return asyncRequestQueueName;
        }

        @Override
        protected String getResponseQueueName() {
            return null;
        }

        @Override
        protected String receiveResponse(M3ApiRequest request, String correlationId) {
            return null;
        }

        @Override
        protected void afterExecution(String correlationId) {
            if (closeConnections) {
                rabbitConnectionProvider.closeAll();
            }
        }
    }
}
