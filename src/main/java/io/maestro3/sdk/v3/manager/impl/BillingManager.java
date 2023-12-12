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

package io.maestro3.sdk.v3.manager.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.manager.IBillingManager;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.billing.MultiProjectReportCloudTarget;
import io.maestro3.sdk.v3.model.billing.ReportUnit;
import io.maestro3.sdk.v3.model.billing.SdkBillingTagResponse;
import io.maestro3.sdk.v3.model.billing.SdkMultiProjectBillingReportTarget;
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
import io.maestro3.sdk.v3.request.billing.MultiProjectEmailReportRequest;
import io.maestro3.sdk.v3.request.billing.ResourceBillingReportRequest;
import io.maestro3.sdk.v3.request.billing.SubTotalBillingReportRequest;
import io.maestro3.sdk.v3.request.billing.TotalBillingReportRequest;

public class BillingManager extends AbstractManager implements IBillingManager {

    private static final TypeReference<SdkBillingReportResponse> BILLING_REPORT_RESULT = new TypeReference<SdkBillingReportResponse>() {};
    private static final TypeReference<SdkBillingTagResponse> BILLING_TAG_RESULT = new TypeReference<SdkBillingTagResponse>() {};
    private static final TypeReference<SdkBillingTabularReportResponse> BILLING_TABULAR_REPORT_RESULT = new TypeReference<SdkBillingTabularReportResponse>() {};
    private static final TypeReference<SdkBillingInvoicesResponse> BILLING_INVOICE_RESULT = new TypeReference<SdkBillingInvoicesResponse>() {};

    private static final String ALL_ZONES = "NO_ZONE";
    private static final String PUBLIC_ZONES = "PUBLIC";
    private static final String PRIVATE_ZONES = "PRIVATE";
    private static final String SINGLE_ZONE = "SINGLE_ZONE";
    private static final String AWS_UNREACHABLE = "AWS_UNREACHABLE";

    public BillingManager(IM3ApiActionExecutor executor, boolean isAsync) {
        super(executor, isAsync);
    }

    @Override
    public M3Result<SdkBillingReportResponse> getTotalReport(IPrincipal principal, TotalBillingReportRequest request) {
        return execute(principal, request, BILLING_REPORT_RESULT);
    }

    @Override
    public M3Result<SdkBillingReportResponse> getSubtotalReport(IPrincipal principal, SubTotalBillingReportRequest request) {
        return execute(principal, request, BILLING_REPORT_RESULT);
    }

    @Override
    public M3Result<SdkBillingReportResponse> getResourceReport(IPrincipal principal, ResourceBillingReportRequest request) {
        return execute(principal, request, BILLING_REPORT_RESULT);
    }

    @Override
    public M3Result<SdkBillingReportResponse> getHourlyReport(IPrincipal principal, HourlyBillingReportRequest request) {
        return execute(principal, request, BILLING_REPORT_RESULT);
    }

    @Override
    public M3Result<SdkBillingReportResponse> getMultiprojectReport(IPrincipal principal, MultiProjectBillingReportRequest request) {
        MultiProjectEmailReportRequest.Builder multiprojectRequestBuilder = MultiProjectEmailReportRequest.builder()
            .withTag(request.getTag())
            .withTo(request.getTo())
            .withFrom(request.getFrom())
            .withFormat(request.getFormat());
        SdkMultiProjectBillingReportTarget reportUnitDetails = request.getTarget();
        multiprojectRequestBuilder.withEoAccount(reportUnitDetails.getAccountId())
            .withRegion(reportUnitDetails.getRegion())
            .withTenantGroups(reportUnitDetails.getTenantGroups())
            .withTenantNames(reportUnitDetails.getTenantNames())
            .withReportProjectType(request.getType().name())
            .withNativeCurrency(request.isNativeCurrency())
            .withCached(request.isCached());
        ReportUnit reportUnit = reportUnitDetails.getReportUnit();
        switch (reportUnit) {
            case ALL: {
                multiprojectRequestBuilder.withReportZoneType(ALL_ZONES);
                break;
            }
            case ACCOUNT: {
                setAccountReportZoneType(multiprojectRequestBuilder, reportUnitDetails, request.isNativeCurrency());
                break;
            }
            case REGION: {
                multiprojectRequestBuilder.withReportZoneType(SINGLE_ZONE);
                break;
            }
            case CLOUD: {
                MultiProjectReportCloudTarget cloudTarget = reportUnitDetails.getCloudTarget();
                switch (cloudTarget) {
                    case SINGLE:
                        setSingleReportZoneType(request.isNativeCurrency(), multiprojectRequestBuilder, reportUnitDetails);
                        break;
                    case PUBLIC:
                        multiprojectRequestBuilder.withReportZoneType(PUBLIC_ZONES);
                        break;
                    case PRIVATE:
                        multiprojectRequestBuilder.withReportZoneType(PRIVATE_ZONES);
                        break;
                    default:
                        throw new IllegalArgumentException(cloudTarget + " is not supported");
                }
                break;
            }
            default:
                throw new IllegalArgumentException(reportUnit + " is not supported");
        }
        MultiProjectEmailReportRequest multiProjectRequest = multiprojectRequestBuilder.build();
        return execute(principal, multiProjectRequest, BILLING_REPORT_RESULT);
    }

    private void setAccountReportZoneType(MultiProjectEmailReportRequest.Builder multiprojectRequestBuilder,
                                          SdkMultiProjectBillingReportTarget reportUnitDetails,
                                          boolean nativeCurrency) {
        MultiProjectReportCloudTarget cloudTarget = reportUnitDetails.getCloudTarget();
        if(cloudTarget == null) {
            multiprojectRequestBuilder.withReportZoneType(ALL_ZONES);
            return;
        }

        switch (cloudTarget) {
            case SINGLE:
                setSingleReportZoneType(nativeCurrency, multiprojectRequestBuilder, reportUnitDetails);
                break;
            case PUBLIC:
                multiprojectRequestBuilder.withReportZoneType(PUBLIC_ZONES);
                break;
            case PRIVATE:
                multiprojectRequestBuilder.withReportZoneType(PRIVATE_ZONES);
                break;
            default:
                multiprojectRequestBuilder.withReportZoneType(ALL_ZONES);
        }
    }

    private void setSingleReportZoneType(boolean nativeCurrency,
                                         MultiProjectEmailReportRequest.Builder multiprojectRequestBuilder,
                                         SdkMultiProjectBillingReportTarget reportUnitDetails) {
        if (nativeCurrency) {
            if (reportUnitDetails.getCloud() == SdkCloud.AWS){
                multiprojectRequestBuilder.withReportZoneType(AWS_UNREACHABLE);
            } else if (reportUnitDetails.getCloud() == SdkCloud.AZURE){
                multiprojectRequestBuilder.withReportZoneType(SdkCloud.AZURE.name());
            } else {
                throw new IllegalArgumentException(reportUnitDetails.getCloud() + " doesn't support native currency");
            }
        } else {
            multiprojectRequestBuilder.withReportZoneType(reportUnitDetails.getCloud().name());
        }
    }

    @Override
    public M3Result<SdkBillingTagResponse> getTags(IPrincipal principal, BillingTagRequest request) {
        return execute(principal, request, BILLING_TAG_RESULT);
    }

    @Override
    public M3Result<SdkBillingInvoicesResponse> getInvoices(IPrincipal principal, BillingInvoiceRequest request) {
        return execute(principal, request, BILLING_INVOICE_RESULT);
    }

    @Override
    public M3Result<SdkBillingReportResponse> getDailyTotal(IPrincipal principal, DailyReportByTenantGroupRequest request) {
        return execute(principal, request, BILLING_REPORT_RESULT);
    }

    @Override
    public M3Result<SdkBillingReportResponse> getMonthlyTotal(IPrincipal principal, MonthlyReportByTenantGroupRequest request) {
        return execute(principal, request, BILLING_REPORT_RESULT);
    }

    @Override
    public M3Result<SdkBillingCostObjectDetailsResponse> getCostObjectDetails(IPrincipal principal, CostObjectDetailsRequest request) {
        return execute(principal, request, new TypeReference<SdkBillingCostObjectDetailsResponse>() {});
    }

    @Override
    public M3Result<SdkBillingTabularReportResponse> getCostAndUsageReport(IPrincipal principal, CostAndUsageReportRequest request) {
        return execute(principal, request, BILLING_TABULAR_REPORT_RESULT);
    }

    @Override
    public M3Result<Object> getConsumptionDetails(IPrincipal principal, GetConsumptionDetailsRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<Object> addConsumptionDetails(IPrincipal principal, AddConsumptionDetailsRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<Object> deleteConsumptionDetails(IPrincipal principal, DeleteConsumptionDetailsRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<Object> getConsumption(IPrincipal principal, GetConsumptionRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<Object> addConsumption(IPrincipal principal, AddConsumptionRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<Object> deleteConsumption(IPrincipal principal, DeleteConsumptionRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<Object> getAdjustment(IPrincipal principal, GetAdjustmentRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<Object> addAdjustment(IPrincipal principal, AddAdjustmentRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<Object> deleteAdjustment(IPrincipal principal, DeleteAdjustmentRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<Object> checkTenantStatusRequest(IPrincipal principal, CheckTenantStatusRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }
}
