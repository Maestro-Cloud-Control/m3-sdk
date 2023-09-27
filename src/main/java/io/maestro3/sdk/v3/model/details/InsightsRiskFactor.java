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

package io.maestro3.sdk.v3.model.details;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public enum InsightsRiskFactor {

    SAFE("Safe"),
    SCHEDULED("To be checked"),
    MIN("Min"),
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    CRITICAL("Critical");

    private static final InsightsRiskFactor[] VALUES = values();

    private final String name;

    InsightsRiskFactor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static InsightsRiskFactor fromValueNullable(String name) {
        for (InsightsRiskFactor value : VALUES) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name.toUpperCase(Locale.US);
    }

    public static List<InsightsRiskFactor> getInsightsRiskFactors() {
        return Arrays.stream(InsightsRiskFactor.values())
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }
}
