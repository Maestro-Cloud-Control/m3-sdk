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

import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;

public abstract class WebHookRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String templateName;
    private final String username;
    private final String password;
    private final String gitUrl;
    private final String branch;

    protected WebHookRequest(WebHookRequestBuilder<?, ?> builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.templateName = builder.templateName;
        this.gitUrl = builder.gitUrl;
        this.branch = builder.branch;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public String getBranch() {
        return branch;
    }

    public abstract static class WebHookRequestBuilder<B extends WebHookRequestBuilder<B, R>, R extends WebHookRequest> {

        private SdkCloud cloud;
        private String tenantName;
        private String templateName;
        private String username;
        private String password;
        private String gitUrl;
        private String branch;

        protected abstract B getThis();

        public abstract R build();

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

        public B withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }

        public B withTemplateName(String templateName) {
            this.templateName = templateName;
            return getThis();
        }

        public B withGitUsername(String username) {
            this.username = username;
            return getThis();
        }

        public B withGitPassword(String password) {
            this.password = password;
            return getThis();
        }

        public B withGitUrl(String gitUrl) {
            this.gitUrl = gitUrl;
            return getThis();
        }

        public B withBranch(String branch) {
            this.branch = branch;
            return getThis();
        }

        protected void validateParams() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(templateName, "templateName");
            Assert.hasText(username, "username");
            Assert.hasText(password, "password");
            Assert.hasText(gitUrl, "gitUrl");
            Assert.hasText(branch, "branch");
        }
    }
}
