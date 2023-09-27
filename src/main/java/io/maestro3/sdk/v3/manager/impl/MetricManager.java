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
import io.maestro3.sdk.v3.manager.IMetricManager;
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

public class MetricManager extends AbstractManager implements IMetricManager {

    private static final TypeReference<List<Object>> OBJECT_LIST_RESULT = new TypeReference<List<Object>>() {};

    public MetricManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<List<Object>> getUserActions(IPrincipal principal, GetUserActionsRequest request) {
        return execute(principal, request, OBJECT_LIST_RESULT);
    }

    @Override
    public M3Result<List<Object>> getCommonDashboardActions(IPrincipal principal, GetCommonDashboardActionsRequest request) {
        return execute(principal, request, OBJECT_LIST_RESULT);
    }

    @Override
    public M3Result<List<Object>> getUserSpecificActionsForAllDashboards(IPrincipal principal, GetActionsForAllDashboardsRequest request) {
        return execute(principal, request, OBJECT_LIST_RESULT);
    }

    @Override
    public M3Result<Object> updateUserSpecificDashboardAction(IPrincipal principal, UpdateDashboardActionRequest request) {
        return execute(principal, request, OBJECT_RESULT);
    }

    @Override
    public M3Result<Object> updateUserSpecificInstanceDashboardAction(IPrincipal principal, UpdateInstanceDashboardActionRequest request) {
        return execute(principal, request, OBJECT_RESULT);
    }

    @Override
    public M3Result<Boolean> deleteActions(IPrincipal principal, DeleteActionsRequest request) {
        return execute(principal, request, BOOL_RESULT);
    }

    @Override
    public M3Result<Boolean> updateUserActionsWithSkipExisting(IPrincipal principal, UpdateUserActionsRequest request) {
        return execute(principal, request, BOOL_RESULT);
    }

    @Override
    public M3Result<Boolean> isMetricEnabled(IPrincipal principal, MetricEnabledRequest request) {
        return execute(principal, request, BOOL_RESULT);
    }

    @Override
    public M3Result<List<Object>> getAllUserDashboardAction(IPrincipal principal, GetAllUserDashboardActionRequest request) {
        return execute(principal, request, OBJECT_LIST_RESULT);
    }

    @Override
    public M3Result<List<Object>> getAllRealTimeDashboardAction(IPrincipal principal, GetRealTimeDashboardActionRequest request) {
        return execute(principal, request, OBJECT_LIST_RESULT);
    }

    @Override
    public M3Result<List<Object>> getCustomMetrics(IPrincipal principal, GetCustomMetricsRequest request) {
        return execute(principal, request, OBJECT_LIST_RESULT);
    }

    @Override
    public M3Result<String> getGraphMetricImage(IPrincipal principal, GetGraphMetricImageRequest request) {
        return execute(principal, request, STRING_RESULT);
    }

    @Override
    public M3Result<Object> getCustomMetricValue(IPrincipal principal, GetCustomMetricValueRequest request) {
        return execute(principal, request, OBJECT_RESULT);
    }
}
