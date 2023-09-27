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

package io.maestro3.sdk.v3.model.onboarding;

public class SdkOnboardingStep {

    private String description;
    private SdkStepStatus status;
    private String error;
    private String adminCommand;

    public SdkOnboardingStep() {
    }

    public SdkOnboardingStep(String description, SdkStepStatus status) {
        this.description = description;
        this.status = status;
    }

    public SdkOnboardingStep(String description, SdkStepStatus status, String error, String adminCommand) {
        this.description = description;
        this.status = status;
        this.error = error;
        this.adminCommand = adminCommand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SdkStepStatus getStatus() {
        return status;
    }

    public void setStatus(SdkStepStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAdminCommand() {
        return adminCommand;
    }

    public void setAdminCommand(String adminCommand) {
        this.adminCommand = adminCommand;
    }
}
