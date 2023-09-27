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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = PricingPolicyRequest.Builder.class)
public class PricingPolicyRequest implements IRequest {

    private final long from;
    private final long to;
    private final String zoneName;
    private final String policyType;

    private PricingPolicyRequest(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.zoneName = builder.zoneName;
        this.policyType = builder.policyType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getPolicyType() {
        return policyType;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_PRICING_POLICY;
    }

    public static final class Builder {

        private long from;
        private long to;
        private String policyType;
        private String zoneName;

        public Builder withFrom(long from) {
            this.from = from;
            return this;
        }

        public Builder withTo(long to) {
            this.to = to;
            return this;
        }

        public Builder withZoneName(String zoneName) {
            this.zoneName = zoneName;
            return this;
        }

        public Builder withPolicyType(String policyType) {
            this.policyType = policyType;
            return this;
        }

        public PricingPolicyRequest build() {
            Assert.isPositive(from, "from");
            Assert.isPositive(to, "to");
            Assert.hasText(zoneName, "zoneName");
            Assert.hasText(policyType, "policyType");
            return new PricingPolicyRequest(this);
        }
    }

    public static PricingPolicyRequest defaultPolicyRequest() {
        return PricingPolicyRequest.builder()
            .withPolicyType("DEFAULT")
            .withFrom(1)
            .withTo(1)
            .withZoneName("default")
            .build();
    }
}
