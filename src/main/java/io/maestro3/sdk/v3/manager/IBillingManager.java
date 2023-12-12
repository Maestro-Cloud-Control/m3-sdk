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

package io.maestro3.sdk.v3.manager;

import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.model.billing.SdkBillingTagResponse;
import io.maestro3.sdk.v3.model.reporting.SdkBillingCostObjectDetailsResponse;
import io.maestro3.sdk.v3.model.reporting.SdkBillingInvoicesResponse;
import io.maestro3.sdk.v3.model.reporting.SdkBillingReportResponse;
import io.maestro3.sdk.v3.model.reporting.SdkBillingTabularReportResponse;
import io.maestro3.sdk.v3.request.billing.AddAdjustmentRequest;
import io.maestro3.sdk.v3.request.billing.AddConsumptionDetailsRequest;
import io.maestro3.sdk.v3.request.billing.AddConsumptionRequest;
import io.maestro3.sdk.v3.request.billing.BillingInvoiceRequest;
import io.maestro3.sdk.v3.request.billing.BillingTagRequest;
import io.maestro3.sdk.v3.request.billing.CheckTenantStatusRequest;
import io.maestro3.sdk.v3.request.billing.CostAndUsageReportRequest;
import io.maestro3.sdk.v3.request.billing.CostObjectDetailsRequest;
import io.maestro3.sdk.v3.request.billing.DailyReportByTenantGroupRequest;
import io.maestro3.sdk.v3.request.billing.DeleteAdjustmentRequest;
import io.maestro3.sdk.v3.request.billing.DeleteConsumptionDetailsRequest;
import io.maestro3.sdk.v3.request.billing.DeleteConsumptionRequest;
import io.maestro3.sdk.v3.request.billing.GetAdjustmentRequest;
import io.maestro3.sdk.v3.request.billing.GetConsumptionDetailsRequest;
import io.maestro3.sdk.v3.request.billing.GetConsumptionRequest;
import io.maestro3.sdk.v3.request.billing.HourlyBillingReportRequest;
import io.maestro3.sdk.v3.request.billing.MonthlyReportByTenantGroupRequest;
import io.maestro3.sdk.v3.request.billing.MultiProjectBillingReportRequest;
import io.maestro3.sdk.v3.request.billing.ResourceBillingReportRequest;
import io.maestro3.sdk.v3.request.billing.SubTotalBillingReportRequest;
import io.maestro3.sdk.v3.request.billing.TotalBillingReportRequest;

public interface IBillingManager extends IManager {

    M3Result<SdkBillingReportResponse> getTotalReport(IPrincipal principal, TotalBillingReportRequest request);

    M3Result<SdkBillingReportResponse> getSubtotalReport(IPrincipal principal, SubTotalBillingReportRequest request);

    M3Result<SdkBillingReportResponse> getResourceReport(IPrincipal principal, ResourceBillingReportRequest request);

    M3Result<SdkBillingReportResponse> getHourlyReport(IPrincipal principal, HourlyBillingReportRequest request);

    M3Result<SdkBillingReportResponse> getMultiprojectReport(IPrincipal principal, MultiProjectBillingReportRequest request);

    M3Result<SdkBillingTagResponse> getTags(IPrincipal principal, BillingTagRequest request);

    M3Result<SdkBillingInvoicesResponse> getInvoices(IPrincipal principal, BillingInvoiceRequest request);

    M3Result<SdkBillingReportResponse> getDailyTotal(IPrincipal principal, DailyReportByTenantGroupRequest request);

    M3Result<SdkBillingReportResponse> getMonthlyTotal(IPrincipal principal, MonthlyReportByTenantGroupRequest request);

    M3Result<SdkBillingCostObjectDetailsResponse> getCostObjectDetails(IPrincipal principal, CostObjectDetailsRequest request);

    M3Result<SdkBillingTabularReportResponse> getCostAndUsageReport(IPrincipal principal, CostAndUsageReportRequest request);

    M3Result<Object> getConsumptionDetails(IPrincipal principal, GetConsumptionDetailsRequest request);

    M3Result<Object> addConsumptionDetails(IPrincipal principal, AddConsumptionDetailsRequest request);

    M3Result<Object> deleteConsumptionDetails(IPrincipal principal, DeleteConsumptionDetailsRequest request);

    M3Result<Object> getConsumption(IPrincipal principal, GetConsumptionRequest request);

    M3Result<Object> addConsumption(IPrincipal principal, AddConsumptionRequest request);

    M3Result<Object> deleteConsumption(IPrincipal principal, DeleteConsumptionRequest request);

    M3Result<Object> getAdjustment(IPrincipal principal, GetAdjustmentRequest request);

    M3Result<Object> addAdjustment(IPrincipal principal, AddAdjustmentRequest request);

    M3Result<Object> deleteAdjustment(IPrincipal principal, DeleteAdjustmentRequest request);

    M3Result<Object> checkTenantStatusRequest(IPrincipal principal, CheckTenantStatusRequest request);
}
