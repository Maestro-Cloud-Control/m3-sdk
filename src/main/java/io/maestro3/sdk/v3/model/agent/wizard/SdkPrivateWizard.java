/*
 * Copyright 2023 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.model.agent.wizard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SdkPrivateWizard.Builder.class)
public class SdkPrivateWizard {
    //common
    public static final String REGION_NAME = "regionName";
    public static final String USERNAME = "username";
    public static final String TENANT_NAME = "tenant";
    //os
    public static final String REGION_NATIVE_NAME = "regionNativeName";
    public static final String AUTH_URL = "auth";
    public static final String PROJECT_NAME = "project";
    public static final String NETWORK = "network";
    public static final String SEC_GROUP = "securityGroup";
    //vmware
    public static final String SERVER = "server";
    public static final String API_VERSION = "api";
    public static final String VDC_NAME = "vdc";
    public static final String NETWORK_NAME = "net";
    public static final String STORAGE_NAME = "storage";
    public static final String ORG_NAME = "org";
    //vsphere
    public static final String REGION_TYPE = "type";
    public static final String PLACEMENT_TYPE = "placement";
    public static final String DEPLOY_TYPE = "deploy";

    private String id;
    private Integer current;
    private List<SdkPrivateStep> step = new ArrayList<>();
    private SdkAdminCommandPipeline pipeline;
    private boolean valid = true;
    private Map<String, String> meta = new HashMap<>();

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final SdkPrivateWizard wizard = new SdkPrivateWizard();

        @JsonProperty("id")
        public Builder withId(String id) {
            wizard.id = id;
            return this;
        }

        @JsonProperty("meta")
        public Builder withMeta(Map<String, String> meta) {
            wizard.meta = meta;
            return this;
        }

        @JsonProperty("current")
        public Builder withCurrent(Integer current) {
            wizard.current = current;
            return this;
        }

        @JsonProperty("step")
        public Builder withStep(List<SdkPrivateStep> step) {
            wizard.step = step;
            return this;
        }

        @JsonProperty("valid")
        public Builder withValid(boolean valid) {
            wizard.valid = valid;
            return this;
        }

        @JsonProperty("pipeline")
        public Builder withPipeline(SdkAdminCommandPipeline pipeline) {
            wizard.pipeline = pipeline;
            return this;
        }

        public SdkPrivateWizard build() {
            return wizard;
        }

    }

    public String getId() {
        return id;
    }

    public Integer getCurrent() {
        return current;
    }

    public Map<String, String> getMeta() {
        return meta;
    }

    public List<SdkPrivateStep> getStep() {
        return step;
    }

    public boolean isValid() {
        return valid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }


    public void setStep(List<SdkPrivateStep> step) {
        this.step = step;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public SdkAdminCommandPipeline getPipeline() {
        return pipeline;
    }

    public void setPipeline(SdkAdminCommandPipeline pipeline) {
        this.pipeline = pipeline;
    }

    public void invalidate() {
        this.valid = false;
    }

}
