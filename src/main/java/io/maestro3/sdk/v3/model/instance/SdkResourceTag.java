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

package io.maestro3.sdk.v3.model.instance;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.maestro3.sdk.internal.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Resource tag with key-value pair.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkResourceTag {

    private String key;
    private String value;

    public SdkResourceTag() {
    }

    public SdkResourceTag(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static List<SdkResourceTag> fromMap(Map<String, String> tags) {
        Assert.notNull(tags, "tags");
        return tags.entrySet().stream()
                .map(entry -> new SdkResourceTag(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        // no checks for 'value' fields because only 'key' determines the uniqueness of the object
        if (this == o) return true;
        if (!(o instanceof SdkResourceTag)) return false;

        SdkResourceTag that = (SdkResourceTag) o;

        return key.equals(that.key);

    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return "Tag{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
