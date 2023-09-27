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

package io.maestro3.sdk.v3.model.quota;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.maestro3.sdk.internal.util.CollectionUtils;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SdkPriceQuota implements IPriceQuota {
    private String id;
    private String tenantDisplayName;
    private String regionName;
    private String tag;
    private boolean active;
    private boolean depleted;
    private Boolean fromIntegratedEnvironment;
    private boolean integratedEnvironmentDepleted;
    private Boolean sendNotificationsFromIntegratedEnvironment;
    private PriceQuotaType type;
    private List<IPriceQuotaMonthUsage> monthUsages = Collections.emptyList();
    private List<IPriceQuotaDailyUsage> dailyUsages = new ArrayList<>();
    private List<PriceQuotaExceedAction> actions = Collections.emptyList();
    private List<IPriceQuotaThreshold> thresholds = Collections.emptyList();
    private String owner;
    private String lastUpdatedBy;
    private String budgetName;
    private boolean isNative;

    public SdkPriceQuota(String tenantDisplayName) {
        this.tenantDisplayName = tenantDisplayName;
    }

    public SdkPriceQuota() {
    }

    public SdkPriceQuota(String tenantDisplayName,
                         String regionName,
                         PriceQuotaType type,
                         boolean active,
                         List<PriceQuotaExceedAction> actions,
                         String owner,
                         List<IPriceQuotaThreshold> thresholds) {
        this.tenantDisplayName = tenantDisplayName;
        this.regionName = regionName;
        this.type = type;
        this.active = active;
        this.actions = actions;
        this.owner = owner;
        this.thresholds = thresholds;
    }

    public SdkPriceQuota(String id,
                         String tenantDisplayName,
                         String regionName,
                         PriceQuotaType type,
                         List<IPriceQuotaMonthUsage> monthUsages,
                         boolean active,
                         boolean depleted,
                         List<PriceQuotaExceedAction> actions,
                         String owner,
                         String lastUpdatedBy,
                         List<IPriceQuotaThreshold> thresholds) {
        this(tenantDisplayName, regionName, type, active, actions, owner, thresholds);
        this.id = id;
        this.monthUsages = monthUsages;
        this.depleted = depleted;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public SdkPriceQuota(IPriceQuota clone) {
        this.id = clone.getId();
        this.tenantDisplayName = clone.getTenantDisplayName();
        this.regionName = clone.getRegionName();
        this.type = clone.getType();
        this.tag = clone.getTag();
        this.active = clone.isActive();
        this.depleted = clone.isDepleted();
        this.fromIntegratedEnvironment = clone.isFromIntegratedEnvironment();
        this.integratedEnvironmentDepleted = clone.isIntegratedEnvironmentDepleted();
        this.sendNotificationsFromIntegratedEnvironment = clone.getSendNotificationsFromIntegratedEnvironment();
        this.actions = clone.getActions();
        this.owner = clone.getOwner();
        this.lastUpdatedBy = clone.getLastUpdatedBy();
        if (CollectionUtils.isNotEmpty(clone.getThresholds())) {
            this.thresholds = clone.getThresholds().stream()
                    .map(SdkPriceQuotaThreshold::new)
                    .collect(Collectors.toList());
        }
        if (CollectionUtils.isNotEmpty(clone.getMonthUsages())) {
            this.monthUsages = clone.getMonthUsages().stream()
                    .map(SdkPriceQuotaMonthUsage::new)
                    .collect(Collectors.toList());
        }
        if (CollectionUtils.isNotEmpty(clone.getDailyUsages())) {
            this.dailyUsages = clone.getDailyUsages().stream()
                .map(SdkPriceQuotaDailyUsage::new)
                .collect(Collectors.toList());
        }
        this.budgetName = clone.getBudgetName();
        this.isNative = clone.isNative();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    @Override
    public void setTenantDisplayName(String tenantDisplayName) {
        this.tenantDisplayName = tenantDisplayName;
    }

    @Override
    public String getRegionName() {
        return regionName;
    }

    @Override
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public PriceQuotaType getType() {
        return type;
    }

    @Override
    public void setType(PriceQuotaType type) {
        this.type = type;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isInactive() {
        return !isActive();
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    @Override
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @Override
    @JsonIgnore
    public List<IPriceQuotaThreshold> getThresholds() {
        return thresholds;
    }

    @Override
    public void setThresholds(List<IPriceQuotaThreshold> thresholds) {
        this.thresholds = thresholds;
    }

    @Override
    public List<SdkPriceQuotaThreshold> getThresholdsSdkClasses() {
        return thresholds == null ? new ArrayList<>() : thresholds.stream()
                .map(SdkPriceQuotaThreshold::new)
                .collect(Collectors.toList());
    }

    @Override
    public void setThresholdsSdkClasses(List<SdkPriceQuotaThreshold> thresholds) {
        this.thresholds = new ArrayList<>(thresholds);
    }

    @Override
    public boolean isDepleted() {
        return depleted;
    }

    @Override
    public void setDepleted(boolean depleted) {
        this.depleted = depleted;
    }

    @Override
    public boolean isIntegratedEnvironmentDepleted() {
        return integratedEnvironmentDepleted;
    }

    @Override
    public void setIntegratedEnvironmentDepleted(boolean integratedEnvironmentDepleted) {
        this.integratedEnvironmentDepleted = integratedEnvironmentDepleted;
    }

    @Override
    public Boolean isFromIntegratedEnvironment() {
        return fromIntegratedEnvironment;
    }

    @Override
    public void setFromIntegratedEnvironment(Boolean fromIntegratedEnvironment) {
        this.fromIntegratedEnvironment = fromIntegratedEnvironment;
    }

    @Override
    public Boolean getSendNotificationsFromIntegratedEnvironment() {
        return sendNotificationsFromIntegratedEnvironment;
    }

    @Override
    public void setSendNotificationsFromIntegratedEnvironment(Boolean sendNotificationsFromIntegratedEnvironment) {
        this.sendNotificationsFromIntegratedEnvironment = sendNotificationsFromIntegratedEnvironment;
    }

    @Override
    public String getBudgetName() {
        return budgetName;
    }

    @Override
    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    @JsonIgnore
    @Override
    public boolean isNative() {
        return isNative;
    }

    @JsonIgnore
    @Override
    public void setNative(boolean isNative) {
        this.isNative = isNative;
    }

    @Override
    @JsonIgnore
    public List<IPriceQuotaMonthUsage> getMonthUsages() {
        return monthUsages;
    }

    @Override
    public void setMonthUsages(List<IPriceQuotaMonthUsage> monthUsages) {
        this.monthUsages = monthUsages;
    }

    @Override
    public List<SdkPriceQuotaMonthUsage> getMonthUsagesSdkClasses() {
        return monthUsages == null ? new ArrayList<>() : monthUsages.stream()
                .map(SdkPriceQuotaMonthUsage::new)
                .collect(Collectors.toList());
    }

    @Override
    public void setMonthUsagesSdkClasses(List<SdkPriceQuotaMonthUsage> monthUsages) {
        this.monthUsages = new ArrayList<>(monthUsages);
    }

    @Override
    public List<SdkPriceQuotaDailyUsage> getDailyUsagesSdkClasses() {
        return dailyUsages == null ? new ArrayList<>() : dailyUsages.stream()
            .map(SdkPriceQuotaDailyUsage::new)
            .collect(Collectors.toList());
    }

    @Override
    public void setDailyUsagesSdkClasses(List<SdkPriceQuotaDailyUsage> usages) {
        this.dailyUsages = new ArrayList<>(usages);
    }

    @Override
    public List<PriceQuotaExceedAction> getActions() {
        return actions;
    }

    @Override
    public void setActions(List<PriceQuotaExceedAction> actions) {
        this.actions = actions;
    }

    @Override
    @JsonIgnore
    public void addMonthUsage(IPriceQuotaMonthUsage usage) {
        if (CollectionUtils.isEmpty(monthUsages)) {
            monthUsages = new ArrayList<>();
        }
        monthUsages.add(usage);
    }

    @Override
    @JsonIgnore
    public IPriceQuotaMonthUsage getCurrentMonthUsage() {
        return monthUsages.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    @JsonIgnore
    @Override
    public IPriceQuotaMonthUsage getUsage(DateTime month) {
        IPriceQuotaMonthUsage monthUsage = monthUsages.stream()
                .filter(usage -> month.isEqual(usage.getMonth()))
                .findFirst()
                .orElse(null);
        if (monthUsage == null) {
            IPriceQuotaMonthUsage newMonthUsage = new SdkPriceQuotaMonthUsage(month);
            monthUsages.stream()
                    .max(Comparator.comparing(IPriceQuotaMonthUsage::getMonth))
                    .ifPresent(previousMonthUsage -> newMonthUsage.setValue(previousMonthUsage.getValue()));
            monthUsages.add(newMonthUsage);
            return newMonthUsage;
        }
        return monthUsage;
    }

    @Override
    public List<IPriceQuotaDailyUsage> getDailyUsages() {
        return dailyUsages;
    }

    @Override
    public void setDailyUsages(List<IPriceQuotaDailyUsage> dailyUsages) {
        this.dailyUsages = dailyUsages;
    }

    @Override
    public IPriceQuotaDailyUsage getYesterdayDailyUsage() {
        return dailyUsages.stream()
            .findFirst()
            .orElse(null);
    }

    @Override
    public void addDailyUsage(IPriceQuotaDailyUsage usage) {
        dailyUsages = new ArrayList<>();
        dailyUsages.add(new SdkPriceQuotaDailyUsage(usage));
    }

    @Override
    @JsonIgnore
    public boolean hasEachType() {
        return PriceQuotaType.isEach(this.type);
    }

    @Override
    public boolean hasDailyType() {
        return getType().isDaily();
    }

    public boolean isAlerted() {
        IPriceQuotaUsage lastUsage = hasDailyType() ? getYesterdayDailyUsage() : getCurrentMonthUsage();
        IPriceQuotaThreshold threshold = getThreshold(lastUsage.getPercentDepleted());
        return threshold != null && threshold.getAlertSentDate() != null;
    }

    public void setAlertSentDate(DateTime date) {
        IPriceQuotaUsage usage = hasDailyType() ? getYesterdayDailyUsage() : getCurrentMonthUsage();
        IPriceQuotaThreshold threshold = getThreshold(usage.getPercentDepleted());
        if (threshold != null) {
            threshold.setAlertSentDate(date);
        }
    }

    @Override
    public IPriceQuotaThreshold getThreshold(BigDecimal value) {
        return thresholds.stream()
            .filter(threshold -> threshold.getValue().equals(value))
            .findFirst()
            .orElse(null);
    }
}
