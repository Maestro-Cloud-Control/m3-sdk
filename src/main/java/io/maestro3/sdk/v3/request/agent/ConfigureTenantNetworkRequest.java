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
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = ConfigureTenantNetworkRequest.Builder.class)
public class ConfigureTenantNetworkRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String name;
    private final String cidr;

    private final String gatewayNetworkId;        // gateway to upper network
    private final String gatewaySubnetId;        // gateway to upper subnet
    private final String gatewayIpAddress;        // gateway to upper IP
    private final boolean highlyAvailable;
    private final boolean disableSnat;

    private ConfigureTenantNetworkRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.name = builder.name;
        this.cidr = builder.cidr;
        this.gatewayNetworkId = builder.gatewayNetworkId;
        this.gatewaySubnetId = builder.gatewaySubnetId;
        this.gatewayIpAddress = builder.gatewayIpAddress;
        this.highlyAvailable = builder.highlyAvailable;
        this.disableSnat = builder.disableSnat;
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

    public String getName() {
        return name;
    }

    public String getCidr() {
        return cidr;
    }

    public String getGatewayNetworkId() {
        return gatewayNetworkId;
    }

    public String getGatewaySubnetId() {
        return gatewaySubnetId;
    }

    public String getGatewayIpAddress() {
        return gatewayIpAddress;
    }

    public boolean isHighlyAvailable() {
        return highlyAvailable;
    }

    public boolean isDisableSnat() {
        return disableSnat;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CONFIGURE_PRIVATE_NETWORK;
    }

    public static final class Builder {
        private String tenantName;
        private String region;
        private String name;
        private String cidr;

        private String gatewayNetworkId;
        private String gatewaySubnetId;
        private String gatewayIpAddress;
        private boolean highlyAvailable;
        private boolean disableSnat;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCidr(String cidr) {
            this.cidr = cidr;
            return this;
        }

        public Builder withGatewayNetworkId(String gatewayNetworkId) {
            this.gatewayNetworkId = gatewayNetworkId;
            return this;
        }

        public Builder withGatewaySubnetId(String gatewaySubnetId) {
            this.gatewaySubnetId = gatewaySubnetId;
            return this;
        }

        public Builder withGatewayIpAddress(String gatewayIpAddress) {
            this.gatewayIpAddress = gatewayIpAddress;
            return this;
        }

        public Builder withHighlyAvailable(boolean highlyAvailable) {
            this.highlyAvailable = highlyAvailable;
            return this;
        }

        public Builder withDisableSnat(boolean disableSnat) {
            this.disableSnat = disableSnat;
            return this;
        }

        public ConfigureTenantNetworkRequest build() {
            if (StringUtils.isBlank(gatewaySubnetId) != StringUtils.isBlank(gatewayIpAddress)) {
                throw new M3SdkException("gatewaySubnetId and gatewayIpAddress must be specified together.");
            }
            return new ConfigureTenantNetworkRequest(this);
        }

    }
}
