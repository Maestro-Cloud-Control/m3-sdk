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
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = CreateVolumeRequest.Builder.class)
public class CreateVolumeRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String volumeName;
    private final Integer sizeInGB;

    private CreateVolumeRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.volumeName = builder.volumeName;
        this.sizeInGB = builder.sizeInGB;
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

    public String getVolumeName() {
        return volumeName;
    }

    public Integer getSizeInGB() {
        return sizeInGB;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CREATE_VOLUME;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String volumeName;
        private Integer sizeInGB;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withVolumeName(String volumeName) {
            this.volumeName = volumeName;
            return this;
        }

        public Builder withSizeInGB(Integer sizeInGB) {
            this.sizeInGB = sizeInGB;
            return this;
        }

        public CreateVolumeRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.hasText(volumeName, "volumeName");
            Assert.notNull(sizeInGB, "sizeInGB");
            return new CreateVolumeRequest(this);
        }
    }
}