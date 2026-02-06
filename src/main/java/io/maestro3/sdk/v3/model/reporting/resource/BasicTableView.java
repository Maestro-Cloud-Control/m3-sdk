/*
 * Copyright 2024 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.model.reporting.resource;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@JsonDeserialize(builder = BasicTableView.Builder.class)
public class BasicTableView<R extends ITableRecord> extends BasicTable<R> implements IHasTableViewConfig {

    private TableViewConfig viewConfig;

    protected BasicTableView() {
        // db
    }

    public BasicTableView(ITableModel<R> table, TableViewConfig viewConfig) {
        super(ITableModel.BASIC_TABLE_WITH_VIEW, table.getHeaders(), table.getRecords(), table.getOthersRecord(), table.getTotalRecord(), table.getProperties(), table.getAdditionalDataset());
        this.viewConfig = viewConfig;
    }

    public BasicTableView(List<R> records,
                          TableViewConfig viewConfig) {
        super(ITableModel.BASIC_TABLE_WITH_VIEW, viewConfig.getHeaderConfigs().keySet().stream().map(h -> TableHeaderCell.of(StringValue.of(h))).collect(Collectors.toList()), records, null, null, null, null);
        this.viewConfig = viewConfig;
    }

    public BasicTableView(List<R> records,
                          TableViewConfig viewConfig,
                          Map<String, Object> properties) {
        super(ITableModel.BASIC_TABLE_WITH_VIEW, viewConfig.getHeaderConfigs().keySet().stream().map(h -> TableHeaderCell.of(StringValue.of(h))).collect(Collectors.toList()), records, null, null, properties, null);
        this.viewConfig = viewConfig;
    }

    protected BasicTableView(Builder<R> builder) {
        super(ITableModel.BASIC_TABLE_WITH_VIEW, builder.headers, builder.records, builder.othersRecord, builder.totalRecord, builder.properties, builder.additionalDataset);
        this.viewConfig = builder.viewConfig;
    }

    @Override
    public TableViewConfig getViewConfig() {
        return viewConfig;
    }

    public static <R extends ITableRecord> Builder<R> builder() {
        return new Builder<>();
    }

    public static class Builder<R extends ITableRecord> {

        private List<TableHeaderCell> headers;
        private TableViewConfig viewConfig;
        private List<R> records;
        private R othersRecord;
        private R totalRecord;
        private Map<String, Object> properties;
        private List<Object> additionalDataset;

        public Builder<R> withHeaders(List<TableHeaderCell> headers) {
            this.headers = headers;
            return this;
        }

        /* used for backward compatibility*/
        public Builder<R> withStringHeaders(List<String> headers) {
            this.headers = headers.stream().map(h -> TableHeaderCell.of(StringValue.of(h))).collect(Collectors.toList());
            return this;
        }

        public Builder<R> withViewConfig(TableViewConfig viewConfig) {
            this.viewConfig = viewConfig;
            return this;
        }

        public Builder<R> withRecords(List<R> records) {
            this.records = records;
            return this;
        }

        public Builder<R> withOthersRecord(R othersRecord) {
            this.othersRecord = othersRecord;
            return this;
        }

        public Builder<R> withTotalRecord(R totalRecord) {
            this.totalRecord = totalRecord;
            return this;
        }

        public Builder<R> withProperties(Map<String, Object> properties) {
            this.properties = properties;
            return this;
        }

        public Builder<R> withAdditionalDataset(List<Object> additionalDataset) {
            this.additionalDataset = additionalDataset;
            return this;
        }

        public BasicTableView<R> build() {
            return new BasicTableView<>(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicTableView)) return false;
        if (!super.equals(o)) return false;
        BasicTableView<?> that = (BasicTableView<?>) o;
        return Objects.equals(viewConfig, that.viewConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), viewConfig);
    }

    @Override
    public String toString() {
        return "BasicTableView{} " + super.toString();
    }
}
