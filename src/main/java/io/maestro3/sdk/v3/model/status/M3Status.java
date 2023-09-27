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

package io.maestro3.sdk.v3.model.status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class M3Status {

    private boolean serverAvailable = false;
    @JsonProperty
    private Map<String, Boolean> additionalData = new HashMap<>();
    private String cliLatestVersion;
    private String cliDistributionLatestVersionUrl;
    private String cliWindowsDistributionUrl;
    private String cliLinuxDistributionUrl;
    private String cliMacOsDistributionUrl;

    private M3Status() {
    }

    private M3Status(boolean serverStatus, Map<String, Boolean> additionalData,
                     String cliLatestVersion, String cliDistributionLatestVersionUrl, String cliWindowsDistributionUrl,
                     String cliLinuxDistributionUrl, String cliMacOsDistributionUrl) {
        this.serverAvailable = serverStatus;
        this.additionalData = additionalData;
        this.cliLatestVersion = cliLatestVersion;
        this.cliDistributionLatestVersionUrl = cliDistributionLatestVersionUrl;
        this.cliWindowsDistributionUrl = cliWindowsDistributionUrl;
        this.cliLinuxDistributionUrl = cliLinuxDistributionUrl;
        this.cliMacOsDistributionUrl = cliMacOsDistributionUrl;
    }

    public static M3StatusBuilder builder() {
        return new M3StatusBuilder();
    }

    public boolean isServerAvailable() {
        return serverAvailable;
    }

    public String getCliLatestVersion() {
        return cliLatestVersion;
    }

    public String getCliDistributionLatestVersionUrl() {
        return cliDistributionLatestVersionUrl;
    }

    public String getCliWindowsDistributionUrl() {
        return cliWindowsDistributionUrl;
    }

    public String getCliLinuxDistributionUrl() {
        return cliLinuxDistributionUrl;
    }

    public String getCliMacOsDistributionUrl() {
        return cliMacOsDistributionUrl;
    }

    @JsonIgnore
    public boolean isTerraformAvailable() {
        return serverAvailable && additionalData.get("terraform");
    }

    @JsonIgnore
    public boolean isOwnershipAvailable() {
        return serverAvailable && additionalData.get("ownership");
    }

    @JsonIgnore
    public boolean isMailsAvailable() {
        return serverAvailable && additionalData.get("mails");
    }

    public static class M3StatusBuilder {

        private boolean serverAvailable;
        private Map<String, Boolean> additionalData = new HashMap<>();
        private String cliLatestVersion;
        private String cliDistributionLatestVersionUrl;
        private String cliWindowsDistributionUrl;
        private String cliLinuxDistributionUrl;
        private String cliMacOsDistributionUrl;

        public M3StatusBuilder available() {
            serverAvailable = true;
            return this;
        }

        public M3StatusBuilder unavailable() {
            serverAvailable = false;
            return this;
        }

        public M3StatusBuilder withAdditionalData(String serviceName, boolean status) {
            additionalData.put(serviceName, status);
            return this;
        }

        public M3StatusBuilder withCliLatestVersion(String cliLatestVersion) {
            this.cliLatestVersion = cliLatestVersion;
            return this;
        }

        public M3StatusBuilder withCliDistributionLatestVersionUrl(String cliDistributionLatestVersionUrl) {
            this.cliDistributionLatestVersionUrl = cliDistributionLatestVersionUrl;
            return this;
        }

        public M3StatusBuilder withCliWindowsDistributionUrl(String cliWindowsDistributionUrl) {
            this.cliWindowsDistributionUrl = cliWindowsDistributionUrl;
            return this;
        }

        public M3StatusBuilder withCliLinuxDistributionUrl(String cliLinuxDistributionUrl) {
            this.cliLinuxDistributionUrl = cliLinuxDistributionUrl;
            return this;
        }

        public M3StatusBuilder withCliMacOsDistributionUrl(String cliMacOsDistributionUrl) {
            this.cliMacOsDistributionUrl = cliMacOsDistributionUrl;
            return this;
        }

        public M3Status build() {
            return new M3Status(serverAvailable, additionalData, cliLatestVersion, cliDistributionLatestVersionUrl,
                cliWindowsDistributionUrl, cliLinuxDistributionUrl, cliMacOsDistributionUrl);
        }
    }
}
