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

package io.maestro3.sdk.v3.request.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = ManagementConsoleRequest.Builder.class)
public class ManagementConsoleRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String accessType;

    private ManagementConsoleRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
        this.accessType = builder.accessType;
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

    public String getAccessType() {
        return accessType;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SEND_MANAGEMENT_CONSOLE_ACCESS;
    }

    @Override
    public String toString() {
        return "ManagementConsoleRequest{" +
                "tenant='" + tenantName + '\'' +
                ", cloud=" + cloud +
                ", accessType='" + accessType + '\'' +
                '}';
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private String accessType;

        public Builder withTenantName(String tenant) {
            this.tenantName = tenant;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withAccessType(String accessType) {
            this.accessType = accessType;
            return this;
        }

        public ManagementConsoleRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(accessType, "accessType");
            return new ManagementConsoleRequest(this);
        }
    }
}
