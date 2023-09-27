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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.CollectionUtils;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SdkBillingReportTarget.SdkBuilder.class)
public class SdkBillingReportTarget {

    private ReportUnit reportUnit;
    private String tenantGroup;
    private String tenant;
    private String region;
    private List<SdkCloud> clouds;
    private List<String> notAllowedTenantRegions;
    private String invoiceId;
    private String productName;
    private String usageType;
    private String resourceType;
    private boolean onlyGrandTotal;

    protected SdkBillingReportTarget() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SdkBuilder sdkBuilder() {
        return new SdkBuilder();
    }

    public ReportUnit getReportUnit() {
        return reportUnit;
    }

    protected void setReportUnit(ReportUnit reportUnit) {
        this.reportUnit = reportUnit;
    }

    public String getTenantGroup() {
        return tenantGroup;
    }

    protected void setTenantGroup(String tenantGroup) {
        this.tenantGroup = tenantGroup;
    }

    public String getTenant() {
        return tenant;
    }

    protected void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getRegion() {
        return region;
    }

    protected void setRegion(String region) {
        this.region = region;
    }

    public List<String> getNotAllowedTenantRegions() {
        return notAllowedTenantRegions;
    }

    protected void setNotAllowedTenantRegions(List<String> notAllowedTenantRegions) {
        this.notAllowedTenantRegions = notAllowedTenantRegions;
    }

    public List<SdkCloud> getClouds() {
        return clouds;
    }

    protected void setClouds(List<SdkCloud> clouds) {
        this.clouds = clouds;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public boolean isOnlyGrandTotal() {
        return onlyGrandTotal;
    }

    public void setOnlyGrandTotal(boolean onlyGrandTotal) {
        this.onlyGrandTotal = onlyGrandTotal;
    }

    public static class Builder {

        private ReportUnit reportUnit;
        private String tenantGroup;
        private String tenant;
        private String region;
        private List<SdkCloud> clouds;
        private List<String> notAllowedTenantRegions;
        private String invoiceId;
        private String productName;
        private String usageType;
        private String resourceType;

        public Builder tenantGroup(String tenantGroup) {
            Assert.hasText(tenantGroup, "tenantGroup");
            this.tenantGroup = tenantGroup;
            this.reportUnit = ReportUnit.TENANT_GROUP;
            return this;
        }

        public Builder notAllowedTenantRegions(List<String> notAllowedTenantRegions) {
            Assert.notNull(notAllowedTenantRegions, "notAllowedTenantRegions");
            this.notAllowedTenantRegions = notAllowedTenantRegions;
            return this;
        }

        public Builder tenantGroupAndRegion(String tenantGroup, String region) {
            Assert.hasText(tenantGroup, "tenantGroup");
            Assert.hasText(region, "region");
            this.tenantGroup = tenantGroup;
            this.region = region;
            this.reportUnit = ReportUnit.TENANT_GROUP;
            return this;
        }

        public Builder tenantGroupAndCloud(String tenantGroup, SdkCloud cloud) {
            Assert.hasText(tenantGroup, "tenantGroup");
            Assert.notNull(cloud, "cloud");
            this.tenantGroup = tenantGroup;
            this.clouds = Collections.singletonList(cloud);
            this.reportUnit = ReportUnit.TENANT_GROUP_AND_CLOUD;
            return this;
        }

        public Builder tenantGroupAndClouds(String tenantGroup, List<SdkCloud> clouds) {
            Assert.hasText(tenantGroup, "tenantGroup");
            Assert.notNull(clouds, "clouds");
            this.tenantGroup = tenantGroup;
            this.clouds = clouds;
            this.reportUnit = ReportUnit.TENANT_GROUP_AND_CLOUD;
            return this;
        }

        public Builder tenantAndRegion(String tenant, String region) {
            Assert.hasText(tenant, "tenant");
            Assert.hasText(region, "region");
            this.tenant = tenant;
            this.region = region;
            this.reportUnit = ReportUnit.TENANT;
            return this;
        }

        public Builder tenantAndCloud(String tenant, SdkCloud cloud) {
            Assert.hasText(tenant, "tenant");
            Assert.notNull(cloud, "cloud");
            this.tenant = tenant;
            this.clouds = Collections.singletonList(cloud);
            this.reportUnit = ReportUnit.TENANT_AND_CLOUD;
            return this;
        }

        public Builder tenantAndCloudAndProductName(String tenant, SdkCloud cloud, String productName) {
            Assert.hasText(tenant, "tenant");
            Assert.notNull(cloud, "cloud");
            this.tenant = tenant;
            this.clouds = Collections.singletonList(cloud);
            this.productName = productName;
            this.reportUnit = ReportUnit.TENANT_AND_CLOUD;
            return this;
        }

        public Builder tenantAndCloudAndCostObjectDetails(String tenant, SdkCloud cloud, String productName, String usageType, String resourceType) {
            Assert.hasText(tenant, "tenant");
            Assert.notNull(cloud, "cloud");
            this.tenant = tenant;
            this.clouds = Collections.singletonList(cloud);
            this.productName = productName;
            this.usageType = usageType;
            this.resourceType = resourceType;
            this.reportUnit = ReportUnit.TENANT_AND_RESOURCES;
            return this;
        }

        public Builder tenantAndCloudAndTaggedResource(String tenant, SdkCloud cloud) {
            Assert.hasText(tenant, "tenant");
            Assert.notNull(cloud, "cloud");
            this.tenant = tenant;
            this.clouds = Collections.singletonList(cloud);
            this.reportUnit = ReportUnit.TENANT_AND_RESOURCES_TAGGED;
            return this;
        }

        public Builder tenantAndCloudAndUntaggedResource(String tenant, SdkCloud cloud) {
            Assert.hasText(tenant, "tenant");
            Assert.notNull(cloud, "cloud");
            this.tenant = tenant;
            this.clouds = Collections.singletonList(cloud);
            this.reportUnit = ReportUnit.TENANT_AND_RESOURCES_UNTAGGED;
            return this;
        }

        public Builder tenantAndCloudAndAllTagsResource(String tenant, SdkCloud cloud) {
            Assert.hasText(tenant, "tenant");
            Assert.notNull(cloud, "cloud");
            this.tenant = tenant;
            this.clouds = Collections.singletonList(cloud);
            this.reportUnit = ReportUnit.TENANT_AND_RESOURCES_ALL_TAGS;
            return this;
        }

        public Builder tenantAndRegionAndAllTagsResource(String tenant, String region) {
            Assert.hasText(tenant, "tenant");
            Assert.hasText(region, "region");
            this.tenant = tenant;
            this.region = region;
            this.reportUnit = ReportUnit.TENANT_AND_RESOURCES_ALL_TAGS;
            return this;
        }

        public Builder tenantAndClouds(String tenant, List<SdkCloud> clouds) {
            Assert.hasText(tenant, "tenant");
            Assert.notNull(clouds, "clouds");
            this.tenant = tenant;
            this.clouds = clouds;
            this.reportUnit = ReportUnit.TENANT_AND_CLOUD;
            return this;
        }

        public Builder aosTenant(String tenant) {
            Assert.hasText(tenant, "tenant");
            this.tenant = tenant;
            this.reportUnit = ReportUnit.AOS_TENANT;
            return this;
        }

        public Builder tenantAndInvoice(String tenant, String invoiceId) {
            Assert.hasText(tenant, "tenant");
            Assert.notNull(invoiceId, "invoiceId");
            this.tenant = tenant;
            this.invoiceId = invoiceId;
            this.reportUnit = ReportUnit.TENANT_INVOICE;
            return this;
        }

        public SdkBillingReportTarget build() {
            return new SdkBuilder()
                .withReportUnit(reportUnit)
                .withTenantGroup(tenantGroup)
                .withTenant(tenant)
                .withRegion(region)
                .withClouds(clouds)
                .withInvoiceId(invoiceId)
                .withProductName(productName)
                .withUsageType(usageType)
                .withResourceType(resourceType)
                .withNotAllowedTenantRegions(notAllowedTenantRegions)
                .build();
        }
    }

    public static class SdkBuilder {
        private ReportUnit reportUnit;
        private String tenantGroup;
        private String tenant;
        private String region;
        private List<SdkCloud> clouds;
        private List<String> notAllowedTenantRegions;
        private String invoiceId;
        private String productName;
        private String usageType;
        private String resourceType;
        private boolean onlyGrandTotal;

        public SdkBuilder withReportUnit(ReportUnit reportUnit) {
            this.reportUnit = reportUnit;
            return this;
        }

        public SdkBuilder withTenantGroup(String tenantGroup) {
            this.tenantGroup = tenantGroup;
            return this;
        }

        public SdkBuilder withTenant(String tenant) {
            this.tenant = tenant;
            return this;
        }

        public SdkBuilder withRegion(String region) {
            this.region = region;
            return this;
        }

        public SdkBuilder withClouds(List<SdkCloud> clouds) {
            this.clouds = clouds;
            return this;
        }

        public SdkBuilder withNotAllowedTenantRegions(List<String> notAllowedTenantRegions) {
            this.notAllowedTenantRegions = notAllowedTenantRegions;
            return this;
        }

        public SdkBuilder withInvoiceId(String invoiceId) {
            this.invoiceId = invoiceId;
            return this;
        }

        public SdkBuilder withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public SdkBuilder withUsageType(String usageType) {
            this.usageType = usageType;
            return this;
        }

        public SdkBuilder withResourceType(String resourceType) {
            this.resourceType = resourceType;
            return this;
        }

        public SdkBuilder withOnlyGrandTotal(boolean onlyGrandTotal) {
            this.onlyGrandTotal = onlyGrandTotal;
            return this;
        }

        public SdkBillingReportTarget build() {
            validate();

            SdkBillingReportTarget details = new SdkBillingReportTarget();
            details.reportUnit = this.reportUnit;
            details.tenantGroup = this.tenantGroup;
            details.tenant = this.tenant;
            details.region = this.region;
            details.clouds = this.clouds;
            details.invoiceId = this.invoiceId;
            details.productName = this.productName;
            details.usageType = this.usageType;
            details.resourceType = this.resourceType;
            details.notAllowedTenantRegions = this.notAllowedTenantRegions;
            details.onlyGrandTotal = this.onlyGrandTotal;
            return details;
        }

        private void validate() {
            Assert.notNull(reportUnit, "reportUnit");
            validateTenant();
            validateClouds();
        }

        private void validateTenant() {
            if ((StringUtils.isBlank(tenantGroup) && StringUtils.isBlank(tenant))
                || StringUtils.isNotBlank(tenantGroup) && StringUtils.isNotBlank(tenant)) {
                throw new M3SdkException("tenantGroup or tenant must be specified");
            }
        }

        private void validateClouds() {
            if (CollectionUtils.isNotEmpty(clouds)) {
                for (SdkCloud cloud : clouds) {
                    if (cloud == null) { // JsonUtils convert unknown cloud-string to null due to READ_UNKNOWN_ENUM_VALUES_AS_NULL property
                        throw new M3SdkException("Cannot resolve cloud");
                    }
                }
            }
        }
    }
}
