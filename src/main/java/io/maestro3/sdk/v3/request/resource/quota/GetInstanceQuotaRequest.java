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

package io.maestro3.sdk.v3.request.resource.quota;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = GetInstanceQuotaRequest.Builder.class)
public class GetInstanceQuotaRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;

    private GetInstanceQuotaRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_INSTANCE_QUOTA;
    }

    public static final class Builder {

        private String tenantName;
        private String region;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public GetInstanceQuotaRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            return new GetInstanceQuotaRequest(this);
        }
    }
}
