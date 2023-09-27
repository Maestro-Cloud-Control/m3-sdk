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

package io.maestro3.sdk.v3.request.metric;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = UpdateInstanceDashboardActionRequest.Builder.class)
public class UpdateInstanceDashboardActionRequest implements IRequest {

    private final String userIdentifier;
    private final String instanceState;
    private final String tenantName;
    private final String regionName;
    private final String dashboardType;
    private final Object action;
    private final String cloudName;

    private UpdateInstanceDashboardActionRequest(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.instanceState = builder.instanceState;
        this.tenantName = builder.tenantName;
        this.regionName = builder.regionName;
        this.dashboardType = builder.dashboardType;
        this.action = builder.action;
        this.cloudName = builder.cloudName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getInstanceState() {
        return instanceState;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getDashboardType() {
        return dashboardType;
    }

    public Object getAction() {
        return action;
    }

    public String getCloudName() {
        return cloudName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_USER_SPECIFIC_INSTANCE_DASHBOARD_ACTION;
    }

    public static final class Builder {

        private String userIdentifier;
        private String instanceState;
        private String tenantName;
        private String regionName;
        private String dashboardType;
        private Object action;
        private String cloudName;

        public Builder withUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return this;
        }

        public Builder withInstanceState(String instanceState) {
            this.instanceState = instanceState;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegionName(String regionName) {
            this.regionName = regionName;
            return this;
        }

        public Builder withDashboardType(String dashboardType) {
            this.dashboardType = dashboardType;
            return this;
        }

        public Builder withAction(Object action) {
            this.action = action;
            return this;
        }

        public Builder withCloudName(String cloudName) {
            this.cloudName = cloudName;
            return this;
        }

        public UpdateInstanceDashboardActionRequest build() {
            return new UpdateInstanceDashboardActionRequest(this);
        }
    }
}
