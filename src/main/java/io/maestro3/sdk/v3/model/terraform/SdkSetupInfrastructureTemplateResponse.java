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

public class SdkSetupInfrastructureTemplateResponse {
    private boolean success;
    private String errorMessage;
    private String templateUUID;

    private SdkSetupInfrastructureTemplateResponse() {
    }

    private SdkSetupInfrastructureTemplateResponse(boolean success, String errorMessage, String templateUUID) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.templateUUID = templateUUID;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTemplateUUID() {
        return templateUUID;
    }

    public void setTemplateUUID(String templateUUID) {
        this.templateUUID = templateUUID;
    }

    public static SdkSetupInfrastructureTemplateResponse success(String templateUUID){
        return new SdkSetupInfrastructureTemplateResponse(true, null, templateUUID);
    }

    public static SdkSetupInfrastructureTemplateResponse error(String errorMessage){
        return new SdkSetupInfrastructureTemplateResponse(false, errorMessage, null);
    }

    @Override
    public String toString() {
        return "SetupTerraformTemplateResponse{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", templateUUID='" + templateUUID + '\'' +
                '}';
    }
}
