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

@JsonDeserialize(builder = SdkCellItem.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkCellItem {

    private Object value;

    private String title;

    private String placeholder;

    private String hint;

    private Boolean disabled;

    private Boolean isControlCell;

    private Boolean isLocked;

    private SdkCellItem() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final SdkCellItem cellItem = new SdkCellItem();

        @JsonProperty("value")
        public Builder withValue(String value) {
            if (value == null) {
                value = "";
            }
            cellItem.value = value;
            return this;
        }

        @JsonProperty("title")
        public Builder withTitle(String title) {
            cellItem.title = title;
            return this;
        }

        @JsonProperty("placeholder")
        public Builder withPlaceholder(String placeholder) {
            cellItem.placeholder = placeholder;
            return this;
        }

        @JsonProperty("hint")
        public Builder withHint(String hint) {
            cellItem.hint = hint;
            return this;
        }

        @JsonProperty("disabled")
        public Builder withDisabled(Boolean disabled) {
            cellItem.disabled = disabled;
            return this;
        }

        @JsonProperty("isControlCell")
        public Builder withControlCell(Boolean isControlCell) {
            cellItem.isControlCell = isControlCell;
            return this;
        }

        @JsonProperty("isLocked")
        public Builder withLocked(Boolean isLocked) {
            cellItem.isLocked = isLocked;
            return this;
        }

        public SdkCellItem build() {
            return cellItem;
        }

    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getIsControlCell() {
        return isControlCell;
    }

    public void setControlCell(Boolean isControlCell) {
        this.isControlCell = isControlCell;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    @Override
    public String toString() {
        return "CellItem{" +
            "value='" + value + '\'' +
            ", title='" + title + '\'' +
            ", placeholder='" + placeholder + '\'' +
            ", hint='" + hint + '\'' +
            ", disabled=" + disabled +
            ", isControlCell=" + isControlCell +
            ", isLocked=" + isLocked +
            '}';
    }
}
