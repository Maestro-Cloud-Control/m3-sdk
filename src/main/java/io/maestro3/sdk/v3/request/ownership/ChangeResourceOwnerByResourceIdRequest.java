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
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = ChangeResourceOwnerByResourceIdRequest.Builder.class)
public class ChangeResourceOwnerByResourceIdRequest implements IRequest {

    private final ResourceIdRequest resourceIdRequest;
    private final String owner;
    private final String reason;
    private final long date;

    private ChangeResourceOwnerByResourceIdRequest(Builder builder) {
        this.resourceIdRequest = builder.resourceIdRequest;
        this.owner = builder.owner;
        this.reason = builder.reason;
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

    public String getReason() {
        return reason;
    }

    public long getDate() {
        return date;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CHANGE_OWNER;
    }

    public static final class Builder {

        private ResourceIdRequest resourceIdRequest;
        private String owner;
        private String reason;
        private long date;

        public Builder withResourceIdRequest(ResourceIdRequest resourceIdRequest) {
            this.resourceIdRequest = resourceIdRequest;
            return this;
        }

        public Builder withReason(String reason) {
            this.reason = reason;
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

        public ChangeResourceOwnerByResourceIdRequest build() {
            // assert not null (sdk usages with empty string)
            Assert.notNull(resourceIdRequest, "resourceIdRequest");
            Assert.hasText(owner, "owner");
            Assert.hasText(reason, "reason");
            Assert.isPositive(date, "date");
            return new ChangeResourceOwnerByResourceIdRequest(this);
        }
    }
}
