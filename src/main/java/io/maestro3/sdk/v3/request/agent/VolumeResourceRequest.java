/*
 * Copyright 2025 Maestro Cloud Control LLC
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

package io.maestro3.sdk.v3.request.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Describes a requested volume resource for availability checking.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VolumeResourceRequest {

    private String tenant;
    private String region;
    private int sizeInGb;
    private Map<String, String> additionalData;

    public VolumeResourceRequest() {
        this.additionalData = new HashMap<>();
    }

    public VolumeResourceRequest(String tenant, String region, int sizeInGb, Map<String, String> additionalData) {
        this.tenant = tenant;
        this.region = region;
        this.sizeInGb = sizeInGb;
        this.additionalData = additionalData != null ? additionalData : new HashMap<>();
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

    public int getSizeInGb() {
        return sizeInGb;
    }

    public void setSizeInGb(int sizeInGb) {
        this.sizeInGb = sizeInGb;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public String toString() {
        return "VolumeResourceRequest{" +
                "tenant='" + tenant + '\'' +
                ", region='" + region + '\'' +
                ", sizeInGb=" + sizeInGb +
                ", additionalData=" + additionalData +
                '}';
    }
}
