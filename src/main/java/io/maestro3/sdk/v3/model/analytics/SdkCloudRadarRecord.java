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

import java.math.BigDecimal;
import java.util.Date;

public class SdkCloudRadarRecord {
    private Date periodStart;
    private Date periodEnd;
    private String region;
    private SdkCloudRadarPeriod period;

    private BigDecimal totalChargeBack;
    private long cpuCount;
    private long memoryMb;
    private long storageGb;

    public SdkCloudRadarRecord() {
    }

    public SdkCloudRadarRecord(Date periodStart,
                               Date periodEnd,
                               String region,
                               SdkCloudRadarPeriod period, BigDecimal totalChargeBack,
                               long cpuCount,
                               long memoryMb,
                               long storageGb) {
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.region = region;
        this.period = period;
        this.totalChargeBack = totalChargeBack;
        this.cpuCount = cpuCount;
        this.memoryMb = memoryMb;
        this.storageGb = storageGb;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigDecimal getTotalChargeBack() {
        return totalChargeBack;
    }

    public void setTotalChargeBack(BigDecimal totalChargeBack) {
        this.totalChargeBack = totalChargeBack;
    }

    public long getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(long cpuCount) {
        this.cpuCount = cpuCount;
    }

    public long getMemoryMb() {
        return memoryMb;
    }

    public void setMemoryMb(long memoryMb) {
        this.memoryMb = memoryMb;
    }

    public long getStorageGb() {
        return storageGb;
    }

    public void setStorageGb(long storageGb) {
        this.storageGb = storageGb;
    }

    public SdkCloudRadarPeriod getPeriod() {
        return period;
    }

    public void setPeriod(SdkCloudRadarPeriod period) {
        this.period = period;
    }
}
