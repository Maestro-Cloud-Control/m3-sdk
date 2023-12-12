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

@JsonDeserialize(builder = GetResourceIdRequest.Builder.class)
public class GetResourceIdRequest implements IResourceRequest {

    private final ResourceIdRequest resourceIdRequest;

    private GetResourceIdRequest(Builder builder) {
        this.resourceIdRequest = builder.resourceIdRequest;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ResourceIdRequest getResourceIdRequest() {
        return resourceIdRequest;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_RESOURCE_ID;
    }

    public static final class Builder {

        private ResourceIdRequest resourceIdRequest;

        public Builder withResourceIdRequest(ResourceIdRequest resourceIdRequest) {
            this.resourceIdRequest = resourceIdRequest;
            return this;
        }

        public GetResourceIdRequest build() {
            Assert.notNull(resourceIdRequest, "resourceIdRequest");
            return new GetResourceIdRequest(this);
        }
    }
}
