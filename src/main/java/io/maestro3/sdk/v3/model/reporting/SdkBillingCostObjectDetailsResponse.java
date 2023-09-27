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

package io.maestro3.sdk.v3.model.reporting;

import java.util.List;
import java.util.Objects;

public class SdkBillingCostObjectDetailsResponse {

    private List<String> productNames;
    private List<String> usageTypes;
    private List<String> resources;

    public SdkBillingCostObjectDetailsResponse() {
        //json
    }

    public SdkBillingCostObjectDetailsResponse(List<String> productNames, List<String> usageTypes, List<String> resources) {
        this.productNames = productNames;
        this.usageTypes = usageTypes;
        this.resources = resources;
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public List<String> getUsageTypes() {
        return usageTypes;
    }

    public void setUsageTypes(List<String> usageTypes) {
        this.usageTypes = usageTypes;
    }

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SdkBillingCostObjectDetailsResponse)) return false;
        SdkBillingCostObjectDetailsResponse that = (SdkBillingCostObjectDetailsResponse) o;
        return Objects.equals(productNames, that.productNames) && Objects.equals(usageTypes, that.usageTypes) && Objects.equals(resources, that.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNames, usageTypes, resources);
    }

    @Override
    public String toString() {
        return "BillingCostObjectDetailsResponse{" +
            "productNames=" + productNames +
            ", usageTypes=" + usageTypes +
            ", resources=" + resources +
            '}';
    }
}
