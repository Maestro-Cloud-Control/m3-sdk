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

package io.maestro3.sdk.v3.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class M3RawResult {

    private final String id;
    private final ResultStatus status;
    private final String data;
    private final String error;
    private final String readableError;
    private final String localizableError;
    private final int statusCode;

    @JsonCreator
    public M3RawResult(@JsonProperty("id") String id,
                       @JsonProperty("status") ResultStatus status,
                       @JsonProperty("data") String data,
                       @JsonProperty("readableError") String readableError,
                       @JsonProperty("error") String error,
                       @JsonProperty("localizableError") String localizableError,
                       @JsonProperty("statusCode") int statusCode) {
        this.id = id;
        this.status = status;
        this.data = data;
        this.readableError = readableError;
        this.error = error;
        this.localizableError = localizableError;
        this.statusCode = statusCode;
    }

    public String getId() {
        return id;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public String getData() {
        return data;
    }

    public String getError() {
        return error;
    }

    public String getReadableError() {
        return readableError;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getLocalizableError() {
        return localizableError;
    }

    @Override
    public String toString() {
        return "M3RawResult{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", data='" + data + '\'' +
                ", error='" + error + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
