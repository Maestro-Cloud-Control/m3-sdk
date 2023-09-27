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

package io.maestro3.sdk.v3.request.resource.template;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateType;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = ResourceDiagnosticsRequest.Builder.class)
public class ResourceDiagnosticsRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final SdkTemplateType templateType;
    private final String templateName;
    private final String executorName;
    private final String stackId;
    protected final String templateActivity;
    private final long timestamp;

    private ResourceDiagnosticsRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.templateType = builder.templateType;
        this.templateName = builder.templateName;
        this.executorName = builder.executorName;
        this.stackId = builder.stackId;
        this.templateActivity = builder.templateActivity;
        this.timestamp = builder.timestamp;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    public SdkTemplateType getTemplateType() {
        return templateType;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getExecutorName() {
        return executorName;
    }

    public String getStackId() {
        return stackId;
    }

    public String getTemplateActivity() {
        return templateActivity;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.RESOURCE_DIAGNOSTICS_REPORT;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private SdkTemplateType templateType;
        private String templateName;
        private String executorName;
        private String stackId;
        private String templateActivity;
        private long timestamp;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withTemplateType(SdkTemplateType templateType) {
            this.templateType = templateType;
            return this;
        }

        public Builder withTemplateName(String templateName) {
            this.templateName = templateName;
            return this;
        }

        public Builder withExecutorName(String executorName) {
            this.executorName = executorName;
            return this;
        }

        public Builder withStackId(String stackId) {
            this.stackId = stackId;
            return this;
        }

        public Builder withTemplateActivity(String templateActivity) {
            this.templateActivity = templateActivity;
            return this;
        }

        public Builder withTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ResourceDiagnosticsRequest build() {
            return new ResourceDiagnosticsRequest(this);
        }
    }
}
