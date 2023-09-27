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
import io.maestro3.sdk.v3.model.price.SdkPriceModelResponse;
import io.maestro3.sdk.v3.model.price.averagecost.SdkAverageInstanceCostResponse;
import io.maestro3.sdk.v3.model.price.estimator.SdkCostEstimationResponse;
import io.maestro3.sdk.v3.model.price.policy.SdkPricingPolicyAosResponse;
import io.maestro3.sdk.v3.model.price.policy.SdkPricingPolicyResponse;
import io.maestro3.sdk.v3.request.price.AverageInstanceCostRequest;
import io.maestro3.sdk.v3.request.price.EstimatorRequest;
import io.maestro3.sdk.v3.request.price.GetListPricingPolicyAosRequest;
import io.maestro3.sdk.v3.request.price.PriceModelRequest;
import io.maestro3.sdk.v3.request.price.PricingPolicyRequest;
import io.maestro3.sdk.v3.request.price.RemovePricingPolicyAosRequest;
import io.maestro3.sdk.v3.request.price.SavePricingPolicyRequest;

public interface IPriceManager {

    M3Result<SdkPriceModelResponse> getPriceModel(IPrincipal principal, PriceModelRequest request);

    M3Result<SdkCostEstimationResponse> getCostEstimator(IPrincipal principal, EstimatorRequest request);

    M3Result<SdkAverageInstanceCostResponse> getAverageInstanceCost(IPrincipal principal, AverageInstanceCostRequest request);

    M3Result<SdkPricingPolicyResponse> getPricingPolicy(IPrincipal principal, PricingPolicyRequest request);

    M3Result<Void> removePricingPolicyAos(IPrincipal principal, RemovePricingPolicyAosRequest request);

    M3Result<SdkPricingPolicyAosResponse> getListPricingPolicyAos(IPrincipal principal, GetListPricingPolicyAosRequest request);

    M3Result<Void> savePricingPolicy(IPrincipal principal, SavePricingPolicyRequest request);
}
