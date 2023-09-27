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

package io.maestro3.sdk.v3.request.quota;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Set;

@JsonDeserialize(builder = QuotaExistsRequest.Builder.class)
public class QuotaExistsRequest implements IRequest {

    private final Set<String> tenantNames;

    private QuotaExistsRequest(Builder builder) {
        this.tenantNames = builder.tenantNames;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Set<String> getTenantNames() {
        return tenantNames;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.QUOTA_EXISTS_BY_TENANT;
    }

    public static final class Builder {

        private Set<String> tenantNames;

        public Builder withTenantNames(Set<String> tenantNames) {
            this.tenantNames = tenantNames;
            return this;
        }

        public QuotaExistsRequest build() {
            Assert.notEmpty(tenantNames, "tenantNames");
            return new QuotaExistsRequest(this);
        }
    }
}
