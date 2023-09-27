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
import io.maestro3.sdk.v3.manager.IChefManager;
import io.maestro3.sdk.v3.model.chef.SdkChefConfiguration;
import io.maestro3.sdk.v3.model.chef.SdkChefInstance;
import io.maestro3.sdk.v3.model.chef.SdkChefNodeUpdateResult;
import io.maestro3.sdk.v3.request.chef.DescribeChefConfigRequest;
import io.maestro3.sdk.v3.request.chef.GetChefProfilesRequest;
import io.maestro3.sdk.v3.request.chef.GetInstanceChefInfoRequest;
import io.maestro3.sdk.v3.request.chef.UpdateChefNodeStateRequest;

public class ChefManager extends AbstractManager implements IChefManager {

    public ChefManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<SdkChefConfiguration> describeChefConfig(IPrincipal principal, DescribeChefConfigRequest request) {
        return execute(principal, request, new TypeReference<SdkChefConfiguration>() {});
    }

    @Override
    public M3Result<SdkChefConfiguration> describeChefConfigFromDefaultServer(IPrincipal principal, GetChefProfilesRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public M3Result<SdkChefInstance> getInstanceConfiguration(IPrincipal principal, GetInstanceChefInfoRequest request) {
        return execute(principal, request, new TypeReference<SdkChefInstance>() {});
    }

    public M3Result<SdkChefNodeUpdateResult> updateNodeState(IPrincipal principal, UpdateChefNodeStateRequest updateRequest){
        return execute(principal, updateRequest, new TypeReference<SdkChefNodeUpdateResult>() {});
    }

}
