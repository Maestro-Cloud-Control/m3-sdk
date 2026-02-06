package io.maestro3.sdk.v3.model.function;

public class SdkGoogleFunctionVpc {
    private String vpcConnector;
    private String vpcConnectorSettings;

    public SdkGoogleFunctionVpc() {
    }

    public SdkGoogleFunctionVpc(String vpcConnector, String vpcConnectorSettings) {
        this.vpcConnector = vpcConnector;
        this.vpcConnectorSettings = vpcConnectorSettings;
    }

    public String getVpcConnector() {
        return vpcConnector;
    }

    public void setVpcConnector(String vpcConnector) {
        this.vpcConnector = vpcConnector;
    }

    public String getVpcConnectorSettings() {
        return vpcConnectorSettings;
    }

    public void setVpcConnectorSettings(String vpcConnectorSettings) {
        this.vpcConnectorSettings = vpcConnectorSettings;
    }
}
