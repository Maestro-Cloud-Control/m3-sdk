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

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

import java.math.BigDecimal;

@JsonDeserialize(builder = AddAdjustmentRequest.AddAdjustmentRequestBuilder.class)
public class AddAdjustmentRequest extends AbstractAdjustmentRequest {

    private final boolean currencyNative;
    private final BigDecimal value;

    private AddAdjustmentRequest(AddAdjustmentRequestBuilder builder) {
        super(builder);
        this.currencyNative = builder.currencyNative;
        this.value = builder.value;
    }

    public boolean isCurrencyNative() {
        return currencyNative;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static AddAdjustmentRequestBuilder builder() {
        return new AddAdjustmentRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ADD_ADJUSTMENT;
    }

    public static final class AddAdjustmentRequestBuilder
        extends AbstractAdjustmentRequestBuilder<AddAdjustmentRequestBuilder, AddAdjustmentRequest> {

        private boolean currencyNative;
        private BigDecimal value;

        @JsonAlias("currency_native")
        public AddAdjustmentRequestBuilder withCurrencyNative(boolean currencyNative) {
            this.currencyNative = currencyNative;
            return getThis();
        }

        public AddAdjustmentRequestBuilder withValue(BigDecimal value) {
            this.value = value;
            return getThis();
        }

        @Override
        protected AddAdjustmentRequestBuilder getThis() {
            return this;
        }

        @Override
        public AddAdjustmentRequest build() {
            validateParams();
            return new AddAdjustmentRequest(this);
        }
    }
}
