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

public class SdkFixResult {

    private int order;
    private boolean success;
    private String issueDescription;
    private String fixDescription;
    private String errorDescription;
    private Map<String, Object> metadata;

    public SdkFixResult() {
    }

    public SdkFixResult(int order, boolean success, String issueDescription, String fixDescription, String errorDescription) {
        this.success = success;
        this.order = order;
        this.issueDescription = issueDescription;
        this.fixDescription = fixDescription;
        this.errorDescription = errorDescription;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getFixDescription() {
        return fixDescription;
    }

    public void setFixDescription(String fixDescription) {
        this.fixDescription = fixDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
