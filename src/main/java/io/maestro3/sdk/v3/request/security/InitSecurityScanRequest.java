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
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

public abstract class InitSecurityScanRequest implements ITenantRequest, IRegionRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final String instanceId;
    private final String availabilityZone;
    private final String resourceGroup;

    protected InitSecurityScanRequest(AbstractInitSecurityScanRequestBuilder<?, ?> builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.instanceId = builder.instanceId;
        this.availabilityZone = builder.availabilityZone;
        this.resourceGroup = builder.resourceGroup;
    }

    public SdkCloud getCloud() {
        return cloud;
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

    public String getResourceGroup() {
        return resourceGroup;
    }

    public abstract static class AbstractInitSecurityScanRequestBuilder
            <B extends AbstractInitSecurityScanRequestBuilder<B, R>, R extends InitSecurityScanRequest> {

        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private String instanceId;
        private String availabilityZone;
        private String resourceGroup;

        protected abstract B getThis();

        public abstract R build();

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
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

        public B withAvailabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return getThis();
        }

        public B withResourceGroup(String resourceGroup) {
            this.resourceGroup = resourceGroup;
            return getThis();
        }

        protected void validateCommonParams() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(region, "region");
            Assert.hasText(tenantName, "tenantName");
            if (StringUtils.isNotBlank(instanceId)) {
                if (cloud == SdkCloud.AZURE) {
                    Assert.hasText(resourceGroup, "resourceGroup");
                } else if (cloud == SdkCloud.GOOGLE) {
                    Assert.hasText(availabilityZone, "availabilityZone");
                }
            }
        }
    }
}
