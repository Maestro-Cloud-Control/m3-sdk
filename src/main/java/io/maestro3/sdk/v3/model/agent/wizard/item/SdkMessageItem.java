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

@JsonDeserialize(builder = SdkMessageItem.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkMessageItem {

    private String name;
    private String value;
    private String zOrder;
    private String type;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final SdkMessageItem sdkMessageItem = new SdkMessageItem();

        @JsonProperty("name")
        public Builder withName(String name) {
            sdkMessageItem.name = name;
            return this;
        }

        @JsonProperty("value")
        public Builder withValue(String value) {
            sdkMessageItem.value = value;
            return this;
        }

        @JsonProperty("zOrder")
        public Builder withOrder(String order) {
            sdkMessageItem.zOrder = order;
            return this;
        }

        @JsonProperty("type")
        public Builder withType(String messageType) {
            sdkMessageItem.type = messageType;
            return this;
        }

        public SdkMessageItem build() {
            return sdkMessageItem;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getzOrder() {
        return zOrder;
    }

    public void setzOrder(String zOrder) {
        this.zOrder = zOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MessageItem{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", zOrder='" + zOrder + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
