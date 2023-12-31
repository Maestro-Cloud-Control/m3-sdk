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

package io.maestro3.sdk.v3.model.resource.quota;

public enum ResourceQuotaType {

    INSTANCE("Instance Quota"),
    VOLUME("Storage Quota");

    private final String description;

    ResourceQuotaType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ResourceQuotaType fromValue(String name) {
        for (ResourceQuotaType value : values()) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Can't instantiate ResourceQuotaType by name: " + name);
    }
}
