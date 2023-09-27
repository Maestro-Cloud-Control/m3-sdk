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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SdkSelectItem.Builder.class)
public class SdkSelectItem {

    private String name;
    private String title;
    private String type;
    private String zOrder;
    private String description;
    private String serverError;
    private String value;
    private Boolean multiple;
    private List<SdkOptionItem> option;
    private Integer selectedIndex;

    public SdkSelectItem() {
        option = new ArrayList<>();
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Builder {

        private final SdkSelectItem sdkSelectItem = new SdkSelectItem();

        @JsonProperty("name")
        public Builder withName(String name) {
            sdkSelectItem.name = name;
            return this;
        }

        @JsonProperty("title")
        public Builder withTitle(String title) {
            sdkSelectItem.title = title;
            return this;
        }

        @JsonProperty("type")
        public Builder withType(String type) {
            sdkSelectItem.type = type;
            return this;
        }

        @JsonProperty("zOrder")
        public Builder withOrder(String order) {
            sdkSelectItem.zOrder = order;
            return this;
        }

        @JsonProperty("description")
        public Builder withDescription(String description) {
            sdkSelectItem.description = description;
            return this;
        }

        @JsonProperty("serverError")
        public Builder withServerError(String serverError) {
            sdkSelectItem.serverError = serverError;
            return this;
        }

        @JsonProperty("value")
        public Builder withValue(String value) {
            sdkSelectItem.value = value;
            return this;
        }

        @JsonProperty("multiple")
        public Builder withMultiple(Boolean multiple) {
            sdkSelectItem.multiple = multiple;
            return this;
        }

        @JsonProperty("option")
        public Builder withOptions(List<SdkOptionItem> options) {
            sdkSelectItem.option = options;
            return this;
        }

        @JsonProperty("selectedIndex")
        public Builder withSelectedIndex(Integer selectedIndex) {
            sdkSelectItem.selectedIndex = selectedIndex;
            return this;
        }

        public SdkSelectItem build() {
            return sdkSelectItem;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getzOrder() {
        return zOrder;
    }

    public void setzOrder(String zOrder) {
        this.zOrder = zOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServerError() {
        return serverError;
    }

    public void setServerError(String serverError) {
        this.serverError = serverError;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getMultiple() {
        return multiple;
    }

    public void setMultiple(Boolean multiple) {
        this.multiple = multiple;
    }

    public List<SdkOptionItem> getOption() {
        return option;
    }

    public void setOption(List<SdkOptionItem> option) {
        this.option = option;
    }

    public void setOption(SdkOptionItem option) {
        this.option = new ArrayList<>(Collections.singleton(option));
    }

    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public void sortOptions() {
        this.option = option.stream()
            .sorted(Comparator.comparing(SdkOptionItem::getValue))
            .collect(Collectors.toList());
    }

}
