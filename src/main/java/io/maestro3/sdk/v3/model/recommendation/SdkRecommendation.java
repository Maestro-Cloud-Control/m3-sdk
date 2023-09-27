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

import java.util.Map;

public class SdkRecommendation {

    private String region;
    private String resourceId;
    private SdkUiRecommendationSource source;
    private SdkRecommendationCategory category;
    private String problem;
    private String solution;
    private SdkRecommendationImpact impact;
    private long timestamp;
    private boolean isOutdated;
    private double probability;

    private Map<String, Object> metadata;

    public SdkRecommendation() {
    }

    public SdkRecommendation(String region, String resourceId, SdkUiRecommendationSource source, SdkRecommendationCategory category, String problem,
                             String solution, SdkRecommendationImpact impact, long timestamp, boolean isOutdated, double probability) {
        this.region = region;
        this.resourceId = resourceId;
        this.source = source;
        this.category = category;
        this.problem = problem;
        this.solution = solution;
        this.impact = impact;
        this.timestamp = timestamp;
        this.isOutdated = isOutdated;
        this.probability = probability;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public SdkUiRecommendationSource getSource() {
        return source;
    }

    public void setSource(SdkUiRecommendationSource source) {
        this.source = source;
    }

    public SdkRecommendationCategory getCategory() {
        return category;
    }

    public void setCategory(SdkRecommendationCategory category) {
        this.category = category;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public SdkRecommendationImpact getImpact() {
        return impact;
    }

    public void setImpact(SdkRecommendationImpact impact) {
        this.impact = impact;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isOutdated() {
        return isOutdated;
    }

    public void setOutdated(boolean outdated) {
        isOutdated = outdated;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
