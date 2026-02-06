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
import io.maestro3.sdk.internal.util.CollectionUtils;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DelimitedArrayValue implements ICellValue {

    private String type;
    private List<ICellValue> value;
    private String delimiter;

    protected DelimitedArrayValue() {
        // db
    }

    @JsonCreator
    protected DelimitedArrayValue(@JsonProperty("type") String type,
                                  @JsonProperty("value") List<ICellValue> value,
                                  @JsonProperty("delimiter") String delimiter) {
        this.type = type;
        this.value = value;
        this.delimiter = delimiter;
    }

    public String getType() {
        return type;
    }

    @Override
    public List<ICellValue> getValue() {
        return value;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public static DelimitedArrayValue ofCellValues(List<ICellValue> cellValues, String delimiter) {
        return new DelimitedArrayValue(ICellValue.DELIMITED_ARRAY, cellValues, delimiter);
    }

    public static DelimitedArrayValue of(List<String> values, String delimiter) {
        return ofCellValues(CollectionUtils.map(values, StringValue::of), delimiter);
    }

}
