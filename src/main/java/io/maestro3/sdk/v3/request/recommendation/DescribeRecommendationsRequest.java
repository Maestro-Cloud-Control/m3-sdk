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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.details.InsightsRiskFactor;
import io.maestro3.sdk.v3.model.ownership.ResourceType;
import io.maestro3.sdk.v3.model.recommendation.SdkRecommendationCategory;
import io.maestro3.sdk.v3.model.recommendation.SdkUiRecommendationSource;
import io.maestro3.sdk.v3.request.IRegionRequest;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = DescribeRecommendationsRequest.Builder.class)
public class DescribeRecommendationsRequest implements ITenantRequest, IRegionRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;
    private final String resourceGroup;
    private final String availabilityZone;
    private final ResourceType resourceType;

    private final String resourceId;
    private final Collection<SdkRecommendationCategory> categories;

    private final long fromTimestamp;
    private final long toTimestamp;
    private final boolean onlyLastByCategory;

    private final SdkUiRecommendationSource source;
    private final InsightsRiskFactor riskFactor;

    private DescribeRecommendationsRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.resourceGroup = builder.resourceGroup;
        this.availabilityZone = builder.availabilityZone;
        this.resourceType = builder.resourceType;
        this.resourceId = builder.resourceId;
        this.categories = builder.categories;
        this.fromTimestamp = builder.fromTimestamp;
        this.toTimestamp = builder.toTimestamp;
        this.onlyLastByCategory = builder.onlyLastByCategory;
        this.source = builder.source;
        this.riskFactor = builder.riskFactor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    public String getResourceId() {
        return resourceId;
    }

    public Collection<SdkRecommendationCategory> getCategories() {
        return categories;
    }

    public long getFromTimestamp() {
        return fromTimestamp;
    }

    public long getToTimestamp() {
        return toTimestamp;
    }

    public boolean isOnlyLastByCategory() {
        return onlyLastByCategory;
    }

    public String getResourceGroup() {
        return resourceGroup;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public SdkUiRecommendationSource getSource() {
        return source;
    }

    public InsightsRiskFactor getRiskFactor() {
        return riskFactor;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_RECOMMENDATIONS;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private String resourceGroup;
        private String availabilityZone;
        private ResourceType resourceType;
        private String resourceId;
        private Collection<SdkRecommendationCategory> categories;
        private long fromTimestamp;
        private long toTimestamp;
        private boolean onlyLastByCategory;
        private SdkUiRecommendationSource source;
        private InsightsRiskFactor riskFactor;

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

        public Builder withResourceGroup(String resourceGroup) {
            this.resourceGroup = resourceGroup;
            return this;
        }

        public Builder withAvailabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return this;
        }

        public Builder withResourceType(ResourceType resourceType) {
            this.resourceType = resourceType;
            return this;
        }

        public Builder withResourceId(String resourceId) {
            this.resourceId = resourceId;
            return this;
        }

        public Builder withSource(SdkUiRecommendationSource source) {
            this.source = source;
            return this;
        }

        public Builder withCategories(Collection<SdkRecommendationCategory> categories) {
            this.categories = categories;
            return this;
        }

        public Builder withRiskFactor(InsightsRiskFactor riskFactor) {
            this.riskFactor = riskFactor;
            return this;
        }

        public Builder withFromTimestamp(long fromTimestamp) {
            this.fromTimestamp = fromTimestamp;
            return this;
        }

        public Builder withToTimestamp(long toTimestamp) {
            this.toTimestamp = toTimestamp;
            return this;
        }

        public Builder withOnlyLastByCategory(boolean onlyLastByCategory) {
            this.onlyLastByCategory = onlyLastByCategory;
            return this;
        }

        public DescribeRecommendationsRequest build() {
            Assert.notNull(cloud, "cloud cannot be null or empty");
            Assert.hasText(tenantName, "tenantName cannot be null or empty");
            Assert.hasText(region, "region cannot be null or empty");
            Assert.notNull(resourceType, "resourceType cannot be null or empty");
            return new DescribeRecommendationsRequest(this);
        }
    }
}
