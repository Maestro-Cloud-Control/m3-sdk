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
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.manager.IAnalyticsManager;
import io.maestro3.sdk.v3.model.analytics.SdkAwsWorkspaceDescription;
import io.maestro3.sdk.v3.model.analytics.SdkBillingAuditEvent;
import io.maestro3.sdk.v3.model.analytics.SdkBillingConfig;
import io.maestro3.sdk.v3.model.analytics.SdkBillingTimeLine;
import io.maestro3.sdk.v3.model.analytics.SdkCloudRadarRecord;
import io.maestro3.sdk.v3.model.analytics.SdkInstanceAnalytic;
import io.maestro3.sdk.v3.model.analytics.SdkMonitoringRecord;
import io.maestro3.sdk.v3.model.instance.SdkInstance;
import io.maestro3.sdk.v3.request.analytics.AuditEventRequest;
import io.maestro3.sdk.v3.request.analytics.AwsNotOptimalWorkspaceDescriptionRequest;
import io.maestro3.sdk.v3.request.analytics.AwsWorkspacesWithBillableHoursRequest;
import io.maestro3.sdk.v3.request.analytics.BillingTimeLineRequest;
import io.maestro3.sdk.v3.request.analytics.CloudRadarReportRequest;
import io.maestro3.sdk.v3.request.analytics.LowUtilizedInstanceRequest;
import io.maestro3.sdk.v3.request.analytics.MonitoringReportRequest;
import io.maestro3.sdk.v3.request.analytics.InstanceAnalyticReportRequest;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class AnalyticsManager extends AbstractManager implements IAnalyticsManager {

    private static final TypeReference<SdkBillingConfig> BILLING_CONFIG_RESULT = new TypeReference<SdkBillingConfig>() {};
    private static final TypeReference<List<SdkBillingTimeLine>> BILLING_TIME_LINES_RESULT = new TypeReference<List<SdkBillingTimeLine>>() {
    };
    private static final TypeReference<SdkInstanceAnalytic> INSTANCES_ANALYTIC_RESULT = new TypeReference<SdkInstanceAnalytic>() {
    };
    private static final TypeReference<List<SdkBillingAuditEvent>> AUDIT_EVENTS_RESULT = new TypeReference<List<SdkBillingAuditEvent>>() {
    };
    private static final TypeReference<List<SdkInstance>> LOW_UTILIZED_INSTANCE_RESULT = new TypeReference<List<SdkInstance>>() {};
    private static final TypeReference<List<SdkAwsWorkspaceDescription>> AWS_WORKSPACES_RESULT = new TypeReference<List<SdkAwsWorkspaceDescription>>() {};
    private static final TypeReference<List<SdkCloudRadarRecord>> CLOUD_RADAR_RECORD_LIST_RESULT = new TypeReference<List<SdkCloudRadarRecord>>() {};
    private static final TypeReference<List<SdkMonitoringRecord>> MONITORING_RECORD_LIST_RESULT = new TypeReference<List<SdkMonitoringRecord>>() {};

    public AnalyticsManager(IM3ApiActionExecutor executor, boolean isAsync) {
        super(executor, isAsync);
    }

    @Override
    public M3Result<List<SdkMonitoringRecord>> getMonitoringReport(IPrincipal principal, MonitoringReportRequest request) {
        return execute(principal, request, MONITORING_RECORD_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkCloudRadarRecord>> getCloudRadarReport(IPrincipal principal, CloudRadarReportRequest request) {
        return execute(principal, request, CLOUD_RADAR_RECORD_LIST_RESULT);
    }

    @Override
    public M3Result<SdkBillingConfig> getBillingConfig(IPrincipal principal) {
        return execute(principal, () -> ActionType.GET_BILLING_CONFIG, BILLING_CONFIG_RESULT);
    }

    @Override
    public M3Result<List<SdkBillingTimeLine>> getBillingTimeLines(IPrincipal principal, BillingTimeLineRequest request) {
        return execute(principal, request, BILLING_TIME_LINES_RESULT);
    }

    @Override
    public M3Result<SdkInstanceAnalytic> getInstanceAnalytic(IPrincipal principal, InstanceAnalyticReportRequest request) {
        return execute(principal, request, INSTANCES_ANALYTIC_RESULT);
    }

    @Override
    public M3Result<List<SdkBillingAuditEvent>> getAuditEvents(IPrincipal principal, AuditEventRequest request) {
        return execute(principal, request, AUDIT_EVENTS_RESULT);
    }

    @Override
    public M3Result<List<SdkInstance>> getLowUtilizedInstances(IPrincipal principal, LowUtilizedInstanceRequest request) {
        return execute(principal, request, LOW_UTILIZED_INSTANCE_RESULT);
    }

    @Override
    public M3Result<List<SdkAwsWorkspaceDescription>> getNotOptimalAwsWorkspaces(IPrincipal principal, AwsNotOptimalWorkspaceDescriptionRequest request) {
        return execute(principal, request, AWS_WORKSPACES_RESULT);
    }

    @Override
    public M3Result<List<SdkAwsWorkspaceDescription>> getAwsWorkspacesWithBillableHours(IPrincipal principal, AwsWorkspacesWithBillableHoursRequest request) {
        return execute(principal, request, AWS_WORKSPACES_RESULT);
    }
}
