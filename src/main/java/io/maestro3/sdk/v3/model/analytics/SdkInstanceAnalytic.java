package io.maestro3.sdk.v3.model.analytics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SdkInstanceAnalytic.Builder.class)
public class SdkInstanceAnalytic {

    private Map<String, Integer> stoppedAnalytic = new HashMap<>();
    private Map<String, Long> uptimeAnalytic = new HashMap<>();

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final SdkInstanceAnalytic instanceAnalytic = new SdkInstanceAnalytic();

        @JsonProperty("stoppedAnalytic")
        public Builder withStoppedAnalytic(Map<String, Integer> stoppedAnalytic) {
            instanceAnalytic.stoppedAnalytic = stoppedAnalytic;
            return this;
        }

        @JsonProperty("uptimeAnalytic")
        public Builder withUptimeAnalytic(Map<String, Long> uptimeAnalytic) {
            instanceAnalytic.uptimeAnalytic = uptimeAnalytic;
            return this;
        }

        public SdkInstanceAnalytic build() {
            return instanceAnalytic;
        }
    }

    public Map<String, Integer> getStoppedAnalytic() {
        return stoppedAnalytic;
    }

    public void setStoppedAnalytic(Map<String, Integer> stoppedAnalytic) {
        this.stoppedAnalytic = stoppedAnalytic;
    }

    public Map<String, Long> getUptimeAnalytic() {
        return uptimeAnalytic;
    }

    public void setUptimeAnalytic(Map<String, Long> uptimeAnalytic) {
        this.uptimeAnalytic = uptimeAnalytic;
    }
}
