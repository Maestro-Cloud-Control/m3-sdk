package io.maestro3.sdk.v3.model.function;

import io.maestro3.sdk.v3.model.SdkCloud;

public class SdkAwsFunction extends SdkFunction {

    private String arn;
    private String roleArn;
    private SdkAwsFunctionVpc functionVpc;

    public SdkAwsFunction() {
        this.setCloud(SdkCloud.AWS);
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn;
    }

    public String getRoleArn() {
        return roleArn;
    }

    public void setRoleArn(String roleArn) {
        this.roleArn = roleArn;
    }

    public SdkAwsFunctionVpc getFunctionVpc() {
        return functionVpc;
    }

    public void setFunctionVpc(SdkAwsFunctionVpc sdkAwsFunctionVpc) {
        this.functionVpc = sdkAwsFunctionVpc;
    }
}
