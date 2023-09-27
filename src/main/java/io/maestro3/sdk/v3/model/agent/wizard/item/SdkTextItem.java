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
@JsonDeserialize(builder = SdkTextItem.Builder.class)
public class SdkTextItem {

    private String name;
    private String title;
    private String value;
    private String description;
    private String zOrder;
    private String serverError;
    private String regExp;
    private String placeholder;
    private String clientError;
    private String type;
    private Boolean visible;
    private boolean required;


    private SdkTextItem() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private SdkTextItem sdkTextItem = new SdkTextItem();

        @JsonProperty("title")
        public Builder withTitle(String title) {
            if (title == null) {
                title = "";
            }
            sdkTextItem.title = title;
            return this;
        }
        @JsonProperty("visible")
        public Builder withVisible(Boolean visible) {
            sdkTextItem.visible = visible;
            return this;
        }

        @JsonProperty("required")
        public Builder withRequired(Boolean required) {
            sdkTextItem.required = required;
            return this;
        }

        @JsonProperty("value")
        public Builder withValue(String value) {
            sdkTextItem.value = value;
            return this;
        }

        @JsonProperty("type")
        public Builder withType(String type) {
            sdkTextItem.type = type;
            return this;
        }

        @JsonProperty("zOrder")
        public Builder withOrder(String order) {
            sdkTextItem.zOrder = order;
            return this;
        }

        @JsonProperty("name")
        public Builder withName(String name) {
            sdkTextItem.name = name;
            return this;
        }

        @JsonProperty("serverError")
        public Builder withServerError(String serverError) {
            sdkTextItem.serverError = serverError;
            return this;
        }

        @JsonProperty("clientError")
        public Builder withClientError(String clientError) {
            sdkTextItem.clientError = clientError;
            return this;
        }

        @JsonProperty("regExp")
        public Builder withRegExp(String regExp) {
            sdkTextItem.regExp = regExp;
            return this;
        }

        @JsonProperty("description")
        public Builder withDescription(String description) {
            sdkTextItem.description = description;
            return this;
        }

        @JsonProperty("placeholder")
        public Builder withPlaceholder(String placeholder) {
            sdkTextItem.placeholder = placeholder;
            return this;
        }

        public SdkTextItem build() {
            return sdkTextItem;
        }

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


    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getzOrder() {
        return zOrder;
    }

    public String getClientError() {
        return clientError;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void setClientError(String clientError) {
        this.clientError = clientError;
    }

    public void setzOrder(String zOrder) {
        this.zOrder = zOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServerError() {
        return serverError;
    }

    public void setServerError(String serverError) {
        this.serverError = serverError;
    }

    public String getRegExp() {
        return regExp;
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

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public String toString() {
        return "TextItem{" +
            "title='" + title + '\'' +
            ", value='" + value + '\'' +
            ", zOrder='" + zOrder + '\'' +
            ", name='" + name + '\'' +
            ", serverError='" + serverError + '\'' +
            ", regExp='" + regExp + '\'' +
            ", description='" + description + '\'' +
            ", placeholder='" + placeholder + '\'' +
            '}';
    }
}
