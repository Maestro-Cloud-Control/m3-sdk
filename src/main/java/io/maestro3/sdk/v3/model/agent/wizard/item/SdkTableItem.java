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

@JsonDeserialize(builder = SdkTableItem.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkTableItem {

    private String name;

    private String title;

    private String serverError;

    private String description;

    private String zOrder;

    private Boolean canAdd;

    private Boolean canRemove;

    private List<SdkTableHeaderItem> headers;

    private List<SdkTableRowItem> row;

    private SdkTableItem() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final SdkTableItem sdkTableItem = new SdkTableItem();

        @JsonProperty("name")
        public Builder withName(String name) {
            sdkTableItem.name = name;
            return this;
        }

        @JsonProperty("title")
        public Builder withTitle(String title) {
            sdkTableItem.title = title;
            return this;
        }

        @JsonProperty("serverError")
        public Builder withServerError(String serverError) {
            sdkTableItem.serverError = serverError;
            return this;
        }

        @JsonProperty("description")
        public Builder withDescription(String description) {
            sdkTableItem.description = description;
            return this;
        }

        @JsonProperty("zOrder")
        public Builder withOrder(String order) {
            sdkTableItem.zOrder = order;
            return this;
        }

        @JsonProperty("canAdd")
        public Builder withCanAdd(Boolean canAdd) {
            sdkTableItem.canAdd = canAdd;
            return this;
        }

        @JsonProperty("canRemove")
        public Builder withCanRemove(Boolean canRemove) {
            sdkTableItem.canRemove = canRemove;
            return this;
        }

        @JsonProperty("headers")
        public Builder withHeaders(List<SdkTableHeaderItem> headers) {
            sdkTableItem.headers = headers;
            return this;
        }

        @JsonProperty("row")
        public Builder withRow(List<SdkTableRowItem> row) {
            sdkTableItem.row = row;
            return this;
        }

        public SdkTableItem build() {
            return sdkTableItem;
        }

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TableItem{" +
            "name='" + name + '\'' +
            ", title='" + title + '\'' +
            ", serverError='" + serverError + '\'' +
            ", description='" + description + '\'' +
            ", zOrder='" + zOrder + '\'' +
            ", canAdd=" + canAdd +
            ", canRemove=" + canRemove +
            ", headers=" + headers +
            ", row=" + row +
            '}';
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

    public String getzOrder() {
        return zOrder;
    }

    public void setzOrder(String zOrder) {
        this.zOrder = zOrder;
    }

    public Boolean getCanAdd() {
        return canAdd;
    }

    public void setCanAdd(Boolean canAdd) {
        this.canAdd = canAdd;
    }

    public Boolean getCanRemove() {
        return canRemove;
    }

    public void setCanRemove(Boolean canRemove) {
        this.canRemove = canRemove;
    }

    public List<SdkTableHeaderItem> getHeaders() {
        return headers;
    }

    public void setHeaders(List<SdkTableHeaderItem> headers) {
        this.headers = headers;
    }

    public List<SdkTableRowItem> getRow() {
        return row;
    }

    public void setRow(List<SdkTableRowItem> row) {
        this.row = row;
    }

    public String getServerError() {
        return serverError;
    }

    public void setServerError(String serverError) {
        this.serverError = serverError;
    }
}
