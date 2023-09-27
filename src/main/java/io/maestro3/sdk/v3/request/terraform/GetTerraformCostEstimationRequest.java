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

package io.maestro3.sdk.v3.request.terraform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = GetTerraformCostEstimationRequest.Builder.class)
public class GetTerraformCostEstimationRequest extends AbstractTemplateLogRequest {

    private final long timestamp;
    private final String initiator;

    private GetTerraformCostEstimationRequest(Builder builder) {
        super(builder);
        this.timestamp = builder.timestamp;
        this.initiator = builder.initiator;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getInitiator() {
        return initiator;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_TERRAFORM_COST_ESTIMATION;
    }

    public static final class Builder extends AbstractTemplateLogRequestBuilder<Builder, GetTerraformCostEstimationRequest> {

        private long timestamp;
        private String initiator;

        public Builder withTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withInitiator(String initiator) {
            this.initiator = initiator;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public GetTerraformCostEstimationRequest build() {
            this.assertAllFieldsSet();
            withDefaultTemplateType();
            return new GetTerraformCostEstimationRequest(this);
        }
    }
}
