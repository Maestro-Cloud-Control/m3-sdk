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
import io.maestro3.sdk.v3.manager.IQuotaManager;
import io.maestro3.sdk.v3.model.quota.SdkPriceQuota;
import io.maestro3.sdk.v3.model.resource.quota.SdkInstanceQuota;
import io.maestro3.sdk.v3.model.resource.quota.SdkVolumeQuota;
import io.maestro3.sdk.v3.request.quota.CreateQuotaRequest;
import io.maestro3.sdk.v3.request.quota.DepletedActiveQuotaActionsRequest;
import io.maestro3.sdk.v3.request.quota.DepletedActiveQuotaByTenantAndRegionRequest;
import io.maestro3.sdk.v3.request.quota.DepletedQuotaByTenantRequest;
import io.maestro3.sdk.v3.request.quota.QuotaByTenantAndTypeRequest;
import io.maestro3.sdk.v3.request.quota.QuotaExistsInCurrentTenantRequest;
import io.maestro3.sdk.v3.request.quota.QuotaExistsRequest;
import io.maestro3.sdk.v3.request.quota.QuotasByTenantRequest;
import io.maestro3.sdk.v3.request.quota.QuotasByTenantsWithCriteriaRequest;
import io.maestro3.sdk.v3.request.quota.RemoveQuotaRequest;
import io.maestro3.sdk.v3.request.quota.SingleQuotaByTenantAndRegionRequest;
import io.maestro3.sdk.v3.request.quota.UpdateQuotaRequest;
import io.maestro3.sdk.v3.request.resource.quota.GetInstanceQuotaRequest;
import io.maestro3.sdk.v3.request.resource.quota.GetVolumeQuotaRequest;
import io.maestro3.sdk.v3.request.resource.quota.RemoveInstanceQuotaRequest;
import io.maestro3.sdk.v3.request.resource.quota.RemoveVolumeQuotaRequest;
import io.maestro3.sdk.v3.request.resource.quota.UpdateInstanceQuotaRequest;
import io.maestro3.sdk.v3.request.resource.quota.UpdateVolumeQuotaRequest;
import io.maestro3.sdk.v3.request.resource.quota.ValidateResourceQuotaRequest;

import java.util.List;
import java.util.Set;

public class QuotaManager extends AbstractManager implements IQuotaManager {

    private static final TypeReference<SdkPriceQuota> QUOTA_RESULT = new TypeReference<SdkPriceQuota>() {};
    private static final TypeReference<SdkInstanceQuota> INSTANCE_QUOTA_RESULT = new TypeReference<SdkInstanceQuota>() {};
    private static final TypeReference<SdkVolumeQuota> VOLUME_QUOTA_RESULT = new TypeReference<SdkVolumeQuota>() {};
    private static final TypeReference<List<SdkPriceQuota>> QUOTA_LIST_RESULT = new TypeReference<List<SdkPriceQuota>>() {};

    public QuotaManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    // price quotas
    @Override
    public M3Result<SdkPriceQuota> getSingleQuotaByTenantAndRegion(IPrincipal principal, SingleQuotaByTenantAndRegionRequest request) {
        return execute(principal, request, QUOTA_RESULT);
    }

    @Override
    public M3Result<Boolean> existsInCurrentTenant(IPrincipal principal, QuotaExistsInCurrentTenantRequest request) {
        return execute(principal, request, BOOL_RESULT);
    }

    @Override
    public M3Result<List<SdkPriceQuota>> getQuotaByTenantAndType(IPrincipal principal, QuotaByTenantAndTypeRequest request) {
        return execute(principal, request, QUOTA_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkPriceQuota>> getDepletedQuotaByTenant(IPrincipal principal, DepletedQuotaByTenantRequest request) {
        return execute(principal, request, QUOTA_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkPriceQuota>> getDepletedActiveQuotaByTenantAndRegion(IPrincipal principal, DepletedActiveQuotaByTenantAndRegionRequest request) {
        return execute(principal, request, QUOTA_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkPriceQuota>> getDepletedActiveQuotasByTenantDisplayNameAndRegionName(IPrincipal principal, DepletedActiveQuotaActionsRequest request) {
        return execute(principal, request, QUOTA_LIST_RESULT);
    }

    @Override
    public M3Result<Void> create(IPrincipal principal, CreateQuotaRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> update(IPrincipal principal, UpdateQuotaRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<SdkPriceQuota>> getQuotasByTenantAndCriteria(IPrincipal principal, QuotasByTenantsWithCriteriaRequest request) {
        return execute(principal, request, QUOTA_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkPriceQuota>> getQuotasByTenant(IPrincipal principal, QuotasByTenantRequest request) {
        return execute(principal, request, QUOTA_LIST_RESULT);
    }

    @Override
    public M3Result<Set<String>> exists(IPrincipal principal, QuotaExistsRequest request) {
        return execute(principal, request, SET_STRING_RESULT);
    }

    @Override
    public M3Result<Void> remove(IPrincipal principal, RemoveQuotaRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    //resource quotas
    @Override
    public M3Result<SdkInstanceQuota> getInstanceQuota(IPrincipal principal, GetInstanceQuotaRequest request) {
        return execute(principal, request, INSTANCE_QUOTA_RESULT);
    }

    @Override
    public M3Result<SdkVolumeQuota> getVolumeQuota(IPrincipal principal, GetVolumeQuotaRequest request) {
        return execute(principal, request, VOLUME_QUOTA_RESULT);
    }

    @Override
    public M3Result<String> updateInstanceQuota(IPrincipal principal, UpdateInstanceQuotaRequest request) {
        return execute(principal, request, STRING_RESULT);
    }

    @Override
    public M3Result<String> updateVolumeQuota(IPrincipal principal, UpdateVolumeQuotaRequest request) {
        return execute(principal, request, STRING_RESULT);
    }

    @Override
    public M3Result<Void> removeInstanceQuota(IPrincipal principal, RemoveInstanceQuotaRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> removeVolumeQuota(IPrincipal principal, RemoveVolumeQuotaRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> validateResourceQuota(IPrincipal principal, ValidateResourceQuotaRequest request) {
        return execute(principal, request, VOID_RESULT);
    }
}
