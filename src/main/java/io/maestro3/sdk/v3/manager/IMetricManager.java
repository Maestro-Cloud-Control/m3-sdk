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
import io.maestro3.sdk.v3.request.metric.DeleteActionsRequest;
import io.maestro3.sdk.v3.request.metric.GetActionsForAllDashboardsRequest;
import io.maestro3.sdk.v3.request.metric.GetAllUserDashboardActionRequest;
import io.maestro3.sdk.v3.request.metric.GetCommonDashboardActionsRequest;
import io.maestro3.sdk.v3.request.metric.GetCustomMetricValueRequest;
import io.maestro3.sdk.v3.request.metric.GetCustomMetricsRequest;
import io.maestro3.sdk.v3.request.metric.GetGraphMetricImageRequest;
import io.maestro3.sdk.v3.request.metric.GetRealTimeDashboardActionRequest;
import io.maestro3.sdk.v3.request.metric.GetUserActionsRequest;
import io.maestro3.sdk.v3.request.metric.MetricEnabledRequest;
import io.maestro3.sdk.v3.request.metric.UpdateDashboardActionRequest;
import io.maestro3.sdk.v3.request.metric.UpdateInstanceDashboardActionRequest;
import io.maestro3.sdk.v3.request.metric.UpdateUserActionsRequest;

import java.util.List;

public interface IMetricManager extends IManager {

    M3Result<List<Object>> getUserActions(IPrincipal principal, GetUserActionsRequest request);

    M3Result<List<Object>> getCommonDashboardActions(IPrincipal principal, GetCommonDashboardActionsRequest request);

    M3Result<List<Object>> getUserSpecificActionsForAllDashboards(IPrincipal principal, GetActionsForAllDashboardsRequest request);

    M3Result<Object> updateUserSpecificDashboardAction(IPrincipal principal, UpdateDashboardActionRequest request);

    M3Result<Object> updateUserSpecificInstanceDashboardAction(IPrincipal principal, UpdateInstanceDashboardActionRequest request);

    M3Result<Boolean> deleteActions(IPrincipal principal, DeleteActionsRequest request);

    M3Result<Boolean> updateUserActionsWithSkipExisting(IPrincipal principal, UpdateUserActionsRequest request);

    M3Result<Boolean> isMetricEnabled(IPrincipal principal, MetricEnabledRequest request);

    M3Result<List<Object>> getAllUserDashboardAction(IPrincipal principal, GetAllUserDashboardActionRequest request);

    M3Result<List<Object>> getAllRealTimeDashboardAction(IPrincipal principal, GetRealTimeDashboardActionRequest request);

    M3Result<List<Object>> getCustomMetrics(IPrincipal principal, GetCustomMetricsRequest request);

    M3Result<String> getGraphMetricImage(IPrincipal principal, GetGraphMetricImageRequest request);

    M3Result<Object> getCustomMetricValue(IPrincipal principal, GetCustomMetricValueRequest request);
}
