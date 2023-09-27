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

package io.maestro3.sdk.v3.request.ownership.batch;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;
import io.maestro3.sdk.v3.request.ownership.ResourceIdRequest;

import java.util.HashSet;
import java.util.Set;

@JsonDeserialize(builder = BatchOwnerByResourceIdRequestsRequest.Builder.class)
public class BatchOwnerByResourceIdRequestsRequest implements IRequest {

    private final Set<ResourceIdRequest> requests;

    private BatchOwnerByResourceIdRequestsRequest(Builder builder) {
        this.requests = builder.requests;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Set<ResourceIdRequest> getRequests() {
        return requests;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.BATCH_GET_CURRENT_OWNER_BY_RESOURCE_ID_REQUESTS;
    }

    public static final class Builder {

        private Set<ResourceIdRequest> requests = new HashSet<>();

        public Builder addRequest(ResourceIdRequest resourceIdRequest) {
            this.requests.add(resourceIdRequest);
            return this;
        }

        public Builder withRequests(Set<ResourceIdRequest> resourceIdRequests) {
            this.requests.addAll(resourceIdRequests);
            return this;
        }

        public BatchOwnerByResourceIdRequestsRequest build() {
            Assert.notNull(requests, "requests");
            return new BatchOwnerByResourceIdRequestsRequest(this);
        }
    }
}
