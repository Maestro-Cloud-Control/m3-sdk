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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = DescribeTerraformResourcesRequest.Builder.class)
public class DescribeTerraformResourcesRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String templateName;
    private final String stackId;
    private final SdkTemplateType templateType;

    private DescribeTerraformResourcesRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.templateType = builder.templateType;
        this.stackId = builder.stackId;
        this.templateName = builder.templateName;
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

    public SdkTemplateType getTemplateType() {
        return templateType;
    }

    public String getStackId() {
        return stackId;
    }

    public String getTemplateName() {
        return templateName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_TERRAFORM_TEMPLATE_RESOURCES;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private String templateName;
        private String stackId;
        private SdkTemplateType templateType = SdkTemplateType.TERRAFORM;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withStackId(String stackId) {
            this.stackId = stackId;
            return this;
        }

        public Builder withTemplateType(SdkTemplateType templateType) {
            this.templateType = templateType;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withTemplateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        public DescribeTerraformResourcesRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(templateName, "templateName");
            Assert.hasText(stackId, "stackId");
            return new DescribeTerraformResourcesRequest(this);
        }
    }
}
