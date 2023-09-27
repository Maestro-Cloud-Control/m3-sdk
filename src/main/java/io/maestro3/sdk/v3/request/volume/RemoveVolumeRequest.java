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

package io.maestro3.sdk.v3.request.volume;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.CollectionUtils;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(builder = RemoveVolumeRequest.Builder.class)
public class RemoveVolumeRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String volumeId;
    private final Map<String, String> params;

    private RemoveVolumeRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.volumeId = builder.volumeId;
        this.params = builder.params;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.REMOVE_VOLUME;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String volumeId;
        private Map<String, String> params = new HashMap<>();

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withVolumeId(String volumeId) {
            this.volumeId = volumeId;
            return this;
        }

        public Builder withParams(Map<String, String> params) {
            if (CollectionUtils.isNotEmpty(params)) {
                this.params = params;
            }
            return this;
        }

        public RemoveVolumeRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.hasText(volumeId, "volumeId");
            return new RemoveVolumeRequest(this);
        }
    }
}
