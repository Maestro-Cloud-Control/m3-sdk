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

import java.util.Map;

public class TableGroupConfig {

    private String header;
    private Map<String, TableGroupConfig> subGroups;
    private Map<String, Integer> groupBorders;
    private Map<String, Integer> groupSizes;

    public TableGroupConfig() {
    }

    public TableGroupConfig(String header, Map<String, Integer> groupBorders, Map<String, Integer> groupSizes) {
        this.header = header;
        this.groupBorders = groupBorders;
        this.groupSizes = groupSizes;
    }

    public TableGroupConfig(String header, Map<String, TableGroupConfig> subGroups, Map<String, Integer> groupBorders, Map<String, Integer> groupSizes) {
        this(header, groupBorders, groupSizes);
        this.subGroups = subGroups;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Map<String, TableGroupConfig> getSubGroups() {
        return subGroups;
    }

    public void setSubGroups(Map<String, TableGroupConfig> subGroups) {
        this.subGroups = subGroups;
    }

    public Map<String, Integer> getGroupBorders() {
        return groupBorders;
    }

    public void setGroupBorders(Map<String, Integer> groupBorders) {
        this.groupBorders = groupBorders;
    }

    public Map<String, Integer> getGroupSizes() {
        return groupSizes;
    }

    public void setGroupSizes(Map<String, Integer> groupSizes) {
        this.groupSizes = groupSizes;
    }
}



