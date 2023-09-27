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

@JsonDeserialize(builder = AddSingleKeySyncRequest.Builder.class)
public class AddSingleKeySyncRequest implements IRequest {
    private final String email;
    private final String name;
    private final String publicKey;
    private final SdkCloud cloud;
    private final String tenantName;
    private final String region;

    private AddSingleKeySyncRequest(Builder builder) {
        this.email = builder.email;
        this.name = builder.name;
        this.publicKey = builder.publicKey;
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ADD_SINGLE_KEY_SYNC;
    }

    public static final class Builder {
        private String email;
        private String name;
        private String publicKey;
        private SdkCloud cloud;
        private String tenantName;
        private String region;

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

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

        public AddSingleKeySyncRequest build() {
            Assert.hasText(name, "name");
            Assert.hasText(email, "email");
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(region, "region");
            return new AddSingleKeySyncRequest(this);
        }
    }

}
