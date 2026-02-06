/*
 * Copyright 2024 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.model.reporting.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrendValue implements ICellValue {

    private String type;
    private ICellValue value;
    private ICellValue diff;

    protected TrendValue() {
        // db
    }

    @JsonCreator
    protected TrendValue(@JsonProperty("type") String type,
                         @JsonProperty("value") ICellValue value,
                         @JsonProperty("diff") ICellValue diff) {
        this.type = type;
        this.value = value;
        this.diff = diff;
    }

    public String getType() {
        return type;
    }

    public ICellValue getValue() {
        return value;
    }

    public ICellValue getDiff() {
        return diff;
    }

    public static TrendValue of(BigDecimal value, BigDecimal currentValue, BigDecimal prevValue) {
        BigDecimal diff = currentValue != null && prevValue != null && currentValue.compareTo(prevValue) != 0 ? currentValue.subtract(prevValue) : null;
        NumberValue diffValue = diff != null ? NumberValue.of(diff) : null;
        return new TrendValue(ICellValue.TREND_VALUE, NumberValue.of(value), diffValue);
    }

    public static TrendValue of(ICellValue value, ICellValue diff) {
        return new TrendValue(ICellValue.TREND_VALUE, value, diff);
    }
}
