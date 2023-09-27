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

package io.maestro3.sdk.v3.model.instance;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.details.InsightsRiskFactor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "cloud",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SdkOpenStackInstance.class, name = "OPEN_STACK"),
    @JsonSubTypes.Type(value = SdkAwsInstance.class, name = "AWS"),
    @JsonSubTypes.Type(value = SdkAzureInstance.class, name = "AZURE"),
    @JsonSubTypes.Type(value = SdkYandexInstance.class, name = "YANDEX"),
    @JsonSubTypes.Type(value = SdkGoogleInstance.class, name = "GOOGLE"),
    @JsonSubTypes.Type(value = SdkVMWareInstance.class, name = "VMWARE"),
    @JsonSubTypes.Type(value = SdkVSphereInstance.class, name = "VSPHERE"),
    @JsonSubTypes.Type(value = SdkNutanixInstance.class, name = "NUTANIX"),
    @JsonSubTypes.Type(value = SdkHypervInstance.class, name = "HYPERV")
})
public abstract class SdkInstance {

    protected SdkCloud cloud;
    private Integer cpuCount;
    private Integer memoryMb;
    private Integer storageGb;
    private String architecture;
    private String creationDate;
    private String imageId;
    private String instanceId;
    private String instanceName;
    private String instanceType;
    private String keyName;
    private String modificationDate;
    private String nativeImageId;
    private String owner;
    private String platform;
    private String privateDnsName;
    private String privateIpAddress;
    private String publicDnsName;
    private String publicIpAddress;
    private String region;
    private String regionId;
    private String tenant;
    private String tenantDisplayName;
    private String availabilityZone;
    private long creationDateTimestamp;
    private SdkInstanceState state;
    private List<SdkResourceTag> tags = new ArrayList<>();
    private List<String> volumesIds = new ArrayList<>();
    private List<String> securityGroupsNames = new ArrayList<>();
    private Date instanceStopDate;
    private Date instanceTerminationDate;
    private InsightsRiskFactor insightsIndex;
    private String nextScheduledAction;
    private String nextScheduledActionAt;
    private long nextScheduleActionTimestamp;

    public List<SdkResourceTag> getTags() {
        return tags;
    }

    public void setTags(List<SdkResourceTag> tags) {
        this.tags = tags;
    }

    public SdkInstanceState getState() {
        return state;
    }

    public void setState(SdkInstanceState state) {
        this.state = state;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public long getCreationDateTimestamp() {
        return creationDateTimestamp;
    }

    public void setCreationDateTimestamp(long creationDateTimestamp) {
        this.creationDateTimestamp = creationDateTimestamp;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPublicIpAddress() {
        return publicIpAddress;
    }

    public void setPublicIpAddress(String publicIpAddress) {
        this.publicIpAddress = publicIpAddress;
    }

    public String getPrivateIpAddress() {
        return privateIpAddress;
    }

    public void setPrivateIpAddress(String privateIpAddress) {
        this.privateIpAddress = privateIpAddress;
    }

    public String getPublicDnsName() {
        return publicDnsName;
    }

    public void setPublicDnsName(String publicDnsName) {
        this.publicDnsName = publicDnsName;
    }

    public String getPrivateDnsName() {
        return privateDnsName;
    }

    public void setPrivateDnsName(String privateDnsName) {
        this.privateDnsName = privateDnsName;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public List<String> getVolumesIds() {
        return volumesIds;
    }

    public void setVolumesIds(List<String> volumesIds) {
        this.volumesIds = volumesIds;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public void setCloud(SdkCloud cloud) {
        this.cloud = cloud;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    public void setTenantDisplayName(String tenantDisplayName) {
        this.tenantDisplayName = tenantDisplayName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getSecurityGroupsNames() {
        return securityGroupsNames;
    }

    public void setSecurityGroupsNames(List<String> securityGroupsNames) {
        this.securityGroupsNames = securityGroupsNames;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public Integer getMemoryMb() {
        return memoryMb;
    }

    public void setMemoryMb(Integer memoryMb) {
        this.memoryMb = memoryMb;
    }

    public Integer getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }

    public String getNativeImageId() {
        return nativeImageId;
    }

    public void setNativeImageId(String nativeImageId) {
        this.nativeImageId = nativeImageId;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public void setInstanceStopDate(Date instanceStopDate) {
        this.instanceStopDate = instanceStopDate;
    }

    public Date getInstanceStopDate() {
        return instanceStopDate;
    }

    public void setInstanceTerminationDate(Date instanceTerminationDate) {
        this.instanceTerminationDate = instanceTerminationDate;
    }

    public Date getInstanceTerminationDate() {
        return instanceTerminationDate;
    }

    public Integer getStorageGb() {
        return storageGb;
    }

    public void setStorageGb(Integer storageGb) {
        this.storageGb = storageGb;
    }

    public InsightsRiskFactor getInsightsIndex() {
        return insightsIndex;
    }

    public void setInsightsIndex(InsightsRiskFactor insightsIndex) {
        this.insightsIndex = insightsIndex;
    }

    public String getNextScheduledAction() {
        return nextScheduledAction;
    }

    public void setNextScheduledAction(String nextScheduledAction) {
        this.nextScheduledAction = nextScheduledAction;
    }

    public String getNextScheduledActionAt() {
        return nextScheduledActionAt;
    }

    public void setNextScheduledActionAt(String nextScheduledActionAt) {
        this.nextScheduledActionAt = nextScheduledActionAt;
    }

    public long getNextScheduleActionTimestamp() {
        return nextScheduleActionTimestamp;
    }

    public void setNextScheduleActionTimestamp(long nextScheduleActionTimestamp) {
        this.nextScheduleActionTimestamp = nextScheduleActionTimestamp;
    }

    @Override
    public String toString() {
        return "SdkInstance{" +
            "instanceId='" + instanceId + '\'' +
            ", cloud=" + cloud +
            ", instanceName='" + instanceName + '\'' +
            ", region='" + region + '\'' +
            ", tenant='" + tenant + '\'' +
            ", imageId='" + imageId + '\'' +
            ", publicIpAddress='" + publicIpAddress + '\'' +
            ", privateIpAddress='" + privateIpAddress + '\'' +
            ", publicDnsName='" + publicDnsName + '\'' +
            ", privateDnsName='" + privateDnsName + '\'' +
            ", instanceType='" + instanceType + '\'' +
            ", platform='" + platform + '\'' +
            ", state=" + state +
            ", creationDate='" + creationDate + '\'' +
            ", architecture='" + architecture + '\'' +
            ", owner='" + owner + '\'' +
            ", creationDateTimestamp=" + creationDateTimestamp +
            ", modificationDate='" + modificationDate + '\'' +
            ", tags=" + tags +
            ", volumesIds=" + volumesIds +
            ", securityGroupsNames=" + securityGroupsNames +
            ", regionId='" + regionId + '\'' +
            ", keyName='" + keyName + '\'' +
            '}';
    }
}
