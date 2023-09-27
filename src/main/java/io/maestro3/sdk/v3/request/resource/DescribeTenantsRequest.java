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
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Set;

@JsonDeserialize(builder = DescribeTenantsRequest.Builder.class)
public class DescribeTenantsRequest implements IRequest {

    // optional params
    private final SdkCloud cloud;
    private final Set<String> tenantNames;
    private final boolean inactive; //include inactive regions
    private final boolean hidden; //include hidden regions

    private DescribeTenantsRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantNames = builder.tenantNames;
        this.inactive = builder.inactive;
        this.hidden = builder.hidden;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public Set<String> getTenantNames() {
        return tenantNames;
    }

    public boolean isInactive() {
        return inactive;
    }

    public boolean isHidden() {
        return hidden;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_TENANTS;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private Set<String> tenantNames;
        private boolean inactive;
        private boolean hidden;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantNames(Set<String> tenantNames) {
            this.tenantNames = tenantNames;
            return this;
        }

        public Builder withInactive(boolean isInactive) {
            this.inactive = isInactive;
            return this;
        }

        public Builder withHidden(boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        public DescribeTenantsRequest build() {
            return new DescribeTenantsRequest(this);
        }
    }
}
