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

@JsonDeserialize(builder = DeactivateVLANRequest.Builder.class)
public class DeactivateVLANRequest implements IRegionRequest {

    private final String region;
    private final String vlanName;
    private final String tenantName;
    private final boolean force;

    private DeactivateVLANRequest(Builder builder) {
        this.region = builder.region;
        this.vlanName = builder.vlanName;
        this.tenantName = builder.tenantName;
        this.force = builder.force;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getRegion() {
        return region;
    }

    public String getVlanName() {
        return vlanName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public boolean getForce() {
        return force;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DEACTIVATE_VLAN;
    }

    public static final class Builder {
        private String region;
        private String vlanName;
        private String tenantName;
        private boolean force;

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withVlanName(String vlanName) {
            this.vlanName = vlanName;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withForce(boolean force) {
            this.force = force;
            return this;
        }

        public DeactivateVLANRequest build() {
            return new DeactivateVLANRequest(this);
        }
    }
}
