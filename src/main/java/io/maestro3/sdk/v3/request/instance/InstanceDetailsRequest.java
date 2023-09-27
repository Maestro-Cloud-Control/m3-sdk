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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = InstanceDetailsRequest.Builder.class)
public class InstanceDetailsRequest implements ITenantRequest, IRegionRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final String instanceId;
    private final String resourceGroup;
    private final String availabilityZone;
    private final String insightsCategory;
    private final String riskFactor;

    private InstanceDetailsRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.instanceId = builder.instanceId;
        this.region = builder.region;
        this.resourceGroup = builder.resourceGroup;
        this.availabilityZone = builder.availabilityZone;
        this.insightsCategory = builder.insightsCategory;
        this.riskFactor = builder.riskFactor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getInstanceId() {
        return instanceId;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public String getInsightsCategory() {
        return insightsCategory;
    }

    public String getRiskFactor() {
        return riskFactor;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.INSTANCE_DETAILS_REPORT;
    }

    public static final class Builder {
        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private String instanceId;
        private String resourceGroup;
        private String availabilityZone;
        private String insightsCategory;
        private String riskFactor;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withInstanceId(String instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        public Builder withResourceGroup(String resourceGroup) {
            this.resourceGroup = resourceGroup;
            return this;
        }

        public Builder withAvailabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return this;
        }

        public Builder withInsightsCategory(String insightsCategory) {
            this.insightsCategory = insightsCategory;
            return this;
        }

        public Builder withRiskFactor(String riskFactor) {
            this.riskFactor = riskFactor;
            return this;
        }

        public InstanceDetailsRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            return new InstanceDetailsRequest(this);
        }
    }
}
