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

package io.maestro3.sdk.v3.request.custodian;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.ITenantRequest;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = CustodianLastResourceScanRequest.Builder.class)
public class CustodianLastResourceScanRequest implements ITenantRequest {

    private final SdkCloud cloud;
    /**
     * display name
     */
    private final String tenantName;
    private final String region;
    /**
     * The value by which the search will be performed
     */
    private final String identifier;
    private final String resourceType;
    private final boolean exactMatch;
    /**
     * List of fields to search by, separated by comma (e.g. "id,name", if it is empty - default list of fields will be used for search
     */
    private final String searchBy;
    private final boolean searchByAll;

    private CustodianLastResourceScanRequest(Builder builder) {
        this.tenantName = builder.tenantName;
        this.identifier = builder.identifier;
        this.cloud = builder.cloud;
        this.exactMatch = builder.exactMatch;
        this.region = builder.region;
        this.searchByAll = builder.searchByAll;
        this.resourceType = builder.resourceType;
        this.searchBy = builder.searchBy;
    }

    @Override
    public SdkCloud getCloud() {
        return cloud;
    }

    @Override
    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getResourceType() {
        return resourceType;
    }

    public boolean getExactMatch() {
        return exactMatch;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public boolean getSearchByAll() {
        return searchByAll;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_CUSTODIAN_LAST_RESOURCE_SCAN_RESULTS;
    }

    public static final class Builder {
        private SdkCloud cloud;
        private String tenantName;
        private String region;
        private String identifier;
        private String resourceType;
        private boolean exactMatch;
        private String searchBy;
        private boolean searchByAll;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder withResourceType(String resourceType) {
            this.resourceType = resourceType;
            return this;
        }

        public Builder withExactMatch(boolean exactMatch) {
            this.exactMatch = exactMatch;
            return this;
        }

        public Builder withSearchBy(String searchBy) {
            this.searchBy = searchBy;
            return this;
        }

        public Builder withSearchByAll(boolean searchByAll) {
            this.searchByAll = searchByAll;
            return this;
        }

        public CustodianLastResourceScanRequest build() {
            Assert.hasText(tenantName, "tenantName");
            Assert.hasText(identifier, "identifier");
            Assert.notNull(cloud, "cloud");
            return new CustodianLastResourceScanRequest(this);
        }
    }
}
