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

package io.maestro3.sdk.v3.request.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@JsonDeserialize(builder = OnboardingAzureRequest.OnboardingAzureRequestBuilder.class)
public class OnboardingAzureRequest extends AbstractOnboardingRequest {

    private final List<SubscriptionInfo> subscriptions;

    private OnboardingAzureRequest(OnboardingAzureRequestBuilder builder) {
        super(builder);
        this.subscriptions = Optional.ofNullable(builder.subscriptions).orElse(Collections.emptyList());
    }

    public static OnboardingAzureRequestBuilder builder() {
        return new OnboardingAzureRequestBuilder();
    }

    public List<OnboardingAzureRequest.SubscriptionInfo> getSubscriptions() {
        return subscriptions;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ONBOARDING_AZURE_CUSTOMER_AND_TENANT;
    }

    @Override
    public String toString() {
        return "OnboardingAzureRequest{" +
            "adminEmail='" + getAdminEmail() + '\'' +
            ", customerId='" + getCustomerId() + '\'' +
            ", customerName='" + getCustomerName() + '\'' +
            ", subscriptions=" + subscriptions +
            '}';
    }

    public static final class OnboardingAzureRequestBuilder
        extends AbstractOnboardingRequestBuilder<OnboardingAzureRequestBuilder, OnboardingAzureRequest> {

        private List<SubscriptionInfo> subscriptions;

        public OnboardingAzureRequestBuilder withSubscriptions(List<SubscriptionInfo> subscriptions) {
            this.subscriptions = subscriptions;
            return getThis();
        }

        @Override
        protected OnboardingAzureRequestBuilder getThis() {
            return this;
        }

        @Override
        public OnboardingAzureRequest build() {
            return new OnboardingAzureRequest(this);
        }
    }

    @JsonDeserialize(builder = SubscriptionInfo.SubscriptionInfoBuilder.class)
    public static class SubscriptionInfo {

        private final String tenantId;
        private final String subscriptionId;
        private final String subscriptionDisplayName;

        private SubscriptionInfo(SubscriptionInfoBuilder builder) {
            this.tenantId = builder.tenantId;
            this.subscriptionId = builder.subscriptionId;
            this.subscriptionDisplayName = builder.subscriptionDisplayName;
        }

        public String getTenantId() {
            return tenantId;
        }

        public String getSubscriptionId() {
            return subscriptionId;
        }

        public String getSubscriptionDisplayName() {
            return subscriptionDisplayName;
        }

        public static SubscriptionInfoBuilder builder() {
            return new SubscriptionInfoBuilder();
        }

        @Override
        public String toString() {
            return "SubscriptionInfo{" +
                "tenantId='" + tenantId + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", subscriptionDisplayName='" + subscriptionDisplayName + '\'' +
                '}';
        }

        public static class SubscriptionInfoBuilder {

            private String tenantId;
            private String subscriptionId;
            private String subscriptionDisplayName;

            public SubscriptionInfoBuilder withTenantId(String tenantId) {
                this.tenantId = tenantId;
                return this;
            }

            public SubscriptionInfoBuilder withSubscriptionId(String subscriptionId) {
                this.subscriptionId = subscriptionId;
                return this;
            }

            public SubscriptionInfoBuilder withSubscriptionDisplayName(String subscriptionDisplayName) {
                this.subscriptionDisplayName = subscriptionDisplayName;
                return this;
            }

            public SubscriptionInfo build() {
                return new SubscriptionInfo(this);
            }
        }
    }
}
