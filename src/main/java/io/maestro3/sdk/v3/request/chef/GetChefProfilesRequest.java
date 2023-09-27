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

package io.maestro3.sdk.v3.request.chef;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = GetChefProfilesRequest.GetChefProfilesRequestBuilder.class)
public class GetChefProfilesRequest implements IRegionRequest {
    private final String region;
    private final String tenantName;

    private GetChefProfilesRequest(GetChefProfilesRequestBuilder builder) {
        this.region = builder.region;
        this.tenantName = builder.tenantName;
    }

    public static GetChefProfilesRequestBuilder builder() {
        return new GetChefProfilesRequestBuilder();
    }

    public String getRegion() {
        return region;
    }

    public String getTenantName() {
        return tenantName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_DEFAULT_REGION_CHEF_PROFILES;
    }

    public static final class GetChefProfilesRequestBuilder {
        private String region;
        private String tenantName;

        private GetChefProfilesRequestBuilder() {
        }

        public GetChefProfilesRequestBuilder withRegion(String regionName) {
            this.region = regionName;
            return this;
        }

        public GetChefProfilesRequestBuilder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public GetChefProfilesRequest build() {
            Assert.hasText(region, "region");
            Assert.hasText(tenantName, "tenantName");
            return new GetChefProfilesRequest(this);
        }
    }
}
