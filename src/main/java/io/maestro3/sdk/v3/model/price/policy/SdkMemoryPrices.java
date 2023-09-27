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

public class SdkMemoryPrices {

    private String shape;
    private BigDecimal memoryMBSize;

    private BigDecimal memoryGBPerMinute;
    private BigDecimal memoryGBPerHour;
    private BigDecimal memoryGBPerMonth;
    private String scale;

    private SdkWindowsPrices windowsPrices;

    private String availabilityZone;

    public SdkMemoryPrices() {
        //json
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public BigDecimal getMemoryMBSize() {
        return memoryMBSize;
    }

    public void setMemoryMBSize(BigDecimal memoryMBSize) {
        this.memoryMBSize = memoryMBSize;
    }

    public BigDecimal getMemoryGBPerMinute() {
        return memoryGBPerMinute;
    }

    public void setMemoryGBPerMinute(BigDecimal memoryGBPerMinute) {
        this.memoryGBPerMinute = memoryGBPerMinute;
    }

    public BigDecimal getMemoryGBPerHour() {
        return memoryGBPerHour;
    }

    public void setMemoryGBPerHour(BigDecimal memoryGBPerHour) {
        this.memoryGBPerHour = memoryGBPerHour;
    }

    public BigDecimal getMemoryGBPerMonth() {
        return memoryGBPerMonth;
    }

    public void setMemoryGBPerMonth(BigDecimal memoryGBPerMonth) {
        this.memoryGBPerMonth = memoryGBPerMonth;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public SdkWindowsPrices getWindowsPrices() {
        return windowsPrices;
    }

    public void setWindowsPrices(SdkWindowsPrices windowsPrices) {
        this.windowsPrices = windowsPrices;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }
}
