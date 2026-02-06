/*
 * Copyright 2024 Maestro Cloud Control LLC
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Deprecated // use RangeValue instead
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArrayValue implements ICellValue {

    private String type;
    private List<BigDecimal> value;

    protected ArrayValue() {
        // db
    }

    @JsonCreator
    protected ArrayValue(@JsonProperty("type") String type,
                         @JsonProperty("value") List<BigDecimal> value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    @Override
    public List<BigDecimal> getValue() {
        return value;
    }

    public static ArrayValue of(List<Double> values) {
        return new ArrayValue(ICellValue.ARRAY, values.stream().map(BigDecimal::valueOf).collect(Collectors.toList()));
    }
}
