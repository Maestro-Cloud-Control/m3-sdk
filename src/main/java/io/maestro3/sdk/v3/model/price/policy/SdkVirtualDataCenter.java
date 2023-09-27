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

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

public class SdkVirtualDataCenter {
    @NotBlank
    private String name;
    @Min(0)
    private BigDecimal vCorePrice;
    @Min(0)
    private BigDecimal memoryPrice;
    @Valid
    private List<SdkStorageProfilePrice> storageProfilePrices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getVCorePrice() {
        return vCorePrice;
    }

    public void setVCorePrice(BigDecimal vCorePrice) {
        this.vCorePrice = vCorePrice;
    }

    public BigDecimal getMemoryPrice() {
        return memoryPrice;
    }

    public void setMemoryPrice(BigDecimal memoryPrice) {
        this.memoryPrice = memoryPrice;
    }

    public List<SdkStorageProfilePrice> getStorageProfilePrices() {
        return storageProfilePrices;
    }

    public void setStorageProfilePrices(List<SdkStorageProfilePrice> storageProfilePrices) {
        this.storageProfilePrices = storageProfilePrices;
    }
}
