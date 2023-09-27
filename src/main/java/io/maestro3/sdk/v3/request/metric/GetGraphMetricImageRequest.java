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

@JsonDeserialize(builder = GetGraphMetricImageRequest.Builder.class)
public class GetGraphMetricImageRequest implements IRequest {

    private final String userIdentifier;
    private final String range;
    private final String metricName;
    private final String tenantName;
    private final String regionName;
    private final String instanceId;
    private final String availabilityZone;
    private final String resourceGroup;
    private final String folderId;

    private GetGraphMetricImageRequest(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.range = builder.range;
        this.metricName = builder.metricName;
        this.tenantName = builder.tenantName;
        this.regionName = builder.regionName;
        this.instanceId = builder.instanceId;
        this.availabilityZone = builder.availabilityZone;
        this.resourceGroup = builder.resourceGroup;
        this.folderId = builder.folderId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getRange() {
        return range;
    }

    public String getMetricName() {
        return metricName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegionName() {
        return regionName;
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

    public String getFolderId() {
        return folderId;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_GRAPH_IMAGE;
    }

    public static final class Builder {

        private String userIdentifier;
        private String range;
        private String metricName;
        private String tenantName;
        private String regionName;
        private String instanceId;
        private String availabilityZone;
        private String resourceGroup;
        private String folderId;

        public Builder withUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return this;
        }

        public Builder withRange(String range) {
            this.range = range;
            return this;
        }

        public Builder withMetricName(String metricName) {
            this.metricName = metricName;
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

        public Builder withInstanceId(String instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        public Builder withAvailabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return this;
        }

        public Builder withResourceGroup(String resourceGroup) {
            this.resourceGroup = resourceGroup;
            return this;
        }

        public Builder withFolderId(String folderId) {
            this.folderId = folderId;
            return this;
        }

        public GetGraphMetricImageRequest build() {
            return new GetGraphMetricImageRequest(this);
        }
    }
}
