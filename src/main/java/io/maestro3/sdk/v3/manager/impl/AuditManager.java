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
import io.maestro3.sdk.v3.manager.IAuditManager;
import io.maestro3.sdk.v3.model.audit.ResourceIdRequestOnSdkAuditEventPair;
import io.maestro3.sdk.v3.model.audit.SdkAuditEvent;
import io.maestro3.sdk.v3.request.audit.BatchCreationAuditEventByResourceIdRequestsRequest;
import io.maestro3.sdk.v3.request.audit.DescribeAuditRequest;
import io.maestro3.sdk.v3.request.audit.GetCreationAuditEventRequest;
import io.maestro3.sdk.v3.request.audit.GetEventsRequest;
import io.maestro3.sdk.v3.request.audit.SaveCadfEventRequest;

import java.util.List;

public class AuditManager extends AbstractManager implements IAuditManager {

    private static final TypeReference<List<SdkAuditEvent>> EVENT_LIST_RESULT = new TypeReference<List<SdkAuditEvent>>() {};
    private static final TypeReference<SdkAuditEvent> EVENT_RESULT = new TypeReference<SdkAuditEvent>() {};
    private static final TypeReference<List<ResourceIdRequestOnSdkAuditEventPair>> EVENT_PAIR_LIST_RESULT = new TypeReference<List<ResourceIdRequestOnSdkAuditEventPair>>() {};

    public AuditManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<Void> saveCadfEvent(IPrincipal principal, SaveCadfEventRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<SdkAuditEvent>> describeAudit(IPrincipal principal, DescribeAuditRequest request) {
        return execute(principal, request, EVENT_LIST_RESULT);
    }

    @Override
    public M3Result<SdkAuditEvent> getCreationAuditEvent(IPrincipal principal, GetCreationAuditEventRequest request) {
        return execute(principal, request, EVENT_RESULT);
    }

    @Override
    public M3Result<List<ResourceIdRequestOnSdkAuditEventPair>> getListCreationAuditEvent(IPrincipal principal, BatchCreationAuditEventByResourceIdRequestsRequest request) {
        return execute(principal, request, EVENT_PAIR_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkAuditEvent>> getEvents(IPrincipal principal, GetEventsRequest eventsRequest) {
        return execute(principal, eventsRequest, EVENT_LIST_RESULT);
    }
}
