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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(builder = SdkTableHeaderItem.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkTableHeaderItem {

    private String name;

    private String title;

    private String regExp;

    private Boolean overridable;

    private Boolean disabled;

    private SdkTableHeaderType type;

    private List<SdkOptionItem> option;

    private SdkTableHeaderItem() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final SdkTableHeaderItem sdkTableHeaderItem = new SdkTableHeaderItem();

        @JsonProperty("name")
        public Builder withName(String name) {
            sdkTableHeaderItem.name = name;
            return this;
        }

        @JsonProperty("title")
        public Builder withTitle(String title) {
            sdkTableHeaderItem.title = title;
            return this;
        }

        @JsonProperty("regExp")
        public Builder withRegExp(String regExp) {
            sdkTableHeaderItem.regExp = regExp;
            return this;
        }

        @JsonProperty("overridable")
        public Builder withOverridable(Boolean overridable) {
            sdkTableHeaderItem.overridable = overridable;
            return this;
        }

        @JsonProperty("disabled")
        public Builder withDisabled(Boolean disabled) {
            sdkTableHeaderItem.disabled = disabled;
            return this;
        }

        @JsonProperty("option")
        public Builder withOptions(List<SdkOptionItem> options) {
            sdkTableHeaderItem.option = options;
            return this;
        }

        @JsonProperty("type")
        public Builder withType(SdkTableHeaderType type) {
            sdkTableHeaderItem.type = type;
            return this;
        }

        public SdkTableHeaderItem build() {
            return sdkTableHeaderItem;
        }

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

    public Boolean getOverridable() {
        return overridable;
    }

    public void setOverridable(Boolean overridable) {
        this.overridable = overridable;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public List<SdkOptionItem> getOption() {
        return option;
    }

    public void setOption(List<SdkOptionItem> option) {
        this.option = option;
    }

    public String getRegExp() {
        return regExp;
    }

    public void setRegExp(String regExp) {
        this.regExp = regExp;
    }

    public SdkTableHeaderType getType() {
        return type;
    }

    public void setType(SdkTableHeaderType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TableHeaderItem{" +
            "name='" + name + '\'' +
            ", title='" + title + '\'' +
            ", overridable=" + overridable +
            ", disabled=" + disabled +
            ", option=" + option +
            '}';
    }

}
