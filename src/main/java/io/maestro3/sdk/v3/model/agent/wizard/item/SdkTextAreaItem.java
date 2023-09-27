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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SdkTextAreaItem.Builder.class)
public class SdkTextAreaItem {

    private String name;
    private String title;
    private String value;
    private String regExp;
    private String serverError;
    private String zOrder;
    private String placeholder;
    private String description;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final SdkTextAreaItem sdkTextAreaItem = new SdkTextAreaItem();

        @JsonProperty("name")
        public Builder withName(String name) {
            sdkTextAreaItem.name = name;
            return this;
        }

        @JsonProperty("title")
        public Builder withTitle(String title) {
            sdkTextAreaItem.title = title;
            return this;
        }

        @JsonProperty("value")
        public Builder withValue(String value) {
            sdkTextAreaItem.value = value;
            return this;
        }

        @JsonProperty("serverError")
        public Builder withServerError(String serverError) {
            sdkTextAreaItem.serverError = serverError;
            return this;
        }

        @JsonProperty("regExp")
        public Builder withRegExp(String regExp) {
            sdkTextAreaItem.regExp = regExp;
            return this;
        }

        @JsonProperty("zOrder")
        public Builder withOrder(String order) {
            sdkTextAreaItem.zOrder = order;
            return this;
        }

        @JsonProperty("placeholder")
        public Builder withPlaceholder(String placeholder) {
            sdkTextAreaItem.placeholder = placeholder;
            return this;
        }

        @JsonProperty("description")
        public Builder withDescription(String description) {
            sdkTextAreaItem.description = description;
            return this;
        }

        public SdkTextAreaItem build() {
            return sdkTextAreaItem;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRegExp() {
        return regExp;
    }


    public String getServerError() {
        return serverError;
    }

    public void setServerError(String serverError) {
        this.serverError = serverError;
    }

    public String getzOrder() {
        return zOrder;
    }

    public void setzOrder(String zOrder) {
        this.zOrder = zOrder;
    }


    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public void setRegExp(String regExp) {
        this.regExp = regExp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TextAreaItem{" +
            "name='" + name + '\'' +
            ", title='" + title + '\'' +
            ", value='" + value + '\'' +
            ", serverError='" + serverError + '\'' +
            ", zOrder='" + zOrder + '\'' +
            ", description='" + description + "'" +
            '}';
    }

}
