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

public final class OwnershipCloudParamNames {

    // COMMON
    public static final String TENANT = "tenant";
    public static final String REGION = "region";
    public static final String RESOURCE_ID = "resourceId";
    public static final String RESOURCE_TYPE = "resourceType";

    // AWS
    public static final String AWS_ACCOUNT_ID = "accountId";

    // GGL
    public static final String GGL_PROJECT_ID = "projectId";
    public static final String AVAILABILITY_ZONE = "availabilityZone";

    // AZURE
    public static final String AZURE_SUBSCRIPTION_ID = "subscriptionId";
    public static final String RESOURCE_GROUP = "resourceGroup";

    // OPEN_STACK
    public static final String OPEN_STACK_PROJECT_ID = "openStackProjectId";

    // YANDEX
    public static final String CLOUD_RESOURCE_ID = "cloudResourceId";

    //HARDWARE
    public static final String HARDWARE_PROJECT_ID = "hardwareProjectId";

    //CSA
    public static final String CSA_PROJECT_ID = "csaProjectId";

    // VMWARE
    public static final String VMWARE_PROJECT_ID = "vmwareProjectId";

    //Enterprise
    public static final String ENTERPRISE_PROJECT_ID = "enterpriseProjectId";

    // VSPHERE
    public static final String VSPHERE_PROJECT_ID = "vsphereProjectId";

    // Nutanix
    public static final String NUTANIX_PROJECT_ID = "nutanixProjectId";

    // Hyperv
    public static final String HYPERV_PROJECT_ID = "hypervProjectId";

    private OwnershipCloudParamNames() {
    }
}
