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

package io.maestro3.sdk.v3.model.billing;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkMultiProjectBillingReportTarget {

    private ReportUnit reportUnit;
    private String region;
    private Set<String> tenantGroups;
    private Set<String> tenantNames;
    private String accountId;
    private SdkCloud cloud;
    private MultiProjectReportCloudTarget cloudTarget;

    protected SdkMultiProjectBillingReportTarget() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public ReportUnit getReportUnit() {
        return reportUnit;
    }

    protected void setReportUnit(ReportUnit reportUnit) {
        this.reportUnit = reportUnit;
    }

    public String getRegion() {
        return region;
    }

    protected void setRegion(String region) {
        this.region = region;
    }

    public Set<String> getTenantGroups() {
        return tenantGroups;
    }

    protected void setTenantGroups(Set<String> tenantGroups) {
        this.tenantGroups = tenantGroups;
    }

    public Set<String> getTenantNames() {
        return tenantNames;
    }

    public void setTenantNames(Set<String> tenantNames) {
        this.tenantNames = tenantNames;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    protected void setCloud(SdkCloud cloud) {
        this.cloud = cloud;
    }

    public String getAccountId() {
        return accountId;
    }

    protected void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public MultiProjectReportCloudTarget getCloudTarget() {
        return cloudTarget;
    }

    protected void setCloudTarget(MultiProjectReportCloudTarget cloudTarget) {
        this.cloudTarget = cloudTarget;
    }

    public static class Builder {

        private ReportUnit reportUnit;
        private String region;
        private Set<String> tenantGroups;
        private Set<String> tenantNames;
        private String accountId;
        private SdkCloud cloud;
        private MultiProjectReportCloudTarget cloudTarget;


        public Builder all() {
            this.reportUnit = ReportUnit.ALL;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            this.reportUnit = ReportUnit.REGION;
            return this;
        }

        public Builder cloud(SdkCloud cloud) {
            if (!SdkCloud.HARDWARE.equals(cloud)
                && !SdkCloud.ENTERPRISE.equals(cloud)
                && !SdkCloud.WORKSPACE.equals(cloud)
                && !SdkCloud.AOS.equals(cloud)
                && !cloud.isPublic()) {
                throw new M3SdkException("Multi project report by single cloud available only for public CPs (AWS, Azure, Google), Hardware, Enterprise, Workspace or AOS");
            }
            this.cloud = cloud;
            this.reportUnit = ReportUnit.CLOUD;
            this.cloudTarget = MultiProjectReportCloudTarget.SINGLE;
            return this;
        }

        public Builder publicCloud() {
            this.reportUnit = ReportUnit.CLOUD;
            this.cloudTarget = MultiProjectReportCloudTarget.PUBLIC;
            return this;
        }

        public Builder privateCloud() {
            this.reportUnit = ReportUnit.CLOUD;
            this.cloudTarget = MultiProjectReportCloudTarget.PRIVATE;
            return this;
        }

        public Builder account(String accountId) {
            this.accountId = accountId;
            this.reportUnit = ReportUnit.ACCOUNT;
            return this;
        }

        public Builder tenantGroups(Set<String> tenantGroups) {
            this.tenantGroups = tenantGroups;
            return this;
        }

        public Builder tenantNames(Set<String> tenantNames) {
            this.tenantNames = tenantNames;
            return this;
        }

        public SdkMultiProjectBillingReportTarget build() {
            Assert.notNull(reportUnit, "reportUnit");
            switch (reportUnit) {
                case CLOUD: {
                    Assert.notNull(cloudTarget, "cloudTarget");
                    if (cloudTarget == MultiProjectReportCloudTarget.SINGLE) {
                        Assert.notNull(cloud, "cloud");
                    }
                    break;
                }
                case ACCOUNT: {
                    Assert.hasText(accountId, "accountId");
                    break;
                }
                case REGION: {
                    Assert.hasText(region, "region");
                    break;
                }
                default:
                    break;
            }
            SdkMultiProjectBillingReportTarget target = new SdkMultiProjectBillingReportTarget();
            target.reportUnit = this.reportUnit == null ? ReportUnit.ALL : this.reportUnit;
            target.region = this.region;
            target.cloud = this.cloud;
            target.tenantGroups = this.tenantGroups;
            target.tenantNames = this.tenantNames;
            target.accountId = this.accountId;
            target.cloudTarget = this.cloudTarget;
            return target;
        }
    }
}
