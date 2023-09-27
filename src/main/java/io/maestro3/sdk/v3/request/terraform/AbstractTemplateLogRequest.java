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
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateType;
import io.maestro3.sdk.v3.request.ITenantRequest;

public abstract class AbstractTemplateLogRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String templateName;
    private final String stackId;
    private final SdkTemplateType templateType;

    protected AbstractTemplateLogRequest(AbstractTemplateLogRequestBuilder<?, ?> builder) {
        this.tenantName = builder.tenantName;
        this.templateType = builder.templateType;
        this.stackId = builder.stackId;
        this.cloud = builder.cloud;
        this.templateName = builder.templateName;
    }

    public String getStackId() {
        return stackId;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public SdkTemplateType getTemplateType() {
        return templateType;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public abstract static class AbstractTemplateLogRequestBuilder
        <B extends AbstractTemplateLogRequestBuilder<B, R>, R extends AbstractTemplateLogRequest> {

        private SdkCloud cloud;
        private String tenantName;
        private String templateName;
        private String stackId;
        private SdkTemplateType templateType;

        protected abstract B getThis();

        public abstract R build();

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

        public B withStackId(String stackId) {
            this.stackId = stackId;
            return getThis();
        }

        public B withTemplateType(SdkTemplateType templateType) {
            this.templateType = templateType;
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

        protected void assertAllFieldsSet() {
            Assert.hasText(tenantName, "tenantName");
            Assert.notNull(cloud, "cloud");
            Assert.hasText(templateName, "templateName");
        }

        protected void withDefaultTemplateType() {
            if (templateType == null) {
                templateType = SdkTemplateType.TERRAFORM;
            }
        }
    }
}
