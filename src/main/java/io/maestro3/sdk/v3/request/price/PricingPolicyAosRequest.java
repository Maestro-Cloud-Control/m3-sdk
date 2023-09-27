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

package io.maestro3.sdk.v3.request.price;

import io.maestro3.sdk.v3.request.IRequest;

public abstract class PricingPolicyAosRequest implements IRequest {

    private final String tenantName;
    private final long effectiveFrom;
    private final String policyId;
    private final String requesterEmail;

    protected PricingPolicyAosRequest(AbstractPricingPolicyAosRequestBuilder<?, ?> builder) {
        this.tenantName = builder.tenantName;
        this.effectiveFrom = builder.effectiveFrom;
        this.policyId = builder.policyId;
        this.requesterEmail = builder.requesterEmail;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public long getEffectiveFrom() {
        return effectiveFrom;
    }

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public abstract static class AbstractPricingPolicyAosRequestBuilder
        <B extends AbstractPricingPolicyAosRequestBuilder<B, R>, R extends PricingPolicyAosRequest> {

        private String tenantName;
        private long effectiveFrom;
        private String policyId;
        private String requesterEmail;

        protected abstract B getThis();

        public abstract R build();

        public B withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }

        public B withEffectiveFrom(long effectiveFrom) {
            this.effectiveFrom = effectiveFrom;
            return getThis();
        }

        public B withPolicyId(String policyId) {
            this.policyId = policyId;
            return getThis();
        }

        public B withRequesterEmail(String requesterEmail) {
            this.requesterEmail = requesterEmail;
            return getThis();
        }
    }
}
