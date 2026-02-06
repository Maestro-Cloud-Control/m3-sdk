/*
 *
 * Copyright 2024 Softline Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.request.support;

import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.support.SdkSupportProvider;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.Set;

public abstract class AbstractSupportRequest implements ITenantRequest {

    protected String tenantName;
    protected SdkCloud cloud;
    protected SdkSupportProvider supportProvider;

    protected AbstractSupportRequest(AbstractSupportRequestBuilder<?, ?> builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        assertProviderIsSupported(builder.supportProvider);
        this.supportProvider = builder.supportProvider;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    public SdkSupportProvider getSupportProvider() {
        return supportProvider;
    }

    abstract Set<SdkSupportProvider> getAllowedProviders();

    protected void assertProviderIsSupported(SdkSupportProvider provider) {
        boolean isSupported = getAllowedProviders().contains(provider);
        if (!isSupported) {
            throw new M3SdkException(String.format("This operation is not supported for %s", provider.name()));
        }
    }

    public abstract static class AbstractSupportRequestBuilder<BUILDER
            extends AbstractSupportRequestBuilder<BUILDER, REQUEST>, REQUEST extends AbstractSupportRequest> {
        protected String tenantName;
        protected SdkCloud cloud;
        protected SdkSupportProvider supportProvider;

        protected abstract BUILDER getThis();

        public abstract REQUEST build();

        public BUILDER withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }

        public BUILDER withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }

        public BUILDER withSupportProvider(SdkSupportProvider supportProvider) {
            this.supportProvider = supportProvider;
            return getThis();
        }

        protected void checkFields() {
            Assert.hasText(tenantName, "tenantName");
            Assert.notNull(cloud, "cloud");
        }
    }
}
