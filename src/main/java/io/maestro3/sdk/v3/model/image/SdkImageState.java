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

package io.maestro3.sdk.v3.model.image;

import java.util.Locale;

public enum SdkImageState {
    AVAILABLE("Available"),
    READY("Ready"),
    FAILED("Failed"),
    SUCCEEDED("Succeeded"),
    IN_PROGRESS("In progress"),
    PENDING("Updating"),
    DELETING("Deleting"),
    CREATING("Creating"),
    UPDATING("Updating"),
    UNKNOWN("Unknown");
    private String name;

    private static final SdkImageState[] VALUES = values();

    SdkImageState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SdkImageState fromValue(String status) {
        String lowerCaseStatus = status.toLowerCase(Locale.US);
        for (SdkImageState imageState : VALUES) {
            if (imageState.name.equalsIgnoreCase(lowerCaseStatus)) {
                return imageState;
            }
        }
        return UNKNOWN;
    }
}
