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

/**
 * Describes a requested instance resource for availability checking.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstanceResourceRequest {

    private String tenant;
    private String region;
    private String shape;
    private String image;
    private int count;

    public InstanceResourceRequest() {
    }

    public InstanceResourceRequest(String tenant, String region, String shape, String image, int count) {
        this.tenant = tenant;
        this.region = region;
        this.shape = shape;
        this.image = image;
        this.count = count;
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

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "InstanceResourceRequest{" +
                "tenant='" + tenant + '\'' +
                ", region='" + region + '\'' +
                ", shape='" + shape + '\'' +
                ", image='" + image + '\'' +
                ", count=" + count +
                '}';
    }
}
