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

package io.maestro3.sdk.v3.request.paas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.terraform.template.SdkTerraformTemplateVariable;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@JsonDeserialize(builder = ActivatePlatformServiceRequest.Builder.class)
public class ActivatePlatformServiceRequest implements ITenantRequest, IRegionRequest {

    private final String serviceName;
    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final int expireAfter;
    private final boolean needReview;
    private final String serviceEntryId;
    private final Map<String, String> params;
    private final Map<String, SdkTerraformTemplateVariable> variables;

    private ActivatePlatformServiceRequest(Builder builder) {
        this.serviceName = builder.serviceName;
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.expireAfter = builder.expireAfter;
        this.needReview = builder.needReview;
        this.serviceEntryId = builder.serviceEntryId;
        this.variables = Optional.ofNullable(builder.variables).orElse(new HashMap<>());
        this.params = Optional.ofNullable(builder.params).orElse(new HashMap<>());
    }

    public static Builder builder() {
        return new Builder();
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, SdkTerraformTemplateVariable> getVariables() {
        return variables;
    }

    public String getServiceEntryId() {
        return serviceEntryId;
    }

    public boolean isNeedReview() {
        return needReview;
    }

    public int getExpireAfter() {
        return expireAfter;
    }

    public String getServiceName() {
        return serviceName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ACTIVATE_PLATFORM_SERVICE;
    }

    public static final class Builder {

        private String serviceName;
        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private int expireAfter;
        private boolean needReview;
        private String serviceEntryId;
        private Map<String, SdkTerraformTemplateVariable> variables;
        private Map<String, String> params;

        public Builder withServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

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

        public Builder withExpireAfter(int expireAfter) {
            this.expireAfter = expireAfter;
            return this;
        }

        public Builder withNeedReview(boolean needReview) {
            this.needReview = needReview;
            return this;
        }

        public Builder withServiceEntryId(String platformEntryId) {
            this.serviceEntryId = platformEntryId;
            return this;
        }

        public Builder withVariables(Map<String, SdkTerraformTemplateVariable> variables) {
            this.variables = variables;
            return this;
        }

        public Builder withParams(Map<String, String> params) {
            this.params = params;
            return this;
        }

        public ActivatePlatformServiceRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.hasText(serviceName, "serviceName");
            return new ActivatePlatformServiceRequest(this);
        }
    }
}
