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

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.ownership.ResourceType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResourceIdRequestSerializationTest {

    private static final String RESOURCE_ID  = "resource-001";
    private static final String TENANT       = "tenant-001";
    private static final String REGION       = "us-east-1";
    private static final String PROJECT_ID   = "project-001";
    private static final ResourceType RESOURCE_TYPE = ResourceType.INSTANCE;

    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        // The "cloud" field is serialized from getCloud() but is set implicitly in each
        // subclass constructor (not exposed via the builder), so we must ignore it on read-back.
        objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    // ------------------------------------------------------------------ helpers

    private String serialize(ResourceIdRequest request) throws Exception {
        return objectMapper.writeValueAsString(request);
    }

    private ResourceIdRequest deserializeAsAbstract(String json) throws Exception {
        return objectMapper.readValue(json, ResourceIdRequest.class);
    }

    private <T extends ResourceIdRequest> T deserializeAs(String json, Class<T> type) throws Exception {
        return objectMapper.readValue(json, type);
    }

    private void assertBaseFields(ResourceIdRequest request, SdkCloud expectedCloud) {
        Assert.assertEquals(RESOURCE_ID,   request.getResourceId());
        Assert.assertEquals(TENANT,        request.getTenant());
        Assert.assertEquals(REGION,        request.getRegion());
        Assert.assertEquals(RESOURCE_TYPE, request.getResourceType());
        Assert.assertEquals(expectedCloud, request.getCloud());
    }

    // ------------------------------------------------------------------ AWS

    @Test
    public void awsResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        AwsResourceIdRequest original = AwsResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withAccountId("aws-account-001")
                .build();

        String json = serialize(original);

        Assert.assertTrue("JSON must contain resourceId",  json.contains("resource-001"));
        Assert.assertTrue("JSON must contain accountId",   json.contains("aws-account-001"));

        AwsResourceIdRequest deserialized = deserializeAs(json, AwsResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.AWS);
        Assert.assertEquals("aws-account-001", deserialized.getAccountId());
    }

    @Test
    public void awsResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        AwsResourceIdRequest original = AwsResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withAccountId("aws-account-001")
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof AwsResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.AWS);
        Assert.assertEquals("aws-account-001", deserialized.getAccountId());
    }

    // ------------------------------------------------------------------ Azure

    @Test
    public void azureResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        AzureResourceIdRequest original = AzureResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withSubscriptionId("azure-sub-001")
                .withResourceGroup("rg-001")
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains("azure-sub-001"));
        Assert.assertTrue(json.contains("rg-001"));

        AzureResourceIdRequest deserialized = deserializeAs(json, AzureResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.AZURE);
        Assert.assertEquals("azure-sub-001", deserialized.getSubscriptionId());
        Assert.assertEquals("rg-001",        deserialized.getResourceGroup());
    }

    @Test
    public void azureResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        AzureResourceIdRequest original = AzureResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withSubscriptionId("azure-sub-001")
                .withResourceGroup("rg-001")
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof AzureResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.AZURE);
        Assert.assertEquals("azure-sub-001", ((AzureResourceIdRequest) deserialized).getSubscriptionId());
        Assert.assertEquals("rg-001",        ((AzureResourceIdRequest) deserialized).getResourceGroup());
    }

    // ------------------------------------------------------------------ Google

    @Test
    public void googleResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        GoogleResourceIdRequest original = GoogleResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .withAvailabilityZone("us-central1-a")
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains(PROJECT_ID));
        Assert.assertTrue(json.contains("us-central1-a"));

        GoogleResourceIdRequest deserialized = deserializeAs(json, GoogleResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.GOOGLE);
        Assert.assertEquals(PROJECT_ID,      deserialized.getProjectId());
        Assert.assertEquals("us-central1-a", deserialized.getAvailabilityZone());
    }

    @Test
    public void googleResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        GoogleResourceIdRequest original = GoogleResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .withAvailabilityZone("us-central1-a")
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof GoogleResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.GOOGLE);
        Assert.assertEquals(PROJECT_ID,      ((GoogleResourceIdRequest) deserialized).getProjectId());
        Assert.assertEquals("us-central1-a", ((GoogleResourceIdRequest) deserialized).getAvailabilityZone());
    }

    // ------------------------------------------------------------------ OpenStack

    @Test
    public void openStackResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        OpenStackResourceIdRequest original = OpenStackResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains(PROJECT_ID));

        OpenStackResourceIdRequest deserialized = deserializeAs(json, OpenStackResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.OPEN_STACK);
        Assert.assertEquals(PROJECT_ID, deserialized.getProjectId());
    }

    @Test
    public void openStackResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        OpenStackResourceIdRequest original = OpenStackResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof OpenStackResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.OPEN_STACK);
        Assert.assertEquals(PROJECT_ID, ((OpenStackResourceIdRequest) deserialized).getProjectId());
    }

    // ------------------------------------------------------------------ Yandex

    @Test
    public void yandexResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        YandexResourceIdRequest original = YandexResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withCloudResourceId("yandex-cloud-001")
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains("yandex-cloud-001"));

        YandexResourceIdRequest deserialized = deserializeAs(json, YandexResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.YANDEX);
        Assert.assertEquals("yandex-cloud-001", deserialized.getCloudResourceId());
    }

    @Test
    public void yandexResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        YandexResourceIdRequest original = YandexResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withCloudResourceId("yandex-cloud-001")
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof YandexResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.YANDEX);
        Assert.assertEquals("yandex-cloud-001", ((YandexResourceIdRequest) deserialized).getCloudResourceId());
    }

    // ------------------------------------------------------------------ CSA

    @Test
    public void csaResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        CSAResourceIdRequest original = CSAResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains(PROJECT_ID));

        CSAResourceIdRequest deserialized = deserializeAs(json, CSAResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.CSA);
        Assert.assertEquals(PROJECT_ID, deserialized.getProjectId());
    }

    @Test
    public void csaResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        CSAResourceIdRequest original = CSAResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof CSAResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.CSA);
        Assert.assertEquals(PROJECT_ID, ((CSAResourceIdRequest) deserialized).getProjectId());
    }

    // ------------------------------------------------------------------ Hardware

    @Test
    public void hardwareResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        HardwareResourceIdRequest original = HardwareResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains(PROJECT_ID));

        HardwareResourceIdRequest deserialized = deserializeAs(json, HardwareResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.HARDWARE);
        Assert.assertEquals(PROJECT_ID, deserialized.getProjectId());
    }

    @Test
    public void hardwareResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        HardwareResourceIdRequest original = HardwareResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof HardwareResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.HARDWARE);
        Assert.assertEquals(PROJECT_ID, ((HardwareResourceIdRequest) deserialized).getProjectId());
    }

    // ------------------------------------------------------------------ Enterprise

    @Test
    public void enterpriseResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        EnterpriseResourceIdRequest original = EnterpriseResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains(PROJECT_ID));

        EnterpriseResourceIdRequest deserialized = deserializeAs(json, EnterpriseResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.ENTERPRISE);
        Assert.assertEquals(PROJECT_ID, deserialized.getProjectId());
    }

    @Test
    public void enterpriseResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        EnterpriseResourceIdRequest original = EnterpriseResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof EnterpriseResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.ENTERPRISE);
        Assert.assertEquals(PROJECT_ID, ((EnterpriseResourceIdRequest) deserialized).getProjectId());
    }

    // ------------------------------------------------------------------ VMware

    @Test
    public void vmwareResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        VmwareResourceIdRequest original = VmwareResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains(PROJECT_ID));

        VmwareResourceIdRequest deserialized = deserializeAs(json, VmwareResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.VMWARE);
        Assert.assertEquals(PROJECT_ID, deserialized.getProjectId());
    }

    @Test
    public void vmwareResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        VmwareResourceIdRequest original = VmwareResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof VmwareResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.VMWARE);
        Assert.assertEquals(PROJECT_ID, ((VmwareResourceIdRequest) deserialized).getProjectId());
    }

    // ------------------------------------------------------------------ vSphere

    @Test
    public void vSphereResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        VSphereResourceIdRequest original = VSphereResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains(PROJECT_ID));

        VSphereResourceIdRequest deserialized = deserializeAs(json, VSphereResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.VSPHERE);
        Assert.assertEquals(PROJECT_ID, deserialized.getProjectId());
    }

    @Test
    public void vSphereResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        VSphereResourceIdRequest original = VSphereResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof VSphereResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.VSPHERE);
        Assert.assertEquals(PROJECT_ID, ((VSphereResourceIdRequest) deserialized).getProjectId());
    }

    // ------------------------------------------------------------------ Nutanix

    @Test
    public void nutanixResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        NutanixResourceIdRequest original = NutanixResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains(PROJECT_ID));

        NutanixResourceIdRequest deserialized = deserializeAs(json, NutanixResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.NUTANIX);
        Assert.assertEquals(PROJECT_ID, deserialized.getProjectId());
    }

    @Test
    public void nutanixResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        NutanixResourceIdRequest original = NutanixResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof NutanixResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.NUTANIX);
        Assert.assertEquals(PROJECT_ID, ((NutanixResourceIdRequest) deserialized).getProjectId());
    }

    // ------------------------------------------------------------------ Hyper-V

    @Test
    public void hypervResourceIdRequest_serializeAndDeserialize_directType() throws Exception {
        HypervResourceIdRequest original = HypervResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);

        Assert.assertTrue(json.contains(PROJECT_ID));

        HypervResourceIdRequest deserialized = deserializeAs(json, HypervResourceIdRequest.class);

        assertBaseFields(deserialized, SdkCloud.HYPERV);
        Assert.assertEquals(PROJECT_ID, deserialized.getProjectId());
    }

    @Test
    public void hypervResourceIdRequest_serializeAndDeserialize_abstractType() throws Exception {
        HypervResourceIdRequest original = HypervResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);
        ResourceIdRequest deserialized = deserializeAsAbstract(json);

        Assert.assertNotNull(deserialized);
        Assert.assertTrue(deserialized instanceof HypervResourceIdRequest);
        assertBaseFields(deserialized, SdkCloud.HYPERV);
        Assert.assertEquals(PROJECT_ID, ((HypervResourceIdRequest) deserialized).getProjectId());
    }

    // ------------------------------------------------------------------ JSON structure checks

    @Test
    public void serializedJson_mustContainAtTypeField_forPolymorphicDeserialization() throws Exception {
        OpenStackResourceIdRequest original = OpenStackResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID)
                .withTenant(TENANT)
                .withRegion(REGION)
                .withResourceType(RESOURCE_TYPE)
                .withProjectId(PROJECT_ID)
                .build();

        String json = serialize(original);

        // @JsonTypeInfo(use = Id.NAME, property = "@type") embeds "@type" with the registered short name
        Assert.assertTrue("Serialized JSON must contain '@type' type info field", json.contains("@type"));
        Assert.assertTrue("'@type' value must be the registered short name 'OPEN_STACK'",
                json.contains("OPEN_STACK"));
        Assert.assertFalse("Serialized JSON must NOT contain the full class name anymore",
                json.contains(OpenStackResourceIdRequest.class.getName()));
    }

    @Test
    public void serializedJson_cloud_mustReflectCorrectEnum() throws Exception {
        AwsResourceIdRequest aws = AwsResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID).withTenant(TENANT).withRegion(REGION)
                .withResourceType(RESOURCE_TYPE).withAccountId("acc").build();

        AzureResourceIdRequest azure = AzureResourceIdRequest.builder()
                .withResourceId(RESOURCE_ID).withTenant(TENANT).withRegion(REGION)
                .withResourceType(RESOURCE_TYPE).withSubscriptionId("sub").withResourceGroup("rg").build();

        Assert.assertTrue(serialize(aws).contains("AWS"));
        Assert.assertTrue(serialize(azure).contains("AZURE"));
    }
}



