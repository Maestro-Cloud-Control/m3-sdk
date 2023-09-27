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
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.notification.UserSubscriptionConfiguration;
import io.maestro3.sdk.v3.model.notification.UserSubscriptionRule;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.Map;

@JsonDeserialize(builder = UpdateUserSubscriptionRequest.Builder.class)
public class UpdateUserSubscriptionRequest implements ITenantRequest, IRegionRequest {
    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final Map<String, UserSubscriptionConfiguration> subscriptionsConfiguration;
    private final UserSubscriptionRule subscriptionRule;

    private UpdateUserSubscriptionRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.subscriptionsConfiguration = builder.subscriptionsConfiguration;
        this.subscriptionRule = builder.subscriptionRule;
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

    public String getRegion() {
        return region;
    }

    public Map<String, UserSubscriptionConfiguration> getSubscriptionsConfiguration() {
        return subscriptionsConfiguration;
    }

    public UserSubscriptionRule getSubscriptionRule() {
        return subscriptionRule;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_USER_SUBSCRIPTIONS;
    }

    public static final class Builder {
        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private Map<String, UserSubscriptionConfiguration> subscriptionsConfiguration;
        private UserSubscriptionRule subscriptionRule;

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

        public Builder withSubscriptionsConfiguration(Map<String, UserSubscriptionConfiguration>
                                                          subscriptionsConfiguration) {
            this.subscriptionsConfiguration = subscriptionsConfiguration;
            return this;
        }

        public Builder withSubscriptionRule(UserSubscriptionRule subscriptionRule) {
            this.subscriptionRule = subscriptionRule;
            return this;
        }

        public UpdateUserSubscriptionRequest build() {
            return new UpdateUserSubscriptionRequest(this);
        }
    }
}
