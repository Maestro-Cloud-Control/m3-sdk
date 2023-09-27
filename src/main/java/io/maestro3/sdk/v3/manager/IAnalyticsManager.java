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
import io.maestro3.sdk.v3.model.analytics.SdkAwsWorkspaceDescription;
import io.maestro3.sdk.v3.model.analytics.SdkBillingAuditEvent;
import io.maestro3.sdk.v3.model.analytics.SdkBillingConfig;
import io.maestro3.sdk.v3.model.analytics.SdkBillingTimeLine;
import io.maestro3.sdk.v3.model.analytics.SdkCloudRadarRecord;
import io.maestro3.sdk.v3.model.analytics.SdkMonitoringRecord;
import io.maestro3.sdk.v3.model.instance.SdkInstance;
import io.maestro3.sdk.v3.request.analytics.AuditEventRequest;
import io.maestro3.sdk.v3.request.analytics.AwsNotOptimalWorkspaceDescriptionRequest;
import io.maestro3.sdk.v3.request.analytics.AwsWorkspacesWithBillableHoursRequest;
import io.maestro3.sdk.v3.request.analytics.BillingTimeLineRequest;
import io.maestro3.sdk.v3.request.analytics.CloudRadarReportRequest;
import io.maestro3.sdk.v3.request.analytics.LowUtilizedInstanceRequest;
import io.maestro3.sdk.v3.request.analytics.MonitoringReportRequest;
import io.maestro3.sdk.v3.request.analytics.StoppedInstanceAnalyticReportRequest;

import java.util.List;
import java.util.Map;

public interface IAnalyticsManager extends IManager {

    M3Result<List<SdkMonitoringRecord>> getMonitoringReport(IPrincipal principal, MonitoringReportRequest request);

    M3Result<List<SdkCloudRadarRecord>> getCloudRadarReport(IPrincipal principal, CloudRadarReportRequest request);

    M3Result<SdkBillingConfig> getBillingConfig(IPrincipal principal);

    M3Result<List<SdkBillingTimeLine>> getBillingTimeLines(IPrincipal principal, BillingTimeLineRequest request);

    M3Result<Map<String, Integer>> getStoppedInstanceAnalytic(IPrincipal principal, StoppedInstanceAnalyticReportRequest request);

    M3Result<List<SdkBillingAuditEvent>> getAuditEvents(IPrincipal principal, AuditEventRequest request);

    M3Result<List<SdkInstance>> getLowUtilizedInstances(IPrincipal principal, LowUtilizedInstanceRequest request);

    M3Result<List<SdkAwsWorkspaceDescription>> getNotOptimalAwsWorkspaces(IPrincipal principal, AwsNotOptimalWorkspaceDescriptionRequest request);

    M3Result<List<SdkAwsWorkspaceDescription>> getAwsWorkspacesWithBillableHours(IPrincipal principal, AwsWorkspacesWithBillableHoursRequest request);
}
