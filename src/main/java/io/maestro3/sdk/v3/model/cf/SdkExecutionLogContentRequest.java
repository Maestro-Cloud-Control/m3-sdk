/*
 * Copyright 2024 Maestro Cloud Control LLC
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
package io.maestro3.sdk.v3.model.cf;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = SdkExecutionLogContentRequest.Builder.class)
public class SdkExecutionLogContentRequest {

    private final String initiator;
    private final Long timestamp;
    private final String stackId;
    private final String templateTask;

    private SdkExecutionLogContentRequest(Builder builder) {
        this.initiator = builder.initiator;
        this.timestamp = builder.timestamp;
        this.stackId = builder.stackId;
        this.templateTask = builder.templateTask;
    }

    public String getInitiator() {
        return initiator;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getStackId() {
        return stackId;
    }

    public String getTemplateTask() {
        return templateTask;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String initiator;
        private Long timestamp;
        private String stackId;
        private String templateTask;

        public Builder withInitiator(String initiator) {
            this.initiator = initiator;
            return this;
        }

        public Builder withTimestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withStackId(String stackId) {
            this.stackId = stackId;
            return this;
        }

        public Builder withTemplateTask(String templateTask) {
            this.templateTask = templateTask;
            return this;
        }

        public SdkExecutionLogContentRequest build() {
            return new SdkExecutionLogContentRequest(this);
        }

    }

}
