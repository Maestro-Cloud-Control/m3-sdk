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
import io.maestro3.sdk.v3.request.IMultitenantRequest;

import java.util.List;

@JsonDeserialize(builder = ActivateVLANRequest.Builder.class)
public class ActivateVLANRequest implements IMultitenantRequest {

    private final String region;
    private final String vlanName;
    private final String description;
    private final List<String> tenantNames;
    private final boolean isDmz;
    private final boolean securityGroupDisabled;

    private ActivateVLANRequest(Builder builder) {
        this.region = builder.region;
        this.vlanName = builder.vlanName;
        this.description = builder.description;
        this.tenantNames = builder.tenantNames;
        this.isDmz = builder.isDmz;
        this.securityGroupDisabled = builder.securityGroupDisabled;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<String> getTenantNames() {
        return tenantNames;
    }

    public String getRegion() {
        return region;
    }

    public String getVlanName() {
        return vlanName;
    }

    public String getDescription() {
        return description;
    }

    public boolean getDmz() {
        return isDmz;
    }

    public boolean getSecurityGroupDisabled() {
        return securityGroupDisabled;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ACTIVATE_VLAN;
    }

    public static final class Builder {
        private String region;
        private String vlanName;
        private String description;
        private List<String> tenantNames;
        private boolean isDmz;
        private boolean securityGroupDisabled;

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withVlanName(String vlanName) {
            this.vlanName = vlanName;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withTenantNames(List<String> tenantNames) {
            this.tenantNames = tenantNames;
            return this;
        }

        public Builder withDmz(boolean dmz) {
            isDmz = dmz;
            return this;
        }

        public Builder withSecurityGroupDisabled(boolean securityGroupDisabled) {
            this.securityGroupDisabled = securityGroupDisabled;
            return this;
        }

        public ActivateVLANRequest build() {
            return new ActivateVLANRequest(this);
        }
    }
}
