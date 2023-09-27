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

package io.maestro3.sdk.v3.core;

import java.util.Map;

public class ApprovalResult {

    private String message;
    private ResultStatus status;
    private String jobId;
    private ApprovalActionType actionType;
    private Map<String, Object> placeHolders;
    private String markUpMessage;

    public ApprovalResult() {
    }

    public ApprovalResult(String message, ResultStatus status) {
        this.message = message;
        this.status = status;
    }

    public ApprovalResult(String message, ResultStatus status, ApprovalActionType actionType) {
        this(message, status);
        this.actionType = actionType;
    }

    public ApprovalResult(String message,
                          ResultStatus status,
                          String jobId,
                          ApprovalActionType actionType,
                          Map<String, Object> placeHolders,
                          String markUpMessage) {
        this.message = message;
        this.status = status;
        this.jobId = jobId;
        this.actionType = actionType;
        this.placeHolders = placeHolders;
        this.markUpMessage = markUpMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public ApprovalActionType getActionType() {
        return actionType;
    }

    public void setActionType(ApprovalActionType actionType) {
        this.actionType = actionType;
    }

    public Map<String, Object> getPlaceHolders() {
        return placeHolders;
    }

    public void setPlaceHolders(Map<String, Object> placeHolders) {
        this.placeHolders = placeHolders;
    }

    public String getMarkUpMessage() {
        return markUpMessage;
    }

    public void setMarkUpMessage(String markUpMessage) {
        this.markUpMessage = markUpMessage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String message;
        private ResultStatus status;
        private String jobId;
        private ApprovalActionType actionType;
        private Map<String, Object> placeHolders;
        private String markUpMessage;

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withStatus(ResultStatus status) {
            this.status = status;
            return this;
        }

        public Builder withJobId(String jobId) {
            this.jobId = jobId;
            return this;
        }

        public Builder withActionType(ApprovalActionType actionType) {
            this.actionType = actionType;
            return this;
        }

        public Builder withPlaceHolders(Map<String, Object> placeHolders) {
            this.placeHolders = placeHolders;
            return this;
        }

        public Builder withMarkUpMessage(String markUpMessage) {
            this.markUpMessage = markUpMessage;
            return this;
        }

        public ApprovalResult build() {
            return new ApprovalResult(message,
                status,
                jobId,
                actionType,
                placeHolders,
                markUpMessage);
        }
    }

    @Override
    public String toString() {
        return "ApprovalResult{" +
            "message='" + message + '\'' +
            ", status=" + status +
            ", jobId='" + jobId + '\'' +
            ", actionType=" + actionType +
            ", placeHolders=" + placeHolders +
            ", markUpMessage='" + markUpMessage + '\'' +
            '}';
    }
}
