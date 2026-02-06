package io.maestro3.sdk.v3.request.kubernetes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = DescribeKubernetesClusterInstancesRequest.Builder.class)
public class DescribeKubernetesClusterInstancesRequest implements IRegionRequest {
    /**
     * tenantDisplayName
     */
    private final String tenantName;
    private final String region;
    private final String clusterId;

    private DescribeKubernetesClusterInstancesRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.clusterId = builder.clusterId;
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

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_KUBERNETES_CLUSTER_INSTANCES;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String clusterId;

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

        public DescribeKubernetesClusterInstancesRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            return new DescribeKubernetesClusterInstancesRequest(this);
        }
    }
}
