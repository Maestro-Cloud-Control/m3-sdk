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
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = UpdatePoliciesRequest.Builder.class)
public class UpdatePoliciesRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final Map<String, Object> additionalParameters;

    private UpdatePoliciesRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.additionalParameters = builder.additionalParameters;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public Map<String, Object> getAdditionalParameters() {
        return additionalParameters;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_TERRAFORM_POLICIES;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private Map<String, Object> additionalParameters = new HashMap<>();

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withAdditionalParameter(String parameterName, Object parameterValue) {
            this.additionalParameters.put(parameterName, parameterValue);
            return this;
        }

        public Builder withAdditionalParameters(Map<String, Object> parameters) {
            this.additionalParameters.putAll(parameters);
            return this;
        }

        public UpdatePoliciesRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            return new UpdatePoliciesRequest(this);
        }
    }
}
