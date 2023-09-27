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

package io.maestro3.sdk.v3.request.ssh;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

/**
 * To describe instances that are currently using SSH key
 */
@JsonDeserialize(builder = DescribeKeyInstancesRequest.Builder.class)
public class DescribeKeyInstancesRequest implements ITenantRequest, IRegionRequest {

    private final SdkCloud cloud;
    // display name
    private final String tenantName;
    private final String region;
    private final String keyName;

    private DescribeKeyInstancesRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.keyName = builder.keyName;
    }

    public static Builder builder() {
        return new DescribeKeyInstancesRequest.Builder();
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public String getKeyName() {
        return keyName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_KEY_RELATED_INSTANCES;
    }

    public static final class Builder {
        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private String keyName;

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

        public Builder withKeyName(String keyName) {
            this.keyName = keyName;
            return this;
        }

        public DescribeKeyInstancesRequest build() {
            return new DescribeKeyInstancesRequest(this);
        }
    }
}

