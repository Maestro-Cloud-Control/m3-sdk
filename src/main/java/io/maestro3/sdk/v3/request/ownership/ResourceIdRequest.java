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

package io.maestro3.sdk.v3.request.ownership;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.ownership.ResourceType;

import java.util.Map;
import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class ResourceIdRequest {

    private final String resourceId;
    private final String tenant;
    private final String region;
    private final ResourceType resourceType;
    private final SdkCloud cloud;

    protected ResourceIdRequest(ResourceIdRequestBuilder<?,?> builder, SdkCloud cloud) {
        this.tenant = builder.tenant;
        this.resourceId = builder.resourceId;
        this.region = builder.region;
        this.resourceType = builder.resourceType;
        this.cloud = cloud;
    }

    public String getTenant() {
        return tenant;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getRegion() {
        return region;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public abstract String getAccountId();

    @JsonIgnore
    public abstract Map<String, String> getParams();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceIdRequest that = (ResourceIdRequest) o;
        return Objects.equals(getParams(), that.getParams()) &&
                resourceType == that.resourceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getParams());
    }

    public abstract static class ResourceIdRequestBuilder<B extends ResourceIdRequestBuilder<B, R>, R extends ResourceIdRequest> {

        private String resourceId;
        private String tenant;
        private String region;
        private ResourceType resourceType;

        protected abstract B getThis();

        protected abstract R build();

        public B withResourceId(String resourceId) {
            this.resourceId = resourceId;
            return getThis();
        }

        public B withTenant(String tenant) {
            this.tenant = tenant;
            return getThis();
        }

        public B withRegion(String region) {
            this.region = region;
            return getThis();
        }

        public B withResourceType(ResourceType resourceType) {
            this.resourceType = resourceType;
            return getThis();
        }

        protected void validateCommonParams() {
            Assert.hasText(resourceId, "resourceId");
            Assert.notNull(resourceType, "resourceType");
        }
    }
}
