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

import java.math.RoundingMode;
import java.util.List;

public class SdkDynamicPricingPolicy extends SdkPricingPolicy {

    private List<SdkJavaScriptFunction> javaScriptFunctions;
    private int dynamicServiceScale = 10;
    private RoundingMode dynamicServiceRoundingMode = RoundingMode.CEILING;

    public SdkDynamicPricingPolicy() {
        //json
    }

    public List<SdkJavaScriptFunction> getJavaScriptFunctions() {
        return javaScriptFunctions;
    }

    public void setJavaScriptFunctions(List<SdkJavaScriptFunction> javaScriptFunctions) {
        this.javaScriptFunctions = javaScriptFunctions;
    }

    public int getDynamicServiceScale() {
        return dynamicServiceScale;
    }

    public void setDynamicServiceScale(int dynamicServiceScale) {
        this.dynamicServiceScale = dynamicServiceScale;
    }

    public RoundingMode getDynamicServiceRoundingMode() {
        return dynamicServiceRoundingMode;
    }

    public void setDynamicServiceRoundingMode(RoundingMode dynamicServiceRoundingMode) {
        this.dynamicServiceRoundingMode = dynamicServiceRoundingMode;
    }
}
