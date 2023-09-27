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

package io.maestro3.sdk.v3.request.agent;

import io.maestro3.sdk.v3.request.IRequest;

import java.util.List;

public abstract class PrivateAgentRequest implements IRequest {

    private final String agentId;
    private final String displayName;
    private final String syncQueue;
    private final String asyncQueue;
    private final String responseQueue;
    private final String sdkKey;
    private final String customer;
    private final String exchangeName;
    private final String ip;
    private final List<String> types;

    protected PrivateAgentRequest(AbstractPrivateAgentRequestBuilder<?, ?> builder) {
        this.agentId = builder.agentId;
        this.displayName = builder.displayName;
        this.syncQueue = builder.syncQueue;
        this.asyncQueue = builder.asyncQueue;
        this.responseQueue = builder.responseQueue;
        this.sdkKey = builder.sdkKey;
        this.customer = builder.customer;
        this.exchangeName = builder.exchangeName;
        this.ip = builder.ip;
        this.types = builder.types;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSyncQueue() {
        return syncQueue;
    }

    public String getAsyncQueue() {
        return asyncQueue;
    }

    public String getResponseQueue() {
        return responseQueue;
    }

    public String getSdkKey() {
        return sdkKey;
    }

    public String getCustomer() {
        return customer;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public String getIp() {
        return ip;
    }

    public List<String> getTypes() {
        return types;
    }

    public abstract static class AbstractPrivateAgentRequestBuilder
        <B extends AbstractPrivateAgentRequestBuilder<B, R>, R extends PrivateAgentRequest> {

        private String agentId;
        private String displayName;
        private String syncQueue;
        private String asyncQueue;
        private String responseQueue;
        private String sdkKey;
        private String customer;
        private String exchangeName;
        private String ip;
        private List<String> types;

        protected abstract B getThis();

        public abstract R build();

        public B withAgentId(String agentId) {
            this.agentId = agentId;
            return getThis();
        }

        public B withDisplayName(String displayName) {
            this.displayName = displayName;
            return getThis();
        }

        public B withSyncQueue(String syncQueue) {
            this.syncQueue = syncQueue;
            return getThis();
        }

        public B withAsyncQueue(String asyncQueue) {
            this.asyncQueue = asyncQueue;
            return getThis();
        }

        public B withResponseQueue(String responseQueue) {
            this.responseQueue = responseQueue;
            return getThis();
        }

        public B withSdkKey(String sdkKey) {
            this.sdkKey = sdkKey;
            return getThis();
        }

        public B withCustomer(String customer) {
            this.customer = customer;
            return getThis();
        }

        public B withExchangeName(String exchangeName) {
            this.exchangeName = exchangeName;
            return getThis();
        }

        public B withIp(String ip) {
            this.ip = ip;
            return getThis();
        }

        public B withTypes(List<String> types) {
            this.types = types;
            return getThis();
        }
    }
}
