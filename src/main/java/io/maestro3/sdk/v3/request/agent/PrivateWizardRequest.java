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

package io.maestro3.sdk.v3.request.agent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.agent.wizard.SdkPrivateWizard;
import io.maestro3.sdk.v3.model.agent.wizard.SdkWizardAction;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = PrivateWizardRequest.Builder.class)
public class PrivateWizardRequest implements IRequest {
    private final String wizardId;
    private final String wizardType;
    private SdkPrivateWizard wizard;
    private SdkWizardAction action;
    private final String privateAgentId;

    private PrivateWizardRequest(Builder builder) {
        this.wizardId = builder.wizardId;
        this.privateAgentId = builder.privateAgentId;
        this.wizardType = builder.wizardType;
        this.wizard = builder.wizard;
        this.action = builder.action;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getPrivateAgentId() {
        return privateAgentId;
    }

    public String getWizardId() {
        return wizardId;
    }

    public String getWizardType() {
        return wizardType;
    }

    public SdkPrivateWizard getWizard() {
        return wizard;
    }

    public void setWizard(SdkPrivateWizard wizard) {
        this.wizard = wizard;
    }

    public SdkWizardAction getAction() {
        return action;
    }

    public void setAction(SdkWizardAction action) {
        this.action = action;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.WIZARD_ACTION;
    }

    public static final class Builder {

        private String wizardId;
        private String wizardType;
        private SdkPrivateWizard wizard;
        private SdkWizardAction action;
        private String privateAgentId;

        public Builder withWizardId(String wizardId) {
            this.wizardId = wizardId;
            return this;
        }

        public Builder withWizardType(String wizardType) {
            this.wizardType = wizardType;
            return this;
        }

        public Builder withWizard(SdkPrivateWizard wizard) {
            this.wizard = wizard;
            return this;
        }

        public Builder withAction(SdkWizardAction action) {
            this.action = action;
            return this;
        }

        public Builder withPrivateAgentId(String privateAgentId) {
            this.privateAgentId = privateAgentId;
            return this;
        }

        public PrivateWizardRequest build() {
            return new PrivateWizardRequest(this);
        }
    }
}
