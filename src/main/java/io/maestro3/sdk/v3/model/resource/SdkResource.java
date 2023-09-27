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

package io.maestro3.sdk.v3.model.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.instance.SdkResourceTag;

import java.util.Collections;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "cloud",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SdkOpenStackResource.class, name = "OPEN_STACK"),
    @JsonSubTypes.Type(value = SdkAwsResource.class, name = "AWS"),
    @JsonSubTypes.Type(value = SdkAzureResource.class, name = "AZURE"),
    @JsonSubTypes.Type(value = SdkYandexResource.class, name = "YANDEX"),
    @JsonSubTypes.Type(value = SdkGoogleResource.class, name = "GOOGLE"),
    @JsonSubTypes.Type(value = SdkVmwareResource.class, name = "VMWARE"),
    @JsonSubTypes.Type(value = SdkVSphereResource.class, name = "VSPHERE"),
    @JsonSubTypes.Type(value = SdkNutanixResource.class, name = "NUTANIX"),
    @JsonSubTypes.Type(value = SdkHypervResource.class, name = "HYPERV")
})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SdkResource {

    private String id;
    private SdkCloud cloud;
    private String tenant;
    private String region;
    private String service;
    private String type;
    private List<SdkResourceTag> tags = Collections.emptyList();

    public String getId() {
        return id;
    }

    public SdkResource setId(String id) {
        this.id = id;
        return this;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public SdkResource setCloud(SdkCloud cloud) {
        this.cloud = cloud;
        return this;
    }

    public String getTenant() {
        return tenant;
    }

    public SdkResource setTenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public SdkResource setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getService() {
        return service;
    }

    public SdkResource setService(String service) {
        this.service = service;
        return this;
    }

    public String getType() {
        return type;
    }

    public SdkResource setType(String type) {
        this.type = type;
        return this;
    }

    public List<SdkResourceTag> getTags() {
        return tags;
    }

    public SdkResource setTags(List<SdkResourceTag> tags) {
        this.tags = tags;
        return this;
    }
}
