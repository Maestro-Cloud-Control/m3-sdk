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

package io.maestro3.sdk.v3.model.terraform.template;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SdkTemplateType {
    CLOUD_FORMATION("CloudFormation", true, Collections.singletonList(SdkCloud.AWS)),
    GOOGLE("Google", false, Collections.singletonList(SdkCloud.GOOGLE)),
    AZURE("Azure", false, Collections.singletonList(SdkCloud.AZURE)),
    AZURE_BICEP("Azure Bicep", true, Collections.singletonList(SdkCloud.AZURE)),
    TERRAFORM("Terraform", true, Arrays.asList(SdkCloud.AWS, SdkCloud.GOOGLE, SdkCloud.AZURE, SdkCloud.YANDEX,
        SdkCloud.OPEN_STACK, SdkCloud.VMWARE, SdkCloud.VSPHERE));

    private static final SdkTemplateType[] VALUES = values();
    private String title;
    private boolean supported;
    private List<SdkCloud> supportedClouds;

    SdkTemplateType(String title, boolean supported, List<SdkCloud> supportedClouds) {
        this.title = title;
        this.supported = supported;
        this.supportedClouds = supportedClouds;
    }

    @JsonCreator
    public static SdkTemplateType fromValue(String name) {
        for (SdkTemplateType templateType : VALUES) {
            if (templateType.name().equalsIgnoreCase(name)) {
                return templateType;
            }
        }
        throw new M3SdkException("Failed to find template type by name " + name);
    }


    public static List<SdkTemplateType> getSupportedTypes(SdkCloud cloud) {
        return Stream.of(VALUES)
                .filter(v -> v.supported && v.supportedClouds.contains(cloud))
                .collect(Collectors.toList());
    }

    public String getTitle() {
        return title;
    }

    public boolean isSupported() {
        return supported;
    }
}
