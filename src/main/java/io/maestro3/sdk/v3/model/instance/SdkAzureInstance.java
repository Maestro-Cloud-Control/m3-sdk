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

import java.util.List;

public class SdkAzureInstance extends SdkInstance {

    private String resourceGroup;
    private String nativeInstanceId;
    private String nativeInstanceType;
    private String networkInterfaceReferenceId;
    private List<SdkAzureDiskInfo> diskInfos;

    public SdkAzureInstance() {
        this.setCloud(SdkCloud.AZURE);
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    public String getNetworkInterfaceReferenceId() {
        return networkInterfaceReferenceId;
    }

    public void setNetworkInterfaceReferenceId(String networkInterfaceReferenceId) {
        this.networkInterfaceReferenceId = networkInterfaceReferenceId;
    }

    public String getNativeInstanceId() {
        return nativeInstanceId;
    }

    public void setNativeInstanceId(String nativeInstanceId) {
        this.nativeInstanceId = nativeInstanceId;
    }

    public List<SdkAzureDiskInfo> getDiskInfos() {
        return diskInfos;
    }

    public void setDiskInfos(List<SdkAzureDiskInfo> diskInfos) {
        this.diskInfos = diskInfos;
    }

    public String getNativeInstanceType() {
        return nativeInstanceType;
    }

    public void setNativeInstanceType(String nativeInstanceType) {
        this.nativeInstanceType = nativeInstanceType;
    }
}
