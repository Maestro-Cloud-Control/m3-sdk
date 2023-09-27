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

package io.maestro3.sdk.v3.request.tag;

import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;

public abstract class TagsActionRequest implements IRegionRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final String instanceId;
    private final String requestType;

    // optional params
    private final String availabilityZone; // required for Google
    private final String resourceGroup; // required for Azure

    protected TagsActionRequest(AbstractTagsActionRequestBuilder<?, ?> builder) {
        this.cloud = builder.sdkCloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.instanceId = builder.instanceId;
        this.availabilityZone = builder.availabilityZone;
        this.resourceGroup = builder.resourceGroup;
        this.requestType = builder.requestType;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public String getRequestType() {
        return requestType;
    }

    public abstract static class AbstractTagsActionRequestBuilder
        <B extends AbstractTagsActionRequestBuilder<B, R>, R extends TagsActionRequest> {

        private SdkCloud sdkCloud;
        private String tenantName;
        private String region;
        private String instanceId;
        private String resourceGroup;
        private String availabilityZone;
        private String requestType;

        protected abstract B getThis();

        public abstract R build();

        public B withCloud(SdkCloud sdkCloud) {
            this.sdkCloud = sdkCloud;
            return getThis();
        }

        public B withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }

        public B withRegion(String region) {
            this.region = region;
            return getThis();
        }

        public B withInstanceId(String instanceId) {
            this.instanceId = instanceId;
            return getThis();
        }

        public B withResourceGroup(String resourceGroup) {
            this.resourceGroup = resourceGroup;
            return getThis();
        }

        public B withAvailabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return getThis();
        }

        public B withRequestType(String requestType) {
            this.requestType = requestType;
            return getThis();
        }

        protected void checkFields() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.hasText(instanceId, "instanceId");
            Assert.notNull(sdkCloud, "sdkCloud");
        }
    }
}
