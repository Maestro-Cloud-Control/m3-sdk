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

package io.maestro3.sdk.v3.request.image;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = DeleteImageRequest.Builder.class)
public class DeleteImageRequest implements IRegionRequest {

    private final String tenantName;
    private final String region;
    private final String imageId;

    private DeleteImageRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.region = builder.region;
        this.imageId = builder.imageId;
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

    public String getImageId() {
        return imageId;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DELETE_IMAGE;
    }

    public static final class Builder {

        private String tenantName;
        private String region;
        private String imageId;

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withImageId(String imageId) {
            this.imageId = imageId;
            return this;
        }

        public DeleteImageRequest build() {
            return new DeleteImageRequest(this);
        }
    }
}
