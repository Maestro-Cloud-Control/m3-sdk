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

import java.math.BigDecimal;
import java.util.Objects;

public class NumberValue implements ICellValue {

    private String type;
    private BigDecimal value;

    protected NumberValue() {
        // db
    }

    @JsonCreator
    protected NumberValue(@JsonProperty("type") String type, @JsonProperty("value") BigDecimal value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberValue)) return false;
        NumberValue that = (NumberValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static NumberValue of(int value) {
        return new NumberValue(ICellValue.NUMBER, BigDecimal.valueOf(value));
    }

    public static NumberValue of(double value) {
        return new NumberValue(ICellValue.NUMBER, BigDecimal.valueOf(value));
    }

    public static NumberValue of(BigDecimal value) {
        return new NumberValue(ICellValue.NUMBER, value);
    }
}
