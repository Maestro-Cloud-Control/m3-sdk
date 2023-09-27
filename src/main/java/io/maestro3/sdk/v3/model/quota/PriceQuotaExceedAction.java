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

package io.maestro3.sdk.v3.model.quota;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum PriceQuotaExceedAction {
    RUN_VM_WITH_APPROVE,
    RUN_TEMPLATE_WITH_APPROVE,
    //from maestro2
    NOTHING,
    STOP,
    ALLOW_AFTER_APPROVE,
    DENY_RUN_VM;

    @JsonCreator
    public static PriceQuotaExceedAction fromValue(String name) {
        for (PriceQuotaExceedAction value : values()) {
            if (name.equalsIgnoreCase(value.name()))
                return value;
        }
        throw new IllegalArgumentException("Action with name '" + name + "' is not supported");
    }
}
