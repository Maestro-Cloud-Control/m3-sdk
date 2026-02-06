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

package io.maestro3.sdk.v3.model.reporting.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = TableHeaderCell.Builder.class)
public class TableHeaderCell {

    private final ICellValue cellValue;
    private final TableHeaderViewConfig config;

    protected TableHeaderCell(Builder builder) {
        this.cellValue = builder.cellValue;
        this.config = builder.config;
    }

    public ICellValue getCellValue() {
        return cellValue;
    }

    public TableHeaderViewConfig getConfig() {
        return config;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private ICellValue cellValue;
        private TableHeaderViewConfig config;

        public Builder withCellValue(ICellValue cellValue) {
            this.cellValue = cellValue;
            return this;
        }

        public Builder withConfig(TableHeaderViewConfig config) {
            this.config = config;
            return this;
        }

        public TableHeaderCell build() {
            return new TableHeaderCell(this);
        }

    }

    public static TableHeaderCell of(String value) {
        return TableHeaderCell.builder().withCellValue(StringValue.of(value)).build();
    }

    public static TableHeaderCell of(ICellValue value) {
        return TableHeaderCell.builder().withCellValue(value).build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableHeaderCell)) return false;
        TableHeaderCell that = (TableHeaderCell) o;
        return Objects.equals(cellValue, that.cellValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellValue);
    }
}
