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

@JsonDeserialize(builder = QuotaExistsInCurrentTenantRequest.Builder.class)
public class QuotaExistsInCurrentTenantRequest implements IRequest {

    private final String tenantName;

    private QuotaExistsInCurrentTenantRequest(Builder builder) {
        this.tenantName = builder.tenantName;
    }

    public static Builder builder(){
        return new Builder();
    }

    public String getTenantName() {
        return tenantName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.QUOTA_EXISTS_IN_CURRENT_TENANT;
    }

    @Override
    public String toString() {
        return "QuotaExistsInCurrentTenantRequest{" +
            "tenantName='" + tenantName + '\'' +
            '}';
    }

    public static final class Builder{
        private String tenantName;

        public Builder withTenantName(String tenantName){
            this.tenantName = tenantName;
            return this;
        }

        public QuotaExistsInCurrentTenantRequest build(){
            Assert.notNull(tenantName, "Tenant name cannot be null or empty");
            return new QuotaExistsInCurrentTenantRequest(this);
        }
    }
}
