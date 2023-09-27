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
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class M3ApiResponsesProvider {

    private static final Logger LOG = LoggerFactory.getLogger(M3ApiResponsesProvider.class);
    private static final Map<String, ReplyWaiter> RESPONSES_BY_CORRELATION_ID = new ConcurrentHashMap<>();

    private final int timeoutMillis;
    private final int maxResponsesSize;
    private final String responseQueueName;
    private final RabbitConnectionProvider rabbitConnectionProvider;

    public M3ApiResponsesProvider(RabbitConnectionProvider rabbitConnectionProvider, String responseQueueName, int maxResponsesSize, int timeoutMillis) {
        this.rabbitConnectionProvider = rabbitConnectionProvider;
        this.responseQueueName = responseQueueName;
        this.maxResponsesSize = maxResponsesSize;
        this.timeoutMillis = timeoutMillis;
    }

    public void addResponseWaiter(String correlationId) {
        RESPONSES_BY_CORRELATION_ID.put(correlationId, new ReplyWaiter());
    }

    public void removeResponseWaiter(String correlationId) {
        RESPONSES_BY_CORRELATION_ID.remove(correlationId);
    }

    public String getResponse(long customTimeoutMillis, String correlationId) throws InterruptedException {
        ReplyWaiter replyWaiter = RESPONSES_BY_CORRELATION_ID.get(correlationId);
        if (replyWaiter == null) {
            LOG.error("Reply waiter is null for correlation id: {}", correlationId);
            return null;
        }
        long resultTimeoutMillis = customTimeoutMillis > 0 ? customTimeoutMillis : timeoutMillis;
        return replyWaiter.get(resultTimeoutMillis, TimeUnit.MILLISECONDS);
    }

    public void startConsumer() {
        DefaultConsumer consumer = new DefaultConsumer(rabbitConnectionProvider.getReadChannel()) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                if (RESPONSES_BY_CORRELATION_ID.size() > maxResponsesSize) {
                    LOG.error("M3 api responses are full! Max size: {}", maxResponsesSize);
                    return;
                }

                try {
                    String correlationId = properties.getCorrelationId();
                    ReplyWaiter replyWaiter = RESPONSES_BY_CORRELATION_ID.get(correlationId);
                    if (replyWaiter == null) {
                        LOG.error("Correlation id doesn't have waiter: {}", properties.getCorrelationId());
                        return;
                    }

                    replyWaiter.reply(new String(body, StandardCharsets.UTF_8));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                } finally {
                    rabbitConnectionProvider.getReadChannel().basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        startConsumer(consumer);
    }

    private void startConsumer(DefaultConsumer consumer) {
        try {
            rabbitConnectionProvider.getReadChannel().basicConsume(responseQueueName, false, consumer);
        } catch (IOException e) {
            throw new RuntimeException("Failed to start consumer", e);
        }
    }
}
