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

import java.math.BigDecimal;

public class TableHeaderViewConfig {
    public static final String CONTROL_TYPE_FILTER = "filter";
    public static final String CONTROL_TYPE_SORT = "sort";

    public static final String ALIGN_LEFT = "left";
    public static final String ALIGN_CENTER = "center";
    public static final String ALIGN_RIGHT = "right";
    public static final String DEFAULT_ALIGN = ALIGN_CENTER;

    private static final String NUMBER_FORMAT_COST = "{0,number,#,##0.00}";
    private static final String NUMBER_FORMAT_USAGE = "{0,number,#,##0.00}";
    private static final String UNIT_USD = "USD";

    private String controlType;
    private String unit;
    private String align;
    private String valueFormat;
    private Double widthInPercents;
    private Boolean sortColumn;
    private Boolean compareWithPreviousColumn;
    private BigDecimal compareWithPreviousColumnThreshold;
    private Boolean columnWithTrend;
    private Boolean linkColumn;

    public static Builder builder() {
        return new Builder();
    }

    public TableHeaderViewConfig() {
    }

    public TableHeaderViewConfig(String controlType, String unit, String align, String valueFormat, Double widthInPercents,
                                 Boolean sortColumn, Boolean compareWithPreviousColumn, BigDecimal compareWithPreviousColumnThreshold,
                                 Boolean trendValue, Boolean linkColumn) {
        this.controlType = controlType;
        this.unit = unit;
        this.align = align;
        this.valueFormat = valueFormat;
        this.widthInPercents = widthInPercents;
        this.sortColumn = sortColumn;
        this.compareWithPreviousColumn = compareWithPreviousColumn;
        this.compareWithPreviousColumnThreshold = compareWithPreviousColumnThreshold;
        this.columnWithTrend = trendValue;
        this.linkColumn = linkColumn;
    }

    public String getControlType() {
        return controlType;
    }

    public String getUnit() {
        return unit;
    }

    public String getAlign() {
        return align;
    }

    public String getValueFormat() {
        return valueFormat;
    }

    public Double getWidthInPercents() {
        return widthInPercents;
    }

    public Boolean getSortColumn() {
        return sortColumn;
    }

    public Boolean getCompareWithPreviousColumn() {
        return compareWithPreviousColumn;
    }

    public BigDecimal getCompareWithPreviousColumnThreshold() {
        return compareWithPreviousColumnThreshold;
    }

    public Boolean getColumnWithTrend() {
        return columnWithTrend;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public void setValueFormat(String valueFormat) {
        this.valueFormat = valueFormat;
    }

    public void setWidthInPercents(Double widthInPercents) {
        this.widthInPercents = widthInPercents;
    }

    public void setSortColumn(Boolean sortColumn) {
        this.sortColumn = sortColumn;
    }

    public void setCompareWithPreviousColumn(Boolean compareWithPreviousColumn) {
        this.compareWithPreviousColumn = compareWithPreviousColumn;
    }

    public void setCompareWithPreviousColumnThreshold(BigDecimal compareWithPreviousColumnThreshold) {
        this.compareWithPreviousColumnThreshold = compareWithPreviousColumnThreshold;
    }

    public Boolean getLinkColumn() {
        return linkColumn;
    }

    public void setLinkColumn(Boolean linkColumn) {
        this.linkColumn = linkColumn;
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
        private Boolean columnWithTrend;
        private Boolean linkColumn;

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

        public Builder withColumnWithTrend() {
            this.columnWithTrend = true;
            return this;
        }

        public Builder withLinkColumn() {
            this.linkColumn = true;
            return this;
        }

        public Builder withLinkColumn(boolean withLink) {
            this.linkColumn = withLink;
            return this;
        }

        public TableHeaderViewConfig build() {
            return new TableHeaderViewConfig(controlType, unit, align, valueFormat, widthInPercents, sortColumn,
                compareWithPreviousColumn, compareWithPreviousColumnThreshold, columnWithTrend, linkColumn);
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

    public static TableHeaderViewConfig.Builder costHeader(double widthInPercents) {
        return TableHeaderViewConfig.builder()
            .withRightAlign()
            .withSortControl()
            .withUnit(UNIT_USD)
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
