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
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.quota.PriceQuotaSearchCriteria;
import io.maestro3.sdk.v3.model.quota.PriceQuotaType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Set;

@JsonDeserialize(builder = QuotasByTenantsWithCriteriaRequest.Builder.class)
public class QuotasByTenantsWithCriteriaRequest implements IRequest {

    private final Set<String> tenantNames;
    private final PriceQuotaSearchCriteria criteria;
    private final SdkCloud cloud;
    private final boolean compressEachQuota;
    private final Set<PriceQuotaType> priceQuotaTypes;
    private final Set<String> regionNames;

    private QuotasByTenantsWithCriteriaRequest(Builder builder) {
        this.tenantNames = builder.tenantNames;
        this.criteria = builder.criteria;
        this.cloud = builder.cloud;
        this.compressEachQuota = builder.compressEachQuota;
        this.priceQuotaTypes = builder.priceQuotaTypes;
        this.regionNames = builder.regionNames;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Set<String> getTenantNames() {
        return tenantNames;
    }

    public PriceQuotaSearchCriteria getCriteria() {
        return criteria;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public boolean isCompressEachQuota() {
        return compressEachQuota;
    }

    public Set<PriceQuotaType> getPriceQuotaTypes() {
        return priceQuotaTypes;
    }

    public Set<String> getRegionNames() {
        return regionNames;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_QUOTAS_BY_TENANTS_AND_CRITERIA;
    }

    public static final class Builder {

        private Set<String> tenantNames;
        private PriceQuotaSearchCriteria criteria;
        private SdkCloud cloud;
        private boolean compressEachQuota;
        private Set<PriceQuotaType> priceQuotaTypes;
        private Set<String> regionNames;

        public Builder withTenantNames(Set<String> tenantNames) {
            this.tenantNames = tenantNames;
            return this;
        }

        public Builder withCriteria(PriceQuotaSearchCriteria criteria) {
            this.criteria = criteria;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withCompressEachQuota(boolean compressEachQuota) {
            this.compressEachQuota = compressEachQuota;
            return this;
        }

        public Builder withPriceQuotaTypes(Set<PriceQuotaType> priceQuotaTypes) {
            this.priceQuotaTypes = priceQuotaTypes;
            return this;
        }

        public Builder withRegionNames(Set<String> regionNames) {
            this.regionNames = regionNames;
            return this;
        }

        public QuotasByTenantsWithCriteriaRequest build() {
            Assert.notNull(criteria, "criteria");
            return new QuotasByTenantsWithCriteriaRequest(this);
        }
    }
}
