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

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkTerraformCostSummary {

    //cost info
    private BigDecimal totalHourlyCost;
    private BigDecimal totalMonthlyCost;
    private BigDecimal pastTotalHourlyCost;
    private BigDecimal pastTotalMonthlyCost;
    private BigDecimal diffTotalHourlyCost;
    private BigDecimal diffTotalMonthlyCost;

    //resources info
    private Integer totalDetectedResources;
    private Integer totalSupportedResources;
    private Integer totalUnsupportedResources;
    private Integer totalUsageBasedResources;
    private Integer totalNoPriceResources;
    private Map<String, Integer> unsupportedResourceCounts;
    private Map<String, Integer> noPriceResourceCounts;

    public BigDecimal getTotalHourlyCost() {
        return totalHourlyCost;
    }

    public void setTotalHourlyCost(BigDecimal totalHourlyCost) {
        this.totalHourlyCost = totalHourlyCost;
    }

    public BigDecimal getTotalMonthlyCost() {
        return totalMonthlyCost;
    }

    public void setTotalMonthlyCost(BigDecimal totalMonthlyCost) {
        this.totalMonthlyCost = totalMonthlyCost;
    }

    public BigDecimal getPastTotalHourlyCost() {
        return pastTotalHourlyCost;
    }

    public void setPastTotalHourlyCost(BigDecimal pastTotalHourlyCost) {
        this.pastTotalHourlyCost = pastTotalHourlyCost;
    }

    public BigDecimal getPastTotalMonthlyCost() {
        return pastTotalMonthlyCost;
    }

    public void setPastTotalMonthlyCost(BigDecimal pastTotalMonthlyCost) {
        this.pastTotalMonthlyCost = pastTotalMonthlyCost;
    }

    public BigDecimal getDiffTotalHourlyCost() {
        return diffTotalHourlyCost;
    }

    public void setDiffTotalHourlyCost(BigDecimal diffTotalHourlyCost) {
        this.diffTotalHourlyCost = diffTotalHourlyCost;
    }

    public BigDecimal getDiffTotalMonthlyCost() {
        return diffTotalMonthlyCost;
    }

    public void setDiffTotalMonthlyCost(BigDecimal diffTotalMonthlyCost) {
        this.diffTotalMonthlyCost = diffTotalMonthlyCost;
    }

    public Integer getTotalDetectedResources() {
        return totalDetectedResources;
    }

    public void setTotalDetectedResources(Integer totalDetectedResources) {
        this.totalDetectedResources = totalDetectedResources;
    }

    public Integer getTotalSupportedResources() {
        return totalSupportedResources;
    }

    public void setTotalSupportedResources(Integer totalSupportedResources) {
        this.totalSupportedResources = totalSupportedResources;
    }

    public Integer getTotalUnsupportedResources() {
        return totalUnsupportedResources;
    }

    public void setTotalUnsupportedResources(Integer totalUnsupportedResources) {
        this.totalUnsupportedResources = totalUnsupportedResources;
    }

    public Integer getTotalUsageBasedResources() {
        return totalUsageBasedResources;
    }

    public void setTotalUsageBasedResources(Integer totalUsageBasedResources) {
        this.totalUsageBasedResources = totalUsageBasedResources;
    }

    public Integer getTotalNoPriceResources() {
        return totalNoPriceResources;
    }

    public void setTotalNoPriceResources(Integer totalNoPriceResources) {
        this.totalNoPriceResources = totalNoPriceResources;
    }

    public Map<String, Integer> getUnsupportedResourceCounts() {
        return unsupportedResourceCounts;
    }

    public void setUnsupportedResourceCounts(Map<String, Integer> unsupportedResourceCounts) {
        this.unsupportedResourceCounts = unsupportedResourceCounts;
    }

    public Map<String, Integer> getNoPriceResourceCounts() {
        return noPriceResourceCounts;
    }

    public void setNoPriceResourceCounts(Map<String, Integer> noPriceResourceCounts) {
        this.noPriceResourceCounts = noPriceResourceCounts;
    }
}
