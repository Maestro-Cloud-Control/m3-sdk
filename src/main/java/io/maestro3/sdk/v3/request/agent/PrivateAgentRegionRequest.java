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

package io.maestro3.sdk.v3.request.agent;

import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;

public abstract class PrivateAgentRegionRequest implements ITenantRequest {

    private static final String EMPTY_REGION = "DEFAULT_PRIVATE_REGION";

    private final SdkCloud cloud;
    private final String tenantName;
    private final String nativeRegion;
    private final String privateAgentName;

    protected PrivateAgentRegionRequest(AbstractPrivateAgentRegionRequestBuilder<?, ?> builder) {
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
        this.nativeRegion = resolveNativeRegion(builder);
        this.privateAgentName = builder.privateAgentName;
    }

    private String resolveNativeRegion(AbstractPrivateAgentRegionRequestBuilder<?, ?> builder) {
        if (StringUtils.isNotBlank(builder.nativeRegion)) {
            return builder.nativeRegion;
        }
        if (StringUtils.isNotBlank(builder.privateAgentName)) {
            return builder.privateAgentName + EMPTY_REGION;
        }
        if (StringUtils.isNotBlank(builder.tenantName)) {
            return builder.tenantName + EMPTY_REGION;
        }
        return null;
    }

    public String getTenantName() {
        return tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getNativeRegion() {
        return nativeRegion;
    }

    public String getPrivateAgentName() {
        return privateAgentName;
    }

    public abstract static class AbstractPrivateAgentRegionRequestBuilder
        <B extends AbstractPrivateAgentRegionRequestBuilder<B, R>, R extends PrivateAgentRegionRequest> {

        private SdkCloud cloud;
        private String tenantName;
        private String nativeRegion;
        private String privateAgentName;

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

        public B withNativeRegion(String nativeRegion) {
            this.nativeRegion = nativeRegion;
            return getThis();
        }

        public B withPrivateAgentName(String privateAgentName) {
            this.privateAgentName = privateAgentName;
            return getThis();
        }
    }
}
