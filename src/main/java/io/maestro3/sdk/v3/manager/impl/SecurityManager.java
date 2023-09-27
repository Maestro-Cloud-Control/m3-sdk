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
import io.maestro3.sdk.v3.manager.ISecurityManager;
import io.maestro3.sdk.v3.model.security.SdkNessusLastScanResult;
import io.maestro3.sdk.v3.model.security.SdkNessusPolicy;
import io.maestro3.sdk.v3.model.security.SdkQualysLastScanResult;
import io.maestro3.sdk.v3.request.security.DescribeAvailableTemplatePoliciesRequest;
import io.maestro3.sdk.v3.request.security.GetLastInstanceNessusScanRequest;
import io.maestro3.sdk.v3.request.security.GetLastInstanceQualysScanRequest;
import io.maestro3.sdk.v3.request.security.InitNessusSecurityScanRequest;
import io.maestro3.sdk.v3.request.security.InitQualysSecurityScanRequest;

import java.util.List;
import java.util.Set;

public class SecurityManager extends AbstractManager implements ISecurityManager {

    private static final TypeReference<Set<String>> STRING_SET_RESULT = new TypeReference<Set<String>>() {};
    private static final TypeReference<List<SdkNessusLastScanResult>> NESSUS_SCAN_LIST_RESULT = new TypeReference<List<SdkNessusLastScanResult>>() {};
    private static final TypeReference<List<SdkQualysLastScanResult>> QUALYS_SCAN_LIST_RESULT = new TypeReference<List<SdkQualysLastScanResult>>() {};
    private static final TypeReference<List<SdkNessusPolicy>> NESSUS_POLICY_LIST_RESULT = new TypeReference<List<SdkNessusPolicy>>() {};

    public SecurityManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<Set<String>> initNessusSecurityScan(IPrincipal principal, InitNessusSecurityScanRequest request) {
        return execute(principal, request, STRING_SET_RESULT);
    }

    @Override
    public M3Result<Set<String>> initQualysSecurityScan(IPrincipal principal, InitQualysSecurityScanRequest request) {
        return execute(principal, request, STRING_SET_RESULT);
    }

    @Override
    public M3Result<List<SdkNessusPolicy>> getAvailableTemplatePoliciesForServer(IPrincipal principal, DescribeAvailableTemplatePoliciesRequest request) {
        return execute(principal, request, NESSUS_POLICY_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkNessusPolicy>> getAvailableTemplatePoliciesForDefaultServer(IPrincipal principal) {
        return execute(principal, DescribeAvailableTemplatePoliciesRequest.builder().build(), NESSUS_POLICY_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkNessusLastScanResult>> getLastNessusScansForInstances(IPrincipal principal, GetLastInstanceNessusScanRequest request) {
        return execute(principal, request, NESSUS_SCAN_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkQualysLastScanResult>> getLastQualysScansForInstances(IPrincipal principal, GetLastInstanceQualysScanRequest request) {
        return execute(principal, request, QUALYS_SCAN_LIST_RESULT);
    }
}
