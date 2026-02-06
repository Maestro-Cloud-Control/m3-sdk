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

package io.maestro3.sdk.v3.model.cf;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateProviderType;
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateStatus;
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateType;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkTemplateInfo {

    private String id;
    private SdkCloud cloud;
    private String templateName;
    private String description;
    private SdkTemplateType templateType;
    private SdkTemplateStatus status;
    private String resourceId;
    private SdkTemplateProviderType providerType;
    private String owner;
    protected Map<String, Object> fields = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public void setCloud(SdkCloud cloud) {
        this.cloud = cloud;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SdkTemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(SdkTemplateType templateType) {
        this.templateType = templateType;
    }

    public SdkTemplateStatus getStatus() {
        return status;
    }

    public void setStatus(SdkTemplateStatus status) {
        this.status = status;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public SdkTemplateProviderType getProviderType() {
        return providerType;
    }

    public void setProviderType(SdkTemplateProviderType providerType) {
        this.providerType = providerType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "TemplateInfo{" +
                "cloud=" + cloud +
                ", templateName='" + templateName + '\'' +
                ", description='" + description + '\'' +
                ", templateType=" + templateType +
                ", status=" + status +
                ", resourceId='" + resourceId + '\'' +
                ", providerType=" + providerType +
                ", owner='" + owner + '\'' +
                '}';
    }

}
