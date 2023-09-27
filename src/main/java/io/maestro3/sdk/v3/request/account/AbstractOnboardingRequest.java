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

import io.maestro3.sdk.v3.request.IRequest;

import java.util.Locale;

public abstract class AbstractOnboardingRequest implements IRequest {

    private final String adminEmail;
    private final String customerId;
    private final String customerName;

    protected AbstractOnboardingRequest(AbstractOnboardingRequestBuilder<?, ?> builder) {
        this.adminEmail = builder.adminEmail;
        this.customerId = builder.customerId;
        this.customerName = builder.customerName;
    }

    public String getAdminEmail() {
        return adminEmail == null ? null : adminEmail.toLowerCase(Locale.US);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public abstract static class AbstractOnboardingRequestBuilder
        <B extends AbstractOnboardingRequestBuilder<B, R>, R extends AbstractOnboardingRequest> {

        private String adminEmail;
        private String customerId;
        private String customerName;

        protected abstract B getThis();

        public abstract R build();

        public B withAdminEmail(String adminEmail) {
            this.adminEmail = adminEmail;
            return getThis();
        }

        public B withCustomerId(String customerId) {
            this.customerId = customerId;
            return getThis();
        }

        public B withCustomerName(String customerName) {
            this.customerName = customerName;
            return getThis();
        }
    }
}
