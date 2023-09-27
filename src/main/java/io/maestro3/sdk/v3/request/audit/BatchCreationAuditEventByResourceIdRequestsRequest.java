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

package io.maestro3.sdk.v3.request.audit;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;
import io.maestro3.sdk.v3.request.ownership.ResourceIdRequest;

import java.util.Set;

@JsonDeserialize(builder = BatchCreationAuditEventByResourceIdRequestsRequest.Builder.class)
public class BatchCreationAuditEventByResourceIdRequestsRequest implements IRequest {

    private final Set<ResourceIdRequest> request;

    private BatchCreationAuditEventByResourceIdRequestsRequest(Builder builder) {
        this.request = builder.request;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Set<ResourceIdRequest> getRequest() {
        return request;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.BATCH_GET_LIST_CREATION_AUDIT_EVENT;
    }

    public static final class Builder {

        private Set<ResourceIdRequest> request;

        public Builder withRequest(Set<ResourceIdRequest> request) {
            this.request = request;
            return this;
        }

        public BatchCreationAuditEventByResourceIdRequestsRequest build() {
            Assert.notNull(request, "request");
            return new BatchCreationAuditEventByResourceIdRequestsRequest(this);
        }
    }
}
