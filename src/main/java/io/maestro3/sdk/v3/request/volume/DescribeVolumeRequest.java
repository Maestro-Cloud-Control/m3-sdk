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

package io.maestro3.sdk.v3.request.volume;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.Collections;
import java.util.Set;

@JsonDeserialize(builder = DescribeVolumeRequest.Builder.class)
public class DescribeVolumeRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String instanceId;
    private final Set<String> volumeIds;
    private final boolean all;
    private final Boolean attached;
    private final Boolean system;
    private final String availabilityZone;
    private final Set<String> names;

    private DescribeVolumeRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.instanceId = builder.instanceId;
        this.volumeIds = builder.volumeIds;
        this.all = builder.all;
        this.attached = builder.attached;
        this.system = builder.system;
        this.availabilityZone = builder.availabilityZone;
        this.names = builder.names;
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

    public String getInstanceId() {
        return instanceId;
    }

    public Set<String> getVolumeIds() {
        return volumeIds;
    }

    public boolean isAll() {
        return all;
    }

    public Boolean isAttached() {
        return attached;
    }

    public Boolean getSystem() {
        return system;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public Set<String> getNames() {
        return names;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_VOLUME;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String instanceId;
        private Set<String> volumeIds = Collections.emptySet();
        private boolean all;
        private Boolean attached;
        private Boolean system;
        private String availabilityZone;
        private Set<String> names;

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
            this.attached = true;
            return this;
        }

        public Builder withVolumeIds(Set<String> volumeIds) {
            this.volumeIds = volumeIds;
            return this;
        }

        public Builder withAll(boolean all) {
            this.all = all;
            return this;
        }

        public Builder withAttached(Boolean attached) {
            this.attached = attached;
            return this;
        }

        public Builder withSystem(Boolean system) {
            this.system = system;
            return this;
        }

        public Builder withAvailabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return this;
        }

        public Builder withNames(Set<String> names) {
            this.names = names;
            return this;
        }

        public DescribeVolumeRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            return new DescribeVolumeRequest(this);
        }
    }
}
