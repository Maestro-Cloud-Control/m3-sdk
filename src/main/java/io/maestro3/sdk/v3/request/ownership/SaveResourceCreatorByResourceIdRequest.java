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

@JsonDeserialize(builder = SaveResourceCreatorByResourceIdRequest.Builder.class)
public class SaveResourceCreatorByResourceIdRequest implements IResourceRequest {

    private final ResourceIdRequest resourceIdRequest;
    private final String owner;
    private final long date;

    private SaveResourceCreatorByResourceIdRequest(Builder builder) {
        this.resourceIdRequest = builder.resourceIdRequest;
        this.owner = builder.owner;
        this.date = builder.date;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ResourceIdRequest getResourceIdRequest() {
        return resourceIdRequest;
    }

    public String getOwner() {
        return owner;
    }

    public long getDate() {
        return date;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SAVE_CREATOR;
    }

    public static final class Builder {

        private String owner;
        private ResourceIdRequest resourceIdRequest;
        private long date;

        public Builder withResourceIdRequest(ResourceIdRequest resourceIdRequest) {
            this.resourceIdRequest = resourceIdRequest;
            return this;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder withDate(long date) {
            this.date = date;
            return this;
        }

        public SaveResourceCreatorByResourceIdRequest build() {
            // assert not null (sdk usages with empty string)
            Assert.notNull(resourceIdRequest, "resourceIdRequest");
            Assert.hasText(owner, "owner");
            Assert.isPositive(date, "date");
            return new SaveResourceCreatorByResourceIdRequest(this);
        }
    }
}
