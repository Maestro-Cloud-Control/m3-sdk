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
import io.maestro3.sdk.v3.model.agent.SdkPrivateAgentInfo;
import io.maestro3.sdk.v3.model.agent.SdkPrivateAgentRegion;
import io.maestro3.sdk.v3.model.agent.SdkPrivateAgentShapeInfo;
import io.maestro3.sdk.v3.model.agent.diagnostic.SdkAgentDiagnosticResult;
import io.maestro3.sdk.v3.model.agent.diagnostic.SdkCheckResult;
import io.maestro3.sdk.v3.model.agent.diagnostic.SdkFixResult;
import io.maestro3.sdk.v3.model.agent.network.SdkStaticIpAddress;
import io.maestro3.sdk.v3.model.agent.network.SdkVlanDescribeInfo;
import io.maestro3.sdk.v3.model.agent.network.SdkVlanResponse;
import io.maestro3.sdk.v3.model.agent.wizard.SdkPrivateStepData;
import io.maestro3.sdk.v3.model.agent.wizard.SdkPrivateWizard;
import io.maestro3.sdk.v3.model.image.SdkImage;
import io.maestro3.sdk.v3.model.onboarding.SdkOnboardingStep;
import io.maestro3.sdk.v3.model.terraform.SdkPrivateAgentConsoleExecutionResponse;
import io.maestro3.sdk.v3.model.terraform.SdkPrivateAgentGitExecutionResponse;
import io.maestro3.sdk.v3.request.account.OnboardingPrivateRequest;
import io.maestro3.sdk.v3.request.agent.ActivateVLANRequest;
import io.maestro3.sdk.v3.request.agent.AdditionalParametersRequest;
import io.maestro3.sdk.v3.request.agent.AllocateIpRequest;
import io.maestro3.sdk.v3.request.agent.AssociateIpRequest;
import io.maestro3.sdk.v3.request.agent.CreatePrivateAgentRequest;
import io.maestro3.sdk.v3.request.agent.DeactivateVLANRequest;
import io.maestro3.sdk.v3.request.agent.DeallocateStaticIpRequest;
import io.maestro3.sdk.v3.request.agent.DescribeStaticIpsRequest;
import io.maestro3.sdk.v3.request.agent.DisassociateStaticIpRequest;
import io.maestro3.sdk.v3.request.agent.ListAvailableRegionsForTenantRequest;
import io.maestro3.sdk.v3.request.agent.ListNativeShapesRequest;
import io.maestro3.sdk.v3.request.agent.ListPrivateAgentsRequest;
import io.maestro3.sdk.v3.request.agent.ListRegionImagesRequest;
import io.maestro3.sdk.v3.request.agent.ManageVLANRequest;
import io.maestro3.sdk.v3.request.agent.MoveToDmzRequest;
import io.maestro3.sdk.v3.request.agent.PrivateWizardRequest;
import io.maestro3.sdk.v3.request.agent.ResendInstanceAuditRequest;
import io.maestro3.sdk.v3.request.agent.ResendVolumeAuditRequest;
import io.maestro3.sdk.v3.request.agent.SdkCheckRequest;
import io.maestro3.sdk.v3.request.agent.SdkFixAgentConfigurationRequest;
import io.maestro3.sdk.v3.request.agent.SdkPrivateAgentConsoleExecutionRequest;
import io.maestro3.sdk.v3.request.agent.SdkPrivateAgentGitExecutionRequest;

import java.util.List;
import java.util.Map;

public interface IPrivateAgentManager extends IManager {

    M3Result<List<SdkPrivateAgentInfo>> listPrivateAgents(IPrincipal principal, ListPrivateAgentsRequest regionRequest);

    M3Result<SdkPrivateAgentInfo> createPrivateAgent(IPrincipal principal, CreatePrivateAgentRequest request);

    M3Result<Map<String, Object>> getAgentState(IPrincipal principal);

    M3Result<List<SdkPrivateAgentRegion>> listAvailableRegionsForTenant(IPrincipal principal, ListAvailableRegionsForTenantRequest regionRequest);

    M3Result<List<SdkPrivateAgentShapeInfo>> listNativeShapes(IPrincipal principal, ListNativeShapesRequest regionRequest);

    M3Result<List<SdkImage>> listRegionImages(IPrincipal principal, ListRegionImagesRequest regionRequest);

    M3Result<SdkPrivateWizard> getConfigWizard(IPrincipal principal, String agentId, String wizardType);

    M3Result<SdkPrivateWizard> getConfigWizard(IPrincipal principal, String agentId, String wizardType, String wizardId);

    M3Result<SdkPrivateWizard> executeWizardAction(IPrincipal principal, PrivateWizardRequest request);

    M3Result<SdkPrivateStepData> getAdditionalStepData(IPrincipal principal, AdditionalParametersRequest request);

    M3Result<List<SdkOnboardingStep>> activatePrivateTenant(IPrincipal principal, OnboardingPrivateRequest request);

    M3Result<Void> resendAudit(IPrincipal principal, ResendInstanceAuditRequest auditRequest);

    M3Result<Void> resendAudit(IPrincipal principal, ResendVolumeAuditRequest auditRequest);

    M3Result<SdkAgentDiagnosticResult<SdkCheckResult>> getDiagnosticResult(IPrincipal principal, SdkCheckRequest request);

    M3Result<SdkAgentDiagnosticResult<SdkFixResult>> fixFoundedIssues(IPrincipal principal, SdkFixAgentConfigurationRequest request);

    M3Result<SdkPrivateAgentConsoleExecutionResponse> executeConsoleCommand(IPrincipal principal, SdkPrivateAgentConsoleExecutionRequest request);

    M3Result<SdkPrivateAgentGitExecutionResponse> executeGit(IPrincipal principal, SdkPrivateAgentGitExecutionRequest request);

    M3Result<SdkVlanResponse> activateVlan(IPrincipal principal, ActivateVLANRequest request);

    M3Result<SdkVlanResponse> deactivateVlan(IPrincipal principal, DeactivateVLANRequest request);

    M3Result<List<SdkVlanDescribeInfo>> describeVlan(IPrincipal principal, ManageVLANRequest request);

    M3Result<SdkStaticIpAddress> allocateIp(IPrincipal principal, AllocateIpRequest request);

    M3Result<Boolean> deallocateIp(IPrincipal principal, DeallocateStaticIpRequest request);

    M3Result<List<SdkStaticIpAddress>> describeIps(IPrincipal principal, DescribeStaticIpsRequest request);

    M3Result<SdkStaticIpAddress> associateIp(IPrincipal principal, AssociateIpRequest request);

    M3Result<SdkStaticIpAddress> disassociateIp(IPrincipal principal, DisassociateStaticIpRequest request);

    M3Result<SdkVlanResponse> moveToVlan(IPrincipal principal, MoveToDmzRequest request);
}
