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

package io.maestro3.sdk.v3.model.price;

import java.math.BigDecimal;

public class SdkInstancePriceModelEntry {

    private String shape;
    private String osType;

    private BigDecimal initializationPrice;
    private BigDecimal basePrice;
    private BigDecimal vCoresPrice;
    private BigDecimal memoryPrice;
    private BigDecimal osPrice;
    private BigDecimal systemStoragePrice;

    private BigDecimal totalPrice;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public BigDecimal getInitializationPrice() {
        return initializationPrice;
    }

    public void setInitializationPrice(BigDecimal initializationPrice) {
        this.initializationPrice = initializationPrice;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal getvCoresPrice() {
        return vCoresPrice;
    }

    public void setvCoresPrice(BigDecimal vCoresPrice) {
        this.vCoresPrice = vCoresPrice;
    }

    public BigDecimal getMemoryPrice() {
        return memoryPrice;
    }

    public void setMemoryPrice(BigDecimal memoryPrice) {
        this.memoryPrice = memoryPrice;
    }

    public BigDecimal getOsPrice() {
        return osPrice;
    }

    public void setOsPrice(BigDecimal osPrice) {
        this.osPrice = osPrice;
    }

    public BigDecimal getSystemStoragePrice() {
        return systemStoragePrice;
    }

    public void setSystemStoragePrice(BigDecimal systemStoragePrice) {
        this.systemStoragePrice = systemStoragePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
