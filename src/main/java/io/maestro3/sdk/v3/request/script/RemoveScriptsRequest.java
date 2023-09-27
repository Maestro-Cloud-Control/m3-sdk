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

package io.maestro3.sdk.v3.request.script;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;

import java.util.List;

@JsonDeserialize(builder = RemoveScriptsRequest.Builder.class)
public class RemoveScriptsRequest implements ITenantRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final List<String> fileNames;

    private RemoveScriptsRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.fileNames = builder.fileNames;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.REMOVE_SCRIPT;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String tenantName;
        private List<String> fileNames;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withFileNames(List<String> fileNames) {
            this.fileNames = fileNames;
            return this;
        }

        public RemoveScriptsRequest build() {
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            Assert.notEmpty(fileNames, "fileName");
            return new RemoveScriptsRequest(this);
        }
    }
}
