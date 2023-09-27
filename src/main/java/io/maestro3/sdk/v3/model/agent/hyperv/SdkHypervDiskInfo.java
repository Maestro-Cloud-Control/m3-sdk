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

package io.maestro3.sdk.v3.model.agent.hyperv;

public class SdkHypervDiskInfo {

    private String diskUuid;
    private Integer deviceIndex;
    private String name;
    private Integer sizeInMB;
    private Boolean system;

    public SdkHypervDiskInfo() {
    }

    public SdkHypervDiskInfo(String diskUuid, Integer deviceIndex, String name, Integer sizeInMB, Boolean system) {
        this.diskUuid = diskUuid;
        this.deviceIndex = deviceIndex;
        this.name = name;
        this.sizeInMB = sizeInMB;
        this.system = system;
    }

    public String getDiskUuid() {
        return diskUuid;
    }

    public void setDiskUuid(String diskUuid) {
        this.diskUuid = diskUuid;
    }

    public Integer getDeviceIndex() {
        return deviceIndex;
    }

    public void setDeviceIndex(Integer deviceIndex) {
        this.deviceIndex = deviceIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSizeInMB() {
        return sizeInMB;
    }

    public void setSizeInMB(Integer sizeInMB) {
        this.sizeInMB = sizeInMB;
    }

    public Boolean getSystem() {
        return system;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }
}
