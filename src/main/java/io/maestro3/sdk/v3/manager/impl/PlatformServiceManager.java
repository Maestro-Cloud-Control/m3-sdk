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
import io.maestro3.sdk.v3.manager.IPlatformServiceManager;
import io.maestro3.sdk.v3.model.paas.SdkPlatformService;
import io.maestro3.sdk.v3.model.paas.SdkPlatformServiceEntry;
import io.maestro3.sdk.v3.model.paas.SdkTemplateVariableValidationDto;
import io.maestro3.sdk.v3.model.terraform.template.SdkInfrastructureStack;
import io.maestro3.sdk.v3.model.terraform.template.SdkTerraformTemplateVariable;
import io.maestro3.sdk.v3.request.paas.ActivatePlatformServiceRequest;
import io.maestro3.sdk.v3.request.paas.DeactivatePlatformServiceRequest;
import io.maestro3.sdk.v3.request.paas.DescribePlatformServiceAvailabilityRequest;
import io.maestro3.sdk.v3.request.paas.GetPlatformServiceVariablesInfoRequest;
import io.maestro3.sdk.v3.request.paas.ListPlatformServiceEntriesRequest;
import io.maestro3.sdk.v3.request.paas.ListPlatformServicesRequest;
import io.maestro3.sdk.v3.request.paas.PlatformServiceActionRequest;
import io.maestro3.sdk.v3.request.paas.PostponedRegisterServiceJobRequest;
import io.maestro3.sdk.v3.request.paas.UnregisterPlatformServiceRequest;
import io.maestro3.sdk.v3.request.paas.ValidatePlatformServiceVariablesRequest;
import io.maestro3.sdk.v3.request.terraform.DescribeTemplateStackByServiceEntryIdRequest;

import java.util.List;

public class PlatformServiceManager extends AbstractManager implements IPlatformServiceManager {

    private static final TypeReference<List<SdkPlatformService>> PLATFORM_SERVICE_LIST_RESULT = new TypeReference<List<SdkPlatformService>>() {
    };
    private static final TypeReference<SdkPlatformServiceEntry> PLATFORM_SERVICE_ENTRY_RESULT = new TypeReference<SdkPlatformServiceEntry>() {
    };
    private static final TypeReference<List<SdkPlatformServiceEntry>> PLATFORM_SERVICE_ENTRY_LIST_RESULT = new TypeReference<List<SdkPlatformServiceEntry>>() {
    };
    private static final TypeReference<List<String>> LIST_REGIONS_RESULT = new TypeReference<List<String>>() {
    };
    private static final TypeReference<SdkInfrastructureStack> TF_STACK_RESULT = new TypeReference<SdkInfrastructureStack>() {
    };
    private static final TypeReference<List<SdkTerraformTemplateVariable>> LIST_TF_VAR_RESULT = new TypeReference<List<SdkTerraformTemplateVariable>>(){
    };
    private static final TypeReference<List<SdkTemplateVariableValidationDto>> LIST_VARIABLE_DTO = new TypeReference<List<SdkTemplateVariableValidationDto>>() {
    };

    public PlatformServiceManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<SdkPlatformServiceEntry> activate(IPrincipal principal, ActivatePlatformServiceRequest request) {
        return execute(principal, request, PLATFORM_SERVICE_ENTRY_RESULT);
    }

    @Override
    public M3Result<Void> deactivate(IPrincipal principal, DeactivatePlatformServiceRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<SdkPlatformServiceEntry>> listEntries(IPrincipal principal, ListPlatformServiceEntriesRequest request) {
        return execute(principal, request, PLATFORM_SERVICE_ENTRY_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkPlatformService>> listServiceDefinitions(IPrincipal principal, ListPlatformServicesRequest request) {
        return execute(principal, request, PLATFORM_SERVICE_LIST_RESULT);
    }

    @Override
    public M3Result<List<String>> describeServiceAvailability(IPrincipal principal, DescribePlatformServiceAvailabilityRequest request) {
        return execute(principal, request, LIST_REGIONS_RESULT);
    }

    @Override
    public M3Result<Void> registerPlatformService(IPrincipal principal, PlatformServiceActionRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> unRegisterPlatformService(IPrincipal principal, UnregisterPlatformServiceRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<SdkInfrastructureStack> describeStackByServiceEntryId(IPrincipal principal,
                                                                          DescribeTemplateStackByServiceEntryIdRequest request) {
        return execute(principal, request, TF_STACK_RESULT);
    }

    @Override
    public M3Result<List<SdkTerraformTemplateVariable>> getPlatformServiceVariableInfo(IPrincipal principal, GetPlatformServiceVariablesInfoRequest request) {
        return execute(principal, request, LIST_TF_VAR_RESULT);
    }

    @Override
    public M3Result<List<SdkTemplateVariableValidationDto>> validatePlatformServiceVariables(IPrincipal principal, ValidatePlatformServiceVariablesRequest request) {
        return execute(principal, request, LIST_VARIABLE_DTO);
    }

    @Override
    public M3Result<Void> createPostponedRegisterServiceJob(IPrincipal principal, PostponedRegisterServiceJobRequest request) {
        return execute(principal, request, VOID_RESULT);
    }
}
