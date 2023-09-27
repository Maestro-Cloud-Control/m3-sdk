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

import java.math.BigDecimal;

public class SdkVolumePeriodPrices {
    private BigDecimal activePrice;
    private BigDecimal passivePrice;

    private BigDecimal overSizeGb;
    private BigDecimal underPrice;
    private BigDecimal overPrice;

    public SdkVolumePeriodPrices() {
    }

    public SdkVolumePeriodPrices(BigDecimal activePrice,
                                 BigDecimal passivePrice,
                                 BigDecimal overSizeGb,
                                 BigDecimal underPrice,
                                 BigDecimal overPrice) {
        this.activePrice = activePrice;
        this.passivePrice = passivePrice;
        this.overSizeGb = overSizeGb;
        this.underPrice = underPrice;
        this.overPrice = overPrice;
    }

    public BigDecimal getActivePrice() {
        return activePrice;
    }

    public void setActivePrice(BigDecimal activePrice) {
        this.activePrice = activePrice;
    }

    public BigDecimal getPassivePrice() {
        return passivePrice;
    }

    public void setPassivePrice(BigDecimal passivePrice) {
        this.passivePrice = passivePrice;
    }

    public BigDecimal getOverSizeGb() {
        return overSizeGb;
    }

    public void setOverSizeGb(BigDecimal overSizeGb) {
        this.overSizeGb = overSizeGb;
    }

    public BigDecimal getUnderPrice() {
        return underPrice;
    }

    public void setUnderPrice(BigDecimal underPrice) {
        this.underPrice = underPrice;
    }

    public BigDecimal getOverPrice() {
        return overPrice;
    }

    public void setOverPrice(BigDecimal overPrice) {
        this.overPrice = overPrice;
    }
}
