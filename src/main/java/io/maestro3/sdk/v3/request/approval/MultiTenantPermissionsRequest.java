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

package io.maestro3.sdk.v3.request.approval;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = MultiTenantPermissionsRequest.Builder.class)
public class MultiTenantPermissionsRequest implements IRequest {
    private final String requester;
    private final List<TenantPermissionsRequest> tenantPermissionsRequests;

    private MultiTenantPermissionsRequest(Builder builder) {
        this.requester = builder.requester;
        this.tenantPermissionsRequests = builder.tenantPermissionsRequests;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getRequester() {
        return requester;
    }

    public List<TenantPermissionsRequest> getTenantPermissionsRequests() {
        return tenantPermissionsRequests;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SEND_EXPAND_PERMISSIONS_REQUEST;
    }

    public static final class Builder {

        private String requester;
        private List<TenantPermissionsRequest> tenantPermissionsRequests;

        public Builder withRequester(String requester) {
            this.requester = requester;
            return this;
        }

        public Builder withTenantPermissionsRequests(List<TenantPermissionsRequest> tenantPermissionsRequests) {
            this.tenantPermissionsRequests = tenantPermissionsRequests;
            return this;
        }

        public MultiTenantPermissionsRequest build() {
            Assert.hasText(requester, "requester cannot be null or empty");
            Assert.notEmpty(tenantPermissionsRequests, "tenantPermissionsRequests can not be null or empty");
            return new MultiTenantPermissionsRequest(this);
        }
    }
}
