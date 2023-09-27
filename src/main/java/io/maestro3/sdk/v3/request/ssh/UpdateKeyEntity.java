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

package io.maestro3.sdk.v3.request.ssh;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.SdkCloud;


@JsonDeserialize(builder = UpdateKeyEntity.Builder.class)
public class UpdateKeyEntity {

    private String tenantName;
    private SdkCloud cloud;
    private String region;
    private UpdateKeyState state;

    UpdateKeyEntity(String tenantName, SdkCloud cloud, String region, UpdateKeyState state) {
        this.tenantName = tenantName;
        this.cloud = cloud;
        this.region = region;
        this.state = state;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public UpdateKeyState getState() {
        return state;
    }

    public static class Builder {

        private String tenantName;
        private SdkCloud cloud;
        private String region;
        private UpdateKeyState state;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withState(UpdateKeyState state) {
            this.state = state;
            return this;
        }

        public UpdateKeyEntity build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.notNull(state, "state");
            return new UpdateKeyEntity(tenantName, cloud, region, state);
        }
    }

    public enum UpdateKeyState {
        ADD, REMOVE, ERROR
    }
}

