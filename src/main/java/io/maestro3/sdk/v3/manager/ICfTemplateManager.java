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
import io.maestro3.sdk.v3.model.cf.SdkCfStack;
import io.maestro3.sdk.v3.model.cf.SdkExecutionLogContent;
import io.maestro3.sdk.v3.model.cf.SdkExecutionLogInfo;
import io.maestro3.sdk.v3.model.cf.SdkTemplate;
import io.maestro3.sdk.v3.model.cf.SdkTemplateInfo;
import io.maestro3.sdk.v3.request.cf.CreateCfStackRequest;
import io.maestro3.sdk.v3.request.cf.DeleteCfTemplatesRequest;
import io.maestro3.sdk.v3.request.cf.DescribeCfStacksRequest;
import io.maestro3.sdk.v3.request.cf.DescribeCfTemplateRequest;
import io.maestro3.sdk.v3.request.cf.DescribeCfTemplateRequestByFiltersRequest;
import io.maestro3.sdk.v3.request.cf.DeleteCfStackRequest;
import io.maestro3.sdk.v3.request.resource.template.GetExecutionLogsRequest;
import io.maestro3.sdk.v3.request.resource.template.GetStackResourcesRequest;
import io.maestro3.sdk.v3.request.resource.template.GetTemplateContentRequest;
import io.maestro3.sdk.v3.request.cf.SetupCfTemplateRequest;
import java.util.List;

public interface ICfTemplateManager extends IManager {

    M3Result<List<SdkTemplateInfo>> describeTemplates(IPrincipal principal, DescribeCfTemplateRequest request);

    M3Result<List<SdkTemplateInfo>> describeTemplatesByFilters(IPrincipal principal, DescribeCfTemplateRequestByFiltersRequest request);

    M3Result<Void> removeTemplates(IPrincipal principal, DeleteCfTemplatesRequest request);

    M3Result<Void> setupTemplate(IPrincipal principal, SetupCfTemplateRequest request);

    M3Result<Void> createStack(IPrincipal principal, CreateCfStackRequest request);

    M3Result<SdkTemplate> getTemplateContent(IPrincipal principal, GetTemplateContentRequest request);

    M3Result<List<SdkCfStack>> listStacks(IPrincipal principal, DescribeCfStacksRequest request);

    M3Result<SdkCfStack> deleteStack(IPrincipal principal, DeleteCfStackRequest request);

    M3Result<String> getStackResources(IPrincipal principal, GetStackResourcesRequest request);

    M3Result<List<SdkExecutionLogInfo>> getExecutionLogs(IPrincipal principal, GetExecutionLogsRequest request);

    M3Result<List<SdkExecutionLogContent>> getExecutionLogContent(IPrincipal principal, GetExecutionLogsRequest request);

}
