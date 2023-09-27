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
import io.maestro3.sdk.v3.model.instance.SdkInstanceState;
import io.maestro3.sdk.v3.model.instance.SdkResourceTag;
import io.maestro3.sdk.v3.model.recommendation.SdkUiRecommendationSource;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.Set;

@JsonDeserialize(builder = DescribeInstanceRequest.Builder.class)
public class DescribeInstanceRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final Set<String> instanceIds;
    private final SdkResourceTag resourceTag;
    private final boolean all;
    private final Set<SdkInstanceState> instanceStates;

    private final String resourceGroup;
    private final String availabilityZone;

    private final boolean insights;
    private final SdkUiRecommendationSource source;
    private final String group;
    private final String riskFactor;

    private final boolean schedules;

    private final String owner;

    private DescribeInstanceRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.instanceIds = builder.instanceIds;
        this.resourceTag = builder.resourceTag;
        this.all = builder.all;
        this.instanceStates = builder.instanceStates;
        this.resourceGroup = builder.resourceGroup;
        this.availabilityZone = builder.availabilityZone;
        this.insights = builder.insights;
        this.source = builder.source;
        this.group = builder.group;
        this.riskFactor = builder.riskFactor;
        this.owner = builder.owner;
        this.schedules = builder.schedules;
    }

    public static Builder builder() {
        return new Builder();
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

    public SdkResourceTag getResourceTag() {
        return resourceTag;
    }

    public boolean isAll() {
        return all;
    }

    public Set<SdkInstanceState> getInstanceStates() {
        return instanceStates;
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public boolean isInsights() {
        return insights;
    }

    public SdkUiRecommendationSource getSource() {
        return source;
    }

    public String getGroup() {
        return group;
    }

    public String getRiskFactor() {
        return riskFactor;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isSchedules() {
        return schedules;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_INSTANCE;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private Set<String> instanceIds;
        private SdkResourceTag resourceTag;
        private boolean all;
        private Set<SdkInstanceState> instanceStates;
        private String resourceGroup;
        private String availabilityZone;

        private boolean insights;
        private SdkUiRecommendationSource source;
        private String group;
        private String riskFactor;
        private String owner;
        private boolean schedules;

        public Builder withTenantName(String tenantName) {
            Assert.hasText(tenantName, "tenantName");
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            Assert.hasText(region, "region");
            this.region = region;
            return this;
        }

        public Builder withInstanceIds(Set<String> instanceIds) {
            this.instanceIds = instanceIds;
            return this;
        }

        public Builder withResourceTag(SdkResourceTag resourceTag) {
            this.resourceTag = resourceTag;
            return this;
        }

        public Builder withAll(boolean all) {
            this.all = all;
            return this;
        }

        public Builder withInstanceStates(Set<SdkInstanceState> instanceStates) {
            this.instanceStates = instanceStates;
            return this;
        }

        public Builder withInsights(boolean insights) {
            this.insights = insights;
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

        public Builder withSource(SdkUiRecommendationSource source) {
            this.source = source;
            return this;
        }
        public Builder withGroup(String group) {
            this.group = group;
            return this;
        }

        public Builder withRiskFactor(String riskFactor) {
            this.riskFactor = riskFactor;
            return this;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder withSchedules(boolean schedules) {
            this.schedules = schedules;
            return this;
        }

        public DescribeInstanceRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            return new DescribeInstanceRequest(this);
        }
    }
}
