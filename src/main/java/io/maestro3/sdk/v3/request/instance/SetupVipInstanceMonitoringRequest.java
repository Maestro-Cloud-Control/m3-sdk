/*
 * Copyright 2024 Maestro Cloud Control LLC
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

package io.maestro3.sdk.v3.request.instance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = SetupVipInstanceMonitoringRequest.SetupVipInstanceMonitoringRequestBuilder.class)
public class SetupVipInstanceMonitoringRequest extends InstanceActionRequest {

    private final String metricName;
    private final String range;
    private final String condition;
    private final Double value;

    private SetupVipInstanceMonitoringRequest(SetupVipInstanceMonitoringRequestBuilder builder) {
        super(builder);
        this.metricName = builder.metricName;
        this.range = builder.range;
        this.condition = builder.condition;
        this.value = builder.value;
    }

    public String getMetricName() {
        return metricName;
    }

    public String getRange() {
        return range;
    }

    public String getCondition() {
        return condition;
    }

    public Double getValue() {
        return value;
    }

    public static SetupVipInstanceMonitoringRequestBuilder builder() {
        return new SetupVipInstanceMonitoringRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SETUP_INSTANCE_MONITORING;
    }

    public static class SetupVipInstanceMonitoringRequestBuilder extends
            AbstractInstanceActionBuilder<SetupVipInstanceMonitoringRequestBuilder, SetupVipInstanceMonitoringRequest> {

        private String metricName;
        private String range;
        private String condition;
        private Double value;

        @Override
        protected SetupVipInstanceMonitoringRequestBuilder getThis() {
            return this;
        }

        public SetupVipInstanceMonitoringRequestBuilder withMetricName(String metricName) {
            this.metricName = metricName;
            return this;
        }

        public SetupVipInstanceMonitoringRequestBuilder withRange(String range) {
            this.range = range;
            return this;
        }

        public SetupVipInstanceMonitoringRequestBuilder withCondition(String condition) {
            this.condition = condition;
            return this;
        }

        public SetupVipInstanceMonitoringRequestBuilder withValue(Double value) {
            this.value = value;
            return this;
        }

        @Override
        public SetupVipInstanceMonitoringRequest build() {
            validateCommonParams();
            Assert.hasText(metricName, "metricName");
            Assert.hasText(range, "range");
            Assert.hasText(condition, "condition");
            Assert.notNull(value, "value");
            return new SetupVipInstanceMonitoringRequest(this);
        }

    }

}
