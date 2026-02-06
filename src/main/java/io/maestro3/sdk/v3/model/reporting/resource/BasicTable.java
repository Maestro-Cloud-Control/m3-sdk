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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BasicTable<R extends ITableRecord> implements ITableModel<R> {

    private String type;
    private List<TableHeaderCell> headers;
    private List<R> records;
    private R othersRecord;
    private R totalRecord;
    private List<Object> additionalDataset;
    private Map<String, Object> properties;

    protected BasicTable() {
        // db
    }

    public BasicTable(List<TableHeaderCell> headers,
                      List<R> records) {
        this.type = ITableModel.BASIC_TABLE;
        this.headers = headers;
        this.records = records;
    }

    public BasicTable(ITableModel<R> tableModel) {
        this.type = ITableModel.BASIC_TABLE;
        this.headers = tableModel.getHeaders();
        this.records = tableModel.getRecords();
        this.othersRecord = tableModel.getOthersRecord();
        this.totalRecord = tableModel.getTotalRecord();
        this.properties = tableModel.getProperties();
        this.additionalDataset = tableModel.getAdditionalDataset();
    }

    @JsonCreator
    protected BasicTable(@JsonProperty("type") String type,
                         @JsonProperty("headers") List<TableHeaderCell> headers,
                         @JsonProperty("records") List<R> records,
                         @JsonProperty("othersRecord") R othersRecord,
                         @JsonProperty("totalRecord") R totalRecord,
                         @JsonProperty("properties") Map<String, Object> properties,
                         @JsonProperty("additionalDataset") List<Object> additionalDataset) {
        this.type = type;
        this.headers = headers;
        this.records = records;
        this.othersRecord = othersRecord;
        this.totalRecord = totalRecord;
        this.properties = properties;
        this.additionalDataset = additionalDataset;
    }

    public String getType() {
        return type;
    }

    @Override
    public List<TableHeaderCell> getHeaders() {
        return headers;
    }

    @Override
    public List<R> getRecords() {
        return records;
    }

    @Override
    public R getOthersRecord() {
        return othersRecord;
    }

    public void setOthersRecord(R othersRecord) {
        this.othersRecord = othersRecord;
    }

    public void setTotalRecord(R totalRecord) {
        this.totalRecord = totalRecord;
    }

    @Override
    public R getTotalRecord() {
        return totalRecord;
    }

    @Override
    public List<Object> getAdditionalDataset() {
        return additionalDataset;
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicTable)) return false;
        BasicTable<?> that = (BasicTable<?>) o;
        return Objects.equals(type, that.type) && Objects.equals(headers, that.headers) && Objects.equals(records, that.records) && Objects.equals(othersRecord, that.othersRecord) && Objects.equals(totalRecord, that.totalRecord) && Objects.equals(additionalDataset, that.additionalDataset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, headers, records, othersRecord, totalRecord, additionalDataset);
    }

    @Override
    public String toString() {
        return "BasicTable{" +
            "type='" + type + '\'' +
            ", headers=" + headers +
            ", records=" + records +
            ", othersRecord=" + othersRecord +
            ", totalRecord=" + totalRecord +
            '}';
    }
}
