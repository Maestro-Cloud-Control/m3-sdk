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

import java.util.Set;

@JsonDeserialize(builder = GetActionsForAllDashboardsRequest.Builder.class)
public class GetActionsForAllDashboardsRequest implements IRequest {

    private final String userIdentifier;
    private final String cloudName;
    private final Set<String> allowedTenantNames;

    private GetActionsForAllDashboardsRequest(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.cloudName = builder.cloudName;
        this.allowedTenantNames = builder.allowedTenantNames;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getCloudName() {
        return cloudName;
    }

    public Set<String> getAllowedTenantNames() {
        return allowedTenantNames;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_USER_SPECIFIC_ACTIONS_FOR_ALL_DASHBOARDS;
    }

    public static final class Builder {
        private String userIdentifier;
        private String cloudName;
        private Set<String> allowedTenantNames;

        public Builder withUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return this;
        }

        public Builder withCloudName(String cloudName) {
            this.cloudName = cloudName;
            return this;
        }

        public Builder withAllowedTenantNames(Set<String> allowedTenantNames) {
            this.allowedTenantNames = allowedTenantNames;
            return this;
        }

        public GetActionsForAllDashboardsRequest build() {
            return new GetActionsForAllDashboardsRequest(this);
        }
    }
}
