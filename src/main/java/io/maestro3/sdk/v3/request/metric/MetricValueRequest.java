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

import com.fasterxml.jackson.annotation.JsonAlias;

public class MetricValueRequest {

    private String period;
    private String did;
    private String tenant;
    private String tenantDisplayName;
    private String cloud;
    private String metricType;
    private String instanceId;
    @JsonAlias("identityId")
    private String userIdentityId;
    private String selectedPeriod;
    private String encodedParams;
    @JsonAlias("isNativePlatform")
    private String nativePlatform;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getUserIdentityId() {
        return userIdentityId;
    }

    public void setUserIdentityId(String userIdentityId) {
        this.userIdentityId = userIdentityId;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    public void setTenantDisplayName(String tenantDisplayName) {
        this.tenantDisplayName = tenantDisplayName;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getMetricType() {
        return metricType;
    }

    public void setMetricType(String metricType) {
        this.metricType = metricType;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getSelectedPeriod() {
        return selectedPeriod;
    }

    public void setSelectedPeriod(String selectedPeriod) {
        this.selectedPeriod = selectedPeriod;
    }

    public String getEncodedParams() {
        return encodedParams;
    }

    public void setEncodedParams(String encodedParams) {
        this.encodedParams = encodedParams;
    }

    public String getNativePlatform() {
        return nativePlatform;
    }

    public void setNativePlatform(String nativePlatform) {
        this.nativePlatform = nativePlatform;
    }
}
