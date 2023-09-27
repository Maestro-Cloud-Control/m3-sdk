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

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.SdkUtils;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = PriceModelRequest.Builder.class)
public class PriceModelRequest implements IRequest {

    private final Long from;
    private final Long to;
    private final boolean isResourceStateActive;
    private final String zoneName;
    private final String policyType;
    private final String shapeName;

    private PriceModelRequest(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.isResourceStateActive = builder.isResourceStateActive;
        this.zoneName = builder.zoneName;
        this.policyType = builder.policyType;
        this.shapeName = builder.shapeName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getFrom() {
        return from;
    }

    public Long getTo() {
        return to;
    }

    public boolean isResourceStateActive() {
        return isResourceStateActive;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public String getShapeName() {
        return shapeName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_PRICE_MODEL;
    }

    public static final class Builder {

        private Long from;
        private Long to;
        private boolean isResourceStateActive;
        private String zoneName;
        private String policyType;
        private String shapeName;

        public Builder withFrom(Long from) {
            this.from = from;
            return this;
        }

        public Builder withTo(Long to) {
            this.to = to;
            return this;
        }

        @JsonAlias({"isResourceStateActive", "resourceStateActive"})
        public Builder withIsResourceStateActive(boolean isResourceStateActive) {
            this.isResourceStateActive = isResourceStateActive;
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

        public Builder withShapeName(String shapeName) {
            this.shapeName = shapeName;
            return this;
        }

        public PriceModelRequest build() {
            Assert.hasText(zoneName, "zoneName");
            validate(from, to);
            return new PriceModelRequest(this);
        }

        private void validate(Long from, Long to) {
            if (SdkUtils.allNotNull(from, to)) {
                Assert.isPositive(from, "from");
                Assert.isPositive(to, "to");
            } else if (SdkUtils.atLeastOneNotNull(from, to)) {
                throw new M3SdkException("Both from and to parameters should be specified if at least one of them specified");
            }
        }
    }
}
