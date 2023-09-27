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

public interface IPlatformServiceManager {

    M3Result<SdkPlatformServiceEntry> activate(IPrincipal principal, ActivatePlatformServiceRequest request);

    M3Result<Void> deactivate(IPrincipal principal, DeactivatePlatformServiceRequest request);

    M3Result<List<SdkPlatformServiceEntry>> listEntries(IPrincipal principal, ListPlatformServiceEntriesRequest request);

    M3Result<SdkInfrastructureStack> describeStackByServiceEntryId(IPrincipal principal, DescribeTemplateStackByServiceEntryIdRequest request);

    M3Result<List<SdkPlatformService>> listServiceDefinitions(IPrincipal principal, ListPlatformServicesRequest request);

    M3Result<List<String>> describeServiceAvailability(IPrincipal principal, DescribePlatformServiceAvailabilityRequest request);

    M3Result<Void> registerPlatformService(IPrincipal principal, PlatformServiceActionRequest request);

    M3Result<Void> unRegisterPlatformService(IPrincipal principal, UnregisterPlatformServiceRequest request);

    M3Result<Void> createPostponedRegisterServiceJob(IPrincipal principal, PostponedRegisterServiceJobRequest request);

    M3Result<List<SdkTerraformTemplateVariable>> getPlatformServiceVariableInfo(IPrincipal principal, GetPlatformServiceVariablesInfoRequest request);

    M3Result<List<SdkTemplateVariableValidationDto>> validatePlatformServiceVariables(IPrincipal principal, ValidatePlatformServiceVariablesRequest request);
}
