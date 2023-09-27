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

@JsonDeserialize(builder = OnboardingAwsRequest.OnboardingAwsRequestBuilder.class)
public class OnboardingAwsRequest extends AbstractOnboardingRequest {

    private final String tenantDisplayName;
    private final String accountId;
    private final String accessKey;
    private final String secretKey;

    private OnboardingAwsRequest(OnboardingAwsRequestBuilder builder) {
        super(builder);
        this.tenantDisplayName = builder.tenantDisplayName;
        this.accountId = builder.accountId;
        this.accessKey = builder.accessKey;
        this.secretKey = builder.secretKey;
    }

    public static OnboardingAwsRequestBuilder builder() {
        return new OnboardingAwsRequestBuilder();
    }

    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ONBOARDING_AWS_TENANT;
    }

    public static final class OnboardingAwsRequestBuilder
        extends AbstractOnboardingRequestBuilder<OnboardingAwsRequestBuilder, OnboardingAwsRequest> {

        private String tenantDisplayName;
        private String accountId;
        private String accessKey;
        private String secretKey;

        public OnboardingAwsRequestBuilder withTenantDisplayName(String tenantDisplayName) {
            this.tenantDisplayName = tenantDisplayName;
            return getThis();
        }

        public OnboardingAwsRequestBuilder withAccountId(String accountId) {
            this.accountId = accountId;
            return getThis();
        }

        public OnboardingAwsRequestBuilder withAccessKey(String accessKey) {
            this.accessKey = accessKey;
            return getThis();
        }

        public OnboardingAwsRequestBuilder withSecretKey(String secretKey) {
            this.secretKey = secretKey;
            return getThis();
        }

        @Override
        protected OnboardingAwsRequestBuilder getThis() {
            return this;
        }

        @Override
        public OnboardingAwsRequest build() {
            return new OnboardingAwsRequest(this);
        }

    }
}
