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

package io.maestro3.sdk.v3.model.reporting;

import io.maestro3.sdk.v3.model.reporting.resource.ITableModel;
import io.maestro3.sdk.v3.model.reporting.resource.ITableRecord;

import java.util.Objects;

public class SdkBillingTabularReportResponse {

    private ITableModel<ITableRecord> table;
    private String message;

    public SdkBillingTabularReportResponse() { }

    public SdkBillingTabularReportResponse(ITableModel<ITableRecord> table) {
        this.table = table;
    }

    public SdkBillingTabularReportResponse(String message) {
        this.message = message;
    }

    public ITableModel<ITableRecord> getTable() {
        return table;
    }

    public void setTable(ITableModel<ITableRecord> table) {
        this.table = table;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SdkBillingTabularReportResponse)) return false;
        SdkBillingTabularReportResponse response = (SdkBillingTabularReportResponse) o;
        return Objects.equals(table, response.table) && Objects.equals(message, response.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, message);
    }

    @Override
    public String toString() {
        return "BillingTabularReportResponse{" +
            "table=" + table +
            ", message='" + message + '\'' +
            '}';
    }
}
