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

/**
 * Used to describe the rating of specific recommendation, that can be given to the instance during evaluation
 */
public class SdkRecommendationRating {
    private double stars;
    private double value;

    public SdkRecommendationRating() {
    }

    public SdkRecommendationRating(double value, double stars) {
        this.stars = stars;
        this.value = value;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "RecommendationRating{" +
            "stars=" + stars +
            ", value=" + value +
            '}';
    }
}


