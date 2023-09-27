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

package io.maestro3.sdk.v3.request.resource.quota;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = ValidateResourceQuotaRequest.Builder.class)
public class ValidateResourceQuotaRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final int newInstancesCount;
    private final int newVolumesCount;
    private final int volumeSize;

    private ValidateResourceQuotaRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.newInstancesCount = builder.newInstancesCount;
        this.newVolumesCount = builder.newVolumesCount;
        this.volumeSize = builder.volumeSize;
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

    public int getNewInstancesCount() {
        return newInstancesCount;
    }

    public int getNewVolumesCount() {
        return newVolumesCount;
    }

    public int getVolumeSize() {
        return volumeSize;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.VALIDATE_RESOURCE_QUOTA;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private int newInstancesCount;
        private int newVolumesCount;
        private int volumeSize;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withNewInstancesCount(int newInstancesCount) {
            this.newInstancesCount = newInstancesCount;
            return this;
        }


        public Builder withNewVolumesCount(int newVolumesCount) {
            this.newVolumesCount = newVolumesCount;
            return this;
        }

        public Builder withVolumeSize(int volumeSize) {
            this.volumeSize = volumeSize;
            return this;
        }

        public ValidateResourceQuotaRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.isTrue(newInstancesCount > 0 || newVolumesCount > 0 || volumeSize > 0, "count");
            return new ValidateResourceQuotaRequest(this);
        }
    }
}
