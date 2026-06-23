/*
 * Copyright 2025 Maestro Cloud Control LLC
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

package io.maestro3.sdk.v3.request.agent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Request to check resource availability before Terraform template apply.
 */
@JsonDeserialize(builder = CheckResourceAvailabilityRequest.Builder.class)
public class CheckResourceAvailabilityRequest implements IRegionRequest {

    private final List<InstanceResourceRequest> instances;
    private final List<VolumeResourceRequest> volumes;
    private final String tenantName;
    private final String region;

    private CheckResourceAvailabilityRequest(Builder builder) {
        this.instances = builder.instances;
        this.volumes = builder.volumes;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<InstanceResourceRequest> getInstances() {
        return instances;
    }

    public List<VolumeResourceRequest> getVolumes() {
        return volumes;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CHECK_RESOURCE_AVAILABILITY;
    }

    public static final class Builder {

        private List<InstanceResourceRequest> instances = new ArrayList<>();
        private List<VolumeResourceRequest> volumes = new ArrayList<>();
        private String tenantName;
        private String region;

        private Builder() {
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withInstances(List<InstanceResourceRequest> instances) {
            this.instances = instances;
            return this;
        }

        public Builder withVolumes(List<VolumeResourceRequest> volumes) {
            this.volumes = volumes;
            return this;
        }

        public CheckResourceAvailabilityRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.isTrue(
                    (instances != null && !instances.isEmpty()) || (volumes != null && !volumes.isEmpty()),
                    "at least one of instances or volumes"
            );
            return new CheckResourceAvailabilityRequest(this);
        }
    }
}
