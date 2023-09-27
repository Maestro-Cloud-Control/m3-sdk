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

@JsonDeserialize(builder = GetCustomMetricsRequest.Builder.class)
public class GetCustomMetricsRequest implements IRequest {

    private final String userIdentifier;
    private final String cloudName;
    private final String tenantName;
    private final String regionName;

    private GetCustomMetricsRequest(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.cloudName = builder.cloudName;
        this.tenantName = builder.tenantName;
        this.regionName = builder.regionName;
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

    public String getTenantName() {
        return tenantName;
    }

    public String getRegionName() {
        return regionName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_CUSTOM_METRICS;
    }

    public static final class Builder {

        private String userIdentifier;
        private String cloudName;
        private String tenantName;
        private String regionName;

        public Builder withUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return this;
        }

        public Builder withCloudName(String cloudName) {
            this.cloudName = cloudName;
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

        public GetCustomMetricsRequest build() {
            return new GetCustomMetricsRequest(this);
        }
    }
}
