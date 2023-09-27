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

package io.maestro3.sdk.v3.model.agent.wizard.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SdkOptionItem.Builder.class)
public class SdkOptionItem {

    private String value;
    private String name;
    private String title;
    private String description;
    private boolean selected;

    private List<SdkSelectItem> select = new ArrayList<>();
    private List<SdkTextItem> text  = new ArrayList<>();
    @JsonProperty(value = "message")
    private List<SdkMessageItem> sdkMessageItems = new ArrayList<>();
    @JsonProperty(value = "textarea")
    private List<SdkTextAreaItem> textArea = new ArrayList<>();
    private Integer selectedIndex;

    private SdkOptionItem() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final SdkOptionItem sdkOptionItem = new SdkOptionItem();

        @JsonProperty("value")
        public Builder withValue(String value) {
            sdkOptionItem.value = value;
            return this;
        }

        @JsonProperty("name")
        public Builder withName(String name) {
            sdkOptionItem.name = name;
            return this;
        }

        @JsonProperty("title")
        public Builder withTitle(String title) {
            sdkOptionItem.title = title;
            return this;
        }

        @JsonProperty("description")
        public Builder withDescription(String description) {
            sdkOptionItem.description = description;
            return this;
        }

        @JsonProperty("selected")
        public Builder withSelected(Boolean selected) {
            sdkOptionItem.selected = selected;
            return this;
        }

        @JsonProperty("select")
        public Builder withSelect(List<SdkSelectItem> select) {
            sdkOptionItem.select = select;
            return this;
        }

        @JsonIgnore
        public Builder withSelect(SdkSelectItem select) {
            sdkOptionItem.select = Arrays.asList(select);
            return this;
        }

        @JsonProperty("text")
        public Builder withText(List<SdkTextItem> text) {
            sdkOptionItem.text = text;
            return this;
        }

        @JsonProperty("textarea")
        public Builder withTextArea(List<SdkTextAreaItem> textArea) {
            sdkOptionItem.textArea = textArea;
            return this;
        }

        @JsonProperty(value = "message")
        public Builder withMessageItems(List<SdkMessageItem> sdkMessageItems) {
            sdkOptionItem.sdkMessageItems = sdkMessageItems;
            return this;
        }

        @JsonProperty("selectedIndex")
        public Builder withSelectedIndex(Integer selectedIndex) {
            sdkOptionItem.selectedIndex = selectedIndex;
            return this;
        }

        public SdkOptionItem build() {
            return sdkOptionItem;
        }

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SdkMessageItem> getMessageItems() {
        return sdkMessageItems;
    }

    public void setMessageItems(List<SdkMessageItem> sdkMessageItems) {
        this.sdkMessageItems = sdkMessageItems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
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

    public List<SdkTextItem> getText() {
        return text;
    }

    public void setText(List<SdkTextItem> text) {
        this.text = text;
    }

    public List<SdkTextAreaItem> getTextArea() {
        return textArea;
    }

    public void setTextArea(List<SdkTextAreaItem> textArea) {
        this.textArea = textArea;
    }

    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    @Override
    public String toString() {
        return "OptionItem{" +
            "value='" + value + '\'' +
            ", name='" + name + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", selected=" + selected +
            ", select=" + select +
            ", text=" + text +
            ", textarea=" + textArea +
            ", selectedIndex=" + selectedIndex +
            '}';
    }
}
