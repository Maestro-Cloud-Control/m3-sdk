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
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.StringUtils;

public abstract class AbstractConsumptionRequest extends AbstractConsumptionApiRequest {

    private final String sourceTenant;
    private final String sourceAccountNumber;
    private final String description;
    private final String serviceName;

    protected AbstractConsumptionRequest(AbstractConsumptionRequestBuilder<?, ?> builder) {
        super(builder);
        this.sourceTenant = builder.sourceTenant;
        this.sourceAccountNumber = builder.sourceAccountNumber;
        this.description = builder.description;
        this.serviceName = builder.serviceName;
    }

    public String getSourceTenant() {
        return sourceTenant;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getServiceName() {
        return serviceName;
    }

    public abstract static class AbstractConsumptionRequestBuilder
        <B extends AbstractConsumptionRequest.AbstractConsumptionRequestBuilder<B, R>, R extends AbstractConsumptionRequest>
        extends AbstractConsumptionApiRequestBuilder<B, R> {

        private String sourceTenant;
        private String sourceAccountNumber;
        private String description;
        private String serviceName;

        @JsonAlias("source_project")
        public B withSourceTenant(String sourceTenant) {
            this.sourceTenant = sourceTenant;
            return getThis();
        }

        @JsonAlias("source_account_number")
        public B withSourceAccountNumber(String sourceAccountNumber) {
            this.sourceAccountNumber = sourceAccountNumber;
            return getThis();
        }

        public B withDescription(String description) {
            this.description = description;
            return getThis();
        }

        @JsonAlias("service_name")
        public B withServiceName(String serviceName) {
            this.serviceName = serviceName;
            return getThis();
        }

        @Override
        protected void validateParams() {
            super.validateParams();
            if (StringUtils.isBlank(sourceTenant) && StringUtils.isBlank(sourceAccountNumber)) {
                throw new M3SdkException("source_project or source_account_number must be not be null or empty");
            }
            Assert.hasText(description, "description");
        }
    }
}
