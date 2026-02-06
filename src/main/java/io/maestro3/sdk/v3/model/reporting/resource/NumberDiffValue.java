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

@Deprecated // use TrendValue instead
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberDiffValue implements ICellValue {

    private String type;
    private Integer value;
    private Integer diff;

    protected NumberDiffValue() {
        // db
    }

    @JsonCreator
    protected NumberDiffValue(@JsonProperty("type") String type,
                              @JsonProperty("value") Integer value,
                              @JsonProperty("diff") Integer diff) {
        this.type = type;
        this.value = value;
        this.diff = diff;
    }

    public String getType() {
        return type;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getDiff() {
        return diff;
    }

    public static NumberDiffValue of(Integer value, Integer diff) {
        return new NumberDiffValue(ICellValue.DIFF_VALUE, value, diff);
    }
}
