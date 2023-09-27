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

import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.ownership.ResourceType;

public class SdkRecommendationSetting {
    private SdkCloud cloud;
    private String tenantName;
    private String regionName;
    private SdkRecommendationCategory category;
    private SdkUiRecommendationSource source;
    private String resourceId;
    private ResourceType resourceType;
    /**
     * UTC timestamp in milliseconds, shows until which moment the recommendations that fit this setting should be disabled
     */
    private Long disabledUntil;

    public SdkRecommendationSetting() {
        // for JSON
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public void setCloud(SdkCloud cloud) {
        this.cloud = cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public SdkRecommendationCategory getCategory() {
        return category;
    }

    public void setCategory(SdkRecommendationCategory category) {
        this.category = category;
    }

    public SdkUiRecommendationSource getSource() {
        return source;
    }

    public void setSource(SdkUiRecommendationSource source) {
        this.source = source;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public Long getDisabledUntil() {
        return disabledUntil;
    }

    public void setDisabledUntil(Long disabledUntil) {
        this.disabledUntil = disabledUntil;
    }

    @Override
    public String toString() {
        return "SdkRecommendationSetting{" +
            "cloud=" + cloud +
            ", tenantName='" + tenantName + '\'' +
            ", regionName='" + regionName + '\'' +
            ", category=" + category +
            ", source=" + source +
            ", resourceId='" + resourceId + '\'' +
            ", resourceType=" + resourceType +
            ", disabledUntil=" + disabledUntil +
            '}';
    }
}
