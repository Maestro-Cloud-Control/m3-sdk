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
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Optional;

@JsonDeserialize(builder = AddKeyRequest.Builder.class)
public class AddKeyRequest implements IRequest {

    private final String name;
    private final String publicKey;

    // optional params
    private final String tenantName;
    private final SdkCloud cloud;
    private final String region;
    private final Boolean allTenants;

    private AddKeyRequest(Builder builder) {
        this.name = builder.name;
        this.publicKey = builder.publicKey;
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
        this.region = builder.region;
        this.allTenants = builder.allTenants;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public String getTenantName() {
        return tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getRegion() {
        return region;
    }

    public Boolean isAllTenants() {
        return Optional.ofNullable(allTenants).orElse(false);
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ADD_KEY;
    }

    public static final class Builder {

        private String name;
        private String publicKey;

        private String tenantName;
        private SdkCloud cloud;
        private String region;

        private Boolean allTenants;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPublicKey(String publicKey) {
            this.publicKey = publicKey;
            return this;
        }

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

        public Builder withAllTenants(Boolean allTenants) {
            this.allTenants = allTenants;
            return this;
        }

        public AddKeyRequest build() {
            Assert.hasText(name, "name");
            boolean isForAllTenants = Optional.ofNullable(allTenants).orElse(false);
            if (!isForAllTenants && (cloud != null || tenantName != null || region != null)) {
                Assert.notNull(cloud, "cloud");
                Assert.hasText(tenantName, "tenantName");
                Assert.hasText(region, "region");
            }
            return new AddKeyRequest(this);
        }
    }
}
