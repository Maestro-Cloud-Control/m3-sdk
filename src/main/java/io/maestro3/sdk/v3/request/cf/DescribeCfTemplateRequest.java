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
package io.maestro3.sdk.v3.request.cf;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;
import java.util.List;

@JsonDeserialize(builder = DescribeCfTemplateRequest.Builder.class)
public class DescribeCfTemplateRequest implements ITenantRequest {

    private final String tenantName;
    private final List<String> templateNames;

    private DescribeCfTemplateRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.templateNames = builder.templateNames;
    }

    @Override
    public SdkCloud getCloud() {
        return SdkCloud.AWS;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public List<String> getTemplateNames() {
        return templateNames;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_CF_TEMPLATE;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String tenantName;
        private List<String> templateNames;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withTemplateNames(List<String> templateNames) {
            this.templateNames = templateNames;
            return this;
        }

        public DescribeCfTemplateRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.notNull(templateNames, "templateNames"); // may be the empty list
            return new DescribeCfTemplateRequest(this);
        }

    }

}
