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

package io.maestro3.sdk.v3.request.recommendation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.ownership.ResourceType;
import io.maestro3.sdk.v3.model.recommendation.SdkRecommendationCategory;
import io.maestro3.sdk.v3.model.recommendation.SdkUiRecommendationSource;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.List;

@JsonDeserialize(builder = DescribeRecommendationSettingsRequest.Builder.class)
public class DescribeRecommendationSettingsRequest implements IRegionRequest {
    private final String tenantName;
    private final String region;
    private final String resourceId;
    private final ResourceType resourceType;
    private final List<SdkUiRecommendationSource> sources;
    private final List<SdkRecommendationCategory> categories;

    private DescribeRecommendationSettingsRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.resourceId = builder.resourceId;
        this.resourceType = builder.resourceType;
        this.sources = builder.sources;
        this.categories = builder.categories;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public String getResourceId() {
        return resourceId;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public List<SdkUiRecommendationSource> getSources() {
        return sources;
    }

    public List<SdkRecommendationCategory> getCategories() {
        return categories;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_RECOMMENDATION_SETTINGS;
    }

    public static final class Builder {
        private String tenantName;
        private String region;
        private String resourceId;
        private ResourceType resourceType;
        private List<SdkUiRecommendationSource> sources;
        private List<SdkRecommendationCategory> categories;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withResourceId(String resourceId) {
            this.resourceId = resourceId;
            return this;
        }

        public Builder withResourceType(ResourceType resourceType) {
            this.resourceType = resourceType;
            return this;
        }

        public Builder withSources(List<SdkUiRecommendationSource> sources) {
            this.sources = sources;
            return this;
        }

        public Builder withCategories(List<SdkRecommendationCategory> categories) {
            this.categories = categories;
            return this;
        }

        public DescribeRecommendationSettingsRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            return new DescribeRecommendationSettingsRequest(this);
        }

    }

    @Override
    public String toString() {
        return "DescribeRecommendationSettingsRequest{" +
            ", tenantName='" + tenantName + '\'' +
            ", region='" + region + '\'' +
            ", resourceId='" + resourceId + '\'' +
            ", resourceType=" + resourceType +
            ", sources=" + sources +
            ", categories=" + categories +
            '}';
    }
}
