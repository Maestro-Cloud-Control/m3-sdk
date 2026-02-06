/*
 * Copyright 2024 Maestro Cloud Control LLC
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = TableCell.Builder.class)
public class TableCell {

    private final ICellValue cellValue;
    private final Boolean empty;
    private final TableCellConfig config;

    protected TableCell(Builder builder) {
        this.cellValue = builder.cellValue;
        this.empty = builder.empty;
        this.config = builder.config;
    }

    public ICellValue getCellValue() {
        return cellValue;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public TableCellConfig getConfig() {
        return config;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnore
    public Builder toBuilder() {
        return new Builder().withCellValue(this.cellValue).withEmpty(this.empty).withConfig(this.config);
    }

    public static class Builder {

        private ICellValue cellValue;
        private Boolean empty;
        private TableCellConfig config;

        public Builder withCellValue(ICellValue cellValue) {
            this.cellValue = cellValue;
            return this;
        }

        public Builder withEmpty(Boolean empty) {
            this.empty = empty;
            return this;
        }

        public Builder withConfig(TableCellConfig config) {
            this.config = config;
            return this;
        }

        public TableCell build() {
            return new TableCell(this);
        }

    }

    public static TableCell textCell(String value) {
        return builder().withCellValue(StringValue.of(value)).build();
    }

    public static TableCell emptyTextCell(String value) {
        return builder().withCellValue(StringValue.of(value)).withEmpty(true).build();
    }

    public static TableCell numberCell(int value) {
        return builder().withCellValue(NumberValue.of(value)).build();
    }

    public static TableCell numberCell(double value) {
        return builder().withCellValue(NumberValue.of(value)).build();
    }

    public static TableCell numberCell(BigDecimal value) {
        return builder().withCellValue(NumberValue.of(value)).build();
    }

    public static TableCell textWithHrefCell(String value, String href) {
        return builder().withCellValue(StringValue.of(value)).withConfig(TableCellConfig.hrefCellConfig(href)).build();
    }

    public static TableCell actionCell(String value, String actionLink) {
        return builder().withCellValue(StringValue.of(value)).withConfig(TableCellConfig.actionCellConfig(actionLink)).build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableCell)) return false;
        TableCell tableCell = (TableCell) o;
        return Objects.equals(cellValue, tableCell.cellValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cellValue);
    }
}
