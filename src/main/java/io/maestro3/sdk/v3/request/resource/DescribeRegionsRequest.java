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
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = DescribeRegionsRequest.Builder.class)
public class DescribeRegionsRequest implements ITenantRequest {

    private final String tenantName;
    private final SdkCloud cloud;

    // optional params
    private final boolean inactive;
    private final boolean includeHidden;

    private DescribeRegionsRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
        this.inactive = builder.inactive;
        this.includeHidden = builder.includeHidden;
    }

    public String getTenantName() {
        return tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public boolean isInactive() {
        return inactive;
    }

    public boolean isIncludeHidden() {
        return includeHidden;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_REGIONS;
    }

    public static final class Builder {

        private String tenantName;
        private SdkCloud cloud;
        private boolean inactive;
        private boolean includeHidden;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withInactive(boolean isInactive) {
            this.inactive = isInactive;
            return this;
        }

        public Builder withIncludeHidden(boolean includeHidden) {
            this.includeHidden = includeHidden;
            return this;
        }

        public DescribeRegionsRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            return new DescribeRegionsRequest(this);
        }
    }
}
