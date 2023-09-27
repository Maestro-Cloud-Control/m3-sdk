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

import java.util.List;

@JsonDeserialize(builder = DescribeKeysRequest.Builder.class)
public class DescribeKeysRequest implements ITenantRequest, IRegionRequest {

    private final String tenantName;
    private final SdkCloud cloud;
    private final String region;
    private final String name;
    private final String email;
    private final List<String> maestroStatuses;

    private DescribeKeysRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
        this.region = builder.region;
        this.name = builder.name;
        this.email = builder.email;
        this.maestroStatuses = builder.maestroStatuses;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantName() {
        return tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getMaestroStatuses() {
        return maestroStatuses;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_KEYS;
    }

    public static final class Builder {

        private String tenantName;
        private SdkCloud cloud;
        private String region;
        private String name;
        private String email;
        private List<String> maestroStatuses;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withMaestroStatuses(List<String> maestroStatuses) {
            this.maestroStatuses = maestroStatuses;
            return this;
        }

        public DescribeKeysRequest build() {
            return new DescribeKeysRequest(this);
        }
    }
}
