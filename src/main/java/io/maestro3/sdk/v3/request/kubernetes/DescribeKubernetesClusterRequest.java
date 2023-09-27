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
    private final SdkCloud cloud;
    private final Set<String> clusterNames;

    private DescribeKubernetesClusterRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.cloud = builder.cloud;
        this.clusterNames = builder.clusterNames;
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

    public SdkCloud getCloud() {
        return cloud;
    }

    public Set<String> getClusterNames() {
        return clusterNames;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_KUBERNETES_CLUSTER;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private SdkCloud cloud;
        private Set<String> clusterNames;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withClusterNames(Set<String> clusterNames) {
            this.clusterNames = clusterNames;
            return this;
        }

        public DescribeKubernetesClusterRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.notNull(cloud, "cloud");
            return new DescribeKubernetesClusterRequest(this);
        }
    }
}
