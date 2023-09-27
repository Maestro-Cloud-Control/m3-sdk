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
import io.maestro3.sdk.v3.model.recommendation.SdkRecommendationSetting;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.List;

@JsonDeserialize(builder = UpdateRecommendationSettingsRequest.Builder.class)
public class UpdateRecommendationSettingsRequest implements IRegionRequest {
    private final String tenantName;
    private final String region;
    private final List<SdkRecommendationSetting> settings;

    private UpdateRecommendationSettingsRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.settings = builder.settings;
    }

    public static UpdateRecommendationSettingsRequest.Builder builder() {
        return new UpdateRecommendationSettingsRequest.Builder();
    }

    public List<SdkRecommendationSetting> getSettings() {
        return settings;
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
    public ActionType getActionType() {
        return ActionType.UPDATE_RECOMMENDATION_SETTINGS;
    }

    public static final class Builder {
        private String tenantName;
        private String region;
        private List<SdkRecommendationSetting> settings;

        public UpdateRecommendationSettingsRequest.Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public UpdateRecommendationSettingsRequest.Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public UpdateRecommendationSettingsRequest.Builder withSettings(List<SdkRecommendationSetting> settings) {
            this.settings = settings;
            return this;
        }

        public UpdateRecommendationSettingsRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.notEmpty(settings, "settings");
            return new UpdateRecommendationSettingsRequest(this);
        }

    }
}
