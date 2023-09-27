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

package io.maestro3.sdk.v3.model.security;

import java.math.BigDecimal;

public class SdkQualysLastScanResult {
    private String initiator;
    private SdkScanStatus scanStatus;
    private long scanDate;
    private String instanceId;
    private SdkInstanceRiskFactor riskFactor;
    private String qualysPlatform;
    private BigDecimal avgSecurityRisk;
    private String businessRisk;
    private Integer totalVulnerabilities;

    public SdkQualysLastScanResult() {
    }

    public SdkQualysLastScanResult(String initiator, SdkScanStatus scanStatus, long scanDate, String instanceId,
                                   SdkInstanceRiskFactor riskFactor, String qualysPlatform, BigDecimal avgSecurityRisk,
                                   String businessRisk, Integer totalVulnerabilities) {
        this.initiator = initiator;
        this.scanStatus = scanStatus;
        this.scanDate = scanDate;
        this.instanceId = instanceId;
        this.riskFactor = riskFactor;
        this.qualysPlatform = qualysPlatform;
        this.avgSecurityRisk = avgSecurityRisk;
        this.businessRisk = businessRisk;
        this.totalVulnerabilities = totalVulnerabilities;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public SdkScanStatus getScanStatus() {
        return scanStatus;
    }

    public void setScanStatus(SdkScanStatus scanStatus) {
        this.scanStatus = scanStatus;
    }

    public long getScanDate() {
        return scanDate;
    }

    public void setScanDate(long scanDate) {
        this.scanDate = scanDate;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public SdkInstanceRiskFactor getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(SdkInstanceRiskFactor riskFactor) {
        this.riskFactor = riskFactor;
    }

    public String getQualysPlatform() {
        return qualysPlatform;
    }

    public void setQualysPlatform(String qualysPlatform) {
        this.qualysPlatform = qualysPlatform;
    }

    public BigDecimal getAvgSecurityRisk() {
        return avgSecurityRisk;
    }

    public void setAvgSecurityRisk(BigDecimal avgSecurityRisk) {
        this.avgSecurityRisk = avgSecurityRisk;
    }

    public String getBusinessRisk() {
        return businessRisk;
    }

    public void setBusinessRisk(String businessRisk) {
        this.businessRisk = businessRisk;
    }

    public Integer getTotalVulnerabilities() {
        return totalVulnerabilities;
    }

    public void setTotalVulnerabilities(Integer totalVulnerabilities) {
        this.totalVulnerabilities = totalVulnerabilities;
    }
}
