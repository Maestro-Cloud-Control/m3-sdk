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

package io.maestro3.sdk.v3.model.analytics;

import java.util.Date;

public class SdkMonitoringRecord {

    private Date month;
    private String tenantDisplayName;
    private String region;

    private SdkVmLifetimeMetricGroup vmLifetimeKpi;
    private SdkOptimizationMetricGroup optimizationKpi;

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    public void setTenantDisplayName(String tenantDisplayName) {
        this.tenantDisplayName = tenantDisplayName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public SdkVmLifetimeMetricGroup getVmLifetimeKpi() {
        return vmLifetimeKpi;
    }

    public void setVmLifetimeKpi(SdkVmLifetimeMetricGroup vmLifetimeKpi) {
        this.vmLifetimeKpi = vmLifetimeKpi;
    }

    public SdkOptimizationMetricGroup getOptimizationKpi() {
        return optimizationKpi;
    }

    public void setOptimizationKpi(SdkOptimizationMetricGroup optimizationKpi) {
        this.optimizationKpi = optimizationKpi;
    }


}
