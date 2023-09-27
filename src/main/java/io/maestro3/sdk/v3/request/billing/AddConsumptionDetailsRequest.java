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
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.billing.SdkBillingKpiRecord;

import java.util.List;

@JsonDeserialize(builder = AddConsumptionDetailsRequest.AddConsumptionDetailsRequestBuilder.class)
public class AddConsumptionDetailsRequest extends AbstractConsumptionRequest {

    private final List<SdkBillingKpiRecord> records;

    private AddConsumptionDetailsRequest(AddConsumptionDetailsRequestBuilder builder) {
        super(builder);
        this.records = builder.records;
    }

    public List<SdkBillingKpiRecord> getRecords() {
        return records;
    }

    public static AddConsumptionDetailsRequestBuilder builder() {
        return new AddConsumptionDetailsRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ADD_CONSUMPTION_DETAILS;
    }

    public static final class AddConsumptionDetailsRequestBuilder
        extends AbstractConsumptionRequestBuilder<AddConsumptionDetailsRequest.AddConsumptionDetailsRequestBuilder, AddConsumptionDetailsRequest> {

        private List<SdkBillingKpiRecord> records;

        public AddConsumptionDetailsRequestBuilder withRecords(List<SdkBillingKpiRecord> records) {
            this.records = records;
            return getThis();
        }

        @Override
        protected AddConsumptionDetailsRequestBuilder getThis() {
            return this;
        }

        @Override
        public AddConsumptionDetailsRequest build() {
            Assert.notEmpty(records, "records");
            return new AddConsumptionDetailsRequest(this);
        }
    }
}
