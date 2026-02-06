package io.maestro3.sdk.v3.model.backup;

public class BackupResponse {
    private String instanceId;
    private String tenant;
    private String region;
    private BackupState state;
    private String description;

    public BackupResponse() {
    }

    public BackupResponse(String instanceId, String tenant, String region, BackupState state, String description) {
        this.instanceId = instanceId;
        this.tenant = tenant;
        this.region = region;
        this.state = state;
        this.description = description;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BackupState getState() {
        return state;
    }

    public void setState(BackupState state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
