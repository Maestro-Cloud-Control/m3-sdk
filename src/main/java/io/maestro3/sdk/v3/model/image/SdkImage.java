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

package io.maestro3.sdk.v3.model.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkImage {

    private String tenant;

    private String region;

    private String alias;

    private String name;

    private String description;

    private long createdDate;

    private String imageId;

    private String osType;

    private String imageType;

    private String imageState;

    private SdkCloud cloud;

    private String regionId;

    private Double minMemoryGb;

    private Integer minStorageSizeGb;

    private String virtualizationType;

    private String architecture;

    private String rootVolumeName;

    private String owner;

    private List<String> attachedVolumes = Collections.emptyList();

    private Boolean deleted;

    private String folderId;

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getImageState() {
        return imageState;
    }

    public void setImageState(String imageState) {
        this.imageState = imageState;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public void setCloud(SdkCloud cloud) {
        this.cloud = cloud;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Double getMinMemoryGb() {
        return minMemoryGb;
    }

    public void setMinMemoryGb(Double minMemoryGb) {
        this.minMemoryGb = minMemoryGb;
    }

    public Integer getMinStorageSizeGb() {
        return minStorageSizeGb;
    }

    public void setMinStorageSizeGb(Integer minStorageSizeGb) {
        this.minStorageSizeGb = minStorageSizeGb;
    }

    public String getVirtualizationType() {
        return virtualizationType;
    }

    public void setVirtualizationType(String virtualizationType) {
        this.virtualizationType = virtualizationType;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public String getRootVolumeName() {
        return rootVolumeName;
    }

    public void setRootVolumeName(String rootVolumeName) {
        this.rootVolumeName = rootVolumeName;
    }

    public List<String> getAttachedVolumes() {
        return attachedVolumes;
    }

    public void setAttachedVolumes(List<String> attachedVolumes) {
        this.attachedVolumes = attachedVolumes;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    @Override
    public String toString() {
        return "SdkImage{" +
                "tenant='" + tenant + '\'' +
                ", region='" + region + '\'' +
                ", alias='" + alias + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", imageId='" + imageId + '\'' +
                ", osType='" + osType + '\'' +
                ", imageType='" + imageType + '\'' +
                ", imageState='" + imageState + '\'' +
                ", cloud=" + cloud +
                ", regionId='" + regionId + '\'' +
                ", minStorageSizeGb='" + minStorageSizeGb + '\'' +
                ", minMemoryGb='" + minMemoryGb + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
