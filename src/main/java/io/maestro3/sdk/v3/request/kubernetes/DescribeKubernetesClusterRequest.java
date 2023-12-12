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

package io.maestro3.sdk.v3.request.kubernetes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.Set;

@JsonDeserialize(builder = DescribeKubernetesClusterRequest.Builder.class)
public class DescribeKubernetesClusterRequest implements IRegionRequest {
    /**
     * tenantDisplayName
     */
    private final String tenantName;
    private final String region;
    private final String clusterId;
    private final boolean wide;

    private DescribeKubernetesClusterRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.clusterId = builder.clusterId;
        this.wide = builder.wide;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public String getClusterId() {
        return clusterId;
    }

    public boolean isWide() {
        return wide;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_KUBERNETES_CLUSTER;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String clusterId;
        private boolean wide;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withClusterId(String clusterId) {
            this.clusterId = clusterId;
            return this;
        }

        /**
         * Collect additional properties like: "namespaces", "services", "pods", "endpoints", "ingresses", "replica-sets"
         */
        public Builder withWide(boolean wide) {
            this.wide = wide;
            return this;
        }

        public DescribeKubernetesClusterRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            return new DescribeKubernetesClusterRequest(this);
        }
    }
}
