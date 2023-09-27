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
import io.maestro3.sdk.v3.model.ownership.ResourceIdRequestOnOwnershipPair;
import io.maestro3.sdk.v3.model.ownership.SdkResourceOwnership;
import io.maestro3.sdk.v3.request.ownership.ChangeResourceOwnerByResourceIdRequest;
import io.maestro3.sdk.v3.request.ownership.CurrentResourceOwnerByResourceIdRequest;
import io.maestro3.sdk.v3.request.ownership.FinishOwnershipByResourceIdRequest;
import io.maestro3.sdk.v3.request.ownership.GetResourceIdRequest;
import io.maestro3.sdk.v3.request.ownership.PossibleOwnersByResourceIdRequest;
import io.maestro3.sdk.v3.request.ownership.ResourceCreatorByResourceIdRequest;
import io.maestro3.sdk.v3.request.ownership.ResourceOwnersByResourceIdRequest;
import io.maestro3.sdk.v3.request.ownership.SaveResourceCreatorByResourceIdRequest;
import io.maestro3.sdk.v3.request.ownership.batch.BatchOwnerByResourceIdRequestsRequest;
import io.maestro3.sdk.v3.request.ownership.batch.BatchSaveCreatorsRequest;

import java.util.List;

public interface IOwnershipManager extends IManager {

    M3Result<String> getResourceId(IPrincipal principal, GetResourceIdRequest resourceIdRequest);

    M3Result<List<SdkResourceOwnership>> getResourceOwners(IPrincipal principal, ResourceOwnersByResourceIdRequest resourceOwnersByResourceIdRequest);

    M3Result<Void> saveResourceCreators(IPrincipal principal, BatchSaveCreatorsRequest batchSaveCreatorsRequest);

    M3Result<Void> saveResourceCreator(IPrincipal principal, SaveResourceCreatorByResourceIdRequest saveResourceCreatorByResourceIdRequest);

    M3Result<Void> changeResourceOwner(IPrincipal principal, ChangeResourceOwnerByResourceIdRequest changeResourceOwnerByResourceIdRequest);

    M3Result<SdkResourceOwnership> getCurrentResourceOwner(IPrincipal principal, CurrentResourceOwnerByResourceIdRequest currentResourceOwnerByResourceIdRequest);

    M3Result<SdkResourceOwnership> getResourceCreator(IPrincipal principal, ResourceCreatorByResourceIdRequest request);

    M3Result<List<SdkResourceOwnership>> getPossibleOwners(IPrincipal principal, PossibleOwnersByResourceIdRequest possibleOwnersByResourceIdRequest);

    M3Result<Void> finishOwnership(IPrincipal principal, FinishOwnershipByResourceIdRequest finishOwnershipRequest);

    M3Result<List<ResourceIdRequestOnOwnershipPair>> getCurrentResourceOwners(IPrincipal principal, BatchOwnerByResourceIdRequestsRequest request);
}
