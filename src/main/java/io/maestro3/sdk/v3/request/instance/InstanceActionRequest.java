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

package io.maestro3.sdk.v3.request.instance;

import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.request.IRegionRequest;

public abstract class InstanceActionRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String instanceId;
    private final String availabilityZone;

    protected InstanceActionRequest(AbstractInstanceActionBuilder<?, ?> builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.instanceId = builder.instanceId;
        this.availabilityZone = builder.availabilityZone;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public abstract static class AbstractInstanceActionBuilder
        <B extends AbstractInstanceActionBuilder<B, R>, R extends InstanceActionRequest> {

        private String tenantName;
        private String region;
        private String instanceId;
        private String availabilityZone;

        protected abstract B getThis();

        public abstract R build();

        public B withTenantName(String tenantName) {
            Assert.hasText(tenantName, "tenantName");
            this.tenantName = tenantName;
            return getThis();
        }

        public B withRegion(String region) {
            Assert.hasText(region, "region");
            this.region = region;
            return getThis();
        }

        public B withInstanceId(String instanceId) {
            Assert.hasText(instanceId, "instanceId");
            this.instanceId = instanceId;
            return getThis();
        }

        public B withAvailabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return getThis();
        }

        protected void validateTenantAndRegion() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
        }

        protected void validateCommonParams() {
            validateTenantAndRegion();
            Assert.hasText(instanceId, "instanceId");
        }
    }

}
