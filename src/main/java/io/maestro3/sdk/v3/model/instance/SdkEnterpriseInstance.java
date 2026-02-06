/*
 * Copyright 2024 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.model.instance;

import io.maestro3.sdk.v3.model.SdkCloud;

import java.math.BigDecimal;

public class SdkEnterpriseInstance extends SdkInstance {
    private BigDecimal cpuCost;
    private BigDecimal ramCost;
    private BigDecimal hddCost;

    private String status;
    private String backup;
    private BigDecimal backupFactor;
    private BigDecimal prodFactor;


    public SdkEnterpriseInstance() {
        this.cloud = SdkCloud.ENTERPRISE;
    }

    public BigDecimal getCpuCost() {
        return cpuCost;
    }

    public void setCpuCost(BigDecimal cpuCost) {
        this.cpuCost = cpuCost;
    }

    public BigDecimal getRamCost() {
        return ramCost;
    }

    public void setRamCost(BigDecimal ramCost) {
        this.ramCost = ramCost;
    }

    public BigDecimal getHddCost() {
        return hddCost;
    }

    public void setHddCost(BigDecimal hddCost) {
        this.hddCost = hddCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public BigDecimal getBackupFactor() {
        return backupFactor;
    }

    public void setBackupFactor(BigDecimal backupFactor) {
        this.backupFactor = backupFactor;
    }

    public BigDecimal getProdFactor() {
        return prodFactor;
    }

    public void setProdFactor(BigDecimal prodFactor) {
        this.prodFactor = prodFactor;
    }
}
