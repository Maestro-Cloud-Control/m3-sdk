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
import io.maestro3.sdk.v3.model.notification.TenantSubscriptionRule;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonDeserialize(builder = GetTenantSubscriptionRequest.Builder.class)
public class GetTenantSubscriptionRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final TenantSubscriptionRule rule;

    private GetTenantSubscriptionRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.rule = builder.rule;
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

    public TenantSubscriptionRule getRule() {
        return rule;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_TENANT_SUBSCRIPTIONS;
    }

    public static final class Builder {
        private SdkCloud cloud;
        private String tenantName;
        private TenantSubscriptionRule rule;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRule(TenantSubscriptionRule rule) {
            this.rule = rule;
            return this;
        }

        public GetTenantSubscriptionRequest build() {
            return new GetTenantSubscriptionRequest(this);
        }

    }
}
