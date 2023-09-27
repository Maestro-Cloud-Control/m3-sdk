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
import io.maestro3.sdk.v3.model.billing.BillingReportFormat;

import java.util.List;

@JsonDeserialize(builder = ResourceBillingReportRequest.Builder.class)
public class ResourceBillingReportRequest extends AbstractBillingReportRequest {

    private final List<String> instanceIds;

    private ResourceBillingReportRequest(Builder builder) {
        super(builder, BillingReportFormat.JSON);
        this.instanceIds = builder.instanceIds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<String> getInstanceIds() {
        return instanceIds;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_RESOURCE_BILLING_REPORT;
    }

    public static final class Builder extends AbstractBillingReportRequestBuilder<Builder, ResourceBillingReportRequest> {

        private List<String> instanceIds;

        public Builder withInstanceIds(List<String> instanceIds) {
            this.instanceIds = instanceIds;
            return getThis();
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public ResourceBillingReportRequest build() {
            validateParams();
            return new ResourceBillingReportRequest(this);
        }
    }
}
