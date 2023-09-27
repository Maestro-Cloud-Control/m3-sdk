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
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.SdkUtils;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3ApiAction;
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
import io.maestro3.sdk.v3.manager.impl.AccountManager;
import io.maestro3.sdk.v3.manager.impl.AdminManager;
import io.maestro3.sdk.v3.manager.impl.AnalyticsManager;
import io.maestro3.sdk.v3.manager.impl.ApprovalManager;
import io.maestro3.sdk.v3.manager.impl.AuditManager;
import io.maestro3.sdk.v3.manager.impl.BillingManager;
import io.maestro3.sdk.v3.manager.impl.ChefManager;
import io.maestro3.sdk.v3.manager.impl.FileManager;
import io.maestro3.sdk.v3.manager.impl.MetricManager;
import io.maestro3.sdk.v3.manager.impl.NotificationManager;
import io.maestro3.sdk.v3.manager.impl.OperationManager;
import io.maestro3.sdk.v3.manager.impl.OwnershipManager;
import io.maestro3.sdk.v3.manager.impl.PlatformServiceManager;
import io.maestro3.sdk.v3.manager.impl.PriceManager;
import io.maestro3.sdk.v3.manager.impl.PrivateAgentManager;
import io.maestro3.sdk.v3.manager.impl.QuotaManager;
import io.maestro3.sdk.v3.manager.impl.ResourceManager;
import io.maestro3.sdk.v3.manager.impl.ScheduleManager;
import io.maestro3.sdk.v3.manager.impl.ScriptManager;
import io.maestro3.sdk.v3.manager.impl.SecurityManager;
import io.maestro3.sdk.v3.manager.impl.ServiceManager;
import io.maestro3.sdk.v3.manager.impl.StatusManager;
import io.maestro3.sdk.v3.manager.impl.TerraformManager;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Collection;

public class M3Client implements IM3Client {

    private final IM3ApiActionExecutor executor;
    private final boolean isAsync;
    private final IBillingManager billingManager;
    private final IAnalyticsManager analyticsManager;
    private final ITerraformManager terraformManager;
    private final ISecurityManager nessusManager;
    private final IResourceManager resourceManager;
    private final IAuditManager auditManager;
    private final IMetricManager metricManager;
    private final INotificationManager notificationManager;
    private final IOwnershipManager ownershipManager;
    private final IQuotaManager quotaManager;
    private final IStatusManager statusManager;
    private final IChefManager chefManager;
    private final IApprovalManager approvalManager;
    private final IScheduleManager scheduleManager;
    private final IPrivateAgentManager privateAgentManager;
    private final IPriceManager priceManager;
    private final IAccountManager accountManager;
    private final IPlatformServiceManager platformServiceManager;
    private final IFileManager fileManager;
    private final IScriptManager scriptManager;
    private final IAdminManager adminManager;
    private final IServiceManager serviceManager;
    private final IOperationManager operationManager;

    public M3Client(IM3ApiActionExecutor executor, boolean isAsync) {
        this.executor = executor;
        this.isAsync = isAsync;

        this.billingManager = new BillingManager(executor, isAsync);
        this.analyticsManager = new AnalyticsManager(executor, isAsync);
        this.terraformManager = new TerraformManager(executor, isAsync);
        this.nessusManager = new SecurityManager(executor, isAsync);
        this.auditManager = new AuditManager(executor, isAsync);
        this.metricManager = new MetricManager(executor, isAsync);
        this.notificationManager = new NotificationManager(executor, isAsync);
        this.ownershipManager = new OwnershipManager(executor, isAsync);
        this.quotaManager = new QuotaManager(executor, isAsync);
        this.statusManager = new StatusManager(executor, isAsync);
        this.resourceManager = new ResourceManager(executor, isAsync);
        this.chefManager = new ChefManager(executor, isAsync);
        this.approvalManager = new ApprovalManager(executor, isAsync);
        this.scheduleManager = new ScheduleManager(executor, isAsync);
        this.privateAgentManager = new PrivateAgentManager(executor, isAsync);
        this.priceManager = new PriceManager(executor, isAsync);
        this.accountManager = new AccountManager(executor, isAsync);
        this.platformServiceManager = new PlatformServiceManager(executor, isAsync);
        this.fileManager = new FileManager(executor, isAsync);
        this.scriptManager = new ScriptManager(executor, isAsync);
        this.adminManager = new AdminManager(executor, isAsync);
        this.serviceManager = new ServiceManager(executor, isAsync);
        this.operationManager = new OperationManager(executor, isAsync);
    }

    @Override
    public M3SdkVersion version() {
        return M3SdkVersion.V3;
    }

    @Override
    public IBillingManager billingManager() {
        return billingManager;
    }

    @Override
    public IAnalyticsManager analyticsManager() {
        return analyticsManager;
    }

    @Override
    public ITerraformManager terraformManager() {
        return terraformManager;
    }

    @Override
    public ISecurityManager securityManager() {
        return nessusManager;
    }

    @Override
    public IPrivateAgentManager privateAgentManager() {
        return privateAgentManager;
    }

    @Override
    public IAuditManager auditManager() {
        return auditManager;
    }

    @Override
    public IMetricManager metricManager() {
        return metricManager;
    }

    @Override
    public INotificationManager notificationManager() {
        return notificationManager;
    }

    @Override
    public IOwnershipManager ownershipManager() {
        return ownershipManager;
    }

    @Override
    public IQuotaManager quotaManager() {
        return quotaManager;
    }

    @Override
    public IStatusManager statusManager() {
        return statusManager;
    }

    @Override
    public IResourceManager resourceManager() {
        return resourceManager;
    }

    @Override
    public IChefManager chefManager() {
        return chefManager;
    }

    @Override
    public IScheduleManager scheduleManager() {
        return scheduleManager;
    }

    @Override
    public IApprovalManager approvalManager() {
        return approvalManager;
    }

    @Override
    public IPriceManager priceManager() {
        return priceManager;
    }

    @Override
    public IAccountManager accountManager() {
        return accountManager;
    }

    @Override
    public IPlatformServiceManager platformServiceManager() {
        return platformServiceManager;
    }

    @Override
    public IFileManager fileManager() {
        return fileManager;
    }

    @Override
    public IScriptManager scriptManager() {
        return scriptManager;
    }

    @Override
    public IAdminManager adminManager() {
        return adminManager;
    }

    @Override
    public IOperationManager operationManager() {
        return operationManager;
    }

    @Override
    public IServiceManager serviceManager() {
        return serviceManager;
    }

    @Override
    public M3BatchResult executeBatch(IPrincipal principal, Collection<? extends IRequest> requestData) {
        Assert.batchSizeLimitNotExceeded(requestData);
        M3ApiAction[] apiActions = SdkUtils.convert(requestData);
        if (isAsync) {
            return executor.executeAsyncBatch(principal, version(), apiActions);
        }
        return executor.executeBatch(principal, version(), apiActions);
    }

    @Override
    public void close() throws Exception {
        executor.close();
    }
}
