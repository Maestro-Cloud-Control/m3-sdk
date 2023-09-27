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

package io.maestro3.sdk.v3.request.metric;

import io.maestro3.sdk.v3.request.IRequest;

public abstract class AbstractDashboardActionsRequest implements IRequest {

    private final String userIdentifier;
    private final String dashboardTypeName;
    private final String cloudName;
    private final String tenantName;
    private final String regionName;

    protected AbstractDashboardActionsRequest(AbstractDashboardActionsRequestBuilder<?, ?> builder) {
        this.userIdentifier = builder.userIdentifier;
        this.dashboardTypeName = builder.dashboardTypeName;
        this.cloudName = builder.cloudName;
        this.tenantName = builder.tenantName;
        this.regionName = builder.regionName;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getDashboardTypeName() {
        return dashboardTypeName;
    }

    public String getCloudName() {
        return cloudName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegionName() {
        return regionName;
    }

    public abstract static class AbstractDashboardActionsRequestBuilder
        <B extends AbstractDashboardActionsRequestBuilder<B, R>, R extends AbstractDashboardActionsRequest> {

        private String userIdentifier;
        private String dashboardTypeName;
        private String cloudName;
        private String tenantName;
        private String regionName;

        protected abstract B getThis();

        protected abstract R build();

        public B withUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return getThis();
        }

        public B withDashboardTypeName(String dashboardTypeName) {
            this.dashboardTypeName = dashboardTypeName;
            return getThis();
        }

        public B withCloudName(String cloudName) {
            this.cloudName = cloudName;
            return getThis();
        }

        public B withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }

        public B withRegionName(String regionName) {
            this.regionName = regionName;
            return getThis();
        }
    }
}
