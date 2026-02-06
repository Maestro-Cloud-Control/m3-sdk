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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = StringValue.class, name = ICellValue.STRING),
    @JsonSubTypes.Type(value = LStringValue.class, name = ICellValue.LSTRING),
    @JsonSubTypes.Type(value = NumberValue.class, name = ICellValue.NUMBER),
    @JsonSubTypes.Type(value = NumberDiffValue.class, name = ICellValue.DIFF_VALUE),
    @JsonSubTypes.Type(value = TrendValue.class, name = ICellValue.TREND_VALUE),
    @JsonSubTypes.Type(value = ArrayValue.class, name = ICellValue.ARRAY),
    @JsonSubTypes.Type(value = RangeValue.class, name = ICellValue.RANGE),
    @JsonSubTypes.Type(value = DelimitedArrayValue.class, name = ICellValue.DELIMITED_ARRAY),
    @JsonSubTypes.Type(value = ImageValue.class, name = ICellValue.IMAGE),
})
public interface ICellValue {

    String STRING = "s";
    String LSTRING = "l";
    String NUMBER = "n";
    String DIFF_VALUE = "d";
    String TREND_VALUE = "t";
    String ARRAY = "a";
    String IMAGE = "i";
    String DELIMITED_ARRAY = "da";
    String RANGE = "r";

    Object getValue();
}
