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

package io.maestro3.sdk.v3.request.ownership;

import io.maestro3.sdk.v3.model.ownership.ResourceType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OpenStackResourceIdRequestTest {

    private List<ResourceIdRequest> requests = new ArrayList<>();

    @Before
    public void init() {
        String regionName = "regionName";
        String resourceId = "resourceId";
        String projectId = "projectId";
        String accountId = "accountId";

        ResourceIdRequest openStackResourceIdRequest = OpenStackResourceIdRequest.builder()
                .withResourceId(resourceId)
                .withProjectId(projectId)
                .withResourceType(ResourceType.INSTANCE)
                .withRegion(regionName)
                .build();

        ResourceIdRequest awsResourceIdRequest = AwsResourceIdRequest.builder()
                .withRegion(regionName)
                .withResourceId(resourceId)
                .withAccountId(accountId)
                .withResourceId(resourceId)
                .withResourceType(ResourceType.INSTANCE)
                .build();

        ResourceIdRequest azureResourceIdRequest = AzureResourceIdRequest.builder()
                .withResourceId(resourceId)
                .withResourceGroup("resourceGroup")
                .withResourceType(ResourceType.INSTANCE)
                .withSubscriptionId("subscribtionId")
                .withRegion(regionName)
                .build();

        ResourceIdRequest csaResourceIdRequest = CSAResourceIdRequest.builder()
                .withResourceId(resourceId)
                .withProjectId(projectId)
                .withRegion(regionName)
                .withResourceType(ResourceType.INSTANCE)
                .build();

        ResourceIdRequest googleResourceIdRequest = GoogleResourceIdRequest.builder()
                .withResourceId(resourceId)
                .withProjectId(projectId)
                .withResourceType(ResourceType.INSTANCE)
                .withRegion(regionName)
                .build();

        ResourceIdRequest hardwareResourceIdRequest = HardwareResourceIdRequest.builder()
                .withResourceId(resourceId)
                .withProjectId(projectId)
                .withRegion(regionName)
                .withResourceType(ResourceType.INSTANCE)
                .build();

        requests.add(openStackResourceIdRequest);
        requests.add(awsResourceIdRequest);
        requests.add(azureResourceIdRequest);
        requests.add(azureResourceIdRequest);
        requests.add(csaResourceIdRequest);
        requests.add(googleResourceIdRequest);
        requests.add(hardwareResourceIdRequest);
    }

    @Test
    public void shouldGetResourceParamsMap() {
        requests.forEach(resourceIdRequest -> {
            Map<String, String> paramMap = resourceIdRequest.getParams();
            Assert.assertFalse(paramMap.isEmpty());
            Assert.assertNotNull(paramMap);
        });
    }

}
