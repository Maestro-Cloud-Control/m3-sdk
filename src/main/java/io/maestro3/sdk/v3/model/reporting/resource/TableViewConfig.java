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

public class TableViewConfig {

    private final Map<String, TableHeaderViewConfig> headerConfigs;
    private final TableGroupConfig groupConfig;

    @JsonIgnore
    private Integer rowsLimit;
    @JsonIgnore
    private Integer columnsLimit;
    @JsonIgnore
    private Comparator<ITableRecord> rowsComparator;
    @JsonIgnore
    private Boolean configApplied;

    @JsonCreator
    protected TableViewConfig(@JsonProperty("headerConfigs") Map<String, TableHeaderViewConfig> headerConfigs,
                              @JsonProperty("groupConfig") TableGroupConfig groupConfig) {
        this.headerConfigs = headerConfigs;
        this.groupConfig = groupConfig;
    }

    private TableViewConfig(Map<String, TableHeaderViewConfig> headerConfigs, TableGroupConfig groupConfig, Integer rowsLimit, Integer columnsLimit, Comparator<ITableRecord> rowsComparator) {
        this.headerConfigs = headerConfigs;
        this.groupConfig = groupConfig;
        this.rowsLimit = rowsLimit;
        this.columnsLimit = columnsLimit;
        this.rowsComparator = rowsComparator;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnore
    public TableHeaderViewConfig getHeaderConfig(String headerName) {
        return CollectionUtils.isNotEmpty(headerConfigs) ? headerConfigs.get(headerName) : null;
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

    public static class Builder {
        private final Map<String, TableHeaderViewConfig> headerConfigs = new LinkedHashMap<>();
        private TableGroupConfig groupConfig;
        private Integer rowsLimit;
        private Integer columnsLimit;
        private Comparator<ITableRecord> rowsComparator;

        public Builder headerConfigs(Map<String, TableHeaderViewConfig> headerConfigs) {
            this.headerConfigs.putAll(headerConfigs);
            return this;
        }

        public Builder header(String headerName, TableHeaderViewConfig headerConfig) {
            this.headerConfigs.put(headerName, headerConfig);
            return this;
        }

        public Builder header(String headerName, TableHeaderViewConfig.Builder headerConfigBuilder) {
            this.headerConfigs.put(headerName, headerConfigBuilder.build());
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

        public TableViewConfig build() {
            return new TableViewConfig(headerConfigs, groupConfig, rowsLimit, columnsLimit, rowsComparator);
        }
    }

    public static TableViewConfig empty() {
        return TableViewConfig.builder().build();
    }
}
