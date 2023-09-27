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

package io.maestro3.sdk.v3.request.security;

import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.Set;

public abstract class GetLastInstanceScanRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final Set<String> instanceId;

    protected GetLastInstanceScanRequest(AbstractGetLastInstanceScanRequestBuilder<?, ?> builder) {
        this.region = builder.region;
        this.tenantName = builder.tenantName;
        this.instanceId = builder.instanceId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    public Set<String> getInstanceId() {
        return instanceId;
    }

    public abstract static class AbstractGetLastInstanceScanRequestBuilder
        <B extends AbstractGetLastInstanceScanRequestBuilder<B, R>, R extends GetLastInstanceScanRequest> {

        private String tenantName;
        private String region;
        private Set<String> instanceId;

        protected abstract B getThis();

        public abstract R build();

        public B withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }

        public B withRegion(String region) {
            this.region = region;
            return getThis();
        }

        public B withInstanceId(Set<String> instanceId) {
            this.instanceId = instanceId;
            return getThis();
        }

        protected void validateCommonParams() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.notEmpty(instanceId, "instanceId");
        }
    }
}
