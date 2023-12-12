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

package io.maestro3.sdk.v3.request.schedule;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.schedule.SdkSchedulePriorityFilter;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = DescribeSchedulesRequest.Builder.class)
public class DescribeSchedulesRequest implements ITenantRequest, IRegionRequest {

    private final String scheduleName;
    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final String scheduleGroup;
    private final String instanceId;
    private final String scheduleType;
    private final String scheduleAction;
    private String email;
    private final SdkSchedulePriorityFilter filter;

    private DescribeSchedulesRequest(Builder builder) {
        this.scheduleName = builder.scheduleName;
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.scheduleGroup = builder.scheduleGroup;
        this.instanceId = builder.instanceId;
        this.scheduleType = builder.scheduleType;
        this.scheduleAction = builder.scheduleAction;
        this.email = builder.email;
        this.filter = builder.filter;
    }

    public static Builder builder() {
        return new Builder();
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

    public String getScheduleGroup() {
        return scheduleGroup;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public String getScheduleAction() {
        return scheduleAction;
    }

    public String getEmail() {
        return email;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public SdkSchedulePriorityFilter getFilter() {
        return filter;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_SCHEDULES;
    }

    public static final class Builder {

        private String scheduleName;
        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private String scheduleGroup;
        private String instanceId;
        private String scheduleType;
        private String scheduleAction;
        private String email;
        private SdkSchedulePriorityFilter filter = SdkSchedulePriorityFilter.PRIORITIZED;

        private Builder() {
        }

        public Builder withScheduleName(String scheduleName) {
            this.scheduleName = scheduleName;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String regionName) {
            this.region = regionName;
            return this;
        }

        public Builder withScheduleGroup(String scheduleGroup) {
            this.scheduleGroup = scheduleGroup;
            return this;
        }

        public Builder withInstanceId(String instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        public Builder withScheduleType(String scheduleType) {
            this.scheduleType = scheduleType;
            return this;
        }

        public Builder withScheduleAction(String scheduleAction) {
            this.scheduleAction = scheduleAction;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withFilter(SdkSchedulePriorityFilter filter) {
            this.filter = filter;
            return this;
        }

        public DescribeSchedulesRequest build() {
            return new DescribeSchedulesRequest(this);
        }

    }

}

