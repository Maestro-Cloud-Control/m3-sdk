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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = BasicTable.class, name = ITableModel.BASIC_TABLE),
    @JsonSubTypes.Type(value = BasicTableView.class, name = ITableModel.BASIC_TABLE_WITH_VIEW),
    @JsonSubTypes.Type(value = BasicTableViewWithDataset.class, name = ITableModel.BASIC_TABLE_WITH_DATASET),
})
public interface ITableModel<R extends ITableRecord> {

    String BASIC_TABLE = "table";
    String BASIC_TABLE_WITH_VIEW = "tableWithView";
    String BASIC_TABLE_WITH_DATASET = "tableWithDataset";

    List<String> getHeaders();

    List<R> getRecords();

}
