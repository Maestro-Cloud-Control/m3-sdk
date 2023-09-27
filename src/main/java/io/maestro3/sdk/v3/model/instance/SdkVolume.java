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

import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SdkVolume {

    private String regionId;
    private String tenantName;
    private String instanceId;
    private String volumeId;
    private String volumeName;
    private String sizeLabel;
    private String state;
    private boolean system;
    private Long realSizeMb;
    private List<String> attachments;
    private List<SdkResourceTag> tags = new ArrayList<>();
    private Map<String, String> parameters;
    private SdkCloud cloud;
    private Boolean deleteOnTermination;

    public SdkVolume() {
        //json
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system == null ? false : system;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }


    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    public String getSizeLabel() {
        return sizeLabel;
    }

    public void setSizeLabel(String sizeLabel) {
        this.sizeLabel = sizeLabel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<String> attachments) {
        this.attachments = attachments;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public Long getRealSizeMb() {
        return realSizeMb;
    }

    public SdkVolume setRealSizeMb(Long realSizeMb) {
        this.realSizeMb = realSizeMb;
        return this;
    }

    public List<SdkResourceTag> getTags() {
        return tags;
    }

    public void setTags(List<SdkResourceTag> tags) {
        this.tags = tags;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public SdkVolume setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public void setCloud(SdkCloud cloud) {
        this.cloud = cloud;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public Boolean getDeleteOnTermination() {
        return deleteOnTermination;
    }

    public void setDeleteOnTermination(Boolean deleteOnTermination) {
        this.deleteOnTermination = deleteOnTermination;
    }

    @Override
    public String toString() {
        return "SdkVolume{" +
                "regionId='" + regionId + '\'' +
                ", tenantName='" + tenantName + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", volumeId='" + volumeId + '\'' +
                ", volumeName='" + volumeName + '\'' +
                ", sizeLabel='" + sizeLabel + '\'' +
                ", state='" + state + '\'' +
                ", system=" + system +
                ", realSizeMb=" + realSizeMb +
                ", attachments=" + attachments +
                ", tags=" + tags +
                ", parameters=" + parameters +
                ", cloud=" + cloud +
                ", deleteOnTermination=" + deleteOnTermination +
                '}';
    }
}
