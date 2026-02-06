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
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.recommendation.SdkRecommendationSettingAction;
import io.maestro3.sdk.v3.model.recommendation.SdkRecommendationSetting;
import io.maestro3.sdk.v3.request.ITenantRequest;
import java.util.List;

@JsonDeserialize(builder = UpdateRecommendationSettingsRequest.Builder.class)
public class UpdateRecommendationSettingsRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final List<SdkRecommendationSetting> settings;
    private final SdkRecommendationSettingAction action;

    private UpdateRecommendationSettingsRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.settings = builder.settings;
        this.action = builder.action;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public List<SdkRecommendationSetting> getSettings() {
        return settings;
    }

    public SdkRecommendationSettingAction getAction() {
        return action;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_RECOMMENDATION_SETTINGS;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private List<SdkRecommendationSetting> settings;
        private SdkRecommendationSettingAction action;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withSettings(List<SdkRecommendationSetting> settings) {
            this.settings = settings;
            return this;
        }

        public Builder withAction(SdkRecommendationSettingAction action) {
            this.action = action;
            return this;
        }

        public UpdateRecommendationSettingsRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.notEmpty(settings, "settings");
            Assert.notNull(action, "action");
            return new UpdateRecommendationSettingsRequest(this);
        }

    }
}
