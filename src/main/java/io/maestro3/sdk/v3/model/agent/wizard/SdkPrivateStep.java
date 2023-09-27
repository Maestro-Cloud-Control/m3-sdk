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

package io.maestro3.sdk.v3.model.agent.wizard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SdkPrivateStep.Builder.class)
public class SdkPrivateStep {

    private Integer id;
    private String title;
    private String description;
    private SdkPrivateStepData data;

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {

        private final SdkPrivateStep step = new SdkPrivateStep();

        @JsonProperty("id")
        public Builder withId(Integer id) {
            step.id = id;
            return this;
        }

        @JsonProperty(value = "title")
        public Builder withTitle(String title) {
            step.title = title;
            return this;
        }

        @JsonProperty(value = "description")
        public Builder withDescription(String description) {
            step.description = description;
            return this;
        }

        @JsonProperty(value = "data")
        public Builder withData(SdkPrivateStepData data) {
            step.data = data;
            return this;
        }

        public SdkPrivateStep build() {
            return step;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SdkPrivateStepData getData() {
        return data;
    }

    public void setData(SdkPrivateStepData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SdkPrivateStep{" +
            "id=" + id +
            ", title='" + title + '\'' +
            '}';
    }
}
