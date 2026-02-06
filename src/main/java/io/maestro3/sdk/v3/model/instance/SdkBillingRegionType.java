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

package io.maestro3.sdk.v3.model.instance;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkBillingRegionType {

    private String regionType;
    private Set<String> regions;

    public SdkBillingRegionType() {
    }

    public SdkBillingRegionType(String regionType, Set<String> regions) {
        this.regionType = regionType;
        this.regions = regions;
    }

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    public Set<String> getRegions() {
        return regions;
    }

    public void setRegions(Set<String> regions) {
        this.regions = regions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SdkBillingRegionType)) return false;

        SdkBillingRegionType that = (SdkBillingRegionType) o;
        return regionType.equals(that.regionType);
    }

    @Override
    public int hashCode() {
        return regionType.hashCode();
    }

    @Override
    public String toString() {
        return "SdkVendorsWithRelatedZones{" +
                "regionType='" + regionType + '\'' +
                ", regions=" + regions +
                '}';
    }
}
