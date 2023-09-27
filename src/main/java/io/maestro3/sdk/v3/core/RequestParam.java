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

package io.maestro3.sdk.v3.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RequestParam {

    TENANT("tenant"),
    INSTANCE_ID("instanceId"),
    IDENTITY_ID("identityId"),
    REGION("region"),
    RESOURCE_GROUP("resourceGroup"),
    AVAILABILITY_ZONE("availabilityZone"),
    NATIVE_PLATFORM("nativePlatform"),
    CLOUD("cloud");

    private static final RequestParam[] VALUES = RequestParam.values();
    private String paramName;

    RequestParam(String paramName) {
        this.paramName = paramName;
    }

    @JsonCreator
    public static RequestParam fromValue(String paramName) {
        for (RequestParam requestParam : VALUES) {
            if (requestParam.getParamName().equalsIgnoreCase(paramName)) {
                return requestParam;
            }
        }
        return null;
    }

    @JsonValue
    public String getParamName() {
        return paramName;
    }
}
