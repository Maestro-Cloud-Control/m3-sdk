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

package io.maestro3.sdk.v3.request.resource;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.instance.SdkResourceTag;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = ResourceRequest.Builder.class)
public class ResourceRequest implements IRequest {

    private final String tenantName;
    private final String region;
    private final SdkResourceTag tag;
    private final String group;

    private ResourceRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.tag = builder.tag;
        this.group = builder.group;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    public SdkResourceTag getTag() {
        return tag;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.LIST_RESOURCES;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private SdkResourceTag tag;

        private String group;

        public ResourceRequest.Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public ResourceRequest.Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public ResourceRequest.Builder withTag(SdkResourceTag tag) {
            this.tag = tag;
            return this;
        }

        public ResourceRequest.Builder withGroup(String group) {
            this.group = group;
            return this;
        }

        public ResourceRequest build() {
            Assert.hasText(tenantName,"tenantName");
            Assert.hasText(region,"region");
            return new ResourceRequest(this);
        }
    }
}
