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

import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.billing.BillingReportFormat;
import io.maestro3.sdk.v3.model.billing.SdkBillingReportTarget;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Optional;

public abstract class AbstractBillingReportRequest implements IRequest {

    private final long from;
    private final long to;
    private final String tag;
    private final BillingReportFormat reportFormat;
    private final SdkBillingReportTarget target;

    protected AbstractBillingReportRequest(AbstractBillingReportRequestBuilder<?, ?> builder,
                                           BillingReportFormat defaultReportFormat) {
        this.from = builder.from;
        this.to = builder.to;
        this.tag = builder.tag;
        this.reportFormat = Optional.ofNullable(builder.reportFormat).orElse(defaultReportFormat);
        this.target = builder.target;
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public String getTag() {
        return tag;
    }

    public BillingReportFormat getReportFormat() {
        return reportFormat;
    }

    public SdkBillingReportTarget getTarget() {
        return target;
    }

    public abstract static class AbstractBillingReportRequestBuilder
        <B extends AbstractBillingReportRequestBuilder<B, R>, R extends AbstractBillingReportRequest> {

        protected long from;
        protected long to;
        private String tag;
        private BillingReportFormat reportFormat;
        private SdkBillingReportTarget target;

        protected abstract B getThis();

        public abstract R build();

        public B withFrom(long from) {
            this.from = from;
            return getThis();
        }

        public B withTo(long to) {
            this.to = to;
            return getThis();
        }

        public B withTag(String tag) {
            this.tag = tag;
            return getThis();
        }

        public B withReportFormat(BillingReportFormat reportFormat) {
            this.reportFormat = reportFormat;
            return getThis();
        }

        public B withTarget(SdkBillingReportTarget target) {
            this.target = target;
            return getThis();
        }

        protected void validateParams() {
            Assert.isPositive(from, "from");
            Assert.isPositive(to, "to");
            Assert.notNull(target, "target");
        }
    }
}
