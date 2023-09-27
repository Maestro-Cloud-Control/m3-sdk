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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.maestro3.sdk.v3.model.price.SdkPriceCorrection;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SdkPricingPolicy.class, name = "pricingPolicy"),
    @JsonSubTypes.Type(value = SdkHardwarePricingPolicy.class, name = "hardwarePricingPolicy"),
    @JsonSubTypes.Type(value = SdkDynamicPricingPolicy.class, name = "dynamicPricingPolicy"),
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkPricingPolicy {

    private String id;
    private String zoneId;
    private String type;

    private String applyFor;
    private String targetGroup;
    private String timeUnit;

    // either both exist or both empty
    private String fromCron;
    private String toCron;

    private Date useSince; // must be present

    private Date useTo; // may be empty

    private String priceMode;

    private BigDecimal coefficient;

    private SdkInstancePrices instancePrices;
    private SdkVolumeTypesPrices volumePrices;

    private BigDecimal instanceBasePrice;
    private BigDecimal instanceRunFee;

    private BigDecimal vCorePerMonth;
    private BigDecimal vCoreCoefficient;
    private BigDecimal vCoreReductionCoefficient;
    private BigDecimal vCoreNormCoefficient;
    private BigDecimal customVCorePerMonthMultiplier;

    private BigDecimal memoryGBPerMonth;
    private BigDecimal customMemoryGBPerMonthMultiplier;

    private BigDecimal windowsLicensePerVCorePerMonth;
    private BigDecimal customWindowsLicensePerVCorePerMonthMultiplier;
    private BigDecimal windowsLicensePerMemoryGBPerMonth;
    private BigDecimal customWindowsLicensePerMemoryGBPerMonthMultiplier;
    private BigDecimal windowsLicensePerMonth;
    private BigDecimal customWindowsLicensePerMonthMultiplier;
    private String windowsPriceCalculationMode;

    private BigDecimal storageOverValue;
    private BigDecimal storageGBUnderValuePerMonth;
    private BigDecimal storageGBOverValuePerMonth;
    private BigDecimal systemStorageOverValue;
    private BigDecimal systemStorageGBUnderValuePerMonth;
    private BigDecimal systemStorageGBOverValuePerMonth;

    private BigDecimal storagePassiveGBPerMonth;
    private BigDecimal storageActiveGBPerMonth;
    private BigDecimal additionalStorageMultiplier;
    private String storageCalculationMode;

    private BigDecimal checkpointOverValue;
    private BigDecimal checkpointGBUnderValuePerMonth;
    private BigDecimal checkpointGBOverValuePerMonth;
    private BigDecimal checkpointPassiveGBPerMonth;
    private BigDecimal checkpointActiveGBPerMonth;
    private String checkpointCalculationMode;

    private BigDecimal machineImageOverValue;
    private BigDecimal machineImageGBUnderValuePerMonth;
    private BigDecimal machineImageGBOverValuePerMonth;
    private String machineImageCalculationMode;

    private List<SdkPriceCorrection> priceCorrections;

    private List<SdkServicePrice> servicePrices;

    private List<SdkLocationInfo> locationsPrices;
    private List<SdkVirtualDataCenter> virtualDataCenters;

    private String hoursInMonthMode;
    private BigDecimal fixedHoursInMonth;

    private int vCoresScale = 3;
    private RoundingMode vCoresRounding;
    private int memoryScale = 3;
    private RoundingMode memoryRounding;
    private int instanceBaseScale = 3;
    private RoundingMode instanceBaseRounding;
    private int windowsScale = 3;
    private RoundingMode windowsRounding;
    private int instanceRunFeeScale = 3;
    private RoundingMode instanceRunFeeRounding;

    private int storageScale = 6;
    private RoundingMode storageRounding;

    private int checkpointScale = 6;
    private RoundingMode checkpointRounding;

    private int machineImageScale = 6;
    private RoundingMode machineImageRounding;

    private int scale = 16;
    private RoundingMode roundingMode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApplyFor() {
        return applyFor;
    }

    public void setApplyFor(String applyFor) {
        this.applyFor = applyFor;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String getFromCron() {
        return fromCron;
    }

    public void setFromCron(String fromCron) {
        this.fromCron = fromCron;
    }

    public String getToCron() {
        return toCron;
    }

    public void setToCron(String toCron) {
        this.toCron = toCron;
    }

    public Date getUseSince() {
        return useSince;
    }

    public void setUseSince(Date useSince) {
        this.useSince = useSince;
    }

    public Date getUseTo() {
        return useTo;
    }

    public void setUseTo(Date useTo) {
        this.useTo = useTo;
    }

    public String getPriceMode() {
        return priceMode;
    }

    public void setPriceMode(String priceMode) {
        this.priceMode = priceMode;
    }

    public BigDecimal getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }

    public SdkInstancePrices getInstancePrices() {
        return instancePrices;
    }

    public void setInstancePrices(SdkInstancePrices instancePrices) {
        this.instancePrices = instancePrices;
    }

    public SdkVolumeTypesPrices getVolumePrices() {
        return volumePrices;
    }

    public void setVolumePrices(SdkVolumeTypesPrices volumePrices) {
        this.volumePrices = volumePrices;
    }

    public BigDecimal getInstanceBasePrice() {
        return instanceBasePrice;
    }

    public void setInstanceBasePrice(BigDecimal instanceBasePrice) {
        this.instanceBasePrice = instanceBasePrice;
    }

    public BigDecimal getInstanceRunFee() {
        return instanceRunFee;
    }

    public void setInstanceRunFee(BigDecimal instanceRunFee) {
        this.instanceRunFee = instanceRunFee;
    }

    public BigDecimal getVCorePerMonth() {
        return vCorePerMonth;
    }

    public void setVCorePerMonth(BigDecimal vCorePerMonth) {
        this.vCorePerMonth = vCorePerMonth;
    }

    public BigDecimal getVCoreCoefficient() {
        return vCoreCoefficient;
    }

    public void setVCoreCoefficient(BigDecimal vCoreCoefficient) {
        this.vCoreCoefficient = vCoreCoefficient;
    }

    public BigDecimal getVCoreReductionCoefficient() {
        return vCoreReductionCoefficient;
    }

    public void setVCoreReductionCoefficient(BigDecimal vCoreReductionCoefficient) {
        this.vCoreReductionCoefficient = vCoreReductionCoefficient;
    }

    public BigDecimal getVCoreNormCoefficient() {
        return vCoreNormCoefficient;
    }

    public void setVCoreNormCoefficient(BigDecimal vCoreNormCoefficient) {
        this.vCoreNormCoefficient = vCoreNormCoefficient;
    }

    public BigDecimal getCustomVCorePerMonthMultiplier() {
        return customVCorePerMonthMultiplier;
    }

    public void setCustomVCorePerMonthMultiplier(BigDecimal customVCorePerMonthMultiplier) {
        this.customVCorePerMonthMultiplier = customVCorePerMonthMultiplier;
    }

    public BigDecimal getMemoryGBPerMonth() {
        return memoryGBPerMonth;
    }

    public void setMemoryGBPerMonth(BigDecimal memoryGBPerMonth) {
        this.memoryGBPerMonth = memoryGBPerMonth;
    }

    public BigDecimal getCustomMemoryGBPerMonthMultiplier() {
        return customMemoryGBPerMonthMultiplier;
    }

    public void setCustomMemoryGBPerMonthMultiplier(BigDecimal customMemoryGBPerMonthMultiplier) {
        this.customMemoryGBPerMonthMultiplier = customMemoryGBPerMonthMultiplier;
    }

    public BigDecimal getWindowsLicensePerVCorePerMonth() {
        return windowsLicensePerVCorePerMonth;
    }

    public void setWindowsLicensePerVCorePerMonth(BigDecimal windowsLicensePerVCorePerMonth) {
        this.windowsLicensePerVCorePerMonth = windowsLicensePerVCorePerMonth;
    }

    public BigDecimal getCustomWindowsLicensePerVCorePerMonthMultiplier() {
        return customWindowsLicensePerVCorePerMonthMultiplier;
    }

    public void setCustomWindowsLicensePerVCorePerMonthMultiplier(BigDecimal customWindowsLicensePerVCorePerMonthMultiplier) {
        this.customWindowsLicensePerVCorePerMonthMultiplier = customWindowsLicensePerVCorePerMonthMultiplier;
    }

    public BigDecimal getWindowsLicensePerMemoryGBPerMonth() {
        return windowsLicensePerMemoryGBPerMonth;
    }

    public void setWindowsLicensePerMemoryGBPerMonth(BigDecimal windowsLicensePerMemoryGBPerMonth) {
        this.windowsLicensePerMemoryGBPerMonth = windowsLicensePerMemoryGBPerMonth;
    }

    public BigDecimal getCustomWindowsLicensePerMemoryGBPerMonthMultiplier() {
        return customWindowsLicensePerMemoryGBPerMonthMultiplier;
    }

    public void setCustomWindowsLicensePerMemoryGBPerMonthMultiplier(BigDecimal customWindowsLicensePerMemoryGBPerMonthMultiplier) {
        this.customWindowsLicensePerMemoryGBPerMonthMultiplier = customWindowsLicensePerMemoryGBPerMonthMultiplier;
    }

    public BigDecimal getWindowsLicensePerMonth() {
        return windowsLicensePerMonth;
    }

    public void setWindowsLicensePerMonth(BigDecimal windowsLicensePerMonth) {
        this.windowsLicensePerMonth = windowsLicensePerMonth;
    }

    public BigDecimal getCustomWindowsLicensePerMonthMultiplier() {
        return customWindowsLicensePerMonthMultiplier;
    }

    public void setCustomWindowsLicensePerMonthMultiplier(BigDecimal customWindowsLicensePerMonthMultiplier) {
        this.customWindowsLicensePerMonthMultiplier = customWindowsLicensePerMonthMultiplier;
    }

    public String getWindowsPriceCalculationMode() {
        return windowsPriceCalculationMode;
    }

    public void setWindowsPriceCalculationMode(String windowsPriceCalculationMode) {
        this.windowsPriceCalculationMode = windowsPriceCalculationMode;
    }

    public BigDecimal getStorageOverValue() {
        return storageOverValue;
    }

    public void setStorageOverValue(BigDecimal storageOverValue) {
        this.storageOverValue = storageOverValue;
    }

    public BigDecimal getStorageGBUnderValuePerMonth() {
        return storageGBUnderValuePerMonth;
    }

    public void setStorageGBUnderValuePerMonth(BigDecimal storageGBUnderValuePerMonth) {
        this.storageGBUnderValuePerMonth = storageGBUnderValuePerMonth;
    }

    public BigDecimal getStorageGBOverValuePerMonth() {
        return storageGBOverValuePerMonth;
    }

    public void setStorageGBOverValuePerMonth(BigDecimal storageGBOverValuePerMonth) {
        this.storageGBOverValuePerMonth = storageGBOverValuePerMonth;
    }

    public BigDecimal getSystemStorageOverValue() {
        return systemStorageOverValue;
    }

    public void setSystemStorageOverValue(BigDecimal systemStorageOverValue) {
        this.systemStorageOverValue = systemStorageOverValue;
    }

    public BigDecimal getSystemStorageGBUnderValuePerMonth() {
        return systemStorageGBUnderValuePerMonth;
    }

    public void setSystemStorageGBUnderValuePerMonth(BigDecimal systemStorageGBUnderValuePerMonth) {
        this.systemStorageGBUnderValuePerMonth = systemStorageGBUnderValuePerMonth;
    }

    public BigDecimal getSystemStorageGBOverValuePerMonth() {
        return systemStorageGBOverValuePerMonth;
    }

    public void setSystemStorageGBOverValuePerMonth(BigDecimal systemStorageGBOverValuePerMonth) {
        this.systemStorageGBOverValuePerMonth = systemStorageGBOverValuePerMonth;
    }

    public BigDecimal getStoragePassiveGBPerMonth() {
        return storagePassiveGBPerMonth;
    }

    public void setStoragePassiveGBPerMonth(BigDecimal storagePassiveGBPerMonth) {
        this.storagePassiveGBPerMonth = storagePassiveGBPerMonth;
    }

    public BigDecimal getStorageActiveGBPerMonth() {
        return storageActiveGBPerMonth;
    }

    public void setStorageActiveGBPerMonth(BigDecimal storageActiveGBPerMonth) {
        this.storageActiveGBPerMonth = storageActiveGBPerMonth;
    }

    public BigDecimal getAdditionalStorageMultiplier() {
        return additionalStorageMultiplier;
    }

    public void setAdditionalStorageMultiplier(BigDecimal additionalStorageMultiplier) {
        this.additionalStorageMultiplier = additionalStorageMultiplier;
    }

    public String getStorageCalculationMode() {
        return storageCalculationMode;
    }

    public void setStorageCalculationMode(String storageCalculationMode) {
        this.storageCalculationMode = storageCalculationMode;
    }

    public BigDecimal getCheckpointOverValue() {
        return checkpointOverValue;
    }

    public void setCheckpointOverValue(BigDecimal checkpointOverValue) {
        this.checkpointOverValue = checkpointOverValue;
    }

    public BigDecimal getCheckpointGBUnderValuePerMonth() {
        return checkpointGBUnderValuePerMonth;
    }

    public void setCheckpointGBUnderValuePerMonth(BigDecimal checkpointGBUnderValuePerMonth) {
        this.checkpointGBUnderValuePerMonth = checkpointGBUnderValuePerMonth;
    }

    public BigDecimal getCheckpointGBOverValuePerMonth() {
        return checkpointGBOverValuePerMonth;
    }

    public void setCheckpointGBOverValuePerMonth(BigDecimal checkpointGBOverValuePerMonth) {
        this.checkpointGBOverValuePerMonth = checkpointGBOverValuePerMonth;
    }

    public BigDecimal getCheckpointPassiveGBPerMonth() {
        return checkpointPassiveGBPerMonth;
    }

    public void setCheckpointPassiveGBPerMonth(BigDecimal checkpointPassiveGBPerMonth) {
        this.checkpointPassiveGBPerMonth = checkpointPassiveGBPerMonth;
    }

    public BigDecimal getCheckpointActiveGBPerMonth() {
        return checkpointActiveGBPerMonth;
    }

    public void setCheckpointActiveGBPerMonth(BigDecimal checkpointActiveGBPerMonth) {
        this.checkpointActiveGBPerMonth = checkpointActiveGBPerMonth;
    }

    public String getCheckpointCalculationMode() {
        return checkpointCalculationMode;
    }

    public void setCheckpointCalculationMode(String checkpointCalculationMode) {
        this.checkpointCalculationMode = checkpointCalculationMode;
    }

    public BigDecimal getMachineImageOverValue() {
        return machineImageOverValue;
    }

    public void setMachineImageOverValue(BigDecimal machineImageOverValue) {
        this.machineImageOverValue = machineImageOverValue;
    }

    public BigDecimal getMachineImageGBUnderValuePerMonth() {
        return machineImageGBUnderValuePerMonth;
    }

    public void setMachineImageGBUnderValuePerMonth(BigDecimal machineImageGBUnderValuePerMonth) {
        this.machineImageGBUnderValuePerMonth = machineImageGBUnderValuePerMonth;
    }

    public BigDecimal getMachineImageGBOverValuePerMonth() {
        return machineImageGBOverValuePerMonth;
    }

    public void setMachineImageGBOverValuePerMonth(BigDecimal machineImageGBOverValuePerMonth) {
        this.machineImageGBOverValuePerMonth = machineImageGBOverValuePerMonth;
    }

    public String getMachineImageCalculationMode() {
        return machineImageCalculationMode;
    }

    public void setMachineImageCalculationMode(String machineImageCalculationMode) {
        this.machineImageCalculationMode = machineImageCalculationMode;
    }

    public List<SdkPriceCorrection> getPriceCorrections() {
        return priceCorrections;
    }

    public void setPriceCorrections(List<SdkPriceCorrection> priceCorrections) {
        this.priceCorrections = priceCorrections;
    }

    public List<SdkServicePrice> getServicePrices() {
        return servicePrices;
    }

    public void setServicePrices(List<SdkServicePrice> servicePrices) {
        this.servicePrices = servicePrices;
    }

    public List<SdkLocationInfo> getLocationsPrices() {
        return locationsPrices;
    }

    public void setLocationsPrices(List<SdkLocationInfo> locationsPrices) {
        this.locationsPrices = locationsPrices;
    }

    public List<SdkVirtualDataCenter> getVirtualDataCenters() {
        return virtualDataCenters;
    }

    public void setVirtualDataCenters(List<SdkVirtualDataCenter> virtualDataCenters) {
        this.virtualDataCenters = virtualDataCenters;
    }

    public String getHoursInMonthMode() {
        return hoursInMonthMode;
    }

    public void setHoursInMonthMode(String hoursInMonthMode) {
        this.hoursInMonthMode = hoursInMonthMode;
    }

    public BigDecimal getFixedHoursInMonth() {
        return fixedHoursInMonth;
    }

    public void setFixedHoursInMonth(BigDecimal fixedHoursInMonth) {
        this.fixedHoursInMonth = fixedHoursInMonth;
    }

    public int getVCoresScale() {
        return vCoresScale;
    }

    public void setVCoresScale(int vCoresScale) {
        this.vCoresScale = vCoresScale;
    }

    public RoundingMode getVCoresRounding() {
        return vCoresRounding;
    }

    public void setVCoresRounding(RoundingMode vCoresRounding) {
        this.vCoresRounding = vCoresRounding;
    }

    public int getMemoryScale() {
        return memoryScale;
    }

    public void setMemoryScale(int memoryScale) {
        this.memoryScale = memoryScale;
    }

    public RoundingMode getMemoryRounding() {
        return memoryRounding;
    }

    public void setMemoryRounding(RoundingMode memoryRounding) {
        this.memoryRounding = memoryRounding;
    }

    public int getInstanceBaseScale() {
        return instanceBaseScale;
    }

    public void setInstanceBaseScale(int instanceBaseScale) {
        this.instanceBaseScale = instanceBaseScale;
    }

    public RoundingMode getInstanceBaseRounding() {
        return instanceBaseRounding;
    }

    public void setInstanceBaseRounding(RoundingMode instanceBaseRounding) {
        this.instanceBaseRounding = instanceBaseRounding;
    }

    public int getWindowsScale() {
        return windowsScale;
    }

    public void setWindowsScale(int windowsScale) {
        this.windowsScale = windowsScale;
    }

    public RoundingMode getWindowsRounding() {
        return windowsRounding;
    }

    public void setWindowsRounding(RoundingMode windowsRounding) {
        this.windowsRounding = windowsRounding;
    }

    public int getInstanceRunFeeScale() {
        return instanceRunFeeScale;
    }

    public void setInstanceRunFeeScale(int instanceRunFeeScale) {
        this.instanceRunFeeScale = instanceRunFeeScale;
    }

    public RoundingMode getInstanceRunFeeRounding() {
        return instanceRunFeeRounding;
    }

    public void setInstanceRunFeeRounding(RoundingMode instanceRunFeeRounding) {
        this.instanceRunFeeRounding = instanceRunFeeRounding;
    }

    public int getStorageScale() {
        return storageScale;
    }

    public void setStorageScale(int storageScale) {
        this.storageScale = storageScale;
    }

    public RoundingMode getStorageRounding() {
        return storageRounding;
    }

    public void setStorageRounding(RoundingMode storageRounding) {
        this.storageRounding = storageRounding;
    }

    public int getCheckpointScale() {
        return checkpointScale;
    }

    public void setCheckpointScale(int checkpointScale) {
        this.checkpointScale = checkpointScale;
    }

    public RoundingMode getCheckpointRounding() {
        return checkpointRounding;
    }

    public void setCheckpointRounding(RoundingMode checkpointRounding) {
        this.checkpointRounding = checkpointRounding;
    }

    public int getMachineImageScale() {
        return machineImageScale;
    }

    public void setMachineImageScale(int machineImageScale) {
        this.machineImageScale = machineImageScale;
    }

    public RoundingMode getMachineImageRounding() {
        return machineImageRounding;
    }

    public void setMachineImageRounding(RoundingMode machineImageRounding) {
        this.machineImageRounding = machineImageRounding;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        this.roundingMode = roundingMode;
    }
}
