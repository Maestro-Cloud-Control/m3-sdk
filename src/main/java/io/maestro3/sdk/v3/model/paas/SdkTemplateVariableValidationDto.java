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

package io.maestro3.sdk.v3.model.paas;

import io.maestro3.sdk.v3.model.terraform.template.SdkTerraformTemplateVariable;
import io.maestro3.sdk.v3.model.terraform.template.VariableType;

public class SdkTemplateVariableValidationDto {

    private String name;
    private VariableType type;
    private Object defaultValue;
    private String description;
    private boolean sensitive;
    private Object value;
    private String errorMessage;

    public SdkTemplateVariableValidationDto() {
        //json
    }

    public static SdkTemplateVariableValidationDto fromSdkTemplateVariable(SdkTerraformTemplateVariable variable) {
        SdkTemplateVariableValidationDto dto = new SdkTemplateVariableValidationDto();
        dto.setName(variable.getName());
        dto.setType(variable.getType());
        dto.setDefaultValue(variable.getDefaultValue());
        dto.setDescription(variable.getDescription());
        dto.setSensitive(variable.isSensitive());
        dto.setValue(variable.getValue());
        return dto;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }
}
