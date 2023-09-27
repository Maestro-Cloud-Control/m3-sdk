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

package io.maestro3.sdk.v3.model.price;

import java.util.List;

public class SdkPriceModel {

    private String targetGroup;

    private SdkInstancePriceModel instancePriceModel;
    private SdkStoragePriceModel storagePriceModel;
    private SdkMachineImagePriceModel machineImagePriceModel;
    private SdkCheckpointPriceModel checkpointPriceModel;
    private List<SdkServicePriceModel> servicePriceModels;

    private SdkHardwarePriceModel hardwarePriceModel;

    private List<SdkPriceCorrection> staticMonthlyPrices;

    public String getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    public SdkInstancePriceModel getInstancePriceModel() {
        return instancePriceModel;
    }

    public void setInstancePriceModel(SdkInstancePriceModel instancePriceModel) {
        this.instancePriceModel = instancePriceModel;
    }

    public SdkStoragePriceModel getStoragePriceModel() {
        return storagePriceModel;
    }

    public void setStoragePriceModel(SdkStoragePriceModel storagePriceModel) {
        this.storagePriceModel = storagePriceModel;
    }

    public SdkMachineImagePriceModel getMachineImagePriceModel() {
        return machineImagePriceModel;
    }

    public void setMachineImagePriceModel(SdkMachineImagePriceModel machineImagePriceModel) {
        this.machineImagePriceModel = machineImagePriceModel;
    }

    public SdkCheckpointPriceModel getCheckpointPriceModel() {
        return checkpointPriceModel;
    }

    public void setCheckpointPriceModel(SdkCheckpointPriceModel checkpointPriceModel) {
        this.checkpointPriceModel = checkpointPriceModel;
    }

    public List<SdkServicePriceModel> getServicePriceModels() {
        return servicePriceModels;
    }

    public void setServicePriceModels(List<SdkServicePriceModel> servicePriceModels) {
        this.servicePriceModels = servicePriceModels;
    }

    public SdkHardwarePriceModel getHardwarePriceModel() {
        return hardwarePriceModel;
    }

    public void setHardwarePriceModel(SdkHardwarePriceModel hardwarePriceModel) {
        this.hardwarePriceModel = hardwarePriceModel;
    }

    public List<SdkPriceCorrection> getStaticMonthlyPrices() {
        return staticMonthlyPrices;
    }

    public void setStaticMonthlyPrices(List<SdkPriceCorrection> staticMonthlyPrices) {
        this.staticMonthlyPrices = staticMonthlyPrices;
    }
}
