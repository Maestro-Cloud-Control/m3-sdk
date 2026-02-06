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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableHeaderViewConfig {
    public static final String CONTROL_TYPE_FILTER = "filter";
    public static final String CONTROL_TYPE_SORT = "sort";

    public static final String ALIGN_LEFT = "left";
    public static final String ALIGN_CENTER = "center";
    public static final String ALIGN_RIGHT = "right";
    public static final String DEFAULT_ALIGN = ALIGN_CENTER;

    private static final String NUMBER_FORMAT_COST = "{0,number,currency}";
    private static final String PERCENT_FORMAT_COST = "{0,number,percent}";
    private static final String NUMBER_FORMAT_USAGE = "{0,number,#,##0.00}";
    private static final String CURRENCY_UNIT = System.getProperty("DEFAULT_CURRENCY", "$,USD").split(",")[1];

    private String controlType;
    private String unit;
    private String align;
    private String valueFormat;
    private Double widthInPercents;
    private Boolean sortColumn;
    private Boolean compareWithPreviousColumn;
    private BigDecimal compareWithPreviousColumnThreshold;
    private String compareWithPreviousColumnColor;
    private BigDecimal cellBoldThreshold;
    private Boolean columnWithTrend;
    private Boolean hidden;
    private String cellType;
    @JsonIgnore
    private Function<List<TableCell>, TableCell> mergeFunction;

    public static Builder builder() {
        return new Builder();
    }

    public TableHeaderViewConfig() {
    }

    private TableHeaderViewConfig(Builder builder) {
        this.controlType = builder.controlType;
        this.unit = builder.unit;
        this.align = builder.align;
        this.valueFormat = builder.valueFormat;
        this.widthInPercents = builder.widthInPercents;
        this.sortColumn = builder.sortColumn;
        this.compareWithPreviousColumn = builder.compareWithPreviousColumn;
        this.compareWithPreviousColumnThreshold = builder.compareWithPreviousColumnThreshold;
        this.compareWithPreviousColumnColor = builder.compareWithPreviousColumnColor;
        this.cellBoldThreshold = builder.cellBoldThreshold;
        this.columnWithTrend = builder.columnWithTrend;
        this.hidden = builder.hidden;
        this.cellType = builder.cellType;
        this.mergeFunction = builder.mergeFunction;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getValueFormat() {
        return valueFormat;
    }

    public void setValueFormat(String valueFormat) {
        this.valueFormat = valueFormat;
    }

    public Double getWidthInPercents() {
        return widthInPercents;
    }

    public void setWidthInPercents(Double widthInPercents) {
        this.widthInPercents = widthInPercents;
    }

    public Boolean getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(Boolean sortColumn) {
        this.sortColumn = sortColumn;
    }

    public Boolean getCompareWithPreviousColumn() {
        return compareWithPreviousColumn;
    }

    public void setCompareWithPreviousColumn(Boolean compareWithPreviousColumn) {
        this.compareWithPreviousColumn = compareWithPreviousColumn;
    }

    public BigDecimal getCompareWithPreviousColumnThreshold() {
        return compareWithPreviousColumnThreshold;
    }

    public void setCompareWithPreviousColumnThreshold(BigDecimal compareWithPreviousColumnThreshold) {
        this.compareWithPreviousColumnThreshold = compareWithPreviousColumnThreshold;
    }

    public String getCompareWithPreviousColumnColor() {
        return compareWithPreviousColumnColor;
    }

    public void setCompareWithPreviousColumnColor(String compareWithPreviousColumnColor) {
        this.compareWithPreviousColumnColor = compareWithPreviousColumnColor;
    }

    public BigDecimal getCellBoldThreshold() {
        return cellBoldThreshold;
    }

    public void setCellBoldThreshold(BigDecimal cellBoldThreshold) {
        this.cellBoldThreshold = cellBoldThreshold;
    }

    public Boolean getColumnWithTrend() {
        return columnWithTrend;
    }

    public void setColumnWithTrend(Boolean columnWithTrend) {
        this.columnWithTrend = columnWithTrend;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getCellType() {
        return cellType;
    }

    public void setCellType(String cellType) {
        this.cellType = cellType;
    }

    public Function<List<TableCell>, TableCell> getMergeFunction() {
        return mergeFunction;
    }

    public void setMergeFunction(Function<List<TableCell>, TableCell> mergeFunction) {
        this.mergeFunction = mergeFunction;
    }

    public static class Builder {
        private String controlType;
        private String unit;
        private String align = DEFAULT_ALIGN;
        private String valueFormat;
        private Double widthInPercents;
        private Boolean sortColumn;
        private Boolean compareWithPreviousColumn;
        private BigDecimal compareWithPreviousColumnThreshold;
        private String compareWithPreviousColumnColor;
        private BigDecimal cellBoldThreshold;
        private Boolean columnWithTrend;
        private Boolean hidden;
        private String cellType;
        private Function<List<TableCell>, TableCell> mergeFunction;

        public Builder withUnit(String unit) {
            this.unit = unit;
            return this;
        }

        public Builder withSortControl() {
            this.controlType = CONTROL_TYPE_SORT;
            return this;
        }

        public Builder withFilterControl() {
            this.controlType = CONTROL_TYPE_FILTER;
            return this;
        }

        public Builder withLeftAlign() {
            this.align = ALIGN_LEFT;
            return this;
        }

        public Builder withRightAlign() {
            this.align = ALIGN_RIGHT;
            return this;
        }

        public Builder withCenterAlign() {
            this.align = ALIGN_CENTER;
            return this;
        }

        public Builder withWidthInPercents(double widthInPercents) {
            this.widthInPercents = widthInPercents;
            return this;
        }

        public Builder withValueFormat(String valueFormat) {
            this.valueFormat = valueFormat;
            return this;
        }

        public Builder withSortColumn() {
            this.sortColumn = true;
            return this;
        }

        public Builder withCompareWithPreviousColumn() {
            this.compareWithPreviousColumn = true;
            this.compareWithPreviousColumnThreshold = BigDecimal.valueOf(1.1d);
            return this;
        }

        public Builder withCompareWithPreviousColumnWithColor(String color) {
            this.compareWithPreviousColumn = true;
            this.compareWithPreviousColumnThreshold = BigDecimal.valueOf(1.1d);
            this.compareWithPreviousColumnColor = color;
            return this;
        }

        public Builder withCellBoldThreshold(BigDecimal cellBoldThreshold) {
            this.cellBoldThreshold = cellBoldThreshold;
            return this;
        }

        @Deprecated
        public Builder withColumnWithTrend() {
            this.columnWithTrend = true;
            return this;
        }

        public Builder withHidden() {
            this.hidden = true;
            return this;
        }

        public Builder withCellType(String cellType) {
            this.cellType = cellType;
            return this;
        }

        public Builder withMergeFunction(Function<List<TableCell>, TableCell> mergeFunction) {
            this.mergeFunction = mergeFunction;
            return this;
        }

        public TableHeaderViewConfig build() {
            return new TableHeaderViewConfig(this);
        }
    }

    public static TableHeaderViewConfig.Builder resourceIdHeader(double widthInPercents) {
        return TableHeaderViewConfig.builder()
            .withLeftAlign()
            .withFilterControl()
            .withWidthInPercents(widthInPercents);
    }

    public static TableHeaderViewConfig.Builder regionHeader(double widthInPercents) {
        return TableHeaderViewConfig.builder()
            .withLeftAlign()
            .withFilterControl()
            .withWidthInPercents(widthInPercents);
    }

    public static TableHeaderViewConfig.Builder countHeader(double widthInPercents) {
        return TableHeaderViewConfig.builder()
            .withRightAlign()
            .withSortControl()
            .withWidthInPercents(widthInPercents);
    }

    public static TableHeaderViewConfig.Builder usageHeader(double widthInPercents) {
        return TableHeaderViewConfig.builder()
            .withRightAlign()
            .withSortControl()
            .withValueFormat(NUMBER_FORMAT_USAGE)
            .withWidthInPercents(widthInPercents);
    }

    public static TableHeaderViewConfig.Builder percentHeader(double widthInPercents) {
        return TableHeaderViewConfig.builder()
            .withRightAlign()
            .withSortControl()
            .withValueFormat(PERCENT_FORMAT_COST)
            .withWidthInPercents(widthInPercents)
            .withSortColumn();
    }

    public static TableHeaderViewConfig.Builder costHeader(double widthInPercents) {
        return TableHeaderViewConfig.builder()
            .withRightAlign()
            .withSortControl()
            .withUnit(CURRENCY_UNIT)
            .withValueFormat(NUMBER_FORMAT_COST)
            .withWidthInPercents(widthInPercents)
            .withSortColumn();
    }

    public static TableHeaderViewConfig.Builder defaultHeader(double widthInPercents) {
        return TableHeaderViewConfig.builder()
            .withCenterAlign()
            .withWidthInPercents(widthInPercents);
    }

    public static TableHeaderViewConfig.Builder textHeader(double widthInPercents) {
        return TableHeaderViewConfig.builder()
            .withLeftAlign()
            .withFilterControl()
            .withWidthInPercents(widthInPercents);
    }
}
