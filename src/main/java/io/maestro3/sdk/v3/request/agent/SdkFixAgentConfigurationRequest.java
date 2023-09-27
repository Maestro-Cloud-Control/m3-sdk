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

package io.maestro3.sdk.v3.request.agent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.agent.diagnostic.SdkAgentDiagnosticResult;
import io.maestro3.sdk.v3.model.agent.diagnostic.SdkCheckResult;

@JsonDeserialize(builder = SdkFixAgentConfigurationRequest.Builder.class)
public class SdkFixAgentConfigurationRequest extends AbstractSdkCheckRequest {
    private final SdkAgentDiagnosticResult<SdkCheckResult> diagnosticResult;

    private SdkFixAgentConfigurationRequest(Builder builder) {
        super(builder);
        this.diagnosticResult = builder.diagnosticResult;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SdkAgentDiagnosticResult<SdkCheckResult> getDiagnosticResult() {
        return diagnosticResult;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.AGENT_DIAGNOSTIC_FIX;
    }

    public static final class Builder extends AbstractSdkCheckRequestBuilder<Builder, SdkFixAgentConfigurationRequest> {

        private SdkAgentDiagnosticResult<SdkCheckResult> diagnosticResult;

        public Builder withDiagnosticResult(SdkAgentDiagnosticResult<SdkCheckResult> diagnosticResult) {
            this.diagnosticResult = diagnosticResult;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public SdkFixAgentConfigurationRequest build() {
            return new SdkFixAgentConfigurationRequest(this);
        }
    }
}
