/*
 * Copyright 2024 Maestro Cloud Control LLC
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

package io.maestro3.sdk.v3.model.cf;

import io.maestro3.sdk.v3.model.terraform.template.SdkStackParameter;
import java.util.ArrayList;
import java.util.List;

public class SdkCfStack {

    private String stackName;
    private String templateName;
    private String status;
    private String statusReason;
    private String owner;
    private String description;
    private String tenant;
    private String region;
    private String stackType;
    private long creationTimestamp;
    private long lastModificationTimestamp;
    private boolean templateRemoved;
    private List<SdkStackParameter> parameters = new ArrayList<>();
    private List<SdkStackParameter> outputs = new ArrayList<>();

    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStackType() {
        return stackType;
    }

    public void setStackType(String stackType) {
        this.stackType = stackType;
    }

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public long getLastModificationTimestamp() {
        return lastModificationTimestamp;
    }

    public void setLastModificationTimestamp(long lastModificationTimestamp) {
        this.lastModificationTimestamp = lastModificationTimestamp;
    }

    public boolean isTemplateRemoved() {
        return templateRemoved;
    }

    public void setTemplateRemoved(boolean templateRemoved) {
        this.templateRemoved = templateRemoved;
    }

    public List<SdkStackParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<SdkStackParameter> parameters) {
        this.parameters = parameters;
    }

    public List<SdkStackParameter> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<SdkStackParameter> outputs) {
        this.outputs = outputs;
    }

}
