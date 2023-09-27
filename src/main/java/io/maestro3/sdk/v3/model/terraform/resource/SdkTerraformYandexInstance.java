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

public class SdkTerraformYandexInstance {
    private String instanceId;
    private String zone;

    public SdkTerraformYandexInstance() {
        // default for JSON deserializer
    }

    public SdkTerraformYandexInstance(String instanceId, String zone) {
        this.instanceId = instanceId;
        this.zone = zone;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "SdkTerraformYandexInstance{" +
                "instanceId='" + instanceId + '\'' +
                ", zone='" + zone + '\'' +
                '}';
    }
}

