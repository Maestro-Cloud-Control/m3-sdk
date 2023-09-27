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

public class SdkInstancePrices {
    private SdkVCorePrices baseVCorePrices;
    private Map<String, List<SdkVCorePrices>> customVCorePricesByTypes;

    private SdkMemoryPrices baseMemoryPrices;
    private Map<String, List<SdkMemoryPrices>> customMemoryGBPricesByTypes;

    private boolean applyForActiveOnly;

    public SdkInstancePrices() {
    }

    public SdkInstancePrices(SdkVCorePrices baseVCorePrices,
                          Map<String, List<SdkVCorePrices>> customVCorePricesByTypes,
                          SdkMemoryPrices baseMemoryPrices,
                          Map<String, List<SdkMemoryPrices>> customMemoryGBPricesByTypes,
                          boolean applyForActiveOnly) {
        this.baseVCorePrices = baseVCorePrices;
        this.customVCorePricesByTypes = customVCorePricesByTypes;
        this.baseMemoryPrices = baseMemoryPrices;
        this.customMemoryGBPricesByTypes = customMemoryGBPricesByTypes;
        this.applyForActiveOnly = applyForActiveOnly;
    }

    public SdkVCorePrices getBaseVCorePrices() {
        return baseVCorePrices;
    }

    public void setBaseVCorePrices(SdkVCorePrices baseVCorePrices) {
        this.baseVCorePrices = baseVCorePrices;
    }

    public Map<String, List<SdkVCorePrices>> getCustomVCorePricesByTypes() {
        return customVCorePricesByTypes;
    }

    public void setCustomVCorePricesByTypes(Map<String, List<SdkVCorePrices>> customVCorePricesByTypes) {
        this.customVCorePricesByTypes = customVCorePricesByTypes;
    }

    public SdkMemoryPrices getBaseMemoryPrices() {
        return baseMemoryPrices;
    }

    public void setBaseMemoryPrices(SdkMemoryPrices baseMemoryPrices) {
        this.baseMemoryPrices = baseMemoryPrices;
    }

    public Map<String, List<SdkMemoryPrices>> getCustomMemoryGBPricesByTypes() {
        return customMemoryGBPricesByTypes;
    }

    public void setCustomMemoryGBPricesByTypes(Map<String, List<SdkMemoryPrices>> customMemoryGBPricesByTypes) {
        this.customMemoryGBPricesByTypes = customMemoryGBPricesByTypes;
    }

    public boolean isApplyForActiveOnly() {
        return applyForActiveOnly;
    }

    public void setApplyForActiveOnly(boolean applyForActiveOnly) {
        this.applyForActiveOnly = applyForActiveOnly;
    }
}
