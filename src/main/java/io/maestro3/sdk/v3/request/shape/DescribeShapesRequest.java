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

package io.maestro3.sdk.v3.request.shape;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = DescribeShapesRequest.Builder.class)
public class DescribeShapesRequest implements ITenantRequest, IRegionRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;

    private DescribeShapesRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.LIST_REGION_SHAPES;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private String region;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public DescribeShapesRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            return new DescribeShapesRequest(this);
        }
    }
}
