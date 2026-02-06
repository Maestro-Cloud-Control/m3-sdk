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
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageValue implements ICellValue {

    private String type;
    private String value;
    private String imgSrc;
    private int height;
    private int width;

    protected ImageValue() {
        // db
    }

    @JsonCreator
    protected ImageValue(@JsonProperty("type") String type, @JsonProperty("value") String value,
                         @JsonProperty("imgSrc") String imgSrc,
                         @JsonProperty("height") int height, @JsonProperty("width") int width) {
        this.type = type;
        this.value = value;
        this.imgSrc = imgSrc;
        this.height = height;
        this.width = width;
    }

    public String getType() {
        return type;
    }

    @Override
    public Object getValue() {
        return value;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImageValue)) return false;
        ImageValue that = (ImageValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static ImageValue of(String value, String imgSrc) {
        return of(value, imgSrc, 50, 50);
    }

    public static ImageValue of(String value, String imgSrc, int height, int width) {
        return new ImageValue(ICellValue.IMAGE, value, imgSrc, height, width);
    }

}
