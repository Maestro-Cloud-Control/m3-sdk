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

import java.util.Objects;

/**
 * Describes the action to should be taken to improve instance state
 */
public class SdkRecommendedAction {

    private SdkRecommendationRating rating;
    private String description;
    private String risk;

    public SdkRecommendedAction() {
    }

    public SdkRecommendedAction(SdkRecommendationRating recommendationRating, String description, String risk) {
        this.rating = recommendationRating;
        this.description = description;
        this.risk = risk;
    }

    public SdkRecommendationRating getRating() {
        return rating;
    }

    public void setRating(SdkRecommendationRating rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "RecommendedActionSdk{" +
            "rating=" + rating +
            ", description='" + description + '\'' +
            ", risk='" + risk + '\'' +
            '}';
    }

    public static SdkRecommendedAction create(String description, double ratingStars, double ratingValue, String riskStatus) {
        SdkRecommendationRating recommendationRating = new SdkRecommendationRating(ratingStars, ratingValue);
        return new SdkRecommendedAction(recommendationRating, description, riskStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdkRecommendedAction action = (SdkRecommendedAction) o;
        return description.equals(action.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}

