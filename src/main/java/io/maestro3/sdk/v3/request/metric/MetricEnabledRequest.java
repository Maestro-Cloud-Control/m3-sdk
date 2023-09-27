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
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = MetricEnabledRequest.Builder.class)
public class MetricEnabledRequest implements IRequest {

    private final SdkCloud cloud;
    private final String metricType;

    private MetricEnabledRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.metricType = builder.metricType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getMetricType() {
        return metricType;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.IS_METRIC_ENABLED;
    }

    public static final class Builder {

        private SdkCloud cloud;
        private String metricType;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withMetricType(String metricType) {
            this.metricType = metricType;
            return this;
        }

        public MetricEnabledRequest build() {
            return new MetricEnabledRequest(this);
        }
    }
}
