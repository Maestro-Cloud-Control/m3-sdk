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

package io.maestro3.sdk.v3.request.paas;

import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.paas.SdkPlatformService;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Map;

public abstract class AbstractPlatformServiceActionRequest implements IRequest {

    private final SdkPlatformService platformService;
    private final String tenantDisplayName;
    private final SdkCloud cloud;
    private final boolean allTenants;
    private final String instructions;
    private final Map<String, String> additionalNotificationParams;

    protected AbstractPlatformServiceActionRequest(AbstractPlatformServiceActionRequestBuilder<?, ?> builder) {
        this.platformService = builder.platformService;
        this.tenantDisplayName = builder.tenantDisplayName;
        this.cloud = builder.cloud;
        this.allTenants = builder.allTenants;
        this.instructions = builder.instructions;
        this.additionalNotificationParams = builder.additionalNotificationParams;
    }

    public SdkPlatformService getPlatformService() {
        return platformService;
    }

    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public boolean isAllTenants() {
        return allTenants;
    }

    public String getInstructions() {
        return instructions;
    }

    public Map<String, String> getAdditionalNotificationParams() {
        return additionalNotificationParams;
    }

    public abstract static class AbstractPlatformServiceActionRequestBuilder
        <B extends AbstractPlatformServiceActionRequestBuilder<B, R>, R extends AbstractPlatformServiceActionRequest> {

        private SdkPlatformService platformService;
        private String tenantDisplayName;
        private SdkCloud cloud;
        private boolean allTenants;
        private String instructions;
        private Map<String, String> additionalNotificationParams;

        protected abstract B getThis();

        public abstract R build();

        public B withPlatformService(SdkPlatformService platformService) {
            this.platformService = platformService;
            return getThis();
        }

        public B withTenantDisplayName(String tenantDisplayName) {
            this.tenantDisplayName = tenantDisplayName;
            return getThis();
        }

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

        public B withAllTenants(boolean allTenants) {
            this.allTenants = allTenants;
            return getThis();
        }

        public B withInstructions(String instructions) {
            this.instructions = instructions;
            return getThis();
        }

        public B withAdditionalNotificationParams(Map<String, String> additionalNotificationParams) {
            this.additionalNotificationParams = additionalNotificationParams;
            return getThis();
        }
    }
}
