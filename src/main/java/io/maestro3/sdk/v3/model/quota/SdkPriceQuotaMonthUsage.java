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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.maestro3.sdk.internal.util.DateUtils;
import org.joda.time.DateTime;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SdkPriceQuotaMonthUsage implements IPriceQuotaMonthUsage {
    private DateTime month;
    private BigDecimal value;
    private BigDecimal used;
    private BigDecimal percentUsed;
    private BigDecimal percentDepleted;
    private DateTime estimatedDepleteDate;

    public SdkPriceQuotaMonthUsage() {
        this.value = BigDecimal.ZERO;
        this.used = BigDecimal.ZERO;
        this.percentUsed = BigDecimal.ZERO;
        this.percentDepleted = BigDecimal.ZERO;
    }

    public SdkPriceQuotaMonthUsage(DateTime month,
                                   BigDecimal value,
                                   BigDecimal used,
                                   BigDecimal percentUsed,
                                   BigDecimal percentDepleted,
                                   DateTime estimatedDepleteDate) {
        this.month = month;
        this.value = value;
        this.used = used;
        this.percentUsed = percentUsed;
        this.percentDepleted = percentDepleted;
        this.estimatedDepleteDate = estimatedDepleteDate;
    }

    public SdkPriceQuotaMonthUsage(IPriceQuotaMonthUsage clone) {
        this.month = clone.getMonth();
        this.used = clone.getUsed();
        this.percentUsed = clone.getPercentUsed();
        this.percentDepleted = clone.getPercentDepleted();
        this.value = clone.getValue();
        this.estimatedDepleteDate = clone.getEstimatedDepleteDate();
    }

    public SdkPriceQuotaMonthUsage(BigDecimal value) {
        this.month = DateUtils.getCurrentMonth();
        this.value = value;
        this.used = BigDecimal.ZERO;
        this.percentDepleted = BigDecimal.ZERO;
        this.percentUsed = BigDecimal.ZERO;
    }

    public SdkPriceQuotaMonthUsage(DateTime month) {
        this.month = month;
    }

    @Override
    public DateTime getMonth() {
        return month;
    }

    @Override
    public void setMonth(DateTime month) {
        this.month = month;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal getUsed() {
        return used;
    }

    @Override
    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    @Override
    public BigDecimal getPercentUsed() {
        return percentUsed;
    }

    @Override
    public void setPercentUsed(BigDecimal percentUsed) {
        this.percentUsed = percentUsed;
    }

    @Override
    public BigDecimal getPercentDepleted() {
        return percentDepleted;
    }

    @Override
    public void setPercentDepleted(BigDecimal percentDepleted) {
        this.percentDepleted = percentDepleted;
    }

    @Override
    public int compareTo(IPriceQuotaMonthUsage o) {
        return this.getMonth().compareTo(o.getMonth());
    }

    @Override
    public DateTime getEstimatedDepleteDate() {
        return estimatedDepleteDate;
    }

    @Override
    public void setEstimatedDepleteDate(DateTime estimatedDepleteDate) {
        this.estimatedDepleteDate = estimatedDepleteDate;
    }
}
