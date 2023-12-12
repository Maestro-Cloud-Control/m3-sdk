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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = CustodianLastResourceScanRequest.Builder.class)
public class CustodianLastResourceScanRequest extends AbstractCustodianLastScanRequest {

    private final String region;
    /**
     * The value by which the search will be performed
     */
    private final String identifier;
    /**
     * List of fields to search by, separated by comma (e.g. "id,name", if it is empty - default list of fields will be used for search
     */
    private final String searchBy;

    private CustodianLastResourceScanRequest(Builder builder) {
        super(builder);
        this.region = builder.region;
        this.identifier = builder.identifier;
        this.searchBy = builder.searchBy;
    }

    public String getRegion() {
        return region;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_CUSTODIAN_LAST_RESOURCE_SCAN_RESULTS;
    }

    public static final class Builder extends AbstractCustodianLastScanRequest.Builder<CustodianLastResourceScanRequest.Builder, CustodianLastResourceScanRequest> {

        private String region;
        private String identifier;
        private String searchBy;

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder withSearchBy(String searchBy) {
            this.searchBy = searchBy;
            return getThis();
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        public CustodianLastResourceScanRequest build() {
            super.validateParams();
            Assert.hasText(identifier, "identifier");
            Assert.hasText(searchBy, "searchBy");
            return new CustodianLastResourceScanRequest(this);
        }

    }

}
