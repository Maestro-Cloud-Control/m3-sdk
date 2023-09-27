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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkTableRowItem {

    private List<SdkCellItem> cell;

    private Map<String, String> hiddenData;

    private Boolean deleted;

    private SdkTableRowItem() {
        hiddenData = new HashMap<>();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final SdkTableRowItem sdkTableRowItem = new SdkTableRowItem();

        @JsonProperty("cell")
        public Builder withCell(List<SdkCellItem> cell) {
            sdkTableRowItem.cell = cell;
            return this;
        }

        @JsonProperty("deleted")
        public Builder withDeleted(boolean deleted) {
            sdkTableRowItem.deleted = deleted;
            return this;
        }

        @JsonProperty("hiddenData")
        public Builder withHiddenData(String key, String value) {
            sdkTableRowItem.hiddenData.put(key, value);
            return this;
        }

        public SdkTableRowItem build() {
            return sdkTableRowItem;
        }

    }

    public List<SdkCellItem> getCell() {
        return cell;
    }

    public void setCell(List<SdkCellItem> cell) {
        this.cell = cell;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Map<String, String> getHiddenData() {
        return hiddenData;
    }

    @Override
    public String toString() {
        return "TableRowItem{" +
            "cell=" + cell +
            ", deleted=" + deleted +
            '}';
    }

}
