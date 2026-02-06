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

package io.maestro3.sdk.v3.request.function;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = DescribeFunctionRequest.Builder.class)
public class DescribeFunctionRequest implements IRegionRequest {

    private final SdkCloud cloud;
    // display name
    private final String tenantName;
    private final String region;
    private final String functionName;
    private final String resourceGroup;

    private DescribeFunctionRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.functionName = builder.functionName;
        this.resourceGroup = builder.resourceGroup;
    }

    public static Builder builder() {
        return new DescribeFunctionRequest.Builder();
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_FUNCTION;
    }

    public static final class Builder {
        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private String functionName;
        private String resourceGroup;

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

        public Builder withFunctionName(String functionName) {
            this.functionName = functionName;
            return this;
        }

        public Builder withResourceGroup(String resourceGroup) {
            this.resourceGroup = resourceGroup;
            return this;
        }

        public DescribeFunctionRequest build() {
            return new DescribeFunctionRequest(this);
        }
    }
}