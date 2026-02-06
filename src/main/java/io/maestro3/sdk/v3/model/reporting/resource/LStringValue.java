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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LStringValue implements ICellValue {

    private String type;
    private String value;
    private Map<String, Object> placeholders;

    protected LStringValue() {
        // db
    }

    @JsonCreator
    protected LStringValue(@JsonProperty("type") String type,
                           @JsonProperty("value") String value,
                           @JsonProperty("placeholders") Map<String, Object> placeholders) {
        this.type = type;
        this.value = value;
        this.placeholders = placeholders;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, Object> getPlaceholders() {
        return placeholders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LStringValue)) return false;
        LStringValue that = (LStringValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @JsonIgnore
    public LStringValue withPlaceholder(String key, Object value) {
        if (placeholders == null) {
            placeholders = new LinkedHashMap<>();
        }
        placeholders.put(key, value);
        return this;
    }

    public static LStringValue of(String value) {
        return new LStringValue(ICellValue.LSTRING, value, null);
    }

    public static LStringValue of(String value, Map<String, Object> placeholders) {
        return new LStringValue(ICellValue.LSTRING, value, placeholders);
    }
}
