package io.maestro3.sdk.v3.request.backup;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.CollectionUtils;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.List;

@JsonDeserialize(builder = BackupRequest.Builder.class)
public class BackupRequest implements IRegionRequest, ITenantRequest {
    private final String serviceId;
    private final List<String> instances;
    private final String tenantName;
    private final String region;
    private final String backupServer;
    private final SdkCloud cloud;

    private BackupRequest(String serviceId, List<String> instances, String tenantName, String region,
                          String backupServer, SdkCloud cloud) {
        this.serviceId = serviceId;
        this.instances = instances;
        this.tenantName = tenantName;
        this.region = region;
        this.backupServer = backupServer;
        this.cloud = cloud;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.BACKUP_PLATFORM_SERVICE;
    }

    public String getServiceId() {
        return serviceId;
    }

    public List<String> getInstances() {
        return instances;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public String getBackupServer() {
        return backupServer;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String serviceId;
        private List<String> instances;
        private String tenantName;
        private String region;
        private SdkCloud cloud;
        private String backupServer;

        public Builder withServiceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder withBackupServer(String backupServer) {
            this.backupServer = backupServer;
            return this;
        }

        public Builder withInstances(List<String> instances) {
            this.instances = instances;
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

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public BackupRequest build() {
            Assert.isTrue(StringUtils.isNotBlank(serviceId) ||
                            CollectionUtils.isNotEmpty(instances),
                    "instances or serviceId must be specified");
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.hasText(backupServer, "backupServer");
            Assert.notNull(cloud, "cloud");

            return new BackupRequest(serviceId, instances,
                    tenantName, region, backupServer, cloud);
        }
    }
}
