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

public class BasicTableView<R extends ITableRecord> extends BasicTable<R> implements IHasTableViewConfig {

    private TableViewConfig viewConfig;

    protected BasicTableView() {
    }

    public BasicTableView(List<String> headers,
                          List<R> records,
                          TableViewConfig viewConfig) {
        super(ITableModel.BASIC_TABLE_WITH_VIEW, headers, records);
        this.viewConfig = viewConfig;
    }

    @JsonCreator
    protected BasicTableView(@JsonProperty("type") String type,
                             @JsonProperty("headers") List<String> headers,
                             @JsonProperty("records") List<R> records,
                             @JsonProperty("viewConfig") TableViewConfig viewConfig) {
        super(type, headers, records);
        this.viewConfig = viewConfig;
    }

    public BasicTableView(ITableModel<R> table, TableViewConfig viewConfig) {
        this(table.getHeaders(), table.getRecords(), viewConfig);
    }

    @Override
    public TableViewConfig getViewConfig() {
        return viewConfig;
    }
}
