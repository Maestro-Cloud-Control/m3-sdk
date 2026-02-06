package io.maestro3.sdk.v3.request.function;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.Map;

@JsonDeserialize(builder = UpdateFunctionVariablesRequest.Builder.class)
public class UpdateFunctionVariablesRequest implements IRegionRequest {

    private final SdkCloud cloud;
    // display name
    private final String tenantName;
    private final String region;
    private final String functionName;
    private final String resourceGroup;
    private final Map<String, String> variables;

    private UpdateFunctionVariablesRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.functionName = builder.functionName;
        this.resourceGroup = builder.resourceGroup;
        this.variables = builder.variables;
    }

    public static Builder builder() {
        return new UpdateFunctionVariablesRequest.Builder();
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public Map<String, String> getVariables() {
        return variables;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_FUNCTION_VARIABLES;
    }

    public static final class Builder {
        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private String functionName;
        private String resourceGroup;
        private Map<String, String> variables;

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

        public Builder withFunctionName(String functionName) {
            this.functionName = functionName;
            return this;
        }

        public Builder withResourceGroup(String resourceGroup) {
            this.resourceGroup = resourceGroup;
            return this;
        }

        public Builder withVariables(Map<String, String> variables) {
            this.variables = variables;
            return this;
        }

        public UpdateFunctionVariablesRequest build() {
            return new UpdateFunctionVariablesRequest(this);
        }
    }
}