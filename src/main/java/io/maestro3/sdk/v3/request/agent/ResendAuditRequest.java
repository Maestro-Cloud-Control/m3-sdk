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

package io.maestro3.sdk.v3.request.agent;

import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.List;

public abstract class ResendAuditRequest<D> implements IRequest {

    private final String tenantName;
    private final String regionName;
    private final List<D> dataList;
    private final SdkCloud cloud;

    protected ResendAuditRequest(AbstractResendAuditRequestBuilder<?, ?, D> builder) {
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
        this.regionName = builder.regionName;
        this.dataList = builder.dataList;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getRegionName() {
        return regionName;
    }

    public List<D> getDataList() {
        return dataList;
    }

    public abstract static class AbstractResendAuditRequestBuilder
        <B extends AbstractResendAuditRequestBuilder<B, R, D>, R extends ResendAuditRequest<D>, D> {

        private String tenantName;
        private String regionName;
        private List<D> dataList;
        private SdkCloud cloud;

        protected abstract B getThis();

        public abstract R build();

        public B withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return getThis();
        }

        public B withRegionName(String regionName) {
            this.regionName = regionName;
            return getThis();
        }

        public B withDataList(List<D> dataList) {
            this.dataList = dataList;
            return getThis();
        }

        public B withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return getThis();
        }
    }
}
