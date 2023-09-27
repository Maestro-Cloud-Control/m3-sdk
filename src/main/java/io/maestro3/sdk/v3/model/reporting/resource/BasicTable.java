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
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class BasicTable<R extends ITableRecord> implements ITableModel<R> {

    private String type;
    private List<String> headers;
    private List<R> records;

    protected BasicTable() {
    }

    public BasicTable(List<String> headers,
                      List<R> records) {
        this.type = ITableModel.BASIC_TABLE;
        this.headers = headers;
        this.records = records;
    }

    @JsonCreator
    protected BasicTable(@JsonProperty("type") String type,
                         @JsonProperty("headers") List<String> headers,
                         @JsonProperty("records") List<R> records) {
        this.type = type;
        this.headers = headers;
        this.records = records;
    }

    public String getType() {
        return type;
    }

    @Override
    public List<String> getHeaders() {
        return headers;
    }

    @Override
    public List<R> getRecords() {
        return records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicTable)) return false;
        BasicTable<?> that = (BasicTable<?>) o;
        return Objects.equals(type, that.type) && Objects.equals(headers, that.headers) && Objects.equals(records, that.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, headers, records);
    }

    @Override
    public String toString() {
        return "BasicTable{" +
            "type='" + type + '\'' +
            ", headers=" + headers +
            ", records=" + records +
            '}';
    }
}
