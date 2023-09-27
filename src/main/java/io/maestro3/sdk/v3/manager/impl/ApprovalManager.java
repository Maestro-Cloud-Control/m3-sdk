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
import io.maestro3.sdk.v3.core.ApprovalResult;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.manager.IApprovalManager;
import io.maestro3.sdk.v3.request.approval.ExecuteApprovalActionRequest;
import io.maestro3.sdk.v3.request.approval.ExecuteNotificationActionRequest;
import io.maestro3.sdk.v3.request.approval.MultiTenantPermissionsRequest;


public class ApprovalManager extends AbstractManager implements IApprovalManager {

    private static final TypeReference<ApprovalResult> APPROVAL_RESULT = new TypeReference<ApprovalResult>() {};

    public ApprovalManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<ApprovalResult> executeApprovalAction(IPrincipal principal, ExecuteApprovalActionRequest request) {
        return execute(principal, request, APPROVAL_RESULT);
    }

    @Override
    public M3Result<ApprovalResult> executeNotificationAction(IPrincipal principal, ExecuteNotificationActionRequest request) {
        return execute(principal, request, APPROVAL_RESULT);
    }

    @Override
    public M3Result<String> sendExpandPermissionsRequest(IPrincipal principal, MultiTenantPermissionsRequest requests) {
        return execute(principal, requests, STRING_RESULT);
    }
}
