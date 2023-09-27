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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.maestro3.sdk.v3.model.agent.wizard.item.SdkMessageItem;
import io.maestro3.sdk.v3.model.agent.wizard.item.SdkSelectItem;
import io.maestro3.sdk.v3.model.agent.wizard.item.SdkTableItem;
import io.maestro3.sdk.v3.model.agent.wizard.item.SdkTextAreaItem;
import io.maestro3.sdk.v3.model.agent.wizard.item.SdkTextItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SdkPrivateStepData.Builder.class)
public class SdkPrivateStepData {

    private List<SdkTextItem> text;
    private List<SdkSelectItem> select;
    private List<SdkMessageItem> message;
    @JsonProperty(value = "textarea")
    private List<SdkTextAreaItem> textArea;
    private List<SdkTableItem> table;

    private SdkPrivateStepData() {
        text = new ArrayList<>();
        select = new ArrayList<>();
        textArea = new ArrayList<>();
        message = new ArrayList<>();
        table = new ArrayList<>();
    }

    public void reset() {
        this.text = new ArrayList<>();
        this.textArea = new ArrayList<>();
        this.select = new ArrayList<>();
        this.message = new ArrayList<>();
        this.table = new ArrayList<>();
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {

        private final SdkPrivateStepData stepData = new SdkPrivateStepData();

        @JsonProperty(value = "text")
        public Builder withText(List<SdkTextItem> text) {
            stepData.text = text;
            return this;
        }

        @JsonIgnore
        public Builder withText(SdkTextItem text) {
            stepData.text = Collections.singletonList(text);
            return this;
        }

        @JsonProperty(value = "select")
        public Builder withSelect(List<SdkSelectItem> select) {
            stepData.select = select;
            return this;
        }

        @JsonProperty(value = "table")
        public Builder withTable(List<SdkTableItem> table) {
            stepData.table = table;
            return this;
        }

        @JsonIgnore
        public Builder withSelect(SdkSelectItem select) {
            stepData.select = Collections.singletonList(select);
            return this;
        }

        @JsonProperty(value = "message")
        public Builder withMessage(List<SdkMessageItem> message) {
            stepData.message = message;
            return this;
        }

        @JsonIgnore
        public Builder withMessage(SdkMessageItem message) {
            stepData.message = Collections.singletonList(message);
            return this;
        }

        @JsonProperty(value = "textarea")
        public Builder withTextArea(List<SdkTextAreaItem> textArea) {
            stepData.textArea = textArea;
            return this;
        }

        public SdkPrivateStepData build() {
            return stepData;
        }
    }

    public List<SdkTextItem> getText() {
        return text;
    }

    public void setText(List<SdkTextItem> text) {
        this.text = text;
    }

    public void setText(SdkTextItem text) {
        this.text = new ArrayList<>(Collections.singleton(text));
    }

    public void addText(SdkTextItem text) {
        this.text.add(text);
    }
    public void addText(List<SdkTextItem> text) {
        this.text.addAll(text);
    }

    public List<SdkSelectItem> getSelect() {
        return select;
    }

    public void setSelect(List<SdkSelectItem> select) {
        this.select = select;
    }

    public void setSelect(SdkSelectItem select) {
        this.select = new ArrayList<>(Collections.singleton(select));
    }

    public void addSelect(SdkSelectItem... sdkSelectItems) {
        this.select.addAll(Arrays.asList(sdkSelectItems));
    }

    public void addSelect(SdkSelectItem select) {
        this.select.add(select);
    }

    public List<SdkTableItem> getTable() {
        return table;
    }

    public void setTable(List<SdkTableItem> table) {
        this.table = table;
    }

    public List<SdkMessageItem> getMessage() {
        return message;
    }

    public void setMessage(List<SdkMessageItem> message) {
        this.message = message;
    }

    public void setMessage(SdkMessageItem message) {
        if (message != null) {
            this.message = new ArrayList<>(Collections.singleton(message));
        }
    }

    public List<SdkTextAreaItem> getTextArea() {
        return textArea;
    }

    public void setTextArea(List<SdkTextAreaItem> textArea) {
        this.textArea = textArea;
    }

    public void setTextArea(SdkTextAreaItem textArea) {
        this.textArea = new ArrayList<>(Collections.singleton(textArea));
    }

    public void addTextArea(SdkTextAreaItem textArea) {
        this.textArea.add(textArea);
    }

}
