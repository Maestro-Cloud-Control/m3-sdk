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

package io.maestro3.sdk.v3.request.billing;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.CollectionUtils;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.billing.SdkBillingReportTarget;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.List;

@JsonDeserialize(builder = BillingTagRequest.Builder.class)
public class BillingTagRequest implements IRequest {

    private final long from;
    private final long to;
    private final String tagSearchString;
    private final SdkBillingReportTarget target;
    private final List<String> tenantNames;

    private BillingTagRequest(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.tagSearchString = builder.tagSearchString;
        this.target = builder.target;
        this.tenantNames = builder.tenantNames;
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

    public String getTagSearchString() {
        return tagSearchString;
    }

    public SdkBillingReportTarget getTarget() {
        return target;
    }

    public List<String> getTenantNames() {
        return tenantNames;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_TAGS;
    }

    public static final class Builder {

        private long from;
        private long to;
        private String tagSearchString;
        private SdkBillingReportTarget target;
        private List<String> tenantNames;

        public Builder withFrom(long from) {
            this.from = from;
            return this;
        }

        public Builder withTo(long to) {
            this.to = to;
            return this;
        }

        public Builder withTagSearchString(String tagSearchString) {
            this.tagSearchString = tagSearchString;
            return this;
        }

        public Builder withTarget(SdkBillingReportTarget billingReportTarget) {
            this.target = billingReportTarget;
            return this;
        }

        public Builder withTenantNames(List<String> tenantNames) {
            this.tenantNames = tenantNames;
            return this;
        }

        public BillingTagRequest build() {
            Assert.isPositive(from, "from");
            Assert.isPositive(to, "to");
            Assert.isTrue(target != null || CollectionUtils.isNotEmpty(tenantNames), "target");
            return new BillingTagRequest(this);
        }
    }
}
