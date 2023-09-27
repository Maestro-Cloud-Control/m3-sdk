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

package io.maestro3.sdk.v3.model.terraform.template;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkTerraformTemplateVariable {

    private String name;
    private VariableType type;
    private Object allowedValue;
    private Object value;
    private Object defaultValue;
    private String description;
    private boolean sensitive;

    public SdkTerraformTemplateVariable() {
    }

    public SdkTerraformTemplateVariable(SdkTerraformTemplateVariable variable) {
        this.name = variable.name;
        this.value = variable.value;
        this.defaultValue = variable.defaultValue;
        this.description = variable.description;
        this.type = variable.type;
        this.allowedValue = variable.allowedValue;
        this.sensitive = variable.sensitive;
    }


    public SdkTerraformTemplateVariable(String name, VariableType type, Object defaultValue, String description) {
        this(name, defaultValue, description);
        this.type = type;
    }

    public SdkTerraformTemplateVariable(String name, Object defaultValue, String description) {
        this.name = name;
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.allowedValue = defaultValue;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VariableType getType() {
        return type;
    }

    public void setType(VariableType type) {
        this.type = type;
    }

    public Object getAllowedValue() {
        return allowedValue;
    }

    public void setAllowedValue(Object allowedValue) {
        this.allowedValue = allowedValue;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

    @Override
    public String toString() {
        return "SdkTerraformTemplateVariable{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", allowedValue=" + allowedValue +
                ", value=" + value +
                ", defaultValue=" + defaultValue +
                ", description='" + description + '\'' +
                ", sensitive='" + sensitive + '\'' +
                '}';
    }
}