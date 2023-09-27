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
import io.maestro3.sdk.v3.manager.IStatusManager;
import io.maestro3.sdk.v3.model.status.M3BillingStatus;
import io.maestro3.sdk.v3.model.status.M3Status;
import io.maestro3.sdk.v3.request.status.AuditForHourRequest;
import io.maestro3.sdk.v3.request.status.BillingHistoryRequest;

import java.util.List;

public class StatusManager extends AbstractManager implements IStatusManager {

    private static final TypeReference<M3Status> STATUS_RESULT = new TypeReference<M3Status>() {};
    private static final TypeReference<M3BillingStatus> BILLING_STATUS_RESULT = new TypeReference<M3BillingStatus>() {};

    public StatusManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<M3Status> checkStatus(IPrincipal principal) {
        return execute(principal, () -> ActionType.M3_STATUS, STATUS_RESULT);
    }

    @Override
    public M3Result<M3BillingStatus> checkBillingStatus(IPrincipal principal) {
        return execute(principal, () -> ActionType.M3_BILLING_STATUS, BILLING_STATUS_RESULT);
    }

    @Override
    public M3Result<M3BillingStatus> checkBillingHistory(IPrincipal principal, BillingHistoryRequest request) {
        return execute(principal, request, BILLING_STATUS_RESULT);
    }

    @Override
    public M3Result<Boolean> checkTerraform(IPrincipal principal) {
        return execute(principal, () -> ActionType.TERRAFORM_AVAILABILITY, BOOL_RESULT);
    }

    @Override
    public M3Result<Boolean> checkOwnership(IPrincipal principal) {
        return execute(principal, () -> ActionType.OWNERSHIP_AVAILABILITY, BOOL_RESULT);
    }

    @Override
    public M3Result<Boolean> checkMails(IPrincipal principal) {
        return execute(principal, () -> ActionType.MAILS_AVAILABILITY, BOOL_RESULT);
    }

    @Override
    public M3Result<String> getLastEventForHour(IPrincipal principal, AuditForHourRequest request) {
        return execute(principal, request, STRING_RESULT);
    }

    @Override
    public M3Result<List<String>> getEventsForHour(IPrincipal principal, AuditForHourRequest request) {
        return execute(principal, request, LIST_STRING_RESULT);
    }
}
