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

public class SdkGoogleInstance extends SdkInstance {

    private String selfLink;
    private List<SdkGoogleDiskInfo> diskInfos;
    private String nativeInstanceType;
    private String networkLink;
    private String subNetworkLink;

    public SdkGoogleInstance() {
        this.setCloud(SdkCloud.GOOGLE);
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public List<SdkGoogleDiskInfo> getDiskInfos() {
        return diskInfos;
    }

    public void setDiskInfos(List<SdkGoogleDiskInfo> diskInfos) {
        this.diskInfos = diskInfos;
    }

    public String getNativeInstanceType() {
        return nativeInstanceType;
    }

    public void setNativeInstanceType(String nativeInstanceType) {
        this.nativeInstanceType = nativeInstanceType;
    }

    public String getNetworkLink() {
        return networkLink;
    }

    public void setNetworkLink(String networkLink) {
        this.networkLink = networkLink;
    }

    public String getSubNetworkLink() {
        return subNetworkLink;
    }

    public void setSubNetworkLink(String subNetworkLink) {
        this.subNetworkLink = subNetworkLink;
    }
}
