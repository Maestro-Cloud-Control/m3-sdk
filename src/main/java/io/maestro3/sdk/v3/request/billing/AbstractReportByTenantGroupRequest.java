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
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRequest;

public abstract class AbstractReportByTenantGroupRequest implements IRequest {

    private final long from;
    private final long to;
    private final SdkCloud cloud;
    private final String tenantGroup;
    private final String region;

    protected AbstractReportByTenantGroupRequest(AbstractDailyReportByTenantGroupRequestBuilder<?, ?> builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.cloud = builder.cloud;
        this.tenantGroup = builder.tenantGroup;
        this.region = builder.region;
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantGroup() {
        return tenantGroup;
    }

    public String getRegion() {
        return region;
    }

    public abstract static class AbstractDailyReportByTenantGroupRequestBuilder
        <B extends AbstractDailyReportByTenantGroupRequestBuilder<B, R>, R extends AbstractReportByTenantGroupRequest> {

        private long from;
        private long to;
        private SdkCloud cloud;
        private String tenantGroup;
        private String region;

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

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

        public B withTenantGroup(String tenantGroup) {
            this.tenantGroup = tenantGroup;
            return getThis();
        }

        public B withRegion(String region) {
            this.region = region;
            return getThis();
        }

        protected void validateParams() {
            Assert.isPositive(from, "from");
            Assert.isPositive(to, "to");
            Assert.hasText(tenantGroup, "tenantGroup");
        }
    }
}
