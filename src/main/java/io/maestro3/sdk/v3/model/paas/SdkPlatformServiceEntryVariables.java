package io.maestro3.sdk.v3.model.paas;

import java.util.Map;

public class SdkPlatformServiceEntryVariables {

    private String serviceId;
    private Map<String, Object> params;

    //json serialization/deserialization
    public SdkPlatformServiceEntryVariables() {
    }

    public SdkPlatformServiceEntryVariables(String serviceId, Map<String, Object> params) {
        this.serviceId = serviceId;
        this.params = params;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, Object> getParams() {
        return params;
    }
}
