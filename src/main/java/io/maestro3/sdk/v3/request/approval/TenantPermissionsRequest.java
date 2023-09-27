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

package io.maestro3.sdk.v3.request.approval;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.Objects;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = TenantPermissionsRequest.Builder.class)
public class TenantPermissionsRequest {
    private final String tenantDisplayName;
    private final SdkCloud cloud;
    private final Set<String> permissions;

    private TenantPermissionsRequest(Builder builder) {
        this.tenantDisplayName = builder.tenantDisplayName;
        this.cloud = builder.cloud;
        this.permissions = builder.permissions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TenantPermissionsRequest that = (TenantPermissionsRequest) o;
        return Objects.equals(tenantDisplayName, that.tenantDisplayName) &&
            cloud == that.cloud &&
            Objects.equals(permissions, that.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantDisplayName, cloud, permissions);
    }

    public static final class Builder {

        private String tenantDisplayName;
        private SdkCloud cloud;
        private Set<String> permissions;


        public Builder withTenantDisplayName(String tenantDisplayName) {
            this.tenantDisplayName = tenantDisplayName;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withPermissions(Set<String> permissions) {
            this.permissions = permissions;
            return this;
        }

        public TenantPermissionsRequest build() {
            Assert.hasText(tenantDisplayName, "tenantDisplayName cannot be null or empty");
            Assert.notNull(cloud, "cloud cannot be null or empty");
            Assert.notEmpty(permissions, "permissions can not be null or empty");
            return new TenantPermissionsRequest(this);
        }
    }
}
