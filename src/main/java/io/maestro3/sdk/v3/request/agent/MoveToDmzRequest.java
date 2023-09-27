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

package io.maestro3.sdk.v3.request.agent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = MoveToDmzRequest.Builder.class)
public class MoveToDmzRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String instanceId;
    private final String ipAddress;
    private final String vlanName;
    private final Boolean backToInternal;

    private MoveToDmzRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.instanceId = builder.instanceId;
        this.ipAddress = builder.ipAddress;
        this.vlanName = builder.vlanName;
        this.backToInternal = builder.backToInternal;
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

    public String getIpAddress() {
        return ipAddress;
    }

    public String getVlanName() {
        return vlanName;
    }

    public Boolean getBackToInternal() {
        return backToInternal;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.MOVE_VM_TO_VLAN;
    }

    public static final class Builder {
        private String tenantName;
        private String region;
        private String instanceId;
        private String ipAddress;
        private String vlanName;
        private Boolean backToInternal;

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

        public Builder withIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder withVlanName(String vlanName) {
            this.vlanName = vlanName;
            return this;
        }

        public Builder withBackToInternal(Boolean backToInternal) {
            this.backToInternal = backToInternal;
            return this;
        }

        public MoveToDmzRequest build() {
            return new MoveToDmzRequest(this);
        }
    }
}
