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
import io.maestro3.sdk.v3.model.agent.vcloud.SdkVCloudDiskInfo;

import java.util.List;

public class SdkVMWareInstance extends SdkInstance {

    private long diskSize;
    private String vdc;
    private List<SdkVCloudDiskInfo> diskInfos;

    public SdkVMWareInstance() {
        this.cloud = SdkCloud.VMWARE;
    }

    public String getVdc() {
        return vdc;
    }

    public void setVdc(String vdc) {
        this.vdc = vdc;
    }

    public List<SdkVCloudDiskInfo> getDiskInfos() {
        return diskInfos;
    }

    public void setDiskInfos(List<SdkVCloudDiskInfo> diskInfos) {
        this.diskInfos = diskInfos;
    }

    public long getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(long diskSize) {
        this.diskSize = diskSize;
    }
}
