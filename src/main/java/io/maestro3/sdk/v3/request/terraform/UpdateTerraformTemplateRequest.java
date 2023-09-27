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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = UpdateTerraformTemplateRequest.Builder.class)
public class UpdateTerraformTemplateRequest implements IRequest {

    private final String tenantName;
    private final String templateName;
    private final String templateStatus;

    private UpdateTerraformTemplateRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.templateName = builder.templateName;
        this.templateStatus = builder.templateStatus;
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

    public String getTemplateStatus() {
        return templateStatus;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_TERRAFORM_TEMPLATE;
    }

    public static final class Builder {

        private String tenantName;
        private String templateName;
        private String templateStatus;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withTemplateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        public Builder withTemplateStatus(String templateStatus) {
            this.templateStatus = templateStatus;
            return this;
        }

        public UpdateTerraformTemplateRequest build() {
            return new UpdateTerraformTemplateRequest(this);
        }
    }
}
