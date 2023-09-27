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

package io.maestro3.sdk.v3.request.ssh;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Date;

@JsonDeserialize(builder = ChangeKeyStatusRequest.Builder.class)
public class ChangeKeyStatusRequest implements IRequest {

    private final String fingerPrint;
    private final String newStatusName;
    private final Date jobExecutionDate;
    private final String email;
    private final String keyName;

    private ChangeKeyStatusRequest(Builder builder) {
        this.fingerPrint = builder.fingerPrint;
        this.newStatusName = builder.newStatusName;
        this.jobExecutionDate = builder.jobExecutionDate;
        this.email = builder.email;
        this.keyName = builder.keyName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public Date getJobExecutionDate() {
        return jobExecutionDate;
    }

    public String getNewStatusName() {
        return newStatusName;
    }

    public String getEmail() {
        return email;
    }

    public String getKeyName() {
        return keyName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CHANGE_KEY_STATUS;
    }

    public static final class Builder {

        private String fingerPrint;
        private String newStatusName;
        private Date jobExecutionDate;
        private String email;
        private String keyName;

        public ChangeKeyStatusRequest.Builder withFingerPrint(String fingerPrint) {
            this.fingerPrint = fingerPrint;
            return this;
        }

        public ChangeKeyStatusRequest.Builder withNewStatusName(String newStatusName) {
            this.newStatusName = newStatusName;
            return this;
        }

        public ChangeKeyStatusRequest.Builder withJobExecutionDate(Date jobExecutionDate) {
            this.jobExecutionDate = jobExecutionDate;
            return this;
        }

        public ChangeKeyStatusRequest.Builder withKeyName(String keyName) {
            this.keyName = keyName;
            return this;
        }

        public ChangeKeyStatusRequest.Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ChangeKeyStatusRequest build() {
            return new ChangeKeyStatusRequest(this);
        }
    }
}
