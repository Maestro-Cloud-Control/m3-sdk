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

@JsonDeserialize(builder = GetCreationAuditEventRequest.Builder.class)
public class GetCreationAuditEventRequest implements IRequest {

    private final ResourceIdRequest request;

    private GetCreationAuditEventRequest(Builder builder) {
        this.request = builder.request;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ResourceIdRequest getRequest() {
        return request;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_CREATION_AUDIT_EVENT;
    }

    public static final class Builder {

        private ResourceIdRequest request;

        public Builder withRequest(ResourceIdRequest request) {
            this.request = request;
            return this;
        }

        public GetCreationAuditEventRequest build() {
            Assert.notNull(request, "request");
            return new GetCreationAuditEventRequest(this);
        }
    }

}
