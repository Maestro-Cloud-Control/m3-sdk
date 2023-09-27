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

package io.maestro3.sdk.v3.model.price.policy;

public class SdkVolumePrices {
    private String mode;

    private SdkVolumePeriodPrices minutePrices;
    private SdkVolumePeriodPrices hourlyPrices;
    private SdkVolumePeriodPrices monthlyPrices;
    private String scale;
    private String diskCloudSpecificName;

    private String availabilityZone;
    private boolean system;

    private boolean includeRamSize;
    private boolean detailedUsage = true;

    public SdkVolumePrices() {
        //json
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public SdkVolumePeriodPrices getMinutePrices() {
        return minutePrices;
    }

    public void setMinutePrices(SdkVolumePeriodPrices minutePrices) {
        this.minutePrices = minutePrices;
    }

    public SdkVolumePeriodPrices getHourlyPrices() {
        return hourlyPrices;
    }

    public void setHourlyPrices(SdkVolumePeriodPrices hourlyPrices) {
        this.hourlyPrices = hourlyPrices;
    }

    public SdkVolumePeriodPrices getMonthlyPrices() {
        return monthlyPrices;
    }

    public void setMonthlyPrices(SdkVolumePeriodPrices monthlyPrices) {
        this.monthlyPrices = monthlyPrices;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getDiskCloudSpecificName() {
        return diskCloudSpecificName;
    }

    public void setDiskCloudSpecificName(String diskCloudSpecificName) {
        this.diskCloudSpecificName = diskCloudSpecificName;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public boolean isIncludeRamSize() {
        return includeRamSize;
    }

    public void setIncludeRamSize(boolean includeRamSize) {
        this.includeRamSize = includeRamSize;
    }

    public boolean isDetailedUsage() {
        return detailedUsage;
    }

    public void setDetailedUsage(boolean detailedUsage) {
        this.detailedUsage = detailedUsage;
    }
}
