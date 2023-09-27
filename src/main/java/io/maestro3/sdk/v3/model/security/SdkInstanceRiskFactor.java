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

package io.maestro3.sdk.v3.model.security;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum SdkInstanceRiskFactor {

    NONE(0), LOW(1), MEDIUM(2), HIGH(3), CRITICAL(4);

    private int priority;

    SdkInstanceRiskFactor(int priority) {
        this.priority = priority;
    }

    @JsonCreator
    public static SdkInstanceRiskFactor fromValue(String name) {
        for (SdkInstanceRiskFactor value : values()) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }
        return null;
    }

    public int getPriority() {
        return priority;
    }
}
