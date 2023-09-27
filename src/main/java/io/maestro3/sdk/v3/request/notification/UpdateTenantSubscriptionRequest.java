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

package io.maestro3.sdk.v3.request.notification;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.notification.TenantSubscriptionAudience;
import io.maestro3.sdk.v3.model.notification.TenantSubscriptionConfiguration;
import io.maestro3.sdk.v3.model.notification.TenantSubscriptionRule;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.Map;

@JsonDeserialize(builder = UpdateTenantSubscriptionRequest.Builder.class)
public class UpdateTenantSubscriptionRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final Map<String, TenantSubscriptionConfiguration> subscriptionsConfiguration;
    private final Map<TenantSubscriptionAudience, TenantSubscriptionRule> audiencePolicies;
    private final boolean allAudience;

    private UpdateTenantSubscriptionRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.subscriptionsConfiguration = builder.subscriptionsConfiguration;
        this.audiencePolicies = builder.audiencePolicies;
        this.allAudience = builder.allAudience;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public Map<String, TenantSubscriptionConfiguration> getSubscriptionsConfiguration() {
        return subscriptionsConfiguration;
    }

    public Map<TenantSubscriptionAudience, TenantSubscriptionRule> getAudiencePolicies() {
        return audiencePolicies;
    }

    public boolean isAllAudience() {
        return allAudience;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_TENANT_SUBSCRIPTIONS;
    }

    public static final class Builder {
        private SdkCloud cloud;
        private String tenantName;
        private Map<String, TenantSubscriptionConfiguration> subscriptionsConfiguration;
        private Map<TenantSubscriptionAudience, TenantSubscriptionRule> audiencePolicies;
        private boolean allAudience;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withSubscriptionsConfiguration(Map<String, TenantSubscriptionConfiguration>
                                                          subscriptionsConfiguration) {
            this.subscriptionsConfiguration = subscriptionsConfiguration;
            return this;
        }

        public Builder withAudiencePolicies(Map<TenantSubscriptionAudience, TenantSubscriptionRule> audiencePolicies) {
            this.audiencePolicies = audiencePolicies;
            return this;
        }

        public Builder withAllAudience(boolean allAudience) {
            this.allAudience = allAudience;
            return this;
        }

        public UpdateTenantSubscriptionRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantDisplayName");
            return new UpdateTenantSubscriptionRequest(this);
        }
    }
}
