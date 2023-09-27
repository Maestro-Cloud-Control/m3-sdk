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

package io.maestro3.sdk.v3.model.analytics;

import java.util.Map;

public class SdkBillingConfig {

    private Map<String, SdkAwsBillingConfig> awsBillingConfigs;
    private Map<String, SdkAzureBillingConfig> azureBillingConfigs;
    private Map<String, SdkGoogleBillingConfig> googleBillingConfigs;
    private SdkEpcBillingConfig epcBillingConfig;

    /**
     * @return AWS billing configs by AWS paying account names
     */
    public Map<String, SdkAwsBillingConfig> getAwsBillingConfigs() {
        return awsBillingConfigs;
    }

    public void setAwsBillingConfigs(Map<String, SdkAwsBillingConfig> awsBillingConfigs) {
        this.awsBillingConfigs = awsBillingConfigs;
    }

    /**
     * @return Azure billing configs by azure enrolment numbers
     */
    public Map<String, SdkAzureBillingConfig> getAzureBillingConfigs() {
        return azureBillingConfigs;
    }

    public void setAzureBillingConfigs(Map<String, SdkAzureBillingConfig> azureBillingConfigs) {
        this.azureBillingConfigs = azureBillingConfigs;
    }

    /**
     * @return Google billing configs by Google compute account names
     */
    public Map<String, SdkGoogleBillingConfig> getGoogleBillingConfigs() {
        return googleBillingConfigs;
    }

    public void setGoogleBillingConfigs(Map<String, SdkGoogleBillingConfig> googleBillingConfigs) {
        this.googleBillingConfigs = googleBillingConfigs;
    }

    public SdkEpcBillingConfig getEpcBillingConfig() {
        return epcBillingConfig;
    }

    public void setEpcBillingConfig(SdkEpcBillingConfig epcBillingConfig) {
        this.epcBillingConfig = epcBillingConfig;
    }
}
