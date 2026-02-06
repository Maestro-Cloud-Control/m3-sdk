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
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.CollectionUtils;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.quota.PriceQuotaSearchCriteria;
import io.maestro3.sdk.v3.model.quota.PriceQuotaType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Set;

@JsonDeserialize(builder = QuotasByTenantsWithCriteriaRequest.Builder.class)
public class QuotasByTenantsWithCriteriaRequest implements IRequest {

    private final String tenantGroup;
    private final Long from;
    private final Long to;
    private final Set<String> tenantNames;
    private final PriceQuotaSearchCriteria criteria;
    private final boolean compressEachQuota;
    private final Set<PriceQuotaType> priceQuotaTypes;
    private final String regionName;

    private QuotasByTenantsWithCriteriaRequest(Builder builder) {
        this.tenantGroup = builder.tenantGroup;
        this.from = builder.from;
        this.to = builder.to;
        this.tenantNames = builder.tenantNames;
        this.criteria = builder.criteria;
        this.compressEachQuota = builder.compressEachQuota;
        this.priceQuotaTypes = builder.priceQuotaTypes;
        this.regionName = builder.regionName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantGroup() {
        return tenantGroup;
    }

    public Long getFrom() {
        return from;
    }

    public Long getTo() {
        return to;
    }

    public Set<String> getTenantNames() {
        return tenantNames;
    }

    public PriceQuotaSearchCriteria getCriteria() {
        return criteria;
    }

    public boolean isCompressEachQuota() {
        return compressEachQuota;
    }

    public Set<PriceQuotaType> getPriceQuotaTypes() {
        return priceQuotaTypes;
    }

    public String getRegionName() {
        return regionName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_QUOTAS_BY_TENANTS_AND_CRITERIA;
    }

    public static final class Builder {

        private String tenantGroup;
        private Long from;
        private Long to;
        private Set<String> tenantNames;
        private PriceQuotaSearchCriteria criteria;
        private boolean compressEachQuota;
        private Set<PriceQuotaType> priceQuotaTypes;
        private String regionName;

        public Builder withTenantGroup(String tenantGroup) {
            this.tenantGroup = tenantGroup;
            return this;
        }

        public Builder withFrom(Long from) {
            this.from = from;
            return this;
        }

        public Builder withTo(Long to) {
            this.to = to;
            return this;
        }

        public Builder withTenantNames(Set<String> tenantNames) {
            this.tenantNames = tenantNames;
            return this;
        }

        public Builder withCriteria(PriceQuotaSearchCriteria criteria) {
            this.criteria = criteria;
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

        public Builder withRegionName(String regionName) {
            this.regionName = regionName;
            return this;
        }

        public QuotasByTenantsWithCriteriaRequest build() {
            Assert.notNull(criteria, "criteria");

            if ((StringUtils.isBlank(tenantGroup) && CollectionUtils.isEmpty(tenantNames))
                    || StringUtils.isNotBlank(tenantGroup) && CollectionUtils.isNotEmpty(tenantNames)) {
                throw new M3SdkException("tenantGroup or tenantNames must be specified");
            }

            if (StringUtils.isNotBlank(tenantGroup)) {
                Assert.notNull(from, "from is required for the tenantGroup parameter");
                Assert.notNull(to, "to is required for the tenantGroup parameter");
            }
            return new QuotasByTenantsWithCriteriaRequest(this);
        }
    }
}
