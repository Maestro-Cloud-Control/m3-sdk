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

package io.maestro3.sdk.v3.model.agent.vcloud;

public class SdkVCloudDiskInfo {
    private String storageProfile;
    private long sizeInGb;
    private String attachId;
    private String namedDiskId;
    private String diskName;

    public SdkVCloudDiskInfo() {
    }

    public SdkVCloudDiskInfo(String storageProfile, long sizeInGb, String attachId, String namedDiskId, String diskName) {
        this.namedDiskId = namedDiskId;
        this.diskName = diskName;
        this.storageProfile = storageProfile;
        this.attachId = attachId;
        this.sizeInGb = sizeInGb;
    }

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    public String getNamedDiskId() {
        return namedDiskId;
    }

    public void setNamedDiskId(String namedDiskId) {
        this.namedDiskId = namedDiskId;
    }

    public String getStorageProfile() {
        return storageProfile;
    }

    public void setStorageProfile(String storageProfile) {
        this.storageProfile = storageProfile;
    }

    public long getSizeInGb() {
        return sizeInGb;
    }

    public void setSizeInGb(long sizeInGb) {
        this.sizeInGb = sizeInGb;
    }
}
