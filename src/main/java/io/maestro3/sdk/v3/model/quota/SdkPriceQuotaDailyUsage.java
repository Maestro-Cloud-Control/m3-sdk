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
import org.joda.time.DateTimeZone;

import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SdkPriceQuotaDailyUsage implements IPriceQuotaDailyUsage {
    private DateTime date;
    private BigDecimal value;
    private BigDecimal used;
    private BigDecimal percentUsed;
    private BigDecimal percentDepleted;
    private DateTime estimatedDepleteDate;

    public SdkPriceQuotaDailyUsage() {
        this(BigDecimal.ZERO);
    }

    public SdkPriceQuotaDailyUsage(BigDecimal value) {
        this.date = DateUtils.truncateToDay(new DateTime(DateTimeZone.UTC)).minusDays(1);
        this.value = value;
        this.used = BigDecimal.ZERO;
        this.percentDepleted = BigDecimal.ZERO;
        this.percentUsed = BigDecimal.ZERO;
    }

    public SdkPriceQuotaDailyUsage(DateTime date) {
        this.date = date;
        this.value = BigDecimal.ZERO;
        this.used = BigDecimal.ZERO;
        this.percentUsed = BigDecimal.ZERO;
        this.percentDepleted = BigDecimal.ZERO;
    }

    public SdkPriceQuotaDailyUsage(DateTime date,
                                   BigDecimal value,
                                   BigDecimal used) {
        this.date = date;
        this.value = value;
        this.used = used;
        this.percentUsed = used.divide(value, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        this.percentDepleted = value.compareTo(used) < 0 ? BigDecimal.valueOf(100) : BigDecimal.ZERO;
    }

    public SdkPriceQuotaDailyUsage(IPriceQuotaDailyUsage clone) {
        this.date = clone.getDate();
        this.used = clone.getUsed();
        this.percentUsed = clone.getPercentUsed();
        this.percentDepleted = clone.getPercentDepleted();
        this.value = clone.getValue();
        this.estimatedDepleteDate = clone.getEstimatedDepleteDate();
    }

    @Override
    public DateTime getDate() {
        return date;
    }

    @Override
    public void setDate(DateTime date) {
        this.date = date;
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
    public int compareTo(IPriceQuotaDailyUsage o) {
        return 0;
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
