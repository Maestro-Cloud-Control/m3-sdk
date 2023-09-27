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

package io.maestro3.sdk.v3.request.analytics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRegionRequest;

@JsonDeserialize(builder = MonitoringReportRequest.Builder.class)
public class MonitoringReportRequest implements IRegionRequest {

    private final long from;
    private final long to;
    private final String tenantName;
    private final String region;

    private MonitoringReportRequest(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.tenantName = builder.tenantName;
        this.region = builder.region;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.MONITORING_REPORT;
    }

    public static final class Builder {

        private long from;
        private long to;
        private String tenantName;
        private String region;

        public Builder withFrom(long from) {
            this.from = from;
            return this;
        }

        public Builder withTo(long to) {
            this.to = to;
            return this;
        }

        public Builder withTenantName(String tenantDisplayName) {
            this.tenantName = tenantDisplayName;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public MonitoringReportRequest build() {
            Assert.isPositive(from, "from");
            Assert.isPositive(to, "to");
            Assert.hasText(tenantName, "tenantName");
            return new MonitoringReportRequest(this);
        }
    }
}
