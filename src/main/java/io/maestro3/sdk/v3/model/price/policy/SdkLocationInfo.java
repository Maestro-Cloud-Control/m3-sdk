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

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class SdkLocationInfo {

    @NotBlank
    private String name;
    @Min(0)
    private BigDecimal coefficient;
    @Min(0)
    private BigDecimal unitPrice;
    @Min(0)
    private BigDecimal electricityPrice;
    @Min(0)
    private BigDecimal collingPowerCoefficient;
    @Min(0)
    private BigDecimal storagePricePerGB = BigDecimal.ZERO;
    @Min(0)
    private BigDecimal storageBasePrice = BigDecimal.ZERO;
    @Min(0)
    private BigDecimal corePrice = BigDecimal.ZERO;//virt core price or physical core price
    @Min(0)
    private BigDecimal memoryPerGBPrice = BigDecimal.ZERO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getElectricityPrice() {
        return electricityPrice;
    }

    public void setElectricityPrice(BigDecimal electricityPrice) {
        this.electricityPrice = electricityPrice;
    }

    public BigDecimal getCollingPowerCoefficient() {
        return collingPowerCoefficient;
    }

    public void setCollingPowerCoefficient(BigDecimal collingPowerCoefficient) {
        this.collingPowerCoefficient = collingPowerCoefficient;
    }

    public BigDecimal getStoragePricePerGB() {
        return storagePricePerGB;
    }

    public void setStoragePricePerGB(BigDecimal storagePricePerGB) {
        this.storagePricePerGB = storagePricePerGB;
    }

    public BigDecimal getStorageBasePrice() {
        return storageBasePrice;
    }

    public void setStorageBasePrice(BigDecimal storageBasePrice) {
        this.storageBasePrice = storageBasePrice;
    }

    public BigDecimal getCorePrice() {
        return corePrice;
    }

    public void setCorePrice(BigDecimal corePrice) {
        this.corePrice = corePrice;
    }

    public BigDecimal getMemoryPerGBPrice() {
        return memoryPerGBPrice;
    }

    public void setMemoryPerGBPrice(BigDecimal memoryPerGBPrice) {
        this.memoryPerGBPrice = memoryPerGBPrice;
    }
}
