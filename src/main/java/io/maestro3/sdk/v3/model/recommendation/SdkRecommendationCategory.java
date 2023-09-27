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
import io.maestro3.sdk.internal.Pair;
import io.maestro3.sdk.internal.util.MapUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public enum SdkRecommendationCategory {
    VULNERABILITY("vulnerability", "Vulnerability scan results", RecommendationType.SECURITY),
    SECURITY("security", "Security", RecommendationType.SECURITY),

    TAGS("tags", "Instance tags", RecommendationType.GENERAL),
    LIFE_TIME("lifeTime", "Lifetime", RecommendationType.GENERAL),
    OWNERSHIP("ownership", "Ownership", RecommendationType.GENERAL),
    HIGH_AVAILABILITY("highAvailability", "High availability", RecommendationType.GENERAL),
    OPERATIONAL_EXCELLENCE("operationalExcellence", "Operational excellence", RecommendationType.GENERAL),

    INSTANCE_COSTS("instanceCosts", "Instance costs", RecommendationType.COSTS),
    SHUT_DOWN("shutDown", "Shut down", RecommendationType.COSTS),
    COST("cost", "Cost", RecommendationType.COSTS),
    LOW_UTILIZATION("lowUtilization", "Low utilization", RecommendationType.COSTS),

    CPU_UTILIZATION("cpuUtilization", "CPU utilization", RecommendationType.PERF),
    OPTIMIZATION("optimization", "Optimization", RecommendationType.PERF),
    SCHEDULES("schedules", "Instance schedules", RecommendationType.PERF),
    SCALING("scaleUpDown", "Scale up/down", RecommendationType.PERF),
    SHAPE("shape", "Change shape", RecommendationType.PERF),
    SPLITTING("splitting", "Split instance", RecommendationType.PERF),
    PERFORMANCE("performance", "Performance", RecommendationType.PERF),
    HIGH_UTILIZATION("highUtilization", "High utilization", RecommendationType.PERF);

    private static final SdkRecommendationCategory[] VALUES = values();

    public static final Collection<SdkRecommendationCategory> VALUES_COLLECTION = Collections.unmodifiableList(Arrays.asList(VALUES));

    public static final Map<RecommendationType, Collection<SdkRecommendationCategory>> CATEGORIES_BY_TYPES =
        MapUtils.<RecommendationType, Collection<SdkRecommendationCategory>>builder()
            .withListOfPairs(
                Arrays.stream(RecommendationType.values())
                    .map(rt -> new Pair<RecommendationType, Collection<SdkRecommendationCategory>>(
                        rt, Arrays.stream(VALUES).filter(rc -> rc.getType() == rt).collect(Collectors.toList())))
                    .collect(Collectors.toList()))
            .withPair(RecommendationType.ALL, VALUES_COLLECTION)
            .build();

    private final String name;
    private final String title;
    private final RecommendationType type;

    SdkRecommendationCategory(String name, String title, RecommendationType recommendationType) {
        this.name = name;
        this.title = title;
        this.type = recommendationType;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public RecommendationType getType() {
        return type;
    }

    public static Collection<SdkRecommendationCategory> getByType(RecommendationType type) {
        return CATEGORIES_BY_TYPES.getOrDefault(type, Collections.emptyList());
    }

    @JsonCreator
    public static SdkRecommendationCategory fromValue(String category) {
        for (SdkRecommendationCategory value : VALUES) {
            if (value.name().equalsIgnoreCase(category)) {
                return value;
            }
        }
        return null;
    }
}
