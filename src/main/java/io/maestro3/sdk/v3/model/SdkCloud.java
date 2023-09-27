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

package io.maestro3.sdk.v3.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.maestro3.sdk.exception.M3SdkException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SdkCloud {
    AWS(true),
    AZURE(true),
    GOOGLE(true),
    OPEN_STACK(false),
    YANDEX(true),
    CSA(false),
    HARDWARE(false),
    ENTERPRISE(false),
    VMWARE(false),
    VSPHERE(false),
    WORKSPACE(false),
    AOS(false),
    NUTANIX(false),
    HYPERV(false);

    private static final SdkCloud[] VALUES = values();
    public static final List<SdkCloud> ALL = Arrays.asList(values());
    public static final List<SdkCloud> PUBLIC = Arrays.stream(VALUES).filter(SdkCloud::isPublic).collect(Collectors.toList());
    public static final List<SdkCloud> PRIVATE = Arrays.stream(VALUES).filter(cloud -> !cloud.isPublic()).collect(Collectors.toList());

    private boolean publicCloud;

    SdkCloud(boolean publicCloud) {
        this.publicCloud = publicCloud;
    }

    @JsonCreator
    public static SdkCloud fromValue(String name) throws M3SdkException {
        for (SdkCloud sdkCloud : VALUES) {
            if (sdkCloud.name().equalsIgnoreCase(name)) {
                return sdkCloud;
            }
        }
        throw new IllegalArgumentException("Can't instantiate Cloud by name: " + name);
    }

    public boolean isPublic() {
        return publicCloud;
    }
}
