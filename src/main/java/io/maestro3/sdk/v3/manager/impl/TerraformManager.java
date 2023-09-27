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
import io.maestro3.sdk.v3.manager.ITerraformManager;
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

public class TerraformManager extends AbstractManager implements ITerraformManager {

    private static final TypeReference<SdkLock> TF_LOCK_RESULT = new TypeReference<SdkLock>() {};
    private static final TypeReference<SdkInfrastructureResources> TF_RESOURCE_RESULT = new TypeReference<SdkInfrastructureResources>() {};
    private static final TypeReference<SdkTerraformCostEstimationData> TF_COST_RESOURCE_RESULT = new TypeReference<SdkTerraformCostEstimationData>() {};
    private static final TypeReference<SdkDeleteInfrastructureTemplateResponse> TF_DELETE_RESULT = new TypeReference<SdkDeleteInfrastructureTemplateResponse>() {};
    private static final TypeReference<SdkSetupInfrastructureTemplateResponse> SETUP_TERRAFORM_TEMPLATE = new TypeReference<SdkSetupInfrastructureTemplateResponse>() {};
    private static final TypeReference<List<SdkInfrastructureTemplate>> TF_TEMPLATE_LIST_RESULT = new TypeReference<List<SdkInfrastructureTemplate>>() {};
    private static final TypeReference<List<SdkInfrastructureStack>> TF_STACK_LIST_RESULT = new TypeReference<List<SdkInfrastructureStack>>() {};
    private static final TypeReference<TerraformPolicies> TF_POLICIES_RESULT = new TypeReference<TerraformPolicies>() {};

    public TerraformManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<Void> activate(IPrincipal principal, ActivateTerraformRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> deactivate(IPrincipal principal, DeactivateTerraformRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<TerraformPolicies> describeTerraformPolicies(IPrincipal principal, DescribeTerraformPoliciesRequest request) {
        return execute(principal, request, TF_POLICIES_RESULT);
    }

    @Override
    public M3Result<Set<String>> describeTerraformContextVariables(IPrincipal principal) {
        return execute(principal, () -> ActionType.LIST_TERRAFORM_CONTEXT_VARIABLES, new TypeReference<Set<String>>() {});
    }

    @Override
    public M3Result<String> executeTask(IPrincipal principal, TerraformTaskRequest request) {
        return execute(principal, request, STRING_RESULT);
    }

    @Override
    public M3Result<SdkSetupInfrastructureTemplateResponse> setupTemplateWithInternalStorage(IPrincipal principal, SetupTerraformTemplateWithInternalStorageRequest request) {
        return execute(principal, request, SETUP_TERRAFORM_TEMPLATE);
    }

    @Override
    public M3Result<SdkSetupInfrastructureTemplateResponse> setupTemplateWithGit(IPrincipal principal, SetupTerraformTemplateWithGitRequest request) {
        return execute(principal, request, SETUP_TERRAFORM_TEMPLATE);
    }

    @Override
    public M3Result<Void> startApproveProcessForApplyTemplate(IPrincipal principal, StartApproveProcessForApplyTemplateRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<SdkDeleteInfrastructureTemplateResponse> deleteTemplate(IPrincipal principal, DeleteTerraformTemplateRequest request) {
        return execute(principal, request, TF_DELETE_RESULT);
    }

    @Override
    public M3Result<Void> updateTemplate(IPrincipal principal, UpdateTerraformTemplateRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<SdkInfrastructureTemplate>> describeTemplate(IPrincipal principal, DescribeTerraformTemplateRequest request) {
        return execute(principal, request, TF_TEMPLATE_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkInfrastructureTemplate>> describeTemplatesByFilters(IPrincipal principal,
                                                                                DescribeTerraformTemplatesByFiltersRequest request) {
        return execute(principal, request, TF_TEMPLATE_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkInfrastructureStack>> describeStack(IPrincipal principal, DescribeTemplateStackRequest request) {
        return execute(principal, request, TF_STACK_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkInfrastructureStack>> describeTemplateStacks(IPrincipal principal, DescribeTerraformTemplateStackRequest request) {
        return execute(principal, request, TF_STACK_LIST_RESULT);
    }

    @Override
    public M3Result<SdkInfrastructureResources> describeResources(IPrincipal principal, DescribeTerraformResourcesRequest request) {
        return execute(principal, request, TF_RESOURCE_RESULT);
    }

    @Override
    public M3Result<SdkTerraformCostEstimationData> getCostEstimation(IPrincipal principal, GetTerraformCostEstimationRequest request) {
        return execute(principal, request, TF_COST_RESOURCE_RESULT);
    }

    @Override
    public M3Result<Void> updatePolicies(IPrincipal principal, UpdatePoliciesRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> handleWebHook(IPrincipal principal, WebHookActionRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> setupWebHook(IPrincipal principal, SetupWebHookRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> deleteWebHook(IPrincipal principal, DeleteWebHookRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<SdkLock> getTemplateLock(IPrincipal principal, GetTerraformTemplateLockRequest request) {
        return execute(principal, request, TF_LOCK_RESULT);
    }

    @Override
    public M3Result<Boolean> isTemplateLocked(IPrincipal principal, IsTerraformTemplateLockedRequest request) {
        return execute(principal, request, BOOL_RESULT);
    }

    @Override
    public M3Result<Boolean> lockTemplate(IPrincipal principal, LockTerraformTemplateRequest request) {
        return execute(principal, request, BOOL_RESULT);
    }

    @Override
    public M3Result<Boolean> prolongTemplateLock(IPrincipal principal, ProlongTerraformTemplateLockRequest request) {
        return execute(principal, request, BOOL_RESULT);
    }

    @Override
    public M3Result<Boolean> unlockTemplate(IPrincipal principal, UnlockTerraformTemplateRequest request) {
        return execute(principal, request, BOOL_RESULT);
    }

    @Override
    public M3Result<String> downloadLogs(IPrincipal principal, DownloadTemplateLogsRequest request) {
        return execute(principal, request, STRING_RESULT);
    }

    @Override
    public M3Result<String> downloadLastLog(IPrincipal principal, DownloadLastTerraformLogRequest request) {
        return execute(principal, request, STRING_RESULT);
    }

    @Override
    public M3Result<String> downloadResourcesFile(IPrincipal principal, DownloadTerraformResourcesFileRequest request) {
        return execute(principal, request, STRING_RESULT);
    }

    @Override
    public M3Result<String> exportTemplate(IPrincipal principal, ExportTerraformTemplateRequest request) {
        return execute(principal, request, STRING_RESULT);
    }
}
