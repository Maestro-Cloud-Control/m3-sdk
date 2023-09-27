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

package io.maestro3.sdk.v3.request.price;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.price.policy.SdkPricingPolicy;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = SavePricingPolicyRequest.Builder.class)
public class SavePricingPolicyRequest implements IRequest {

    private final SdkPricingPolicy pricingPolicy;

    private SavePricingPolicyRequest(Builder builder) {
        this.pricingPolicy = builder.pricingPolicy;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SdkPricingPolicy getPricingPolicy() {
        return pricingPolicy;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SAVE_PRICING_POLICY;
    }

    public static final class Builder {

        private SdkPricingPolicy pricingPolicy;

        public Builder withPricingPolicy(SdkPricingPolicy pricingPolicy) {
            this.pricingPolicy = pricingPolicy;
            return this;
        }

        public SavePricingPolicyRequest build() {
            return new SavePricingPolicyRequest(this);
        }
    }
}
