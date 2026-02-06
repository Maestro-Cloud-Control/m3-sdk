/*
 * Copyright 2024 Maestro Cloud Control LLC
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

package io.maestro3.sdk.v3.request.asg;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = ChangeAutoScalingGroupSizeRequest.Builder.class)
public class ChangeAutoScalingGroupSizeRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String groupId;
    private final String clusterId;
    private Integer minCapacity;
    private Integer maxCapacity;
    private final Integer desiredCapacity;

    private ChangeAutoScalingGroupSizeRequest(ChangeAutoScalingGroupSizeRequest.Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.groupId = builder.groupId;
        this.clusterId = builder.clusterId;
        this.minCapacity = builder.minCapacity;
        this.maxCapacity = builder.maxCapacity;
        this.desiredCapacity = builder.desiredCapacity;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getClusterId() {
        return clusterId;
    }

    public Integer getMinCapacity() {
        return minCapacity;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public Integer getDesiredCapacity() {
        return desiredCapacity;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CHANGE_AUTO_SCALING_GROUP_SIZE;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String groupId;
        private String clusterId;
        private Integer minCapacity;
        private Integer maxCapacity;
        private Integer desiredCapacity;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withGroupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder withClusterId(String clusterId) {
            this.clusterId = clusterId;
            return this;
        }

        public Builder withMinCapacity(Integer minCapacity) {
            this.minCapacity = minCapacity;
            return this;
        }

        public Builder withMaxCapacity(Integer maxCapacity) {
            this.maxCapacity = maxCapacity;
            return this;
        }

        public Builder withDesiredCapacity(Integer desiredCapacity) {
            this.desiredCapacity = desiredCapacity;
            return this;
        }

        public ChangeAutoScalingGroupSizeRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.hasText(groupId, "groupId");
            return new ChangeAutoScalingGroupSizeRequest(this);
        }
    }
}
