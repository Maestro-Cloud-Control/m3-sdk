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

package io.maestro3.sdk.v3.model.script;

public class SdkScript {

    private String tenantName;
    private String fileName;
    private String content;
    private String owner;
    private String fileInfoId;
    private String fileInfoUrl;

    public SdkScript() {
    }

    public SdkScript(String tenantName, String fileName, String content, String owner, String fileInfoId) {
        this.tenantName = tenantName;
        this.fileName = fileName;
        this.content = content;
        this.owner = owner;
        this.fileInfoId = fileInfoId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(String fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public String getFileInfoUrl() {
        return fileInfoUrl;
    }

    public void setFileInfoUrl(String fileInfoUrl) {
        this.fileInfoUrl = fileInfoUrl;
    }
}
