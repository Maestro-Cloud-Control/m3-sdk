package io.maestro3.sdk.v3.model.function;

import java.util.List;

public class SdkAwsFunctionVpc {
    private String vpcId;
    private List<String> subnetIds;
    private List<String> securityGroups;

    public SdkAwsFunctionVpc() {
    }

    public SdkAwsFunctionVpc(String vpcId, List<String> subnetIds, List<String> securityGroups) {
        this.vpcId = vpcId;
        this.subnetIds = subnetIds;
        this.securityGroups = securityGroups;
    }

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    public List<String> getSubnetIds() {
        return subnetIds;
    }

    public void setSubnetIds(List<String> subnetIds) {
        this.subnetIds = subnetIds;
    }

    public List<String> getSecurityGroups() {
        return securityGroups;
    }

    public void setSecurityGroups(List<String> securityGroups) {
        this.securityGroups = securityGroups;
    }
}
