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
@JsonDeserialize(builder = UnlockTerraformTemplateRequest.Builder.class)
public class UnlockTerraformTemplateRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String templateName;
    private final String description;
    private final String userEmail;

    private UnlockTerraformTemplateRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.templateName = builder.templateName;
        this.description = builder.description;
        this.userEmail = builder.userEmail;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantName() {
        return tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getDescription() {
        return description;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UNLOCK_TERRAFORM_TEMPLATE;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private String templateName;
        private String description;
        private String userEmail;

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

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public UnlockTerraformTemplateRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(templateName, "templateName");
            Assert.hasText(description, "description");
            Assert.hasText(userEmail, "userEmail");
            return new UnlockTerraformTemplateRequest(this);
        }
    }
}
