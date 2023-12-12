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
import io.maestro3.sdk.internal.util.Assert;

public abstract class AbstractAdjustmentRequest extends AbstractConsumptionApiRequest {

    private final String description;
    private final String creditType;

    protected AbstractAdjustmentRequest(AbstractAdjustmentRequestBuilder<?, ?> builder) {
        super(builder);
        this.description = builder.description;
        this.creditType = builder.creditType;
    }

    public String getDescription() {
        return description;
    }

    public String getCreditType() {
        return creditType;
    }

    public abstract static class AbstractAdjustmentRequestBuilder
        <B extends AbstractAdjustmentRequest.AbstractAdjustmentRequestBuilder<B, R>, R extends AbstractAdjustmentRequest>
        extends AbstractConsumptionApiRequestBuilder<B, R> {

        private String description;
        private String creditType;

        public B withDescription(String description) {
            this.description = description;
            return getThis();
        }

        /**
         * @param creditType available options: ['PREPAYMENT', 'SURCHARGE']
         */
        @JsonAlias("credit_type")
        public AbstractAdjustmentRequestBuilder<B, R> withCreditType(String creditType) {
            this.creditType = creditType;
            return getThis();
        }

        @Override
        protected void validateParams() {
            super.validateParams();
            Assert.hasText(description, "description");
            Assert.hasText(creditType, "credit_type");
        }
    }
}
