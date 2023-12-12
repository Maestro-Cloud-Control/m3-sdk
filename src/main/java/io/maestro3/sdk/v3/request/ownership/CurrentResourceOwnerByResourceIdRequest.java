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

package io.maestro3.sdk.v3.request.ownership;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IResourceRequest;

@JsonDeserialize(builder = CurrentResourceOwnerByResourceIdRequest.Builder.class)
public class CurrentResourceOwnerByResourceIdRequest implements IResourceRequest {

    private final boolean includeFinished;
    private final ResourceIdRequest resourceIdRequest;

    private CurrentResourceOwnerByResourceIdRequest(Builder builder) {
        this.includeFinished = builder.includeFinished;
        this.resourceIdRequest = builder.resourceIdRequest;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ResourceIdRequest getResourceIdRequest() {
        return resourceIdRequest;
    }

    public boolean isIncludeFinished() {
        return includeFinished;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_CURRENT_OWNER;
    }

    public static final class Builder {

        private boolean includeFinished;
        private ResourceIdRequest resourceIdRequest;

        public Builder withResourceIdRequest(ResourceIdRequest resourceIdRequest) {
            this.resourceIdRequest = resourceIdRequest;
            return this;
        }

        public Builder withIncludeFinished(boolean includeFinished) {
            this.includeFinished = includeFinished;
            return this;
        }

        public CurrentResourceOwnerByResourceIdRequest build() {
            Assert.notNull(resourceIdRequest, "resourceIdRequest");
            return new CurrentResourceOwnerByResourceIdRequest(this);
        }
    }
}
