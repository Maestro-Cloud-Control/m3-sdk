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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = TableCellConfig.Builder.class)
public class TableCellConfig {

    private final String format;
    private final Boolean bold;
    private final String textColor;
    private final String cellColor;
    private final String href;
    private final String actionLink;
    private final TableTrendStyle trendStyle;
    private final LStringValue description;
    private final Integer colspan;

    private TableCellConfig(Builder builder) {
        this.format = builder.format;
        this.bold = builder.bold;
        this.textColor = builder.textColor;
        this.cellColor = builder.cellColor;
        this.href = builder.href;
        this.actionLink = builder.actionLink;
        this.trendStyle = builder.trendStyle;
        this.description = builder.description;
        this.colspan = builder.colspan;
    }

    public String getFormat() {
        return format;
    }

    public Boolean getBold() {
        return bold;
    }

    public String getTextColor() {
        return textColor;
    }

    public String getCellColor() {
        return cellColor;
    }

    public String getHref() {
        return href;
    }

    public String getActionLink() {
        return actionLink;
    }

    public TableTrendStyle getTrendStyle() {
        return trendStyle;
    }

    public LStringValue getDescription() {
        return description;
    }

    public Integer getColspan() {
        return colspan;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnore
    public TableCellConfig.Builder toBuilder() {
        return new TableCellConfig.Builder()
            .withFormat(this.format)
            .withBold(this.bold)
            .withTextColor(this.textColor)
            .withCellColor(this.cellColor)
            .withHref(this.href)
            .withActionLink(this.actionLink)
            .withTrendStyle(this.trendStyle)
            .withDescription(this.description)
            .withColspan(this.colspan);
    }

    public static class Builder {

        private String format;
        private Boolean bold;
        private String textColor;
        private String cellColor;
        private String href;
        private String actionLink;
        private TableTrendStyle trendStyle;
        private LStringValue description;
        private Integer colspan;

        public Builder withFormat(String format) {
            this.format = format;
            return this;
        }

        public Builder withBold(Boolean bold) {
            this.bold = bold;
            return this;
        }

        public Builder withTextColor(String textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder withCellColor(String cellColor) {
            this.cellColor = cellColor;
            return this;
        }

        public Builder withHref(String href) {
            this.href = href;
            return this;
        }

        public Builder withActionLink(String actionLink) {
            this.actionLink = actionLink;
            return this;
        }

        public Builder withTrendStyle(TableTrendStyle trendStyle) {
            this.trendStyle = trendStyle;
            return this;
        }

        public Builder withDescription(LStringValue description) {
            this.description = description;
            return this;
        }

        public Builder withColspan(Integer colspan) {
            this.colspan = colspan;
            return this;
        }

        public TableCellConfig build() {
            return new TableCellConfig(this);
        }

    }

    public static TableCellConfig hrefCellConfig(String href) {
        return builder().withHref(href).build();
    }

    public static TableCellConfig actionCellConfig(String actionLink) {
        return builder().withActionLink(actionLink).build();
    }

}
