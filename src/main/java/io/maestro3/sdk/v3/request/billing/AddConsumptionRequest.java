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

package io.maestro3.sdk.v3.request.billing;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

import java.math.BigDecimal;

@JsonDeserialize(builder = AddConsumptionRequest.AddConsumptionRequestBuilder.class)
public class AddConsumptionRequest extends AbstractConsumptionRequest {

    private final BigDecimal value;

    private AddConsumptionRequest(AddConsumptionRequestBuilder builder) {
        super(builder);
        this.value = builder.value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static AddConsumptionRequestBuilder builder() {
        return new AddConsumptionRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ADD_CONSUMPTION;
    }

    public static final class AddConsumptionRequestBuilder
        extends AbstractConsumptionRequestBuilder<AddConsumptionRequestBuilder, AddConsumptionRequest> {

        private BigDecimal value;

        public AddConsumptionRequestBuilder withValue(BigDecimal value) {
            this.value = value;
            return getThis();
        }

        @Override
        protected AddConsumptionRequestBuilder getThis() {
            return this;
        }

        @Override
        public AddConsumptionRequest build() {
            validateParams();
            return new AddConsumptionRequest(this);
        }
    }
}
