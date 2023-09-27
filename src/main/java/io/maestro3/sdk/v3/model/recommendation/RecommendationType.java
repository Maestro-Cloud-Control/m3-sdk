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

package io.maestro3.sdk.v3.model.recommendation;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum RecommendationType {
    ALL("All", "all", 0),
    COSTS("Costs", "costs", 2),
    PERF("Perf", "perf", 3),
    GENERAL("General", "general", 1),
    SECURITY("Security", "security", 4);

    private final String title;
    private final String uiId;
    private final int order;

    private static final RecommendationType[] VALUES = values();

    RecommendationType(String title, String uiId, int order) {
        this.title = title;
        this.uiId = uiId;
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public String getUiId() {
        return uiId;
    }

    public int getOrder() {
        return order;
    }

    @JsonCreator
    public static RecommendationType fromValue(String type) {
        for (RecommendationType value : VALUES) {
            if (value.name().equalsIgnoreCase(type)) {
                return value;
            }
        }
        return null;
    }
}
