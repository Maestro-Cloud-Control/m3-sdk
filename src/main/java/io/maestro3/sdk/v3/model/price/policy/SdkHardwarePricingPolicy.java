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
import java.math.RoundingMode;

public class SdkHardwarePricingPolicy extends SdkPricingPolicy {

    private BigDecimal hardwareCpuPrice;
    private BigDecimal hardwareMemoryPricePerGB;
    private BigDecimal unitPerMonth;
    private BigDecimal hddBasePrice;
    private BigDecimal hddPricePerGb;

    private int hardwareScale = 7;
    private RoundingMode hardwareRoundingMode = RoundingMode.HALF_UP;

    public BigDecimal getHardwareCpuPrice() {
        return hardwareCpuPrice;
    }

    public void setHardwareCpuPrice(BigDecimal hardwareCpuPrice) {
        this.hardwareCpuPrice = hardwareCpuPrice;
    }

    public BigDecimal getHardwareMemoryPricePerGB() {
        return hardwareMemoryPricePerGB;
    }

    public void setHardwareMemoryPricePerGB(BigDecimal hardwareMemoryPricePerGB) {
        this.hardwareMemoryPricePerGB = hardwareMemoryPricePerGB;
    }

    public BigDecimal getUnitPerMonth() {
        return unitPerMonth;
    }

    public void setUnitPerMonth(BigDecimal unitPerMonth) {
        this.unitPerMonth = unitPerMonth;
    }

    public BigDecimal getHddBasePrice() {
        return hddBasePrice;
    }

    public void setHddBasePrice(BigDecimal hddBasePrice) {
        this.hddBasePrice = hddBasePrice;
    }

    public BigDecimal getHddPricePerGb() {
        return hddPricePerGb;
    }

    public void setHddPricePerGb(BigDecimal hddPricePerGb) {
        this.hddPricePerGb = hddPricePerGb;
    }

    public int getHardwareScale() {
        return hardwareScale;
    }

    public void setHardwareScale(int hardwareScale) {
        this.hardwareScale = hardwareScale;
    }

    public RoundingMode getHardwareRoundingMode() {
        return hardwareRoundingMode;
    }

    public void setHardwareRoundingMode(RoundingMode hardwareRoundingMode) {
        this.hardwareRoundingMode = hardwareRoundingMode;
    }
}
