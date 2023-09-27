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

@JsonDeserialize(builder = StoppedInstanceAnalyticReportRequest.Builder.class)
public class StoppedInstanceAnalyticReportRequest implements IRequest {

    private final DateTime from;
    private final DateTime to;

    private StoppedInstanceAnalyticReportRequest(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
    }

    public static Builder builder() {
        return new Builder();
    }

    public DateTime getFrom() {
        return from;
    }

    public DateTime getTo() {
        return to;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_STOPPED_INSTANCES_ANALYTIC;
    }

    public static final class Builder {

        private DateTime from;
        private DateTime to;

        public Builder withFrom(DateTime from) {
            this.from = from;
            return this;
        }

        public Builder withTo(DateTime to) {
            this.to = to;
            return this;
        }

        public StoppedInstanceAnalyticReportRequest build() {
            return new StoppedInstanceAnalyticReportRequest(this);
        }
    }

}
