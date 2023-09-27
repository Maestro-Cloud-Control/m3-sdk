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

package io.maestro3.sdk.v3.client;

import io.maestro3.sdk.M3SdkVersion;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3BatchResult;
import io.maestro3.sdk.v3.manager.IAccountManager;
import io.maestro3.sdk.v3.manager.IAdminManager;
import io.maestro3.sdk.v3.manager.IAnalyticsManager;
import io.maestro3.sdk.v3.manager.IApprovalManager;
import io.maestro3.sdk.v3.manager.IAuditManager;
import io.maestro3.sdk.v3.manager.IBillingManager;
import io.maestro3.sdk.v3.manager.IChefManager;
import io.maestro3.sdk.v3.manager.IFileManager;
import io.maestro3.sdk.v3.manager.IMetricManager;
import io.maestro3.sdk.v3.manager.INotificationManager;
import io.maestro3.sdk.v3.manager.IOperationManager;
import io.maestro3.sdk.v3.manager.IOwnershipManager;
import io.maestro3.sdk.v3.manager.IPlatformServiceManager;
import io.maestro3.sdk.v3.manager.IPriceManager;
import io.maestro3.sdk.v3.manager.IPrivateAgentManager;
import io.maestro3.sdk.v3.manager.IQuotaManager;
import io.maestro3.sdk.v3.manager.IResourceManager;
import io.maestro3.sdk.v3.manager.IScheduleManager;
import io.maestro3.sdk.v3.manager.IScriptManager;
import io.maestro3.sdk.v3.manager.ISecurityManager;
import io.maestro3.sdk.v3.manager.IServiceManager;
import io.maestro3.sdk.v3.manager.IStatusManager;
import io.maestro3.sdk.v3.manager.ITerraformManager;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Collection;


public interface IM3Client extends AutoCloseable{

    IBillingManager billingManager();

    IAnalyticsManager analyticsManager();

    ITerraformManager terraformManager();

    ISecurityManager securityManager();

    IPrivateAgentManager privateAgentManager();

    IAuditManager auditManager();

    IMetricManager metricManager();

    INotificationManager notificationManager();

    IOwnershipManager ownershipManager();

    IQuotaManager quotaManager();

    IStatusManager statusManager();

    IResourceManager resourceManager();

    IChefManager chefManager();

    IScheduleManager scheduleManager();

    IApprovalManager approvalManager();

    IPriceManager priceManager();

    IAccountManager accountManager();

    IPlatformServiceManager platformServiceManager();

    IFileManager fileManager();

    IScriptManager scriptManager();

    M3SdkVersion version();

    IAdminManager adminManager();

    IOperationManager operationManager();

    IServiceManager serviceManager();

    M3BatchResult executeBatch(IPrincipal principal, Collection<? extends IRequest> requestData);
}
