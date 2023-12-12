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

import com.fasterxml.jackson.annotation.JsonAlias;

public abstract class AbstractConsumptionDetailsRequest extends AbstractConsumptionApiRequest {

    private final Integer day;
    private final String serviceName;
    private final String serviceDisplayName;
    private final String unit;

    protected AbstractConsumptionDetailsRequest(AbstractConsumptionDetailsRequestBuilder<?, ?> builder) {
        super(builder);
        this.day = builder.day;
        this.serviceName = builder.serviceName;
        this.serviceDisplayName = builder.serviceDisplayName;
        this.unit = builder.unit;
    }

    public Integer getDay() {
        return day;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceDisplayName() {
        return serviceDisplayName;
    }

    public String getUnit() {
        return unit;
    }

    public abstract static class AbstractConsumptionDetailsRequestBuilder
        <B extends AbstractConsumptionDetailsRequest.AbstractConsumptionDetailsRequestBuilder<B, R>, R extends AbstractConsumptionDetailsRequest>
        extends AbstractConsumptionApiRequestBuilder<B, R> {

        private Integer day;
        private String serviceName;
        private String serviceDisplayName;
        private String unit;

        public B withDay(Integer day) {
            this.day = day;
            return getThis();
        }

        @JsonAlias("service_name")
        public B withServiceName(String serviceName) {
            this.serviceName = serviceName;
            return getThis();
        }

        @JsonAlias("service_display_name")
        public B withServiceDisplayName(String serviceDisplayName) {
            this.serviceDisplayName = serviceDisplayName;
            return getThis();
        }

        public B withUnit(String unit) {
            this.unit = unit;
            return getThis();
        }
    }
}
