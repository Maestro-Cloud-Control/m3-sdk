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
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.Set;

public abstract class ScheduleInstancesRequest implements ITenantRequest, IRegionRequest {

    private final String scheduleName;
    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final Set<String> instanceIds;

    protected ScheduleInstancesRequest(AbstractScheduleInstanceRequestBuilder<?, ?> builder) {
        this.scheduleName = builder.scheduleName;
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.instanceIds = builder.instanceIds;
    }

    public String getScheduleName() {
        return scheduleName;
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

    public Set<String> getInstanceIds() {
        return instanceIds;
    }

    public abstract static class AbstractScheduleInstanceRequestBuilder
            <B extends AbstractScheduleInstanceRequestBuilder<B, R>, R extends ScheduleInstancesRequest> {

        private String scheduleName;
        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private Set<String> instanceIds;
        
        protected abstract B getThis();
        
        public abstract R build();

        public B withScheduleName(String scheduleName) {
            this.scheduleName = scheduleName;
            return getThis();
        }

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

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

        public B withInstanceIds(Set<String> instanceIds) {
            this.instanceIds = instanceIds;
            return getThis();
        }

        protected void validateParams() {
            Assert.hasText(scheduleName, "scheduleName");
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.notNull(instanceIds, "instanceIds");
        }
    }
}
