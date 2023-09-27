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
import org.joda.time.DateTime;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SdkPriceQuotaThreshold implements IPriceQuotaThreshold {
    private BigDecimal value;
    private boolean depleted;
    private DateTime depleteDate;
    private DateTime alertSentDate;

    public SdkPriceQuotaThreshold() {
        this.value = BigDecimal.ZERO;
    }

    public SdkPriceQuotaThreshold(BigDecimal value) {
        this.value = value;
    }

    public SdkPriceQuotaThreshold(BigDecimal value, boolean depleted, DateTime depleteDate, DateTime alertSentDate) {
        this.value = value;
        this.depleted = depleted;
        this.depleteDate = depleteDate;
        this.alertSentDate = alertSentDate;
    }

    public SdkPriceQuotaThreshold(IPriceQuotaThreshold clone) {
        this.value = clone.getValue();
        this.depleted = clone.isDepleted();
        this.depleteDate = clone.getDepleteDate();
        this.alertSentDate = clone.getAlertSentDate();
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
    public boolean isDepleted() {
        return depleted;
    }

    @Override
    public void setDepleted(boolean depleted) {
        this.depleted = depleted;
    }

    @Override
    public boolean isNotDepleted() {
        return !isDepleted();
    }

    @Override
    public void deplete() {
        this.depleted = true;
    }

    @Override
    public DateTime getDepleteDate() {
        return depleteDate;
    }

    @Override
    public void setDepleteDate(DateTime depleteDate) {
        this.depleteDate = depleteDate;
    }

    @Override
    public DateTime getAlertSentDate() {
        return alertSentDate;
    }

    @Override
    public void setAlertSentDate(DateTime alertSentDate) {
        this.alertSentDate = alertSentDate;
    }
}
