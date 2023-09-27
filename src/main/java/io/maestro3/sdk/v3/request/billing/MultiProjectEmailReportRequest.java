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

package io.maestro3.sdk.v3.request.billing;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.model.billing.BillingReportFormat;

import java.util.Set;

@JsonDeserialize(builder = MultiProjectEmailReportRequest.Builder.class)
public class MultiProjectEmailReportRequest extends AbstractMultiProjectReportRequest {

    private final String eoAccount;
    private final String reportProjectType;
    private final String reportZoneType;
    private final String region;
    private final Set<String> tenantGroups;
    private final Set<String> tenantNames;
    private final BillingReportFormat format;

    private MultiProjectEmailReportRequest(Builder builder) {
        super(builder);
        this.eoAccount = builder.eoAccount;
        this.reportProjectType = builder.reportProjectType;
        this.reportZoneType = builder.reportZoneType;
        this.region = builder.region;
        this.tenantGroups = builder.tenantGroups;
        this.tenantNames = builder.tenantNames;
        this.format = builder.format;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getEoAccount() {
        return eoAccount;
    }

    public String getReportProjectType() {
        return reportProjectType;
    }

    public String getReportZoneType() {
        return reportZoneType;
    }

    public String getRegion() {
        return region;
    }

    public Set<String> getTenantGroups() {
        return tenantGroups;
    }

    public Set<String> getTenantNames() {
        return tenantNames;
    }

    public BillingReportFormat getFormat() {
        return format;
    }

    public static final class Builder extends AbstractBuilder<Builder, MultiProjectEmailReportRequest> {

        private String eoAccount;
        private String reportProjectType;
        private String reportZoneType;
        private String region;
        private Set<String> tenantGroups;
        private Set<String> tenantNames;
        private BillingReportFormat format;

        public Builder withEoAccount(String eoAccount) {
            this.eoAccount = eoAccount;
            return this;
        }

        public Builder withReportProjectType(String reportProjectType) {
            this.reportProjectType = reportProjectType;
            return this;
        }

        public Builder withReportZoneType(String reportZoneType) {
            this.reportZoneType = reportZoneType;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withTenantGroups(Set<String> tenantGroups) {
            this.tenantGroups = tenantGroups;
            return this;
        }

        public Builder withTenantNames(Set<String> tenantNames) {
            this.tenantNames = tenantNames;
            return this;
        }

        public Builder withFormat(BillingReportFormat format) {
            this.format = format;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public MultiProjectEmailReportRequest build() {
            return new MultiProjectEmailReportRequest(this);
        }
    }
}
