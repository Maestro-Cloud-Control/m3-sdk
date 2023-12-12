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

public abstract class AbstractConsumptionApiRequest implements IRequest {

    private final String targetTenant;
    private final String targetAccountNumber;
    private final String targetRegion;
    private final SdkCloud targetCloud;
    private final Integer month;
    private final Integer year;

    protected AbstractConsumptionApiRequest(AbstractConsumptionApiRequestBuilder<?, ?> builder) {
        this.targetTenant = builder.targetTenant;
        this.targetAccountNumber = builder.targetAccountNumber;
        this.targetRegion = builder.targetRegion;
        this.targetCloud = builder.targetCloud;
        this.month = builder.month;
        this.year = builder.year;
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

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    public abstract static class AbstractConsumptionApiRequestBuilder
        <B extends AbstractConsumptionApiRequestBuilder<B, R>, R extends AbstractConsumptionApiRequest> {

        private String targetTenant;
        private String targetAccountNumber;
        private String targetRegion;
        private SdkCloud targetCloud;
        private Integer month;
        private Integer year;

        protected abstract B getThis();

        public abstract R build();

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

        public B withMonth(Integer month) {
            this.month = month;
            return getThis();
        }

        public B withYear(Integer year) {
            this.year = year;
            return getThis();
        }

        protected void validateParams() {
            if (StringUtils.isBlank(targetTenant) && StringUtils.isBlank(targetAccountNumber)) {
                throw new M3SdkException("target_project or target_account_number must be not be null or empty");
            }

            Assert.notNull(year, "year");
            Assert.notNull(month, "month");
        }
    }
}
