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
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRequest;

public abstract class AbstractConsumptionRequest implements IRequest {

    private final String sourceTenant;
    private final String sourceAccountNumber;
    private final String targetTenant;
    private final String targetAccountNumber;
    private final String targetRegion;
    private final SdkCloud targetCloud;
    private final Integer day;
    private final Integer month;
    private final Integer year;
    private final String description;

    protected AbstractConsumptionRequest(AbstractConsumptionRequestBuilder<?, ?> builder) {
        this.sourceTenant = builder.sourceTenant;
        this.sourceAccountNumber = builder.sourceAccountNumber;
        this.targetTenant = builder.targetTenant;
        this.targetAccountNumber = builder.targetAccountNumber;
        this.targetRegion = builder.targetRegion;
        this.targetCloud = builder.targetCloud;
        this.day = builder.day;
        this.month = builder.month;
        this.year = builder.year;
        this.description = builder.description;
    }

    public String getSourceTenant() {
        return sourceTenant;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public String getTargetTenant() {
        return targetTenant;
    }

    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public String getTargetRegion() {
        return targetRegion;
    }

    public SdkCloud getTargetCloud() {
        return targetCloud;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public abstract static class AbstractConsumptionRequestBuilder
        <B extends AbstractConsumptionRequestBuilder<B, R>, R extends AbstractConsumptionRequest> {

        private String sourceTenant;
        private String sourceAccountNumber;
        private String targetTenant;
        private String targetAccountNumber;
        private String targetRegion;
        private SdkCloud targetCloud;
        private Integer day;
        private Integer month;
        private Integer year;
        private String description;

        protected abstract B getThis();

        public abstract R build();

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

        @JsonAlias("target_project")
        public B withTargetTenant(String targetTenant) {
            this.targetTenant = targetTenant;
            return getThis();
        }

        @JsonAlias("target_account_number")
        public B withTargetAccountNumber(String targetAccountNumber) {
            this.targetAccountNumber = targetAccountNumber;
            return getThis();
        }

        @JsonAlias("target_region")
        public B withTargetRegion(String targetRegion) {
            this.targetRegion = targetRegion;
            return getThis();
        }

        @JsonAlias("target_cloud")
        public B withTargetCloud(SdkCloud targetCloud) {
            this.targetCloud = targetCloud;
            return getThis();
        }

        public B withDay(Integer day) {
            this.day = day;
            return getThis();
        }

        public B withMonth(Integer month) {
            this.month = month;
            return getThis();
        }

        public B withYear(Integer year) {
            this.year = year;
            return getThis();
        }

        public B withDescription(String description) {
            this.description = description;
            return getThis();
        }

        protected void validateParams() {
            if (StringUtils.isBlank(sourceTenant) && StringUtils.isBlank(sourceAccountNumber)) {
                throw new M3SdkException("source_project or source_account_number must be not be null or empty");
            }
            if (StringUtils.isBlank(targetTenant) && StringUtils.isBlank(targetAccountNumber)) {
                throw new M3SdkException("target_project or target_account_number must be not be null or empty");
            }

            Assert.hasText(targetRegion, "target_region");
            Assert.notNull(year, "year");
            Assert.notNull(month, "month");
            Assert.hasText(description, "description");
        }
    }
}
