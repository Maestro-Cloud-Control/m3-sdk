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

package io.maestro3.sdk.v3.request.custodian;

import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;

public abstract class AbstractCustodianLastScanRequest implements ITenantRequest {

    private final SdkCloud cloud;
    /**
     * display name
     */
    private final String tenantName;
    private final String resourceType;
    private final boolean exactMatch;
    private final boolean searchByAll;

    protected AbstractCustodianLastScanRequest(Builder<?, ?> builder) {
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
        this.exactMatch = builder.exactMatch;
        this.searchByAll = builder.searchByAll;
        this.resourceType = builder.resourceType;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public boolean getExactMatch() {
        return exactMatch;
    }

    public boolean getSearchByAll() {
        return searchByAll;
    }

    public abstract static class Builder<B extends AbstractCustodianLastScanRequest.Builder<B, R>, R extends AbstractCustodianLastScanRequest> {

        private SdkCloud cloud;
        private String tenantName;
        private String resourceType;
        private boolean exactMatch;
        private boolean searchByAll;

        protected abstract B getThis();

        public abstract R build();

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

        public B withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }

        public B withResourceType(String resourceType) {
            this.resourceType = resourceType;
            return getThis();
        }

        public B withExactMatch(boolean exactMatch) {
            this.exactMatch = exactMatch;
            return getThis();
        }

        public B withSearchByAll(boolean searchByAll) {
            this.searchByAll = searchByAll;
            return getThis();
        }

        protected void validateParams() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
        }

    }

}
