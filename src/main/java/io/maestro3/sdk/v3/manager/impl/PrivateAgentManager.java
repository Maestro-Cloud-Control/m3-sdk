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
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.manager.IPrivateAgentManager;
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
import io.maestro3.sdk.v3.model.agent.wizard.SdkWizardAction;
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

public class PrivateAgentManager extends AbstractManager implements IPrivateAgentManager {

    private static final TypeReference<List<SdkPrivateAgentInfo>> PRIVATE_AGENTS_REFERENCE = new TypeReference<List<SdkPrivateAgentInfo>>() {
    };
    private static final TypeReference<SdkPrivateAgentInfo> PRIVATE_AGENT_REFERENCE = new TypeReference<SdkPrivateAgentInfo>() {
    };
    private static final TypeReference<List<SdkPrivateAgentShapeInfo>> SHAPE_REFERENCE = new TypeReference<List<SdkPrivateAgentShapeInfo>>() {
    };
    private static final TypeReference<List<SdkPrivateAgentRegion>> AGENT_REGION_REFERENCE = new TypeReference<List<SdkPrivateAgentRegion>>() {
    };
    private static final TypeReference<List<SdkImage>> IMAGE_REFERENCE = new TypeReference<List<SdkImage>>() {
    };
    private static final TypeReference<SdkPrivateWizard> WIZARD_REFERENCE = new TypeReference<SdkPrivateWizard>() {
    };
    private static final TypeReference<SdkPrivateStepData> DATA_REFERENCE = new TypeReference<SdkPrivateStepData>() {
    };
    private static final TypeReference<SdkAgentDiagnosticResult<SdkCheckResult>> DIAGNOSTIC_REFERENCE = new TypeReference<SdkAgentDiagnosticResult<SdkCheckResult>>() {
    };
    private static final TypeReference<SdkAgentDiagnosticResult<SdkFixResult>> DIAGNOSTIC_FIX_REFERENCE = new TypeReference<SdkAgentDiagnosticResult<SdkFixResult>>() {
    };
    private static final TypeReference<List<SdkVlanDescribeInfo>> VLAN_DESCRIBE_REF = new TypeReference<List<SdkVlanDescribeInfo>>() {
    };
    private static final TypeReference<SdkVlanResponse> VLAN_RESPONSE_TYPE_REFERENCE = new TypeReference<SdkVlanResponse>() {
    };
    private static final TypeReference<SdkPrivateAgentConsoleExecutionResponse> CONSOLE_EXECUTION_RESPONSE = new TypeReference<SdkPrivateAgentConsoleExecutionResponse>() {
    };
    private static final TypeReference<SdkPrivateAgentGitExecutionResponse> GIT_EXECUTION_RESPONSE = new TypeReference<SdkPrivateAgentGitExecutionResponse>() {
    };
    private static final TypeReference<Map<String, Object>> MAP_OF_OBJECTS = new TypeReference<Map<String, Object>>() {
    };
    private static final TypeReference<List<SdkOnboardingStep>> ONBOARDING_STEPS = new TypeReference<List<SdkOnboardingStep>>() {
    };
    private static final TypeReference<SdkStaticIpAddress> IP_ADDRESS_TYPE_REFERENCE = new TypeReference<SdkStaticIpAddress>() {
    };
    private static final TypeReference<List<SdkStaticIpAddress>> LIST_IP_ADDRESS_TYPE_REFERENCE = new TypeReference<List<SdkStaticIpAddress>>() {
    };
    private static final TypeReference<Boolean> BOOLEAN = new TypeReference<Boolean>() {
    };

    public PrivateAgentManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<List<SdkPrivateAgentInfo>> listPrivateAgents(IPrincipal principal, ListPrivateAgentsRequest regionRequest) {
        return execute(principal, regionRequest, PRIVATE_AGENTS_REFERENCE);
    }

    @Override
    public M3Result<SdkPrivateAgentInfo> createPrivateAgent(IPrincipal principal, CreatePrivateAgentRequest request) {
        return execute(principal, request, PRIVATE_AGENT_REFERENCE);
    }

    @Override
    public M3Result<Map<String, Object>> getAgentState(IPrincipal principal) {
        return execute(principal, () -> ActionType.GET_AGENT_STATE_ACTION, MAP_OF_OBJECTS);
    }

    @Override
    public M3Result<List<SdkPrivateAgentRegion>> listAvailableRegionsForTenant(IPrincipal principal, ListAvailableRegionsForTenantRequest regionRequest) {
        return execute(principal, regionRequest, AGENT_REGION_REFERENCE);
    }

    @Override
    public M3Result<List<SdkPrivateAgentShapeInfo>> listNativeShapes(IPrincipal principal, ListNativeShapesRequest regionRequest) {
        return execute(principal, regionRequest, SHAPE_REFERENCE);
    }

    @Override
    public M3Result<List<SdkImage>> listRegionImages(IPrincipal principal, ListRegionImagesRequest regionRequest) {
        return execute(principal, regionRequest, IMAGE_REFERENCE);
    }

    @Override
    public M3Result<SdkPrivateWizard> getConfigWizard(IPrincipal principal, String agentId, String wizardType) {
        PrivateWizardRequest request = PrivateWizardRequest.builder()
            .withPrivateAgentId(agentId)
            .withWizardType(wizardType)
            .withAction(SdkWizardAction.GET)
            .build();
        return execute(principal, request, WIZARD_REFERENCE);
    }

    @Override
    public M3Result<SdkPrivateWizard> getConfigWizard(IPrincipal principal, String agentId, String wizardType, String wizardId) {
        if (wizardId == null) {
            return getConfigWizard(principal, agentId, wizardType);
        }
        SdkPrivateWizard wizard = new SdkPrivateWizard();
        wizard.setId(wizardId);
        PrivateWizardRequest request = PrivateWizardRequest.builder()
            .withPrivateAgentId(agentId)
            .withWizardId(wizardId)
            .withWizardType(wizardType)
            .withWizard(wizard)
            .withAction(SdkWizardAction.GET)
            .build();
        return execute(principal, request, WIZARD_REFERENCE);
    }

    @Override
    public M3Result<SdkPrivateWizard> executeWizardAction(IPrincipal principal, PrivateWizardRequest request) {
        return execute(principal, request, WIZARD_REFERENCE);
    }

    @Override
    public M3Result<SdkPrivateStepData> getAdditionalStepData(IPrincipal principal, AdditionalParametersRequest request) {
        return execute(principal, request, DATA_REFERENCE);
    }

    @Override
    public M3Result<List<SdkOnboardingStep>> activatePrivateTenant(IPrincipal principal, OnboardingPrivateRequest request) {
        ActionType actionType = request.getActionType();
        if (actionType == null) {
            throw new M3SdkException("Failed to find action type for cloud " + request.getCloud());
        }
        return execute(principal, request, ONBOARDING_STEPS);
    }

    @Override
    public M3Result<Void> resendAudit(IPrincipal principal, ResendInstanceAuditRequest auditRequest) {
        return execute(principal, auditRequest, VOID_RESULT);
    }

    @Override
    public M3Result<Void> resendAudit(IPrincipal principal, ResendVolumeAuditRequest auditRequest) {
        return execute(principal, auditRequest, VOID_RESULT);
    }

    @Override
    public M3Result<SdkAgentDiagnosticResult<SdkCheckResult>> getDiagnosticResult(IPrincipal principal, SdkCheckRequest request) {
        return execute(principal, request, DIAGNOSTIC_REFERENCE);
    }

    @Override
    public M3Result<SdkAgentDiagnosticResult<SdkFixResult>> fixFoundedIssues(IPrincipal principal, SdkFixAgentConfigurationRequest request) {
        return execute(principal, request, DIAGNOSTIC_FIX_REFERENCE);
    }

    @Override
    public M3Result<SdkPrivateAgentConsoleExecutionResponse> executeConsoleCommand(IPrincipal principal, SdkPrivateAgentConsoleExecutionRequest request) {
        return execute(principal, request, CONSOLE_EXECUTION_RESPONSE);
    }

    @Override
    public M3Result<SdkPrivateAgentGitExecutionResponse> executeGit(IPrincipal principal, SdkPrivateAgentGitExecutionRequest request) {
        return execute(principal, request, GIT_EXECUTION_RESPONSE);
    }

    @Override
    public M3Result<SdkVlanResponse> activateVlan(IPrincipal principal, ActivateVLANRequest request) {
        return execute(principal, request, VLAN_RESPONSE_TYPE_REFERENCE);
    }

    @Override
    public M3Result<SdkVlanResponse> deactivateVlan(IPrincipal principal, DeactivateVLANRequest request) {
        return execute(principal, request, VLAN_RESPONSE_TYPE_REFERENCE);
    }

    @Override
    public M3Result<List<SdkVlanDescribeInfo>> describeVlan(IPrincipal principal, ManageVLANRequest request) {
        return execute(principal, request, VLAN_DESCRIBE_REF);
    }

    @Override
    public M3Result<SdkStaticIpAddress> allocateIp(IPrincipal principal, AllocateIpRequest request) {
        return execute(principal, request, IP_ADDRESS_TYPE_REFERENCE);
    }

    @Override
    public M3Result<Boolean> deallocateIp(IPrincipal principal, DeallocateStaticIpRequest request) {
        return execute(principal, request, BOOLEAN);
    }

    @Override
    public M3Result<List<SdkStaticIpAddress>> describeIps(IPrincipal principal, DescribeStaticIpsRequest request) {
        return execute(principal, request, LIST_IP_ADDRESS_TYPE_REFERENCE);
    }

    @Override
    public M3Result<SdkStaticIpAddress> associateIp(IPrincipal principal, AssociateIpRequest request) {
        return execute(principal, request, IP_ADDRESS_TYPE_REFERENCE);
    }

    @Override
    public M3Result<SdkStaticIpAddress> disassociateIp(IPrincipal principal, DisassociateStaticIpRequest request) {
        return execute(principal, request, IP_ADDRESS_TYPE_REFERENCE);
    }

    @Override
    public M3Result<SdkVlanResponse> moveToVlan(IPrincipal principal, MoveToDmzRequest request) {
        return execute(principal, request, VLAN_RESPONSE_TYPE_REFERENCE);
    }
}
