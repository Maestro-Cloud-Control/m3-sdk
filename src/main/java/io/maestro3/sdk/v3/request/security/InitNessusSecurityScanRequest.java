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

package io.maestro3.sdk.v3.request.security;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = InitNessusSecurityScanRequest.Builder.class)
public class InitNessusSecurityScanRequest extends InitSecurityScanRequest {

    private final String templateId;
    private final String policyId;

    private InitNessusSecurityScanRequest(Builder builder) {
        super(builder);
        this.templateId = builder.templateId;
        this.policyId = builder.policyId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getPolicyId() {
        return policyId;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.INIT_NESSUS_SECURITY_SCAN;
    }

    public static final class Builder extends AbstractInitSecurityScanRequestBuilder<Builder, InitNessusSecurityScanRequest> {

        private String templateId;
        private String policyId;

        public Builder withTemplateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Builder withPolicyId(String policyId) {
            this.policyId = policyId;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public InitNessusSecurityScanRequest build() {
            validateCommonParams();
            Assert.hasText(templateId, "templateId");
            Assert.hasText(policyId, "policyId");
            return new InitNessusSecurityScanRequest(this);
        }
    }
}
