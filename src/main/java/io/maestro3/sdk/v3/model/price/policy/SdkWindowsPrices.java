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

public class SdkWindowsPrices {
    private String mode;

    private BigDecimal licensePerVCorePerMonth;
    private BigDecimal licensePerMemoryGBPerMonth;

    private BigDecimal licensePerMonth;

    public SdkWindowsPrices() {
    }

    public SdkWindowsPrices(String mode,
                            BigDecimal licensePerVCorePerMonth,
                            BigDecimal licensePerMemoryGBPerMonth,
                            BigDecimal licensePerMonth) {
        this.mode = mode;
        this.licensePerVCorePerMonth = licensePerVCorePerMonth;
        this.licensePerMemoryGBPerMonth = licensePerMemoryGBPerMonth;
        this.licensePerMonth = licensePerMonth;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public BigDecimal getLicensePerVCorePerMonth() {
        return licensePerVCorePerMonth;
    }

    public void setLicensePerVCorePerMonth(BigDecimal licensePerVCorePerMonth) {
        this.licensePerVCorePerMonth = licensePerVCorePerMonth;
    }

    public BigDecimal getLicensePerMemoryGBPerMonth() {
        return licensePerMemoryGBPerMonth;
    }

    public void setLicensePerMemoryGBPerMonth(BigDecimal licensePerMemoryGBPerMonth) {
        this.licensePerMemoryGBPerMonth = licensePerMemoryGBPerMonth;
    }

    public BigDecimal getLicensePerMonth() {
        return licensePerMonth;
    }

    public void setLicensePerMonth(BigDecimal licensePerMonth) {
        this.licensePerMonth = licensePerMonth;
    }
}
