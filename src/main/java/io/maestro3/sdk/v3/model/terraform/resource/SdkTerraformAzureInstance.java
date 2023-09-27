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

package io.maestro3.sdk.v3.model.terraform.resource;

public class SdkTerraformAzureInstance {

    private String location;
    private String resourceGroup;
    private String name;

    public SdkTerraformAzureInstance() {
    }

    public SdkTerraformAzureInstance(String location, String resourceGroup, String name) {
        this.location = location;
        this.resourceGroup = resourceGroup;
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SdkTerraformAzureInstance{" +
                "location='" + location + '\'' +
                ", resourceGroup='" + resourceGroup + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
