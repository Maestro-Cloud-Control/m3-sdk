/*
 * Copyright 2024 Maestro Cloud Control LLC
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
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateType;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = GetStackResourcesRequest.Builder.class)
public class GetStackResourcesRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final String templateName;
    private final String stackId;
    private final SdkTemplateType templateType;

    private GetStackResourcesRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.templateName = builder.templateName;
        this.stackId = builder.stackId;
        this.templateType = builder.templateType;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getStackId() {
        return stackId;
    }

    public SdkTemplateType getTemplateType() {
        return templateType;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_STACK_RESOURCES;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private String templateName;
        private String stackId;
        private SdkTemplateType templateType;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withTemplateName(String templateName) {
            this.templateName = templateName;
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

        public GetStackResourcesRequest build() {
            Assert.notNull(this.cloud, "cloud");
            Assert.hasText(this.tenantName, "tenantName");
            Assert.hasText(this.templateName, "templateName");
            Assert.hasText(this.stackId, "stackId");
            Assert.notNull(this.templateType, "templateType");
            if (SdkTemplateType.CLOUD_FORMATION == templateType) {
                Assert.isTrue(SdkCloud.AWS == this.cloud, "cloud=AWS");
                Assert.hasText(this.region, "region");
            }
            return new GetStackResourcesRequest(this);
        }

    }

}
