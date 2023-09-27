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
import io.maestro3.sdk.v3.model.status.M3BillingStatus;
import io.maestro3.sdk.v3.model.status.M3Status;
import io.maestro3.sdk.v3.request.status.AuditForHourRequest;
import io.maestro3.sdk.v3.request.status.BillingHistoryRequest;

import java.util.List;

public interface IStatusManager extends IManager {

    M3Result<M3Status> checkStatus(IPrincipal principal);

    M3Result<M3BillingStatus> checkBillingStatus(IPrincipal principal);

    M3Result<M3BillingStatus> checkBillingHistory(IPrincipal principal, BillingHistoryRequest request);

    M3Result<Boolean> checkTerraform(IPrincipal principal);

    M3Result<Boolean> checkOwnership(IPrincipal principal);

    M3Result<Boolean> checkMails(IPrincipal principal);

    M3Result<String> getLastEventForHour(IPrincipal principal, AuditForHourRequest request);

    M3Result<List<String>> getEventsForHour(IPrincipal principal, AuditForHourRequest request);

}
