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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = DeleteTerraformTemplateRequest.Builder.class)
public class DeleteTerraformTemplateRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String templateName;
    private final boolean forceDeletion;

    private DeleteTerraformTemplateRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.templateName = builder.templateName;
        this.forceDeletion = builder.forceDeletion;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public boolean isForceDeletion() {
        return forceDeletion;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DELETE_TERRAFORM_TEMPLATE;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private String templateName;
        private boolean forceDeletion;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
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

        public Builder withForceDeletion(boolean forceDeletion) {
            this.forceDeletion = forceDeletion;
            return this;
        }

        public DeleteTerraformTemplateRequest build() {
            Assert.notNull(this.cloud, "cloud");
            Assert.hasText(this.tenantName, "tenantName");
            Assert.hasText(this.templateName, "templateName");
            return new DeleteTerraformTemplateRequest(this);
        }
    }
}
