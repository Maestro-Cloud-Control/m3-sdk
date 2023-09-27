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
import io.maestro3.sdk.v3.model.billing.BillingReportFormat;
import io.maestro3.sdk.v3.model.billing.MultiProjectBillingReportType;
import io.maestro3.sdk.v3.model.billing.SdkMultiProjectBillingReportTarget;

@JsonDeserialize(builder = MultiProjectBillingReportRequest.Builder.class)
public class MultiProjectBillingReportRequest extends AbstractMultiProjectReportRequest {

    private final MultiProjectBillingReportType type;
    private final SdkMultiProjectBillingReportTarget target;
    private final BillingReportFormat format;

    private MultiProjectBillingReportRequest(Builder builder) {
        super(builder);
        this.type = builder.type;
        this.target = builder.target;
        this.format = builder.format;
    }

    public static Builder builder() {
        return new Builder();
    }

    public MultiProjectBillingReportType getType() {
        return type;
    }

    public SdkMultiProjectBillingReportTarget getTarget() {
        return target;
    }

    public BillingReportFormat getFormat() {
        return format;
    }

    public static final class Builder extends AbstractMultiProjectReportRequest.AbstractBuilder<Builder, MultiProjectBillingReportRequest> {

        private MultiProjectBillingReportType type;
        private SdkMultiProjectBillingReportTarget target;
        private BillingReportFormat format;

        public Builder withType(MultiProjectBillingReportType type) {
            this.type = type;
            return this;
        }

        public Builder withTarget(SdkMultiProjectBillingReportTarget target) {
            this.target = target;
            return this;
        }

        public Builder withFormat(BillingReportFormat format) {
            this.format = format;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public MultiProjectBillingReportRequest build() {
            validateParams();
            Assert.notNull(target, "target");
            Assert.notNull(type, "type");
            Assert.notNull(format, "format");
            return new MultiProjectBillingReportRequest(this);
        }
    }
}
