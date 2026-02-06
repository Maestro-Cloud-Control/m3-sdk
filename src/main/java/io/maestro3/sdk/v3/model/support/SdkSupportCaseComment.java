/*
 * Copyright 2024 Softline Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.model.support;

public class SdkSupportCaseComment {
    private String message;
    private String submittedBy;
    private long submittedOn;

    public SdkSupportCaseComment() {
        // For JSON
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public long getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(long submittedOn) {
        this.submittedOn = submittedOn;
    }

    @Override
    public String toString() {
        return "SdkSupportCaseComment{" +
                "message='" + message + '\'' +
                ", submittedBy='" + submittedBy + '\'' +
                ", submittedOn=" + submittedOn +
                '}';
    }
}
