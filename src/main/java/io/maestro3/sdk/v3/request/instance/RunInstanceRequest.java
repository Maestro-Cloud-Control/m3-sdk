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

package io.maestro3.sdk.v3.request.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.CollectionUtils;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.annotation.SecuredParams;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.List;
import java.util.Map;

@JsonDeserialize(builder = RunInstanceRequest.Builder.class)
public class RunInstanceRequest implements IRegionRequest {

    @JsonProperty(required = true)
    @JsonPropertyDescription("Tenant display name were new virtual machine will be started")
    private final String tenantName;
    @JsonProperty(required = true)
    @JsonPropertyDescription("Region name were new virtual machine will be started")
    private final String region;
    @JsonProperty(required = true)
    @JsonPropertyDescription("Instance name that will be used for new virtual machine")
    private final String instanceName;
    @JsonProperty(required = true)
    @JsonPropertyDescription("Image name that will be used as source for virtual machine")
    private final String imageId;
    @JsonProperty(required = true)
    @JsonPropertyDescription("Virtual machine size. Represent count of vCpu, RAM and storage")
    private final String shape;
    private final String instanceType;
    @JsonProperty(required = true)
    @JsonPropertyDescription("Email of the request initiator")
    private final String owner;
    @JsonProperty(required = true)
    @JsonPropertyDescription("Name of user ssh key")
    private final String keyName;
    private final int count;
    private final Integer stopAfter;
    private final Integer terminateAfter;
    private final String chefProfile;
    private final boolean installChefClient;
    private final String insanceChefUuid;
    @SecuredParams
    private final String initScript;
    private final String userScriptId;
    private final String userScriptName;
    private final String username;
    @SecuredParams
    private final String password;
    private final String availabilityZone;
    private final Map<String, String> additionalData;
    private final Map<String, String> tags;
    private final Boolean lockedTermination;
    private final List<String> networks;
    private final String subNetwork;
    private final List<String> securityGroups;
    private final String ip;

    private RunInstanceRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.instanceType = builder.instanceType;
        this.stopAfter = builder.stopAfter;
        this.terminateAfter = builder.terminateAfter;
        this.instanceName = builder.instanceName;
        this.imageId = builder.imageId;
        this.shape = builder.shape;
        this.owner = builder.owner;
        this.chefProfile = builder.chefProfile;
        this.installChefClient = builder.installChefClient;
        this.insanceChefUuid = builder.insanceChefUuid;
        this.keyName = builder.keyName;
        this.count = builder.count;
        this.initScript = builder.initScript;
        this.userScriptId = builder.userScriptId;
        this.userScriptName = builder.userScriptName;
        this.username = builder.username;
        this.password = builder.password;
        this.availabilityZone = builder.availabilityZone;
        this.additionalData = builder.additionalData;
        this.tags = builder.tags;
        this.lockedTermination = builder.lockedTermination;
        this.networks = builder.networks;
        this.subNetwork = builder.subNetwork;
        this.securityGroups = builder.securityGroups;
        this.ip = builder.ip;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return builder()
            .withTenantName(tenantName)
            .withRegion(region)
            .withInstanceName(instanceName)
            .withImageId(imageId)
            .withShape(shape)
            .withInstanceType(instanceType)
            .withOwner(owner)
            .withKeyName(keyName)
            .withCount(count)
            .withStopAfter(stopAfter)
            .withTerminateAfter(terminateAfter)
            .withChefProfile(chefProfile)
            .withInstallChefClient(installChefClient)
            .withInsanceChefUuid(insanceChefUuid)
            .withInitScript(initScript)
            .withUserScriptId(userScriptId)
            .withUserScriptName(userScriptName)
            .withUsername(username)
            .withPassword(password)
            .withAvailabilityZone(availabilityZone)
            .withAdditionalData(additionalData)
            .withTags(tags)
            .withLockedTermination(lockedTermination)
            .withNetworks(networks)
            .withSubNetwork(subNetwork)
            .withSecurityGroups(securityGroups)
            .withIp(ip);
    }

    public String getInitScript() {
        return initScript;
    }

    public Integer getStopAfter() {
        return stopAfter;
    }

    public Integer getTerminateAfter() {
        return terminateAfter;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public String getImageId() {
        return imageId;
    }

    public String getShape() {
        return shape;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public String getOwner() {
        return owner;
    }

    public String getKeyName() {
        return keyName;
    }

    public int getCount() {
        return count;
    }

    public String getInsanceChefUuid() {
        return insanceChefUuid;
    }

    public String getChefProfile() {
        return chefProfile;
    }

    public boolean isInstallChefClient() {
        return installChefClient;
    }

    public String getUserScriptId() {
        return userScriptId;
    }

    public String getUserScriptName() {
        return userScriptName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public List<String> getNetworks() {
        return networks;
    }

    public String getIp() {
        return ip;
    }

    public List<String> getSecurityGroups() {
        return securityGroups;
    }

    public String getSubNetwork() {
        return subNetwork;
    }

    @JsonIgnore
    public String getTagValue(String tagKey) {
        return CollectionUtils.isNotEmpty(tags) ? tags.get(tagKey) : null;
    }

    public Boolean getLockedTermination() {
        return lockedTermination;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.RUN_INSTANCE;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String instanceName;
        private String imageId;
        private String shape;
        private String instanceType;
        private String owner;
        private String keyName;
        private Integer stopAfter;
        private Integer terminateAfter;
        private int count = 1;
        private boolean installChefClient;
        private String insanceChefUuid;
        private String chefProfile;
        private String initScript;
        private String userScriptId;
        private String userScriptName;
        private String username;
        private String password;
        private String availabilityZone;
        private Map<String, String> additionalData;
        private Map<String, String> tags;
        private Boolean lockedTermination;
        private List<String> networks;
        private String subNetwork;
        private List<String> securityGroups;
        private String ip;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withNetworks(List<String> networks) {
            this.networks = networks;
            return this;
        }

        public Builder withSubNetwork(String subNetwork) {
            this.subNetwork = subNetwork;
            return this;
        }

        public Builder withSecurityGroups(List<String> securityGroups) {
            this.securityGroups = securityGroups;
            return this;
        }

        public Builder withIp(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder withInitScript(String initScript) {
            this.initScript = initScript;
            return this;
        }

        public Builder withInsanceChefUuid(String insanceChefUuid) {
            this.insanceChefUuid = insanceChefUuid;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withStopAfter(Integer stopAfter) {
            this.stopAfter = stopAfter;
            return this;
        }

        public Builder withInstallChefClient(boolean installChefClient) {
            this.installChefClient = installChefClient;
            return this;
        }

        public Builder withChefProfile(String chefProfile) {
            this.chefProfile = chefProfile;
            return this;
        }

        public Builder withTerminateAfter(Integer terminateAfter) {
            this.terminateAfter = terminateAfter;
            return this;
        }

        public Builder withInstanceName(String instanceName) {
            this.instanceName = instanceName;
            return this;
        }

        public Builder withImageId(String imageId) {
            this.imageId = imageId;
            return this;
        }

        public Builder withShape(String shape) {
            this.shape = shape;
            return this;
        }

        public Builder withInstanceType(String instanceType) {
            this.instanceType = instanceType;
            return this;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder withKeyName(String keyName) {
            this.keyName = keyName;
            return this;
        }

        public Builder withCount(int count) {
            this.count = count;
            return this;
        }

        public Builder withUserScriptId(String userScriptId) {
            this.userScriptId = userScriptId;
            return this;
        }

        public Builder withUserScriptName(String userScriptName) {
            this.userScriptName = userScriptName;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withAvailabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return this;
        }

        public Builder withAdditionalData(Map<String, String> additionalData) {
            this.additionalData = additionalData;
            return this;
        }

        public Builder withTags(Map<String, String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder withLockedTermination(Boolean lockedTermination) {
            this.lockedTermination = lockedTermination;
            return this;
        }

        public RunInstanceRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.hasText(instanceName, "instanceName");
            Assert.hasText(imageId, "imageId");
            if (StringUtils.isBlank(instanceType)) {
                Assert.hasText(shape, "shape");
            } else if (StringUtils.isBlank(shape)) {
                Assert.hasText(instanceType, "instanceType");
            } else {
                throw new M3SdkException("Shape or instance type parameter should be specified");
            }
            Assert.inRange(count, 1, 10, "count");
            return new RunInstanceRequest(this);
        }
    }
}
