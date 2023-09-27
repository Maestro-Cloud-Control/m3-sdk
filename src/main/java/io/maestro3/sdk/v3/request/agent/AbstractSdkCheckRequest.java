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

import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRequest;

public abstract class AbstractSdkCheckRequest implements IRequest {

    private final String agentId;
    private final String customer;
    private final String regionName;
    private final SdkCloud cloud;
    private final String type;

    protected AbstractSdkCheckRequest(AbstractSdkCheckRequestBuilder<?, ?> builder) {
        this.agentId = builder.agentId;
        this.customer = builder.customer;
        this.regionName = builder.regionName;
        this.cloud = builder.cloud;
        this.type = builder.type;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getCustomer() {
        return customer;
    }

    public String getRegionName() {
        return regionName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getType() {
        return type;
    }

    public abstract static class AbstractSdkCheckRequestBuilder
        <B extends AbstractSdkCheckRequestBuilder<B, R>, R extends AbstractSdkCheckRequest> {

        private String agentId;
        private String customer;
        private String regionName;
        private SdkCloud cloud;
        private String type;

        protected abstract B getThis();

        public abstract R build();

        public B withAgentId(String agentId) {
            this.agentId = agentId;
            return getThis();
        }

        public B withCustomer(String customer) {
            this.customer = customer;
            return getThis();
        }

        public B withRegionName(String regionName) {
            this.regionName = regionName;
            return getThis();
        }

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

        public B withType(String type) {
            this.type = type;
            return getThis();
        }
    }
}
