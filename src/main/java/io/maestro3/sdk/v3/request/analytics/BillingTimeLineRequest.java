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

package io.maestro3.sdk.v3.request.analytics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.List;

@JsonDeserialize(builder = BillingTimeLineRequest.Builder.class)
public class BillingTimeLineRequest implements IRequest {

    private final List<String> zoneIds;
    private final List<String> types;
    private final String tenantName;
    private final String resourceId;

    private BillingTimeLineRequest(Builder builder) {
        this.zoneIds = builder.zoneIds;
        this.types = builder.types;
        this.tenantName = builder.tenantName;
        this.resourceId = builder.resourceId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<String> getZoneIds() {
        return zoneIds;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getResourceId() {
        return resourceId;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_BILLING_TIME_LINES;
    }

    public static final class Builder {

        private List<String> zoneIds;
        private List<String> types;
        private String tenantName;
        private String resourceId;

        public Builder withZoneIds(List<String> zoneIds) {
            this.zoneIds = zoneIds;
            return this;
        }

        public Builder withTypes(List<String> types) {
            this.types = types;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withResourceId(String resourceId) {
            this.resourceId = resourceId;
            return this;
        }

        public BillingTimeLineRequest build() {
            Assert.notEmpty(zoneIds, "zoneIds can not be null");
            Assert.notEmpty(types, "types can not be null");
            return new BillingTimeLineRequest(this);
        }
    }
}
