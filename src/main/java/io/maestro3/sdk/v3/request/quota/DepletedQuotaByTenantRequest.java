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

package io.maestro3.sdk.v3.request.quota;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.quota.PriceQuotaTypeSearchCriteria;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = DepletedQuotaByTenantRequest.Builder.class)
public class DepletedQuotaByTenantRequest implements IRequest {

    private final String tenantName;
    private final PriceQuotaTypeSearchCriteria typesCriteria;

    private DepletedQuotaByTenantRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.typesCriteria = builder.typesCriteria;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantName() {
        return tenantName;
    }

    public PriceQuotaTypeSearchCriteria getTypesCriteria() {
        return typesCriteria;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_DEPLETED_QUOTA_BY_TENANT;
    }

    public static final class Builder {

        private String tenantName;
        private PriceQuotaTypeSearchCriteria typesCriteria;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withTypesCriteria(PriceQuotaTypeSearchCriteria typesCriteria) {
            this.typesCriteria = typesCriteria;
            return this;
        }

        public DepletedQuotaByTenantRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.notNull(typesCriteria, "typesCriteria");
            return new DepletedQuotaByTenantRequest(this);
        }
    }
}
