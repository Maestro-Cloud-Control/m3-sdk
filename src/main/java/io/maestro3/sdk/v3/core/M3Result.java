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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.maestro3.sdk.internal.util.JsonUtils;

public class M3Result<T> extends M3RawResult {

    private final T model;

    @JsonCreator
    protected M3Result(@JsonProperty("id") String id,
                       @JsonProperty("status") ResultStatus status,
                       @JsonProperty("data") String rawData,
                       @JsonProperty("error") String error,
                       @JsonProperty("readableError") String readableError,
                       @JsonProperty("localizableError") String localizableError,
                       @JsonProperty("model") T model,
                       @JsonProperty("statusCode") int statusCode) {
        super(id, status, rawData, readableError, error, localizableError, statusCode);
        this.model = model;
    }

    public static <T> M3Result<T> error(String id, String errorMessage) {
        return new M3Result<>(id, ResultStatus.FAILED, null, errorMessage, null, null,null, 500);
    }

    public static <T> M3Result<T> error(String id, String errorMessage, String readableError) {
        return new M3Result<>(id, ResultStatus.FAILED, null, errorMessage, readableError, null, null, 500);
    }

    public static <T> M3Result<T> error(String id, String errorMessage, String readableError, int statusCode) {
        return new M3Result<>(id, ResultStatus.FAILED, null, errorMessage, readableError, null, null, statusCode);
    }

    public static <T> M3Result<T> error(String id, String errorMessage, String readableError, String localizableError, int statusCode) {
        return new M3Result<>(id, ResultStatus.FAILED, null, errorMessage, readableError, localizableError, null, statusCode);
    }

    public static <T> M3Result<T> success(String id, T model) {
        return new M3Result<>(id, ResultStatus.SUCCESS, JsonUtils.convertObjectToJson(model), null, null, null, model, 200);
    }

    public static <T> M3Result<T> success(String id, String rawData, T model) {
        return new M3Result<>(id, ResultStatus.SUCCESS, rawData, null, null, null, model, 200);
    }

    public static <T> M3Result<T> success(String id, T model, int statusCode) {
        return new M3Result<>(id, ResultStatus.SUCCESS, JsonUtils.convertObjectToJson(model), null, null, null, model, statusCode);
    }

    public static <T> M3Result<T> pending(String id) {
        return new M3Result<>(id, ResultStatus.PENDING, null, null, null, null, null, 202);
    }

    @JsonIgnore
    public T getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "M3Result{" +
                "id='" + getId() + '\'' +
                ", status=" + getStatus() +
                ", data='" + getData() + '\'' +
                ", error='" + getError() + '\'' +
                ", statusCode='" + getStatusCode() + '\'' +
                ", model=" + model +
                "}";
    }
}
