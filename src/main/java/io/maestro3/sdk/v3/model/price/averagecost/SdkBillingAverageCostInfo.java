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

package io.maestro3.sdk.v3.model.price.averagecost;

import java.math.BigDecimal;

public class SdkBillingAverageCostInfo {

    private BigDecimal averageCost = BigDecimal.ZERO;
    private BigDecimal fullCost = BigDecimal.ZERO;
    private BigDecimal oneThirdCost = BigDecimal.ZERO;

    public SdkBillingAverageCostInfo() {
    }

    public SdkBillingAverageCostInfo(BigDecimal averageCost, BigDecimal fullCost, BigDecimal oneThirdCost) {
        this.averageCost = averageCost;
        this.fullCost = fullCost;
        this.oneThirdCost = oneThirdCost;
    }

    public BigDecimal getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(BigDecimal averageCost) {
        this.averageCost = averageCost;
    }

    public BigDecimal getFullCost() {
        return fullCost;
    }

    public void setFullCost(BigDecimal fullCost) {
        this.fullCost = fullCost;
    }

    public BigDecimal getOneThirdCost() {
        return oneThirdCost;
    }

    public void setOneThirdCost(BigDecimal oneThirdCost) {
        this.oneThirdCost = oneThirdCost;
    }
}
