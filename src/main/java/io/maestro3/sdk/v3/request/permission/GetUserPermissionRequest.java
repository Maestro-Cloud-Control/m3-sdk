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

package io.maestro3.sdk.v3.request.permission;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = GetUserPermissionRequest.Builder.class)
public class GetUserPermissionRequest implements ITenantRequest {

    private final String tenantName;
    private final SdkCloud cloud;
    private final String env;

    private GetUserPermissionRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
        this.env = builder.env;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    public String getEnv() {
        return env;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_USER_PERMISSIONS;
    }

    public static final class Builder {

        private String tenantName;
        private SdkCloud cloud;
        private String env;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withEnv(String env) {
            this.env = env;
            return this;
        }

        public GetUserPermissionRequest build() {
            return new GetUserPermissionRequest(this);
        }
    }
}
