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
import io.maestro3.sdk.v3.model.audit.ResourceIdRequestOnSdkAuditEventPair;
import io.maestro3.sdk.v3.model.audit.SdkAuditEvent;
import io.maestro3.sdk.v3.request.audit.BatchCreationAuditEventByResourceIdRequestsRequest;
import io.maestro3.sdk.v3.request.audit.DescribeAuditRequest;
import io.maestro3.sdk.v3.request.audit.GetCreationAuditEventRequest;
import io.maestro3.sdk.v3.request.audit.GetEventsRequest;
import io.maestro3.sdk.v3.request.audit.SaveCadfEventRequest;

import java.util.List;

public interface IAuditManager extends IManager {

    M3Result<Void> saveCadfEvent(IPrincipal principal, SaveCadfEventRequest request);

    M3Result<List<SdkAuditEvent>> describeAudit(IPrincipal principal, DescribeAuditRequest request);

    M3Result<SdkAuditEvent> getCreationAuditEvent(IPrincipal principal, GetCreationAuditEventRequest request);

    M3Result<List<ResourceIdRequestOnSdkAuditEventPair>> getListCreationAuditEvent(IPrincipal principal, BatchCreationAuditEventByResourceIdRequestsRequest request);

    M3Result<List<SdkAuditEvent>> getEvents(IPrincipal principal,  GetEventsRequest eventsRequest);

}
