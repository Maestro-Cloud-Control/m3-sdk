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

import java.util.List;
import java.util.Map;

public class SdkVolumeTypesPrices {
    private SdkVolumePrices baseVolumePrices;
    private Map<String, List<SdkVolumePrices>> volumePricesByType;
    private boolean calcVolumesWithInstance;

    public SdkVolumeTypesPrices() {
    }

    public SdkVolumeTypesPrices(SdkVolumePrices baseVolumePrices,
                                Map<String, List<SdkVolumePrices>> volumePricesByType,
                                boolean calcVolumesWithInstance) {
        this.baseVolumePrices = baseVolumePrices;
        this.volumePricesByType = volumePricesByType;
        this.calcVolumesWithInstance = calcVolumesWithInstance;
    }

    public SdkVolumePrices getBaseVolumePrices() {
        return baseVolumePrices;
    }

    public void setBaseVolumePrices(SdkVolumePrices baseVolumePrices) {
        this.baseVolumePrices = baseVolumePrices;
    }

    public Map<String, List<SdkVolumePrices>> getVolumePricesByType() {
        return volumePricesByType;
    }

    public void setVolumePricesByType(Map<String, List<SdkVolumePrices>> volumePricesByType) {
        this.volumePricesByType = volumePricesByType;
    }

    public boolean isCalcVolumesWithInstance() {
        return calcVolumesWithInstance;
    }

    public void setCalcVolumesWithInstance(boolean calcVolumesWithInstance) {
        this.calcVolumesWithInstance = calcVolumesWithInstance;
    }
}
