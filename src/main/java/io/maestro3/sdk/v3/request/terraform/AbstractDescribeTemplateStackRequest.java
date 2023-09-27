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

import java.util.List;

public abstract class AbstractDescribeTemplateStackRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final List<String> stacksId;
    private final String serviceEntryId;
    private final String templateName;
    private final SdkTemplateType type;

    protected AbstractDescribeTemplateStackRequest(AbstractDescribeTemplateStackRequestBuilder<?, ?> builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.stacksId = builder.stacksId;
        this.serviceEntryId = builder.serviceEntryId;
        this.templateName = builder.templateName;
        this.type = builder.type;
    }

    public SdkTemplateType getType() {
        return type;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public List<String> getStacksId() {
        return stacksId;
    }

    public String getServiceEntryId() {
        return serviceEntryId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public abstract static class AbstractDescribeTemplateStackRequestBuilder
        <B extends AbstractDescribeTemplateStackRequestBuilder<B, R>, R extends AbstractDescribeTemplateStackRequest> {

        private SdkCloud cloud;
        private String tenantName;
        private List<String> stacksId;
        private String serviceEntryId;
        private String templateName;
        private SdkTemplateType type = SdkTemplateType.TERRAFORM;

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

        public B withType(SdkTemplateType type) {
            this.type = type;
            return getThis();
        }

        public B withTemplateName(String templateName) {
            this.templateName = templateName;
            return getThis();
        }

        public B withStacksId(List<String> stacksId) {
            this.stacksId = stacksId;
            return getThis();
        }

        public B withServiceEntryId(String serviceEntryId) {
            this.serviceEntryId = serviceEntryId;
            return getThis();
        }

        protected void validateCommonParams() {
            Assert.notNull(stacksId, "stacksId"); // may be the empty list
        }
    }
}
