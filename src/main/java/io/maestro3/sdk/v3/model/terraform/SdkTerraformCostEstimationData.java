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

package io.maestro3.sdk.v3.model.terraform;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkTerraformCostEstimationData {
    private boolean isSuccess;
    private String preformattedMessage;
    private List<SdkTerraformCostObject> objects = new ArrayList<>();
    private SdkTerraformCostSummary summary;
    private Long pricesDate;

    public Long getPricesDate() {
        return pricesDate;
    }

    public void setPricesDate(Long pricesDate) {
        this.pricesDate = pricesDate;
    }

    public SdkTerraformCostSummary getSummary() {
        return summary;
    }

    public void setSummary(SdkTerraformCostSummary summary) {
        this.summary = summary;
    }

    public String getPreformattedMessage() {
        return preformattedMessage;
    }

    public void setPreformattedMessage(String preformattedMessage) {
        this.preformattedMessage = preformattedMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public List<SdkTerraformCostObject> getObjects() {
        return objects;
    }

    public void setObjects(List<SdkTerraformCostObject> objects) {
        this.objects = objects;
    }
}
