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

public interface IQuotaManager {

    // price quotas
    M3Result<SdkPriceQuota> getSingleQuotaByTenantAndRegion(IPrincipal principal, SingleQuotaByTenantAndRegionRequest request);

    @Deprecated
    M3Result<Boolean> existsInCurrentTenant(IPrincipal principal, QuotaExistsInCurrentTenantRequest request);

    M3Result<List<SdkPriceQuota>> getQuotaByTenantAndType(IPrincipal principal, QuotaByTenantAndTypeRequest request);

    M3Result<List<SdkPriceQuota>> getDepletedQuotaByTenant(IPrincipal principal, DepletedQuotaByTenantRequest request);

    M3Result<List<SdkPriceQuota>> getDepletedActiveQuotaByTenantAndRegion(IPrincipal principal, DepletedActiveQuotaByTenantAndRegionRequest request);

    M3Result<List<SdkPriceQuota>> getDepletedActiveQuotasByTenantDisplayNameAndRegionName(IPrincipal principal, DepletedActiveQuotaActionsRequest request);

    M3Result<List<SdkPriceQuota>> getQuotasByTenantAndCriteria(IPrincipal principal, QuotasByTenantsWithCriteriaRequest request);

    M3Result<List<SdkPriceQuota>> getQuotasByTenant(IPrincipal principal, QuotasByTenantRequest request);

    M3Result<Void> create(IPrincipal principal, CreateQuotaRequest request);

    M3Result<Void> update(IPrincipal principal, UpdateQuotaRequest request);

    M3Result<Set<String>> exists(IPrincipal principal, QuotaExistsRequest request);

    M3Result<Void> remove(IPrincipal principal, RemoveQuotaRequest request);

    //resource quotas
    M3Result<SdkInstanceQuota> getInstanceQuota(IPrincipal principal, GetInstanceQuotaRequest request);

    M3Result<SdkVolumeQuota> getVolumeQuota(IPrincipal principal, GetVolumeQuotaRequest request);

    M3Result<String> updateInstanceQuota(IPrincipal principal, UpdateInstanceQuotaRequest request);

    M3Result<String> updateVolumeQuota(IPrincipal principal, UpdateVolumeQuotaRequest request);

    M3Result<Void> removeInstanceQuota(IPrincipal principal, RemoveInstanceQuotaRequest request);

    M3Result<Void> removeVolumeQuota(IPrincipal principal, RemoveVolumeQuotaRequest request);

    M3Result<Void> validateResourceQuota(IPrincipal principal, ValidateResourceQuotaRequest request);
}
