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

package io.maestro3.sdk.v3.model.terraform;

import java.math.BigDecimal;
import java.util.List;

public class SdkTerraformCostObject {

    private String name;
    private String description;
    private String unit;
    private BigDecimal hourlyQuantity;
    private BigDecimal monthlyQuantity;
    private BigDecimal price;
    private BigDecimal hourlyCost;
    private BigDecimal monthlyCost;
    private List<SdkTerraformCostObject> nestedObjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getHourlyQuantity() {
        return hourlyQuantity;
    }

    public void setHourlyQuantity(BigDecimal hourlyQuantity) {
        this.hourlyQuantity = hourlyQuantity;
    }

    public BigDecimal getMonthlyQuantity() {
        return monthlyQuantity;
    }

    public void setMonthlyQuantity(BigDecimal monthlyQuantity) {
        this.monthlyQuantity = monthlyQuantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getHourlyCost() {
        return hourlyCost;
    }

    public void setHourlyCost(BigDecimal hourlyCost) {
        this.hourlyCost = hourlyCost;
    }

    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(BigDecimal monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public List<SdkTerraformCostObject> getNestedObjects() {
        return nestedObjects;
    }

    public void setNestedObjects(List<SdkTerraformCostObject> nestedObjects) {
        this.nestedObjects = nestedObjects;
    }
}
