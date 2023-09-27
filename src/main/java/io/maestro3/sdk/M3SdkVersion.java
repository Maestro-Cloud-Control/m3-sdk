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

package io.maestro3.sdk;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.v3.client.IM3Client;
import io.maestro3.sdk.v3.client.M3Client;

import java.util.Arrays;

/**
 * The supported versions of m3-sdk.
 */
public enum M3SdkVersion {

    V3(3, 2, 80, "v3", "Updated requests", "/maestro/api/v3", null) {
        @Override
        IM3Client client(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
            return new M3Client(actionExecutor, isAsync);
        }
    };

    private static final M3SdkVersion[] VALUES = values();

    private final int major;
    private final int minor;
    private final int micro;
    private final String nameInLowerCase;
    private final String description;
    private final String endpoint;
    private final M3SdkVersion previous;

    M3SdkVersion(int major, int minor, int micro, String nameInLowerCase, String description, String endpoint, M3SdkVersion previous) {
        this.major = major;
        this.minor = minor;
        this.micro = micro;
        this.nameInLowerCase = nameInLowerCase;
        this.description = description;
        this.endpoint = endpoint;
        this.previous = previous;
    }

    @JsonCreator
    public static M3SdkVersion fromValue(String name) {
        return Arrays.stream(VALUES)
                .filter(version -> version.getNameInLowerCase().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    public static M3SdkVersion fromVersion(String sdkVersion) {
        return Arrays.stream(VALUES)
                .filter(version -> version.getVersion().equalsIgnoreCase(sdkVersion))
                .findFirst().orElse(null);
    }

    /**
     * The latest version supported by SDK.
     *
     * @return the latest version supported by SDK
     * @throws M3SdkException if no version of SDK is supported
     */
    public static M3SdkVersion latest() throws M3SdkException {
        if (VALUES.length >= 1) {
            return VALUES[VALUES.length - 1];
        } else {
            throw new M3SdkException("No versions is supported by SDK.");
        }
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getMicro() {
        return micro;
    }

    public String getDescription() {
        return description;
    }

    public String getVersion() {
        return String.format("%s.%s.%s", major, minor, micro);
    }

    abstract IM3Client client(IM3ApiActionExecutor actionExecutor, boolean isAsync);

    public String getEndpoint() {
        return endpoint;
    }

    public M3SdkVersion getPrevious() {
        return previous;
    }

    public String getNameInLowerCase() {
        return nameInLowerCase;
    }
}
