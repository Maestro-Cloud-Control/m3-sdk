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

package io.maestro3.sdk.v3.request.image;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = CreateImageRequest.Builder.class)
public class CreateImageRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String instanceId;
    private final String name;
    private final String description;
    private final String owner;

    // Azure parameters
    private final String resourceGroup;

    // GCP parameters
    private final String availabilityZone;

    private CreateImageRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.instanceId = builder.instanceId;
        this.name = builder.name;
        this.description = builder.description;
        this.owner = builder.owner;
        this.resourceGroup = builder.resourceGroup;
        this.availabilityZone = builder.availabilityZone;
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

    public String getInstanceId() {
        return instanceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CREATE_IMAGE;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String instanceId;
        private String name;
        private String description;
        private String owner;
        private String resourceGroup;
        private String availabilityZone;

        public Builder withOwner(String owner) {
            this.owner = owner;
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

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
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

        public CreateImageRequest build() {
            return new CreateImageRequest(this);
        }
    }
}
