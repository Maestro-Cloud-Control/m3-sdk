package io.maestro3.sdk.v3.model.function;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "cloud",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SdkAwsFunction.class, name = "AWS"),
        @JsonSubTypes.Type(value = SdkAzureFunction.class, name = "AZURE"),
        @JsonSubTypes.Type(value = SdkGoogleFunction.class, name = "GOOGLE"),
})
public class SdkFunction {

    private String functionName;
    private SdkCloud cloud;
    private String runtime;
    private String handler;
    private Integer memoryAllocation;
    private Integer timeoutConfiguration;
    private String lastModified;
    private Long codeSize;
    private String storageLocation;
    private String version;
    private String revisionId;
    private List<SdkFunctionVariable> functionVariables;

    public SdkFunction() {
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public void setCloud(SdkCloud cloud) {
        this.cloud = cloud;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Integer getMemoryAllocation() {
        return memoryAllocation;
    }

    public void setMemoryAllocation(Integer memoryAllocation) {
        this.memoryAllocation = memoryAllocation;
    }

    public Integer getTimeoutConfiguration() {
        return timeoutConfiguration;
    }

    public void setTimeoutConfiguration(Integer timeoutConfiguration) {
        this.timeoutConfiguration = timeoutConfiguration;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Long getCodeSize() {
        return codeSize;
    }

    public void setCodeSize(Long codeSize) {
        this.codeSize = codeSize;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRevisionId() {
        return revisionId;
    }

    public void setRevisionId(String revisionId) {
        this.revisionId = revisionId;
    }

    public List<SdkFunctionVariable> getFunctionVariables() {
        return functionVariables;
    }

    public void setFunctionVariables(List<SdkFunctionVariable> functionVariables) {
        this.functionVariables = functionVariables;
    }
}
