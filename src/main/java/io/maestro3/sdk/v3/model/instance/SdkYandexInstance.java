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

public class SdkYandexInstance extends SdkInstance {

    private String folderId;
    private Integer coreFraction;
    private Integer storageGb;
    private List<SdkYandexDiskInfo> diskInfos;

    public SdkYandexInstance() {
        this.cloud = SdkCloud.YANDEX;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public Integer getCoreFraction() {
        return coreFraction;
    }

    public void setCoreFraction(Integer coreFraction) {
        this.coreFraction = coreFraction;
    }

    public Integer getStorageGb() {
        return storageGb;
    }

    public void setStorageGb(Integer storageGb) {
        this.storageGb = storageGb;
    }

    public List<SdkYandexDiskInfo> getDiskInfos() {
        return diskInfos;
    }

    public void setDiskInfos(List<SdkYandexDiskInfo> diskInfos) {
        this.diskInfos = diskInfos;
    }
}
