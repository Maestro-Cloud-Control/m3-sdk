/*
 * Copyright 2024 Maestro Cloud Control LLC
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

package io.maestro3.sdk.v3.request.billing;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = GetBillingRegionTypesRequest.Builder.class)
public class GetBillingRegionTypesRequest implements IRequest {

    private final boolean all;

    private GetBillingRegionTypesRequest(Builder builder) {
        this.all = builder.all;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean isAll() {
        return all;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_BILLING_REGION_TYPES;
    }

    public static final class Builder {

        private boolean all;

        public Builder withAll(boolean all) {
            this.all = all;
            return this;
        }

        public GetBillingRegionTypesRequest build() {
            return new GetBillingRegionTypesRequest(this);
        }
    }
}
