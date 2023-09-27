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

package io.maestro3.sdk.v3.model.agent.diagnostic;

import java.util.Map;

public class SdkCheckResult {
    private int order;
    private String description;
    private String errorMessage;
    private boolean success;
    private boolean fixable;
    private String checkerName;
    private String fixMessage;
    private Map<String, Object> metadata;

    public SdkCheckResult() {
    }

    public SdkCheckResult(int order, String description, String checkerName) {
        this.order = order;
        this.description = description;
        this.checkerName = checkerName;
    }

    public String getFixMessage() {
        return fixMessage;
    }

    public void setFixMessage(String fixMessage) {
        this.fixMessage = fixMessage;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFixable() {
        return fixable;
    }

    public void setFixable(boolean fixable) {
        this.fixable = fixable;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
