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

package io.maestro3.sdk.v3.model.terraform;

public class TerraformTaskVariable {
    private TaskVariableType type;
    private String name;
    private Object value;
    private boolean sensitive;

    public TerraformTaskVariable() {
    }

    public TerraformTaskVariable(TaskVariableType type, String name, Object value, boolean sensitive) {
        this.type = type;
        this.name = name;
        this.value = value;
        this.sensitive = sensitive;
    }

    public TaskVariableType getType() {
        return type;
    }

    public void setType(TaskVariableType type) {
        this.type = type;
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

    public boolean isSensitive() {
        return sensitive;
    }

    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

    @Override
    public String toString() {
        return "TerraformTaskVariable{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", sensitive=" + sensitive +
                '}';
    }
}
