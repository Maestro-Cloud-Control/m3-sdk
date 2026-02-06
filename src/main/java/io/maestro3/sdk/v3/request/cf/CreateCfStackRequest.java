/*
 * Copyright 2024 Maestro Cloud Control LLC
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

package io.maestro3.sdk.v3.request.cf;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;
import java.util.Map;

@JsonDeserialize(builder = CreateCfStackRequest.Builder.class)
public class CreateCfStackRequest implements ITenantRequest {

    private final String tenantName;
    private final String region;
    private final String templateName;
    private final String stackName;
    private final Map<String, String> parameters;

    private CreateCfStackRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.templateName = builder.templateName;
        this.stackName = builder.stackName;
        this.parameters = builder.parameters;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public SdkCloud getCloud() {
        return SdkCloud.AWS;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getStackName() {
        return stackName;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CREATE_CF_STACK;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String templateName;
        private String stackName;
        private Map<String, String> parameters;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withTemplateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        public Builder withStackName(String stackName) {
            this.stackName = stackName;
            return this;
        }

        public Builder withParameters(Map<String, String> parameters) {
            this.parameters = parameters;
            return this;
        }

        public CreateCfStackRequest build() {
            Assert.hasText(this.tenantName, "tenantName");
            Assert.hasText(this.templateName, "templateName");
            Assert.hasText(this.stackName, "stackName");
            Assert.notNull(this.parameters, "parameters");
            return new CreateCfStackRequest(this);
        }

    }

}
