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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.maestro3.sdk.internal.util.CollectionUtils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TableViewConfig {

    private Map<String, TableHeaderViewConfig> headerConfigs;
    private TableGroupConfig groupConfig;

    @JsonIgnore
    private Integer rowsLimit;
    @JsonIgnore
    private Integer columnsLimit;
    @JsonIgnore
    private Comparator<ITableRecord> rowsComparator;
    @JsonIgnore
    private Boolean configApplied;
    @JsonIgnore
    private boolean withOtherRow;

    protected TableViewConfig() {
        // db
    }

    @JsonCreator
    protected TableViewConfig(@JsonProperty("groupConfig") TableGroupConfig groupConfig) {
        this.headerConfigs = Map.of();
        this.groupConfig = groupConfig;
    }

    private TableViewConfig(Builder builder) {
        this.headerConfigs = builder.headerConfigs;
        this.groupConfig = builder.groupConfig;
        this.rowsLimit = builder.rowsLimit;
        this.columnsLimit = builder.columnsLimit;
        this.rowsComparator = builder.rowsComparator;
        this.withOtherRow = builder.withOtherRow;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder()
            .headerConfigs(this.headerConfigs)
            .groupConfig(this.groupConfig)
            .rowsLimit(this.rowsLimit)
            .columnsLimit(this.columnsLimit)
            .rowsComparator(this.rowsComparator)
            .withOtherRow(this.withOtherRow);
    }

    @JsonIgnore
    public TableHeaderViewConfig getHeaderConfig(String headerName) {
        return CollectionUtils.isNotEmpty(headerConfigs) ? headerConfigs.get(headerName) : null;
    }

    @JsonIgnore
    public TableHeaderViewConfig getHeaderConfig(TableHeaderCell cell) {
        return CollectionUtils.isNotEmpty(headerConfigs) && cell.getCellValue() != null && cell.getCellValue().getValue() != null
            ? headerConfigs.get(cell.getCellValue().getValue().toString()) : null;
    }

    public Map<String, TableHeaderViewConfig> getHeaderConfigs() {
        return headerConfigs;
    }

    public TableGroupConfig getGroupConfig() {
        return groupConfig;
    }

    public Integer getRowsLimit() {
        return rowsLimit;
    }

    public Integer getColumnsLimit() {
        return columnsLimit;
    }

    public Comparator<ITableRecord> getRowsComparator() {
        return rowsComparator;
    }

    public Boolean getConfigApplied() {
        return configApplied;
    }

    public void setConfigApplied(Boolean configApplied) {
        this.configApplied = configApplied;
    }

    public boolean isWithOtherRow() {
        return withOtherRow;
    }

    public static class Builder {
        private final Map<String, TableHeaderViewConfig> headerConfigs = new LinkedHashMap<>();
        private TableGroupConfig groupConfig;
        private Integer rowsLimit;
        private Integer columnsLimit;
        private Comparator<ITableRecord> rowsComparator;
        private boolean withOtherRow;

        public Builder headerConfigs(Map<String, TableHeaderViewConfig> headerConfigs) {
            this.headerConfigs.putAll(headerConfigs);
            return this;
        }

        public Builder headerCellConfigs(Map<TableHeaderCell, TableHeaderViewConfig> headerConfigs) {
            Map<String, TableHeaderViewConfig> collect = headerConfigs.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().getCellValue().getValue().toString(), Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
            this.headerConfigs.putAll(collect);
            return this;
        }

        public Builder header(String headerName, TableHeaderViewConfig headerConfig) {
            this.headerConfigs.put(headerName, headerConfig);
            return this;
        }

        public Builder header(TableHeaderCell headerName, TableHeaderViewConfig headerConfig) {
            this.headerConfigs.put(headerName.getCellValue().getValue().toString(), headerConfig);
            return this;
        }

        public Builder header(String headerName, TableHeaderViewConfig.Builder headerConfigBuilder) {
            this.headerConfigs.put(headerName, headerConfigBuilder.build());
            return this;
        }

        public Builder header(TableHeaderCell tableHeaderCell, TableHeaderViewConfig.Builder headerConfigBuilder) {
            this.headerConfigs.put(tableHeaderCell.getCellValue().getValue().toString(), headerConfigBuilder.build());
            return this;
        }

        public Builder rowsLimit(Integer limit) {
            this.rowsLimit = limit;
            return this;
        }

        public Builder columnsLimit(Integer columnsLimit) {
            this.columnsLimit = columnsLimit;
            return this;
        }

        public Builder groupConfig(TableGroupConfig groupConfig) {
            this.groupConfig = groupConfig;
            return this;
        }

        public Builder rowsComparator(Comparator<ITableRecord> rowsComparator) {
            this.rowsComparator = rowsComparator;
            return this;
        }

        public Builder withOtherRow(boolean withOtherRow) {
            this.withOtherRow = withOtherRow;
            return this;
        }

        public Builder withOtherRow() {
            this.withOtherRow = true;
            return this;
        }

        public TableViewConfig build() {
            return new TableViewConfig(this);
        }
    }

    public static TableViewConfig empty() {
        return TableViewConfig.builder().build();
    }
}
