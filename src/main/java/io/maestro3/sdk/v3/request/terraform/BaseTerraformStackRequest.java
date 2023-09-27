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
import io.maestro3.sdk.v3.model.terraform.TerraformTask;
import io.maestro3.sdk.v3.model.terraform.TerraformTaskVariable;
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateType;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseTerraformStackRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String stackId;
    private final String templateName;
    private final String taskInitiatorEmail;
    private final TerraformTask task;
    private final Map<String, TerraformTaskVariable> variables;
    private final String serviceEntryId;
    private final boolean paasRequest;
    private final Map<String, Object> metadata;
    private final String agentId;
    private final String region;
    private final SdkTemplateType templateType;

    protected BaseTerraformStackRequest(BaseTerraformStackRequestBuilder<?, ?> builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.stackId = builder.stackId;
        this.templateName = builder.templateName;
        this.taskInitiatorEmail = builder.taskInitiatorEmail;
        this.task = builder.task;
        this.variables = builder.variables;
        this.serviceEntryId = builder.serviceEntryId;
        this.paasRequest = builder.paasRequest;
        this.metadata = builder.metadata;
        this.agentId = builder.agentId;
        this.region = builder.region;
        this.templateType = builder.templateType;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public String getStackId() {
        return stackId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getTaskInitiatorEmail() {
        return taskInitiatorEmail;
    }

    public TerraformTask getTask() {
        return task;
    }

    public Map<String, TerraformTaskVariable> getVariables() {
        return variables;
    }

    public String getServiceEntryId() {
        return serviceEntryId;
    }

    public boolean isPaasRequest() {
        return paasRequest;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getRegion() {
        return region;
    }

    public SdkTemplateType getTemplateType() {
        return templateType;
    }

    public abstract static class BaseTerraformStackRequestBuilder
        <B extends BaseTerraformStackRequestBuilder<B, R>, R extends BaseTerraformStackRequest> {

        private SdkCloud cloud;
        private String tenantName;
        private TerraformTask task;
        private String templateName;
        private String stackId;
        private Map<String, TerraformTaskVariable> variables = new HashMap<>();
        private String taskInitiatorEmail;
        private String serviceEntryId;
        private boolean paasRequest;
        private Map<String, Object> metadata;
        private String agentId;
        private String region;
        protected SdkTemplateType templateType = SdkTemplateType.TERRAFORM; // default tf for backward compatibility

        protected abstract B getThis();

        public abstract R build();

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

        public B withRegion(String region) {
            this.region = region;
            return getThis();
        }

        public B withTask(TerraformTask task) {
            this.task = task;
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

        public B withStackId(String stackId) {
            this.stackId = stackId;
            return getThis();
        }

        public B withTemplateName(String templateName) {
            this.templateName = templateName;
            return getThis();
        }

        public B withTaskInitiatorEmail(String taskInitiatorEmail) {
            this.taskInitiatorEmail = taskInitiatorEmail;
            return getThis();
        }

        public B withVariables(Map<String, TerraformTaskVariable> variables) {
            this.variables = variables;
            return getThis();
        }

        public B withServiceEntryId(String serviceEntryId) {
            this.serviceEntryId = serviceEntryId;
            return getThis();
        }

        public B withPaasRequest(boolean paasRequest) {
            this.paasRequest = paasRequest;
            return getThis();
        }

        public B withMetadata(Map<String, Object> metadata) {
            this.metadata = metadata;
            return getThis();
        }

        public B withAgentId(String agentId) {
            this.agentId = agentId;
            return getThis();
        }

        protected void assertAllFieldsSet() {
            Assert.hasText(tenantName, "tenantName");
            if (!"SYSTEM".equals(tenantName)) {
                Assert.notNull(cloud, "cloud");
            }
            Assert.hasText(templateName, "templateName");
            Assert.notNull(variables, "variables");
        }
    }
}
