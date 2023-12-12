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

package io.maestro3.sdk.v3.request.nessus;

import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.security.InitNessusSecurityScanRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InitSecurityScanRequestTest {

    @Test
    public void test() {
        InitNessusSecurityScanRequest request = InitNessusSecurityScanRequest.builder()
                .withResourceGroup("resourceGroup")
                .withTemplateId("templateId")
                .withPolicyId("policyId")
                .withInstanceId("instanceId")
                .withRegion("regionId")
                .withCloud(SdkCloud.AWS)
                .withTenantName("tenantName")
                .withAvailabilityZone("availabilityZone")
                .build();
        assertEquals("resourceGroup", request.getResourceGroup());
        assertEquals("templateId", request.getTemplateId());
        assertEquals("policyId", request.getPolicyId());
        assertEquals("instanceId", request.getInstanceId());
        assertEquals("regionId", request.getRegion());
        assertEquals(SdkCloud.AWS, request.getCloud());
        assertEquals("tenantName", request.getTenantName());
        assertEquals("availabilityZone", request.getAvailabilityZone());
    }

}
