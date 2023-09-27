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
import java.util.Objects;

public class SdkAwsInstance extends SdkInstance {

    private String subnetId;
    private String vpcId;
    private List<String> deviceNames;
    private List<SdkAwsDiskInfo> diskInfos;
    private String nativeInstanceType;

    public SdkAwsInstance() {
        this.setCloud(SdkCloud.AWS);
    }

    public String getSubnetId() {
        return subnetId;
    }

    public void setSubnetId(String subnetId) {
        this.subnetId = subnetId;
    }

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    public List<String> getDeviceNames() {
        return deviceNames;
    }

    public void setDeviceNames(List<String> deviceNames) {
        this.deviceNames = deviceNames;
    }

    public List<SdkAwsDiskInfo> getDiskInfos() {
        return diskInfos;
    }

    public void setDiskInfos(List<SdkAwsDiskInfo> diskInfos) {
        this.diskInfos = diskInfos;
    }

    public String getNativeInstanceType() {
        return nativeInstanceType;
    }

    public void setNativeInstanceType(String nativeInstanceType) {
        this.nativeInstanceType = nativeInstanceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SdkAwsInstance)) return false;
        if (!super.equals(o)) return false;
        SdkAwsInstance that = (SdkAwsInstance) o;
        return Objects.equals(subnetId, that.subnetId) &&
            Objects.equals(vpcId, that.vpcId) &&
            Objects.equals(deviceNames, that.deviceNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subnetId, vpcId, deviceNames);
    }
}
