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

import java.util.List;

public class ComplexRecord implements ITableRecord {

    private String type;
    private List<Object> rowData;

    protected ComplexRecord() {
    }

    public ComplexRecord(List<Object> rowData) {
        this.type = ITableRecord.COMPLEX_RECORD;
        this.rowData = rowData;
    }

    @JsonCreator
    protected ComplexRecord(@JsonProperty("type") String type,
                            @JsonProperty("rowData") List<Object> rowData) {
        this.type = type;
        this.rowData = rowData;
    }

    public String getType() {
        return type;
    }

    public List<Object> getRowData() {
        return rowData;
    }

    @JsonIgnore
    @Override
    public void setValue(int headerIndex, Object value) {
        this.rowData.set(headerIndex, value);
    }

    @JsonIgnore
    @Override
    public Object getValue(int headerIndex) {
        return rowData.get(headerIndex);
    }
}
