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

package io.maestro3.sdk.v3.model.security;

public class SdkNessusPolicy {
    private String policyAlias;
    private String policyId;
    private boolean useCred;
    private String description;
    private String templateId;

    public SdkNessusPolicy() {
    }

    public SdkNessusPolicy(String policyAlias, String policyId, boolean useCred, String description, String templateId) {
        this.policyAlias = policyAlias;
        this.templateId = templateId;
        this.policyId = policyId;
        this.useCred = useCred;
        this.description = description;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getPolicyAlias() {
        return policyAlias;
    }

    public void setPolicyAlias(String policyAlias) {
        this.policyAlias = policyAlias;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public boolean isUseCred() {
        return useCred;
    }

    public void setUseCred(boolean useCred) {
        this.useCred = useCred;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
