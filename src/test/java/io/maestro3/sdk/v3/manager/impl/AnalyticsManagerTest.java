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

import io.maestro3.sdk.M3SdkVersion;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.core.ResultStatus;
import io.maestro3.sdk.v3.core.StaticPrincipal;
import io.maestro3.sdk.v3.manager.IAnalyticsManager;
import io.maestro3.sdk.v3.model.analytics.SdkCloudRadarPeriod;
import io.maestro3.sdk.v3.model.analytics.SdkCloudRadarRecord;
import io.maestro3.sdk.v3.model.analytics.SdkMonitoringRecord;
import io.maestro3.sdk.v3.request.analytics.CloudRadarReportRequest;
import io.maestro3.sdk.v3.request.analytics.MonitoringReportRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class AnalyticsManagerTest {

    private IM3ApiActionExecutor actionExecutor;

    private IAnalyticsManager analyticsManager;

    private IPrincipal principal;

    @Before
    public void init() {
        actionExecutor = Mockito.mock(IM3ApiActionExecutor.class);
        analyticsManager = new AnalyticsManager(actionExecutor, false);
        principal = StaticPrincipal.getPrincipal();
    }

    @Test
    public void getCloudRadarReport() {
        M3Result<List<SdkCloudRadarRecord>> rawResult = M3Result.success("id", List.of());
        when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);

        CloudRadarReportRequest reportRequest = CloudRadarReportRequest.builder()
                .withFrom(new Date().getTime())
                .withTo(new Date().getTime())
                .withPeriod(SdkCloudRadarPeriod.DAY)
                .build();

        M3Result<List<SdkCloudRadarRecord>> result = analyticsManager.getCloudRadarReport(principal, reportRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

    @Test
    public void getMonitoringReport() {
        M3Result<List<SdkCloudRadarRecord>> rawResult = M3Result.success("id", List.of());
        when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);

        MonitoringReportRequest reportRequest = MonitoringReportRequest.builder()
                .withFrom(new Date().getTime())
                .withTo(new Date().getTime())
                .withTenantName("tenantName")
                .build();

        M3Result<List<SdkMonitoringRecord>> result = analyticsManager.getMonitoringReport(principal, reportRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }
}
