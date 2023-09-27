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

package io.maestro3.sdk.v3.request.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.EnumMap;
import java.util.Map;

@JsonDeserialize(builder = OnboardingPrivateRequest.OnboardingPrivateRequestBuilder.class)
public class OnboardingPrivateRequest extends AbstractOnboardingRequest {

    private static final Map<SdkCloud, ActionType> ACTION_TYPE_MAP = new EnumMap<>(SdkCloud.class);

    static {
        ACTION_TYPE_MAP.put(SdkCloud.OPEN_STACK, ActionType.ONBOARDING_OPENSTACK_TENANT);
        ACTION_TYPE_MAP.put(SdkCloud.VMWARE, ActionType.ONBOARDING_VMWARE_TENANT);
        ACTION_TYPE_MAP.put(SdkCloud.VSPHERE, ActionType.ONBOARDING_VSPHERE_TENANT);
    }

    private final String tenantDisplayName;
    private final String tenantGroup;
    private final String tenantName;
    private final SdkCloud cloud;

    private OnboardingPrivateRequest(OnboardingPrivateRequestBuilder builder) {
        super(builder);
        this.tenantDisplayName = builder.tenantDisplayName;
        this.tenantGroup = builder.tenantGroup;
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
    }

    public static OnboardingPrivateRequestBuilder builder() {
        return new OnboardingPrivateRequestBuilder();
    }

    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    public String getTenantGroup() {
        return tenantGroup;
    }

    public String getTenantName() {
        return tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public ActionType getActionType() {
        return ACTION_TYPE_MAP.get(cloud);
    }

    public static final class OnboardingPrivateRequestBuilder
        extends AbstractOnboardingRequestBuilder<OnboardingPrivateRequestBuilder, OnboardingPrivateRequest> {

        private String tenantDisplayName;
        private String tenantGroup;
        private String tenantName;
        private SdkCloud cloud;

        public OnboardingPrivateRequestBuilder withTenantDisplayName(String tenantDisplayName) {
            this.tenantDisplayName = tenantDisplayName;
            return getThis();
        }

        public OnboardingPrivateRequestBuilder withTenantGroup(String tenantGroup) {
            this.tenantGroup = tenantGroup;
            return getThis();
        }

        public OnboardingPrivateRequestBuilder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }

        public OnboardingPrivateRequestBuilder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

        @Override
        protected OnboardingPrivateRequestBuilder getThis() {
            return this;
        }

        @Override
        public OnboardingPrivateRequest build() {
            return new OnboardingPrivateRequest(this);
        }
    }
}
