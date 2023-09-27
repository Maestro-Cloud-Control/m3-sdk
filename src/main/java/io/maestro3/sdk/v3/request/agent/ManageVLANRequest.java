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

package io.maestro3.sdk.v3.request.agent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = ManageVLANRequest.Builder.class)
public class ManageVLANRequest implements IRegionRequest {

    private final String region;
    private final String tenantName;
    private final String oldId;
    private final String newId;

    private ManageVLANRequest(Builder builder) {
        this.region = builder.region;
        this.tenantName = builder.tenantName;
        this.oldId = builder.oldId;
        this.newId = builder.newId;
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

    public String getOldId() {
        return oldId;
    }

    public String getNewId() {
        return newId;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_VLAN;
    }

    public static final class Builder {
        private String region;
        private String tenantName;
        private String oldId;
        private String newId;

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withOldId(String oldId) {
            this.oldId = oldId;
            return this;
        }

        public Builder withNewId(String newId) {
            this.newId = newId;
            return this;
        }

        public ManageVLANRequest build() {
            return new ManageVLANRequest(this);
        }
    }
}
