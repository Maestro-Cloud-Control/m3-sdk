/*
 *
 * Copyright 2024 Softline Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.model.support;

import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class SdkSupportCategory {
    private String code;
    private String name;
    private List<SdkSupportCategory> categories = Collections.emptyList();
    private List<SdkSupportSubject> subjects = Collections.emptyList();

    public SdkSupportCategory() {
        // For JSON
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SdkSupportCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<SdkSupportCategory> categories) {
        validateSubjectsAndCategories(subjects, categories);
        this.categories = categories;
    }

    public List<SdkSupportSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SdkSupportSubject> subjects) {
        validateSubjectsAndCategories(subjects, categories);
        this.subjects = subjects;
    }

    private void validateSubjectsAndCategories(List<SdkSupportSubject> subjects, List<SdkSupportCategory> categories) {
        if (CollectionUtils.isNotEmpty(subjects) && CollectionUtils.isNotEmpty(categories)) {
            throw new M3SdkException("SdkSupportCategory can only have either subjects or categories.");
        }
    }
}
