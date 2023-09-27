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

package io.maestro3.sdk.v3.model.reseller;

import io.maestro3.sdk.v3.model.resource.SdkTenantInfo;

public class SdkGoogleResellerOnboardNewCustomerResponse {
    private SdkGoogleResellerCustomer customer;
    private SdkTenantInfo tenant;

    public SdkGoogleResellerOnboardNewCustomerResponse() {
        // for JSON
    }

    public SdkGoogleResellerOnboardNewCustomerResponse(SdkGoogleResellerCustomer customer, SdkTenantInfo tenant) {
        this.customer = customer;
        this.tenant = tenant;
    }

    public SdkGoogleResellerOnboardNewCustomerResponse withCustomer(SdkGoogleResellerCustomer customer) {
        this.customer = customer;
        return this;
    }

    public SdkGoogleResellerOnboardNewCustomerResponse withTenant(SdkTenantInfo tenant) {
        this.tenant = tenant;
        return this;
    }

    public SdkGoogleResellerCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(SdkGoogleResellerCustomer customer) {
        this.customer = customer;
    }

    public SdkTenantInfo getTenant() {
        return tenant;
    }

    public void setTenant(SdkTenantInfo tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "SdkGoogleResellerOnboardNewCustomerResponse{" +
            "customer=" + customer +
            ", tenant=" + tenant +
            '}';
    }
}
