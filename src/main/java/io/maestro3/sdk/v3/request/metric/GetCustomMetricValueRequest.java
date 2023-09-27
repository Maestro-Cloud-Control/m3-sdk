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

package io.maestro3.sdk.v3.request.metric;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = GetCustomMetricValueRequest.Builder.class)
public class GetCustomMetricValueRequest implements IRequest {

    private final String metricData;
    private final MetricValueRequest request;

    private GetCustomMetricValueRequest(Builder builder) {
        this.metricData = builder.metricData;
        this.request = builder.request;
    }

    public static Builder builder() {
        return new Builder();
    }

    public MetricValueRequest getRequest() {
        return request;
    }

    public String getMetricData() {
        return metricData;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_CUSTOM_METRIC_VALUE;
    }

    public static final class Builder {

        private String metricData;
        private MetricValueRequest request;

        public Builder withMetricData(String metricData) {
            this.metricData = metricData;
            return this;
        }

        public Builder withRequest(MetricValueRequest request) {
            this.request = request;
            return this;
        }

        public GetCustomMetricValueRequest build() {
            return new GetCustomMetricValueRequest(this);
        }
    }
}

