package io.maestro3.sdk.v3.model.function;

import io.maestro3.sdk.v3.model.SdkCloud;

public class SdkAzureFunction extends SdkFunction {

    private String resourceGroup;
    private String virtualNetworkSubnetId;

    public SdkAzureFunction() {
        this.setCloud(SdkCloud.AZURE);
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    public String getVirtualNetworkSubnetId() {
        return virtualNetworkSubnetId;
    }

    public void setVirtualNetworkSubnetId(String virtualNetworkSubnetId) {
        this.virtualNetworkSubnetId = virtualNetworkSubnetId;
    }
}
