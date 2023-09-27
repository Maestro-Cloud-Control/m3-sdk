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

package io.maestro3.sdk.v3.request.instance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = ManageInstanceTerminationProtectionRequest.Builder.class)
public class ManageInstanceTerminationProtectionRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String availabilityZone;
    private final String instanceId;
    private final Action action;

    private ManageInstanceTerminationProtectionRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.availabilityZone = builder.availabilityZone;
        this.instanceId = builder.instanceId;
        this.action = builder.action;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    @Override
    public String getRegion() {
        return region;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public Action getAction() {
        return action;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.MANAGE_TERMINATION_PROTECTION;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String availabilityZone;
        private String instanceId;
        private Action action;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withAvailabilityZone(String availabilityZone) {
            this.availabilityZone = availabilityZone;
            return this;
        }

        public Builder withInstanceId(String instanceId) {
            this.instanceId = instanceId;
            return this;
        }

        public Builder withAction(Action action) {
            this.action = action;
            return this;
        }

        public ManageInstanceTerminationProtectionRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            Assert.hasText(instanceId, "instanceId");
            Assert.notNull(action, "action");
            return new ManageInstanceTerminationProtectionRequest(this);
        }
    }

    public enum Action {
        ENABLE, DISABLE
    }
}