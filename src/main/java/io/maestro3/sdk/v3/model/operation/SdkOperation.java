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

package io.maestro3.sdk.v3.model.operation;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.maestro3.sdk.v3.core.ResultStatus;

public class SdkOperation {
    private String id;
    private boolean done;
    private Object response;
    private String error;
    private long createdTimestamp;
    private long startedTimestamp;
    private long processTimestamp;
    private ResultStatus status;

    public SdkOperation() {
        // JSON
    }

    public SdkOperation(SdkOperation clone) {
        this.id = clone.getId();
        this.done = clone.isDone();
        this.response = clone.getResponse();
        this.error = clone.getError();
        this.createdTimestamp = clone.getCreatedTimestamp();
        this.startedTimestamp = clone.getStartedTimestamp();
        this.processTimestamp = clone.getProcessTimestamp();
        this.status = clone.getStatus();
    }

    public SdkOperation withId(String id) {
        this.id = id;
        return this;
    }

    public SdkOperation withDone(boolean done) {
        this.done = done;
        return this;
    }

    public SdkOperation withResponse(Object response) {
        this.response = response;
        return this;
    }

    public SdkOperation withError(String error) {
        this.error = error;
        return this;
    }

    public SdkOperation withCreatedTimestamp(long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
        return this;
    }

    public SdkOperation withStartedTimestamp(long startedTimestamp) {
        this.startedTimestamp = startedTimestamp;
        return this;
    }

    public SdkOperation withProcessTimestamp(long processTimestamp) {
        this.processTimestamp = processTimestamp;
        return this;
    }

    public SdkOperation withStatus(ResultStatus status) {
        this.status = status;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public long getStartedTimestamp() {
        return startedTimestamp;
    }

    public void setStartedTimestamp(long startedTimestamp) {
        this.startedTimestamp = startedTimestamp;
    }

    public long getProcessTimestamp() {
        return processTimestamp;
    }

    public void setProcessTimestamp(long processTimestamp) {
        this.processTimestamp = processTimestamp;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Operation{" +
            "id='" + id + '\'' +
            ", done=" + done +
            ", response=" + response +
            ", error='" + error + '\'' +
            ", createdTimestamp=" + createdTimestamp +
            ", processTimestamp=" + processTimestamp +
            ", status=" + status +
            '}';
    }

    public enum Status {
        PENDING,
        SUCCESS,
        FAILED,
        PROCESSING,
        POSTPONED;

        @JsonCreator
        public static Status fromValue(String name) {
            for (Status status : values()) {
                if (status.name().equalsIgnoreCase(name)) {
                    return status;
                }
            }
            return null;
        }
    }
}
