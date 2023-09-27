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

package io.maestro3.sdk.v3.request.billing;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.billing.BillingReportFormat;
import io.maestro3.sdk.v3.model.billing.BillingReportType;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = CostAndUsageReportRequest.Builder.class)
public class CostAndUsageReportRequest implements ITenantRequest, IRegionRequest {

    private final long date;
    private final String tenantName;
    private final String region;
    private final SdkCloud cloud;
    private final BillingReportType reportType;
    private final BillingReportFormat reportFormat;
    private final String resourceType;

    private CostAndUsageReportRequest(Builder builder) {
        this.reportType = builder.reportType;
        this.resourceType = builder.resourceType;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.cloud = builder.cloud;
        this.date = builder.date;
        this.reportFormat = builder.reportFormat;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getDate() {
        return date;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    public BillingReportType getReportType() {
        return reportType;
    }

    public String getResourceType() {
        return resourceType;
    }

    public BillingReportFormat getReportFormat() {
        return reportFormat;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_COST_AND_USAGE_REPORT;
    }

    public static final class Builder {

        private long date;
        private String tenantName;
        private String region;
        private SdkCloud cloud;
        private BillingReportFormat reportFormat = BillingReportFormat.JSON;
        private BillingReportType reportType;
        private String resourceType;

        public Builder withDate(long date) {
            this.date = date;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withReportType(BillingReportType reportType) {
            this.reportType = reportType;
            return this;
        }

        public Builder withResourceType(String resourceType) {
            this.resourceType = resourceType;
            return this;
        }

        public Builder withReportFormat(BillingReportFormat reportFormat) {
            this.reportFormat = reportFormat;
            return this;
        }

        public CostAndUsageReportRequest build() {
            Assert.notNull(reportType, "reportType");
            Assert.notNull(resourceType, "resourceType");
            Assert.notNull(cloud, "cloud");
            Assert.notNull(date, "date");
            Assert.hasText(tenantName, "tenantName");
            return new CostAndUsageReportRequest(this);
        }
    }
}
