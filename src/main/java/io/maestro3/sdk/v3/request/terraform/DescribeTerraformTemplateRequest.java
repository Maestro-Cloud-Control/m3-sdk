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
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateType;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = DescribeTerraformTemplateRequest.Builder.class)
public class DescribeTerraformTemplateRequest implements ITenantRequest {
    private static final String SYSTEM_TENANT = "SYSTEM";

    private final SdkCloud cloud;
    private final String tenantName;
    private final List<String> templateNames;
    private final SdkTemplateType templateType;

    private DescribeTerraformTemplateRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.templateType = builder.templateType;
        this.templateNames = builder.templateNames;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SdkTemplateType getTemplateType() {
        return templateType;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public List<String> getTemplateNames() {
        return templateNames;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_TERRAFORM_TEMPLATE;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private List<String> templateNames;
        private SdkTemplateType templateType = SdkTemplateType.TERRAFORM;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withTemplateNames(List<String> templateNames) {
            this.templateNames = templateNames;
            return this;
        }

        public Builder withTemplateType(SdkTemplateType templateType) {
            this.templateType = templateType;
            return this;
        }

        public DescribeTerraformTemplateRequest build() {
            if (!SYSTEM_TENANT.equals(tenantName)) {
                Assert.notNull(cloud, "cloud");
            }
            Assert.hasText(tenantName, "tenantName");
            Assert.notNull(templateNames, "templateNames"); // may be the empty list
            return new DescribeTerraformTemplateRequest(this);
        }

    }
}
