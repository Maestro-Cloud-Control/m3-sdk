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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SetupTerraformTemplateWithGitRequest.Builder.class)
public class SetupTerraformTemplateWithGitRequest extends AbstractTerraformTaskRequest {

    private final String gitUrl;
    private final String gitUsername;
    private final String gitPassword;
    private final String gitBranch;
    private final String gitTerraformDirectoryPath;
    private final String webHookAction;
    private final String providerType;

    private SetupTerraformTemplateWithGitRequest(Builder builder) {
        super(builder);
        this.gitUrl = builder.gitUrl;
        this.gitUsername = builder.gitUsername;
        this.gitPassword = builder.gitPassword;
        this.gitBranch = builder.gitBranch;
        this.gitTerraformDirectoryPath = builder.gitTerraformDirectoryPath;
        this.webHookAction = builder.webHookAction;
        this.providerType = builder.providerType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getGitUsername() {
        return gitUsername;
    }

    public String getGitPassword() {
        return gitPassword;
    }

    public String getGitBranch() {
        return gitBranch;
    }

    public String getGitTerraformDirectoryPath() {
        return gitTerraformDirectoryPath;
    }

    public String getWebHookAction() {
        return webHookAction;
    }

    public String getProviderType() {
        return providerType;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SETUP_TERRAFORM_TEMPLATE_WITH_GITHUB;
    }

    public static final class Builder extends AbstractBuilder<Builder, SetupTerraformTemplateWithGitRequest> {

        private String gitUrl;
        private String gitUsername;
        private String gitPassword;
        private String gitBranch;
        private String gitTerraformDirectoryPath;
        private String webHookAction;
        private String providerType;

        public Builder withGitUrl(String gitUrl) {
            this.gitUrl = gitUrl;
            return this;
        }

        public Builder withGitUsername(String gitUsername) {
            this.gitUsername = gitUsername;
            return this;
        }

        public Builder withGitPassword(String gitPassword) {
            this.gitPassword = gitPassword;
            return this;
        }

        public Builder withGitBranch(String gitBranch) {
            this.gitBranch = gitBranch;
            return this;
        }

        public Builder withGitTerraformDirectoryPath(String gitTerraformDirectoryPath) {
            this.gitTerraformDirectoryPath = gitTerraformDirectoryPath;
            return this;
        }

        public Builder withWebHookAction(String webHookAction) {
            this.webHookAction = webHookAction;
            return this;
        }

        public Builder withProviderType(String providerType) {
            this.providerType = providerType;
            return this;
        }

        @Override
        protected void assertAllFieldsSet() {
            super.assertAllFieldsSet();
            Assert.hasText(terraformVersion, "terraformVersion");
            Assert.hasText(gitUrl, "gitUrl");
            Assert.hasText(gitUsername, "gitUsername");
            Assert.hasText(gitPassword, "gitPassword");
            Assert.hasText(gitBranch, "gitBranch");
            Assert.hasText(webHookAction, "webHookAction");
            Assert.hasText(providerType, "providerType");
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        public SetupTerraformTemplateWithGitRequest build() {
            this.assertAllFieldsSet();
            return new SetupTerraformTemplateWithGitRequest(this);
        }

    }
}
