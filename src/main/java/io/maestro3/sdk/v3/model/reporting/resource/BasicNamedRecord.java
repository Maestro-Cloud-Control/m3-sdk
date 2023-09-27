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

import java.math.BigDecimal;
import java.util.List;

public class BasicNamedRecord implements ITableRecord {

    private String type;
    private String name;
    private List<BigDecimal> rowData;

    protected BasicNamedRecord() {
    }

    public BasicNamedRecord(String name,
                            List<BigDecimal> rowData) {
        this.type = ITableRecord.BASIC_NAMED_RECORD;
        this.name = name;
        this.rowData = rowData;
    }

    @JsonCreator
    protected BasicNamedRecord(@JsonProperty("type") String type,
                               @JsonProperty("name") String name,
                               @JsonProperty("rowData") List<BigDecimal> rowData) {
        this.type = type;
        this.name = name;
        this.rowData = rowData;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<BigDecimal> getRowData() {
        return rowData;
    }

    @JsonIgnore
    @Override
    public void setValue(int headerIndex, Object value) {
        if (headerIndex == 0) {
            this.name = (String) value;
        } else {
            this.rowData.set(headerIndex - 1, (BigDecimal) value);
        }
    }

    @JsonIgnore
    @Override
    public Object getValue(int headerIndex) {
        if (headerIndex == 0) {
            return name;
        }
        return rowData.get(headerIndex - 1);
    }
}
