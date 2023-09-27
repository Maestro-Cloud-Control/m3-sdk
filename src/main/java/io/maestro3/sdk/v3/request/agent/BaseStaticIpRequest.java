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

import io.maestro3.sdk.v3.request.IRegionRequest;

public abstract class BaseStaticIpRequest implements IRegionRequest {
    private final String region;
    private final String tenantName;

    protected BaseStaticIpRequest(AbstractStaticIpRequestBuilder<?, ?> builder) {
        this.region = builder.region;
        this.tenantName = builder.tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public abstract static class AbstractStaticIpRequestBuilder<B extends AbstractStaticIpRequestBuilder<B, R>, R extends BaseStaticIpRequest> {

        private String region;
        private String tenantName;

        protected abstract B getThis();

        public abstract R build();

        public B withRegion(String region) {
            this.region = region;
            return getThis();
        }

        public B withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }
    }
}
