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

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RangeValue implements ICellValue {

    private String type;
    private List<RangeEntry> value;

    protected RangeValue() {
        // db
    }

    @JsonCreator
    protected RangeValue(@JsonProperty("type") String type,
                         @JsonProperty("value") List<RangeEntry> value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public static RangeValue of(List<RangeValue.RangeEntry> values) {
        return new RangeValue(ICellValue.RANGE, values);
    }

    @Override
    public List<RangeEntry> getValue() {
        return value;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class RangeEntry {

        private ICellValue value;
        private TableTrendStyle trendStyle;

        public ICellValue getValue() {
            return value;
        }

        public void setValue(ICellValue value) {
            this.value = value;
        }

        public TableTrendStyle getTrendStyle() {
            return trendStyle;
        }

        public void setTrendStyle(TableTrendStyle trendStyle) {
            this.trendStyle = trendStyle;
        }

        public static RangeEntry of(BigDecimal value, TableTrendStyle trendStyle) {
            return of(NumberValue.of(value), trendStyle);
        }

        public static RangeEntry of(ICellValue value, TableTrendStyle trendStyle) {
            RangeEntry tableTrend = new RangeEntry();
            tableTrend.setValue(value);
            tableTrend.setTrendStyle(trendStyle);
            return tableTrend;
        }

    }

}
