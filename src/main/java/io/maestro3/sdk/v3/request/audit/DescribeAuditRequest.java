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

@JsonDeserialize(builder = DescribeAuditRequest.Builder.class)
public class DescribeAuditRequest implements IRequest {

    private final ResourceIdRequest request;
    private final boolean includeArchived;
    private final int limit;

    private DescribeAuditRequest(Builder builder) {
        this.request = builder.request;
        this.includeArchived = builder.includeArchived;
        this.limit = builder.limit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ResourceIdRequest getRequest() {
        return request;
    }

    public boolean isIncludeArchived() {
        return includeArchived;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_AUDIT;
    }

    public static final class Builder {

        private ResourceIdRequest request;
        private boolean includeArchived;
        private int limit;

        public Builder withRequest(ResourceIdRequest request) {
            this.request = request;
            return this;
        }

        public Builder withIncludeArchived(boolean includeArchived) {
            this.includeArchived = includeArchived;
            return this;
        }

        public Builder withLimit(int limit) {
            this.limit = limit;
            return this;
        }

        public DescribeAuditRequest build() {
            Assert.notNull(request, "request");
            return new DescribeAuditRequest(this);
        }
    }
}
