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
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.List;

public interface IPriceQuota {
    String getId( );

    void setId(String id);

    String getTenantDisplayName();

    void setTenantDisplayName(String tenantDisplayName);

    String getRegionName();

    void setRegionName(String regionName);

    PriceQuotaType getType();

    void setType(PriceQuotaType type);

    String getTag();

    void setTag(String tag);

    boolean isActive();

    void setActive(boolean active);

    boolean isInactive();

    String getOwner();

    void setOwner(String owner);

    String getLastUpdatedBy();

    void setLastUpdatedBy(String lastUpdatedBy);

    List<IPriceQuotaThreshold> getThresholds();

    void setThresholds(List<IPriceQuotaThreshold> thresholds);

    @JsonProperty(value = "thresholds")
    List<SdkPriceQuotaThreshold> getThresholdsSdkClasses();

    @JsonProperty(value = "thresholds")
    void setThresholdsSdkClasses(List<SdkPriceQuotaThreshold> thresholds);

    boolean isDepleted();

    void setDepleted(boolean depleted);

    boolean isIntegratedEnvironmentDepleted();

    void setIntegratedEnvironmentDepleted(boolean integratedEnvironmentDepleted);

    Boolean isFromIntegratedEnvironment();

    void setFromIntegratedEnvironment(Boolean fromIntegratedEnvironment);

    Boolean getSendNotificationsFromIntegratedEnvironment();

    void setSendNotificationsFromIntegratedEnvironment(Boolean sendNotificationsFromIntegratedEnvironment);

    String getBudgetName();

    void setBudgetName(String budgetName);

    boolean isNative();

    void setNative(boolean isNative);

    List<IPriceQuotaMonthUsage> getMonthUsages();

    void setMonthUsages(List<IPriceQuotaMonthUsage> monthUsages);

    @JsonProperty(value = "monthUsages")
    List<SdkPriceQuotaMonthUsage> getMonthUsagesSdkClasses();

    @JsonProperty(value = "monthUsages")
    void setMonthUsagesSdkClasses(List<SdkPriceQuotaMonthUsage> monthUsages);

    @JsonProperty(value = "dailyUsages")
    List<SdkPriceQuotaDailyUsage> getDailyUsagesSdkClasses();

    @JsonProperty(value = "dailyUsages")
    void setDailyUsagesSdkClasses(List<SdkPriceQuotaDailyUsage> usages);

    List<PriceQuotaExceedAction> getActions();

    void setActions(List<PriceQuotaExceedAction> actions);

    @JsonIgnore
    void addMonthUsage(IPriceQuotaMonthUsage usage);

    @JsonIgnore
    IPriceQuotaMonthUsage getCurrentMonthUsage();

    @JsonIgnore
    IPriceQuotaMonthUsage getUsage(DateTime month);

    @JsonIgnore
    List<IPriceQuotaDailyUsage> getDailyUsages();

    @JsonIgnore
    void setDailyUsages(List<IPriceQuotaDailyUsage> dailyUsages);

    @JsonIgnore
    IPriceQuotaDailyUsage getYesterdayDailyUsage();

    @JsonIgnore
    void addDailyUsage(IPriceQuotaDailyUsage usage);

    @JsonIgnore
    boolean hasEachType();

    @JsonIgnore
    boolean hasDailyType();

    @JsonIgnore
    boolean isAlerted();

    @JsonIgnore
    void setAlertSentDate(DateTime date);

    @JsonIgnore
    IPriceQuotaThreshold getThreshold(BigDecimal value);
}
