/*
 * Copyright 2025 Maestro Cloud Control LLC
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

package io.maestro3.sdk.v3.request.recommendation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.ownership.ResourceType;
import io.maestro3.sdk.v3.model.recommendation.SdkCustodianExceptionType;
import io.maestro3.sdk.v3.model.recommendation.SdkRecommendationCategory;
import io.maestro3.sdk.v3.model.recommendation.SdkUiRecommendationSource;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;
import java.util.List;

@JsonDeserialize(builder = DescribeRecommendationSettingsRequest.Builder.class)
public class DescribeRecommendationSettingsRequest implements ITenantRequest, IRegionRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final ResourceType resourceType;
    private final String resourceId;
    private final List<SdkUiRecommendationSource> sources;
    private final List<SdkRecommendationCategory> categories;
    private final List<SdkCustodianExceptionType> types;

    private DescribeRecommendationSettingsRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.resourceType = builder.resourceType;
        this.resourceId = builder.resourceId;
        this.sources = builder.sources;
        this.categories = builder.categories;
        this.types = builder.types;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public String getResourceId() {
        return resourceId;
    }

    public List<SdkUiRecommendationSource> getSources() {
        return sources;
    }

    public List<SdkRecommendationCategory> getCategories() {
        return categories;
    }

    public List<SdkCustodianExceptionType> getTypes() {
        return types;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_RECOMMENDATION_SETTINGS;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private ResourceType resourceType;
        private String resourceId;
        private List<SdkUiRecommendationSource> sources;
        private List<SdkRecommendationCategory> categories;
        private List<SdkCustodianExceptionType> types;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

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

        public Builder withTypes(List<SdkCustodianExceptionType> types) {
            this.types = types;
            return this;
        }

        public DescribeRecommendationSettingsRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            if (StringUtils.isNotBlank(region) || resourceType != null || StringUtils.isNotBlank(resourceId)) {
                Assert.hasText(region, "region");
                Assert.isTrue(ResourceType.INSTANCE == resourceType, "resourceType");
                Assert.hasText(resourceId, "resourceId");
            }
            return new DescribeRecommendationSettingsRequest(this);
        }

    }

}
