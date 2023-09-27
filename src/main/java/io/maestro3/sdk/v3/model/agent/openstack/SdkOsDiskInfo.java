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

package io.maestro3.sdk.v3.model.agent.openstack;

public class SdkOsDiskInfo {
    private long sizeInGb;
    private String type;
    private boolean bootable;
    private String nativeId;

    public SdkOsDiskInfo() {
    }

    public SdkOsDiskInfo(String nativeId, long sizeInGb, String type, boolean bootable) {
        this.sizeInGb = sizeInGb;
        this.nativeId = nativeId;
        this.bootable = bootable;
        this.type = type;
    }

    public String getNativeId() {
        return nativeId;
    }

    public void setNativeId(String nativeId) {
        this.nativeId = nativeId;
    }

    public boolean isBootable() {
        return bootable;
    }

    public void setBootable(boolean bootable) {
        this.bootable = bootable;
    }

    public long getSizeInGb() {
        return sizeInGb;
    }

    public void setSizeInGb(long sizeInGb) {
        this.sizeInGb = sizeInGb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
