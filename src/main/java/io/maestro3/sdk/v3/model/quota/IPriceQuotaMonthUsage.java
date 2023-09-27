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

import org.joda.time.DateTime;

import java.math.BigDecimal;

public interface IPriceQuotaMonthUsage extends IPriceQuotaUsage<IPriceQuotaMonthUsage> {
    DateTime getMonth();

    void setMonth(DateTime month);

    BigDecimal getValue();

    void setValue(BigDecimal value);

    BigDecimal getUsed();

    void setUsed(BigDecimal used);

    BigDecimal getPercentUsed();

    void setPercentUsed(BigDecimal percentUsed);

    BigDecimal getPercentDepleted();

    void setPercentDepleted(BigDecimal percentDepleted);

    @Override
    int compareTo(IPriceQuotaMonthUsage o);

    DateTime getEstimatedDepleteDate();

    void setEstimatedDepleteDate(DateTime estimatedDepleteDate);
}