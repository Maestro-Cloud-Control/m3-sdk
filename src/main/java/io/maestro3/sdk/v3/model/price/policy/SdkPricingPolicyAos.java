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

package io.maestro3.sdk.v3.model.price.policy;

import java.util.List;

public class SdkPricingPolicyAos {

    private String id;
    private String tenant;
    private String tenantDisplayName;
    private int credit;
    private int creditMonth;
    private long freeUsage;
    private long effectiveFrom;
    private long effectiveTo;
    private List<SdkPricingTier> unitTiers;
    private List<SdkPricingTier> providerTiers;
    private String status;
    private String description;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public long getFreeUsage() {
        return freeUsage;
    }

    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }

    public long getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(long effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public long getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(long effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public List<SdkPricingTier> getUnitTiers() {
        return unitTiers;
    }

    public void setUnitTiers(List<SdkPricingTier> unitTiers) {
        this.unitTiers = unitTiers;
    }

    public List<SdkPricingTier> getProviderTiers() {
        return providerTiers;
    }

    public void setProviderTiers(List<SdkPricingTier> providerTiers) {
        this.providerTiers = providerTiers;
    }

    public int getCreditMonth() {
        return creditMonth;
    }

    public void setCreditMonth(int creditMonth) {
        this.creditMonth = creditMonth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    public void setTenantDisplayName(String tenantDisplayName) {
        this.tenantDisplayName = tenantDisplayName;
    }
}
