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
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;
import org.joda.time.DateTime;

import java.util.List;

@JsonDeserialize(builder = InstanceAnalyticReportRequest.Builder.class)
public class InstanceAnalyticReportRequest implements IRequest {

    private final DateTime stoppedAnalyticFrom;
    private final DateTime stoppedAnalyticTo;

    private final DateTime uptimeAnalyticFrom;
    private final DateTime uptimeAnalyticTo;
    private final List<String> instanceIds;

    private InstanceAnalyticReportRequest(Builder builder) {
        this.stoppedAnalyticFrom = builder.stoppedAnalyticFrom;
        this.stoppedAnalyticTo = builder.stoppedAnalyticTo;
        this.uptimeAnalyticFrom = builder.uptimeAnalyticFrom;
        this.uptimeAnalyticTo = builder.uptimeAnalyticTo;
        this.instanceIds = builder.instanceIds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public DateTime getStoppedAnalyticFrom() {
        return stoppedAnalyticFrom;
    }

    public DateTime getStoppedAnalyticTo() {
        return stoppedAnalyticTo;
    }

    public DateTime getUptimeAnalyticFrom() {
        return uptimeAnalyticFrom;
    }

    public DateTime getUptimeAnalyticTo() {
        return uptimeAnalyticTo;
    }

    public List<String> getInstanceIds() {
        return instanceIds;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_INSTANCES_ANALYTIC;
    }

    public static final class Builder {

        private DateTime stoppedAnalyticFrom;
        private DateTime stoppedAnalyticTo;

        private DateTime uptimeAnalyticFrom;
        private DateTime uptimeAnalyticTo;
        private List<String> instanceIds;

        public Builder withStoppedAnalyticFrom(DateTime stoppedAnalyticFrom) {
            this.stoppedAnalyticFrom = stoppedAnalyticFrom;
            return this;
        }

        public Builder withStoppedAnalyticTo(DateTime stoppedAnalyticTo) {
            this.stoppedAnalyticTo = stoppedAnalyticTo;
            return this;
        }

        public Builder withUptimeAnalyticFrom(DateTime uptimeAnalyticFrom) {
            this.uptimeAnalyticFrom = uptimeAnalyticFrom;
            return this;
        }

        public Builder withUptimeAnalyticTo(DateTime uptimeAnalyticTo) {
            this.uptimeAnalyticTo = uptimeAnalyticTo;
            return this;
        }

        public Builder withInstanceIds(List<String> instanceIds) {
            this.instanceIds = instanceIds;
            return this;
        }

        public InstanceAnalyticReportRequest build() {
            return new InstanceAnalyticReportRequest(this);
        }
    }

}
