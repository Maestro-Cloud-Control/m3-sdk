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

package io.maestro3.sdk.v3.model.reporting;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportRecord {
    private Integer number;
    private String recordType;
    private String customer;
    private String zone;
    private String projectCode;
    private String originalProjectCode;
    private String projectType;
    private Date billingPeriodStartDate;
    private Date billingPeriodEndDate;

    //from CostObject
    private String productName;
    private String resource;
    private String usageType;

    // Currently is only used with "INSTANCE" value from ResourceType class, consider rework
    private String resourceType;
    private String nativeResourceId;

    private String operation;
    private String resourceId;
    private String resourceName;
    private String resourceDescription;
    private String operationSystem;
    private String virtualDataCenter;
    private String instance;
    private String description;
    private Date usageStartDate;
    private Date usageEndDate;
    private BigDecimal quantity;
    private String unit;
    private String currencyCode;
    private BigDecimal totalPrice;
    private BigDecimal epcTotalPrice;
    private BigDecimal awsTotalPrice;
    private BigDecimal azureTotalPrice;
    private BigDecimal googleTotalPrice;
    private BigDecimal hardwareTotalPrice;
    private BigDecimal mobileTotalPrice;
    private BigDecimal enterpriseTotalPrice;
    private BigDecimal swiftStackTotalPrice;
    private BigDecimal reportPortalTotalPrice;
    private BigDecimal awsWorkspacesTotalPrice;
    private BigDecimal azureWorkspacesTotalPrice;
    private BigDecimal aosTotalPrice;
    private BigDecimal yearTotalPrice;
    private String monthOverMonth;
    private String businessUnitName;
    private String tag;
    private String costCenterName;
    private Map<String, Object> additionalInfo;

    private String accountManager;
    private String projectSponsor;

    //for report by inactive projects
    private Date projectDeactivationDate;
    private Date projectUpsaDeactivationDate;
    private String comments;

    //hwu
    private String serverOwner;
    private String serverName;
    private String serverUsage;

    //azure csp
    private String invoiceId;
    private Date invoiceDate;
    private String subscriptionId;
    private String azureBillingProvider;

    private String tenantName;
    private String originalTenantName;

    public ReportRecord() {
        //json
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getOriginalProjectCode() {
        return originalProjectCode;
    }

    public void setOriginalProjectCode(String originalProjectCode) {
        this.originalProjectCode = originalProjectCode;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Date getBillingPeriodStartDate() {
        return billingPeriodStartDate;
    }

    public void setBillingPeriodStartDate(Date billingPeriodStartDate) {
        this.billingPeriodStartDate = billingPeriodStartDate;
    }

    public Date getBillingPeriodEndDate() {
        return billingPeriodEndDate;
    }

    public void setBillingPeriodEndDate(Date billingPeriodEndDate) {
        this.billingPeriodEndDate = billingPeriodEndDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getResourceDescription() {
        return resourceDescription;
    }

    public void setResourceDescription(String resourceDescription) {
        this.resourceDescription = resourceDescription;
    }

    public String getVirtualDataCenter() {
        return virtualDataCenter;
    }

    public void setVirtualDataCenter(String virtualDataCenter) {
        this.virtualDataCenter = virtualDataCenter;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUsageStartDate() {
        return usageStartDate;
    }

    public void setUsageStartDate(Date usageStartDate) {
        this.usageStartDate = usageStartDate;
    }

    public Date getUsageEndDate() {
        return usageEndDate;
    }

    public void setUsageEndDate(Date usageEndDate) {
        this.usageEndDate = usageEndDate;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getEpcTotalPrice() {
        return epcTotalPrice;
    }

    public void setEpcTotalPrice(BigDecimal epcTotalPrice) {
        this.epcTotalPrice = epcTotalPrice;
    }

    public BigDecimal getAwsTotalPrice() {
        return awsTotalPrice;
    }

    public void setAwsTotalPrice(BigDecimal awsTotalPrice) {
        this.awsTotalPrice = awsTotalPrice;
    }

    public BigDecimal getAzureTotalPrice() {
        return azureTotalPrice;
    }

    public void setAzureTotalPrice(BigDecimal azureTotalPrice) {
        this.azureTotalPrice = azureTotalPrice;
    }

    public BigDecimal getGoogleTotalPrice() {
        return googleTotalPrice;
    }

    public void setGoogleTotalPrice(BigDecimal googleTotalPrice) {
        this.googleTotalPrice = googleTotalPrice;
    }

    public BigDecimal getHardwareTotalPrice() {
        return hardwareTotalPrice;
    }

    public void setHardwareTotalPrice(BigDecimal hardwareTotalPrice) {
        this.hardwareTotalPrice = hardwareTotalPrice;
    }

    public BigDecimal getMobileTotalPrice() {
        return mobileTotalPrice;
    }

    public void setMobileTotalPrice(BigDecimal mobileTotalPrice) {
        this.mobileTotalPrice = mobileTotalPrice;
    }

    public BigDecimal getEnterpriseTotalPrice() {
        return enterpriseTotalPrice;
    }

    public void setEnterpriseTotalPrice(BigDecimal enterpriseTotalPrice) {
        this.enterpriseTotalPrice = enterpriseTotalPrice;
    }

    public BigDecimal getSwiftStackTotalPrice() {
        return swiftStackTotalPrice;
    }

    public void setSwiftStackTotalPrice(BigDecimal swiftStackTotalPrice) {
        this.swiftStackTotalPrice = swiftStackTotalPrice;
    }

    public BigDecimal getReportPortalTotalPrice() {
        return reportPortalTotalPrice;
    }

    public void setReportPortalTotalPrice(BigDecimal reportPortalTotalPrice) {
        this.reportPortalTotalPrice = reportPortalTotalPrice;
    }

    public BigDecimal getAwsWorkspacesTotalPrice() {
        return awsWorkspacesTotalPrice;
    }

    public void setAwsWorkspacesTotalPrice(BigDecimal awsWorkspacesTotalPrice) {
        this.awsWorkspacesTotalPrice = awsWorkspacesTotalPrice;
    }

    public BigDecimal getAzureWorkspacesTotalPrice() {
        return azureWorkspacesTotalPrice;
    }

    public void setAzureWorkspacesTotalPrice(BigDecimal azureWorkspacesTotalPrice) {
        this.azureWorkspacesTotalPrice = azureWorkspacesTotalPrice;
    }

    public BigDecimal getAosTotalPrice() {
        return aosTotalPrice;
    }

    public void setAosTotalPrice(BigDecimal aosTotalPrice) {
        this.aosTotalPrice = aosTotalPrice;
    }

    public String getMonthOverMonth() {
        return monthOverMonth;
    }

    public void setMonthOverMonth(String monthOverMonth) {
        this.monthOverMonth = monthOverMonth;
    }

    public BigDecimal getYearTotalPrice() {
        return yearTotalPrice;
    }

    public void setYearTotalPrice(BigDecimal yearTotalPrice) {
        this.yearTotalPrice = yearTotalPrice;
    }

    public String getBusinessUnitName() {
        return businessUnitName;
    }

    public void setBusinessUnitName(String businessUnitName) {
        this.businessUnitName = businessUnitName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCostCenterName() {
        return costCenterName;
    }

    public void setCostCenterName(String costCenterName) {
        this.costCenterName = costCenterName;
    }

    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Date getProjectDeactivationDate() {
        return projectDeactivationDate;
    }

    public void setProjectDeactivationDate(Date projectDeactivationDate) {
        this.projectDeactivationDate = projectDeactivationDate;
    }

    public Date getProjectUpsaDeactivationDate() {
        return projectUpsaDeactivationDate;
    }

    public void setProjectUpsaDeactivationDate(Date projectUpsaDeactivationDate) {
        this.projectUpsaDeactivationDate = projectUpsaDeactivationDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getServerOwner() {
        return serverOwner;
    }

    public void setServerOwner(String serverOwner) {
        this.serverOwner = serverOwner;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerUsage() {
        return serverUsage;
    }

    public void setServerUsage(String serverUsage) {
        this.serverUsage = serverUsage;
    }

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    public String getProjectSponsor() {
        return projectSponsor;
    }

    public void setProjectSponsor(String projectSponsor) {
        this.projectSponsor = projectSponsor;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getAzureBillingProvider() {
        return azureBillingProvider;
    }

    public void setAzureBillingProvider(String azureBillingProvider) {
        this.azureBillingProvider = azureBillingProvider;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getOriginalTenantName() {
        return originalTenantName;
    }

    public void setOriginalTenantName(String originalTenantName) {
        this.originalTenantName = originalTenantName;
    }

    public String getNativeResourceId() {
        return nativeResourceId;
    }

    public void setNativeResourceId(String nativeResourceId) {
        this.nativeResourceId = nativeResourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportRecord)) return false;
        ReportRecord that = (ReportRecord) o;
        return Objects.equals(number, that.number) && Objects.equals(recordType, that.recordType) && Objects.equals(customer, that.customer) && Objects.equals(zone, that.zone) && Objects.equals(projectCode, that.projectCode) && Objects.equals(originalProjectCode, that.originalProjectCode) && Objects.equals(projectType, that.projectType) && Objects.equals(billingPeriodStartDate, that.billingPeriodStartDate) && Objects.equals(billingPeriodEndDate, that.billingPeriodEndDate) && Objects.equals(productName, that.productName) && Objects.equals(resource, that.resource) && Objects.equals(usageType, that.usageType) && Objects.equals(resourceType, that.resourceType) && Objects.equals(operation, that.operation) && Objects.equals(resourceId, that.resourceId) && Objects.equals(resourceName, that.resourceName) && Objects.equals(resourceDescription, that.resourceDescription) && Objects.equals(operationSystem, that.operationSystem) && Objects.equals(virtualDataCenter, that.virtualDataCenter) && Objects.equals(instance, that.instance) && Objects.equals(description, that.description) && Objects.equals(usageStartDate, that.usageStartDate) && Objects.equals(usageEndDate, that.usageEndDate) && Objects.equals(quantity, that.quantity) && Objects.equals(unit, that.unit) && Objects.equals(currencyCode, that.currencyCode) && Objects.equals(totalPrice, that.totalPrice) && Objects.equals(epcTotalPrice, that.epcTotalPrice) && Objects.equals(awsTotalPrice, that.awsTotalPrice) && Objects.equals(azureTotalPrice, that.azureTotalPrice) && Objects.equals(googleTotalPrice, that.googleTotalPrice) && Objects.equals(hardwareTotalPrice, that.hardwareTotalPrice) && Objects.equals(mobileTotalPrice, that.mobileTotalPrice) && Objects.equals(enterpriseTotalPrice, that.enterpriseTotalPrice) && Objects.equals(swiftStackTotalPrice, that.swiftStackTotalPrice) && Objects.equals(reportPortalTotalPrice, that.reportPortalTotalPrice) && Objects.equals(awsWorkspacesTotalPrice, that.awsWorkspacesTotalPrice) && Objects.equals(azureWorkspacesTotalPrice, that.azureWorkspacesTotalPrice) && Objects.equals(aosTotalPrice, that.aosTotalPrice) && Objects.equals(yearTotalPrice, that.yearTotalPrice) && Objects.equals(monthOverMonth, that.monthOverMonth) && Objects.equals(businessUnitName, that.businessUnitName) && Objects.equals(tag, that.tag) && Objects.equals(costCenterName, that.costCenterName) && Objects.equals(additionalInfo, that.additionalInfo) && Objects.equals(accountManager, that.accountManager) && Objects.equals(projectSponsor, that.projectSponsor) && Objects.equals(projectDeactivationDate, that.projectDeactivationDate) && Objects.equals(projectUpsaDeactivationDate, that.projectUpsaDeactivationDate) && Objects.equals(comments, that.comments) && Objects.equals(serverOwner, that.serverOwner) && Objects.equals(serverName, that.serverName) && Objects.equals(serverUsage, that.serverUsage) && Objects.equals(invoiceId, that.invoiceId) && Objects.equals(invoiceDate, that.invoiceDate) && Objects.equals(subscriptionId, that.subscriptionId) && Objects.equals(azureBillingProvider, that.azureBillingProvider) && Objects.equals(tenantName, that.tenantName) && Objects.equals(originalTenantName, that.originalTenantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, recordType, customer, zone, projectCode, originalProjectCode, projectType, billingPeriodStartDate, billingPeriodEndDate, productName, resource, usageType, resourceType, operation, resourceId, resourceName, resourceDescription, operationSystem, virtualDataCenter, instance, description, usageStartDate, usageEndDate, quantity, unit, currencyCode, totalPrice, epcTotalPrice, awsTotalPrice, azureTotalPrice, googleTotalPrice, hardwareTotalPrice, mobileTotalPrice, enterpriseTotalPrice, swiftStackTotalPrice, reportPortalTotalPrice, awsWorkspacesTotalPrice, azureWorkspacesTotalPrice, aosTotalPrice, yearTotalPrice, monthOverMonth, businessUnitName, tag, costCenterName, additionalInfo, accountManager, projectSponsor, projectDeactivationDate, projectUpsaDeactivationDate, comments, serverOwner, serverName, serverUsage, invoiceId, invoiceDate, subscriptionId, azureBillingProvider, tenantName, originalTenantName);
    }

    @Override
    public String toString() {
        return "ReportRecord{" +
            "recordType='" + recordType + '\'' +
            ", zone='" + zone + '\'' +
            ", projectCode='" + projectCode + '\'' +
            ", totalPrice=" + totalPrice +
            ", tenantName='" + tenantName + '\'' +
            '}';
    }
}
