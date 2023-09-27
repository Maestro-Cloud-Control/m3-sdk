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
import io.maestro3.sdk.v3.model.locks.SdkLock;
import io.maestro3.sdk.v3.model.terraform.SdkDeleteInfrastructureTemplateResponse;
import io.maestro3.sdk.v3.model.terraform.SdkSetupInfrastructureTemplateResponse;
import io.maestro3.sdk.v3.model.terraform.SdkTerraformCostEstimationData;
import io.maestro3.sdk.v3.model.terraform.TerraformPolicies;
import io.maestro3.sdk.v3.model.terraform.resource.SdkInfrastructureResources;
import io.maestro3.sdk.v3.model.terraform.template.SdkInfrastructureStack;
import io.maestro3.sdk.v3.model.terraform.template.SdkInfrastructureTemplate;
import io.maestro3.sdk.v3.request.terraform.ActivateTerraformRequest;
import io.maestro3.sdk.v3.request.terraform.DeactivateTerraformRequest;
import io.maestro3.sdk.v3.request.terraform.DeleteTerraformTemplateRequest;
import io.maestro3.sdk.v3.request.terraform.DeleteWebHookRequest;
import io.maestro3.sdk.v3.request.terraform.DescribeTemplateStackRequest;
import io.maestro3.sdk.v3.request.terraform.DescribeTerraformPoliciesRequest;
import io.maestro3.sdk.v3.request.terraform.DescribeTerraformResourcesRequest;
import io.maestro3.sdk.v3.request.terraform.DescribeTerraformTemplateRequest;
import io.maestro3.sdk.v3.request.terraform.DescribeTerraformTemplateStackRequest;
import io.maestro3.sdk.v3.request.terraform.DescribeTerraformTemplatesByFiltersRequest;
import io.maestro3.sdk.v3.request.terraform.DownloadLastTerraformLogRequest;
import io.maestro3.sdk.v3.request.terraform.DownloadTemplateLogsRequest;
import io.maestro3.sdk.v3.request.terraform.DownloadTerraformResourcesFileRequest;
import io.maestro3.sdk.v3.request.terraform.ExportTerraformTemplateRequest;
import io.maestro3.sdk.v3.request.terraform.GetTerraformCostEstimationRequest;
import io.maestro3.sdk.v3.request.terraform.GetTerraformTemplateLockRequest;
import io.maestro3.sdk.v3.request.terraform.IsTerraformTemplateLockedRequest;
import io.maestro3.sdk.v3.request.terraform.LockTerraformTemplateRequest;
import io.maestro3.sdk.v3.request.terraform.ProlongTerraformTemplateLockRequest;
import io.maestro3.sdk.v3.request.terraform.SetupTerraformTemplateWithGitRequest;
import io.maestro3.sdk.v3.request.terraform.SetupTerraformTemplateWithInternalStorageRequest;
import io.maestro3.sdk.v3.request.terraform.SetupWebHookRequest;
import io.maestro3.sdk.v3.request.terraform.StartApproveProcessForApplyTemplateRequest;
import io.maestro3.sdk.v3.request.terraform.TerraformTaskRequest;
import io.maestro3.sdk.v3.request.terraform.UnlockTerraformTemplateRequest;
import io.maestro3.sdk.v3.request.terraform.UpdatePoliciesRequest;
import io.maestro3.sdk.v3.request.terraform.UpdateTerraformTemplateRequest;
import io.maestro3.sdk.v3.request.terraform.WebHookActionRequest;

import java.util.List;
import java.util.Set;

public interface ITerraformManager extends IManager {

    M3Result<Void> activate(IPrincipal principal, ActivateTerraformRequest request);

    M3Result<Void> deactivate(IPrincipal principal, DeactivateTerraformRequest request);

    M3Result<TerraformPolicies> describeTerraformPolicies(IPrincipal principal, DescribeTerraformPoliciesRequest request);

    M3Result<Set<String>> describeTerraformContextVariables(IPrincipal principal);

    M3Result<String> executeTask(IPrincipal principal, TerraformTaskRequest request);

    M3Result<SdkSetupInfrastructureTemplateResponse> setupTemplateWithInternalStorage(IPrincipal principal, SetupTerraformTemplateWithInternalStorageRequest request);

    M3Result<SdkSetupInfrastructureTemplateResponse> setupTemplateWithGit(IPrincipal principal, SetupTerraformTemplateWithGitRequest request);

    M3Result<Void> startApproveProcessForApplyTemplate(IPrincipal principal, StartApproveProcessForApplyTemplateRequest request);


    M3Result<SdkDeleteInfrastructureTemplateResponse> deleteTemplate(IPrincipal principal, DeleteTerraformTemplateRequest request);

    M3Result<Void> updateTemplate(IPrincipal principal, UpdateTerraformTemplateRequest request);

    M3Result<List<SdkInfrastructureTemplate>> describeTemplate(IPrincipal principal, DescribeTerraformTemplateRequest request);

    M3Result<List<SdkInfrastructureTemplate>> describeTemplatesByFilters(IPrincipal principal, DescribeTerraformTemplatesByFiltersRequest request);

    M3Result<List<SdkInfrastructureStack>> describeStack(IPrincipal principal, DescribeTemplateStackRequest request);

    M3Result<List<SdkInfrastructureStack>> describeTemplateStacks(IPrincipal principal, DescribeTerraformTemplateStackRequest request);

    M3Result<SdkInfrastructureResources> describeResources(IPrincipal principal, DescribeTerraformResourcesRequest request);

    M3Result<SdkTerraformCostEstimationData> getCostEstimation(IPrincipal principal, GetTerraformCostEstimationRequest request);

    M3Result<Void> updatePolicies(IPrincipal principal, UpdatePoliciesRequest request);

    M3Result<Void> handleWebHook(IPrincipal principal, WebHookActionRequest request);

    M3Result<Void> setupWebHook(IPrincipal principal, SetupWebHookRequest request);

    M3Result<Void> deleteWebHook(IPrincipal principal, DeleteWebHookRequest request);


    M3Result<SdkLock> getTemplateLock(IPrincipal principal, GetTerraformTemplateLockRequest request);

    M3Result<Boolean> isTemplateLocked(IPrincipal principal, IsTerraformTemplateLockedRequest request);

    M3Result<Boolean> lockTemplate(IPrincipal principal, LockTerraformTemplateRequest request);

    M3Result<Boolean> prolongTemplateLock(IPrincipal principal, ProlongTerraformTemplateLockRequest request);

    M3Result<Boolean> unlockTemplate(IPrincipal principal, UnlockTerraformTemplateRequest request);


    M3Result<String> downloadLogs(IPrincipal principal, DownloadTemplateLogsRequest request);

    M3Result<String> downloadLastLog(IPrincipal principal, DownloadLastTerraformLogRequest request);

    M3Result<String> downloadResourcesFile(IPrincipal principal, DownloadTerraformResourcesFileRequest request);

    M3Result<String> exportTemplate(IPrincipal principal, ExportTerraformTemplateRequest request);
}
