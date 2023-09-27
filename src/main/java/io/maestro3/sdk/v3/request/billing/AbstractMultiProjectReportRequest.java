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
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

public abstract class AbstractMultiProjectReportRequest implements IRequest {

    private final long from;
    private final long to;
    private final String tag;
    private final boolean nativeCurrency;
    private final boolean cached;

    protected AbstractMultiProjectReportRequest(AbstractBuilder<?, ?> builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.tag = builder.tag;
        this.nativeCurrency = builder.nativeCurrency;
        this.cached = builder.cached;
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

    public boolean isNativeCurrency() {
        return nativeCurrency;
    }

    public boolean isCached() {
        return cached;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_MULTIPROJECT_BILLING_REPORT;
    }

    public abstract static class AbstractBuilder<B extends AbstractBuilder<B, R>, R extends AbstractMultiProjectReportRequest> {

        private long from;
        private long to;
        private String tag;
        private boolean nativeCurrency;
        private boolean cached;
        
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

        public B withNativeCurrency(boolean nativeCurrency) {
            this.nativeCurrency = nativeCurrency;
            return getThis();
        }

        public B withCached(boolean cached) {
            this.cached = cached;
            return getThis();
        }

        protected void validateParams() {
            Assert.notNull(from, "from");
            Assert.notNull(to, "to");
            Assert.notNull(nativeCurrency, "nativeCurrency");
        }
    }
}
