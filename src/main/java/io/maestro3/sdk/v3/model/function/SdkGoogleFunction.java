package io.maestro3.sdk.v3.model.function;

import io.maestro3.sdk.v3.model.SdkCloud;

public class SdkGoogleFunction extends SdkFunction {

    private SdkGoogleFunctionVpc functionVpc;

    public SdkGoogleFunctionVpc getFunctionVpc() {
        return functionVpc;
    }

    public void setFunctionVpc(SdkGoogleFunctionVpc functionVpc) {
        this.functionVpc = functionVpc;
    }

    public SdkGoogleFunction() {
        this.setCloud(SdkCloud.GOOGLE);
    }

}
