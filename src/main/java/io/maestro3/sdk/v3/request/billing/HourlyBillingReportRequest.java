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
import io.maestro3.sdk.v3.model.billing.BillingReportFormat;

import java.util.concurrent.TimeUnit;

@JsonDeserialize(builder = HourlyBillingReportRequest.Builder.class)
public class HourlyBillingReportRequest extends AbstractBillingReportRequest {

    private final String instanceId;

    private HourlyBillingReportRequest(Builder builder) {
        super(builder, BillingReportFormat.EMAIL);
        this.instanceId = builder.instanceId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getInstanceId() {
        return instanceId;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_HOURLY_BILLING_REPORT;
    }

    public static final class Builder extends AbstractBillingReportRequestBuilder<Builder, HourlyBillingReportRequest> {

        private String instanceId;

        public Builder withInstanceId(String instanceId) {
            this.instanceId = instanceId;
            return getThis();
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public HourlyBillingReportRequest build() {
            validateParams();
            Assert.isTrue(TimeUnit.DAYS.toMillis(1) == to - from, "'Hourly report allowed only for day period'");
            return new HourlyBillingReportRequest(this);
        }
    }
}
