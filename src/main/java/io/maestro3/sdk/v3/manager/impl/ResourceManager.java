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

package io.maestro3.sdk.v3.manager.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.manager.IResourceManager;
import io.maestro3.sdk.v3.model.custodian.SdkCustodianResourceScanResults;
import io.maestro3.sdk.v3.model.image.SdkImage;
import io.maestro3.sdk.v3.model.instance.SdkCloudWatchAgentInstanceInfo;
import io.maestro3.sdk.v3.model.instance.SdkHashedPassword;
import io.maestro3.sdk.v3.model.instance.SdkInstance;
import io.maestro3.sdk.v3.model.instance.SdkInstances;
import io.maestro3.sdk.v3.model.instance.SdkKeyPair;
import io.maestro3.sdk.v3.model.instance.SdkResourceTagDto;
import io.maestro3.sdk.v3.model.instance.SdkVolume;
import io.maestro3.sdk.v3.model.kubernetes.SdkKubernetesClusters;
import io.maestro3.sdk.v3.model.recommendation.SdkRecommendation;
import io.maestro3.sdk.v3.model.recommendation.SdkRecommendationSetting;
import io.maestro3.sdk.v3.model.resource.SdkRegionInfo;
import io.maestro3.sdk.v3.model.resource.SdkResource;
import io.maestro3.sdk.v3.model.resource.SdkTenantInfo;
import io.maestro3.sdk.v3.model.shape.SdkShapeInfo;
import io.maestro3.sdk.v3.request.custodian.CustodianLastResourceScanRequest;
import io.maestro3.sdk.v3.request.image.CreateImageRequest;
import io.maestro3.sdk.v3.request.image.DeleteImageRequest;
import io.maestro3.sdk.v3.request.image.DescribeImageRequest;
import io.maestro3.sdk.v3.request.instance.DescribeInstanceCloudWatchAgentsRequest;
import io.maestro3.sdk.v3.request.instance.DescribeInstanceRequest;
import io.maestro3.sdk.v3.request.instance.GetInstanceHashedPasswordRequest;
import io.maestro3.sdk.v3.request.instance.InstallInstanceCloudWatchAgentRequest;
import io.maestro3.sdk.v3.request.instance.ManageInstanceTerminationProtectionRequest;
import io.maestro3.sdk.v3.request.instance.RebootInstanceRequest;
import io.maestro3.sdk.v3.request.instance.RunInstanceRequest;
import io.maestro3.sdk.v3.request.instance.StartInstanceRequest;
import io.maestro3.sdk.v3.request.instance.StopInstanceRequest;
import io.maestro3.sdk.v3.request.instance.TerminateInstanceRequest;
import io.maestro3.sdk.v3.request.instance.UninstallInstanceCloudWatchAgentRequest;
import io.maestro3.sdk.v3.request.kubernetes.DescribeKubernetesClusterRequest;
import io.maestro3.sdk.v3.request.recommendation.DescribeRecommendationSettingsRequest;
import io.maestro3.sdk.v3.request.recommendation.DescribeRecommendationsRequest;
import io.maestro3.sdk.v3.request.recommendation.UpdateRecommendationSettingsRequest;
import io.maestro3.sdk.v3.request.resource.DescribeRegionsRequest;
import io.maestro3.sdk.v3.request.resource.DescribeTenantsRequest;
import io.maestro3.sdk.v3.request.resource.ResourceRequest;
import io.maestro3.sdk.v3.request.shape.DescribeShapesRequest;
import io.maestro3.sdk.v3.request.ssh.AddKeyRequest;
import io.maestro3.sdk.v3.request.ssh.AddSingleKeySyncRequest;
import io.maestro3.sdk.v3.request.ssh.ChangeKeyOwnerRequest;
import io.maestro3.sdk.v3.request.ssh.ChangeKeyStatusRequest;
import io.maestro3.sdk.v3.request.ssh.DeleteKeyRequest;
import io.maestro3.sdk.v3.request.ssh.DescribeKeyInstancesRequest;
import io.maestro3.sdk.v3.request.ssh.DescribeKeysRequest;
import io.maestro3.sdk.v3.request.ssh.RenameKeyRequest;
import io.maestro3.sdk.v3.request.ssh.UpdateKeyRequest;
import io.maestro3.sdk.v3.request.tag.DeleteTagsRequest;
import io.maestro3.sdk.v3.request.tag.DescribeTagRequest;
import io.maestro3.sdk.v3.request.tag.UpdateTagsRequest;
import io.maestro3.sdk.v3.request.volume.AttachVolumeRequest;
import io.maestro3.sdk.v3.request.volume.CreateAndAttachVolumeRequest;
import io.maestro3.sdk.v3.request.volume.CreateVolumeRequest;
import io.maestro3.sdk.v3.request.volume.DescribeVolumeRequest;
import io.maestro3.sdk.v3.request.volume.DetachVolumeRequest;
import io.maestro3.sdk.v3.request.volume.RemoveVolumeRequest;
import io.maestro3.sdk.v3.request.volume.ResizeVolumeRequest;

import java.util.List;

public class ResourceManager extends AbstractManager implements IResourceManager {

    private static final TypeReference<List<SdkVolume>> VOLUME_LIST_RESULT = new TypeReference<List<SdkVolume>>() {};
    private static final TypeReference<List<SdkResource>> RESOURCE_LIST_RESULT = new TypeReference<List<SdkResource>>() {};
    private static final TypeReference<List<SdkImage>> IMAGE_LIST_RESULT = new TypeReference<List<SdkImage>>() {};
    private static final TypeReference<SdkInstances> INSTANCES_RESULT = new TypeReference<SdkInstances>() {};
    private static final TypeReference<List<SdkCloudWatchAgentInstanceInfo>> CW_AGENT_LIST_RESULT = new TypeReference<List<SdkCloudWatchAgentInstanceInfo>>() {};
    private static final TypeReference<List<SdkResourceTagDto>> TAG_LIST_RESULT = new TypeReference<List<SdkResourceTagDto>>() {};
    private static final TypeReference<SdkKeyPair> KEY_RESULT = new TypeReference<SdkKeyPair>() {};
    private static final TypeReference<List<SdkKeyPair>> KEY_LIST_RESULT = new TypeReference<List<SdkKeyPair>>() {};
    private static final TypeReference<List<SdkTenantInfo>> TENANTS_LIST_RESULT = new TypeReference<List<SdkTenantInfo>>() {};
    private static final TypeReference<List<SdkRegionInfo>> REGIONS_LIST_RESULT = new TypeReference<List<SdkRegionInfo>>() {};
    private static final TypeReference<List<SdkShapeInfo>> REGIONS_SHAPES_LIST_RESULT = new TypeReference<List<SdkShapeInfo>>() {};
    private static final TypeReference<List<SdkRecommendation>> RECOMMENDATION_RESULT = new TypeReference<List<SdkRecommendation>>() {};
    private static final TypeReference<List<SdkRecommendationSetting>> RECOMMENDATION_SETTINGS_RESULT = new TypeReference<List<SdkRecommendationSetting>>() {};
    private static final TypeReference<SdkHashedPassword> PASS_RESULT = new TypeReference<SdkHashedPassword>() {};
    private static final TypeReference<SdkKubernetesClusters> KUBERNETES_CLUSTERS_RESULT = new TypeReference<SdkKubernetesClusters>() {};
    private static final TypeReference<List<SdkInstance>> INSTANCES_LIST_RESULT = new TypeReference<List<SdkInstance>>() {};
    private static final TypeReference<List<SdkCustodianResourceScanResults>> CUSTODIAN_LAST_RESOURCE_SCAN_RESULT = new TypeReference<>() {};

    public ResourceManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<List<SdkResource>> listResources(IPrincipal principal, ResourceRequest request) {
        return execute(principal, request, RESOURCE_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkResourceTagDto>> describeTags(IPrincipal principal, DescribeTagRequest request) {
        return execute(principal, request, TAG_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkResourceTagDto>> updateTags(IPrincipal principal, UpdateTagsRequest request) {
        return execute(principal, request, TAG_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkResourceTagDto>> deleteTags(IPrincipal principal, DeleteTagsRequest request) {
        return execute(principal, request, TAG_LIST_RESULT);
    }

    @Override
    public M3Result<SdkInstances> describeInstance(IPrincipal principal, DescribeInstanceRequest request) {
        return execute(principal, request, INSTANCES_RESULT);
    }

    @Override
    public M3Result<SdkInstances> runInstance(IPrincipal principal, RunInstanceRequest request) {
        return execute(principal, request, INSTANCES_RESULT);
    }

    @Override
    public M3Result<SdkInstances> startInstance(IPrincipal principal, StartInstanceRequest request) {
        return execute(principal, request, INSTANCES_RESULT);
    }

    @Override
    public M3Result<SdkInstances> stopInstance(IPrincipal principal, StopInstanceRequest request) {
        return execute(principal, request, INSTANCES_RESULT);
    }

    @Override
    public M3Result<SdkInstances> rebootInstance(IPrincipal principal, RebootInstanceRequest request) {
        return execute(principal, request, INSTANCES_RESULT);
    }

    @Override
    public M3Result<SdkInstances> terminateInstance(IPrincipal principal, TerminateInstanceRequest request) {
        return execute(principal, request, INSTANCES_RESULT);
    }

    @Override
    public M3Result<List<SdkCloudWatchAgentInstanceInfo>> describeCloudWatchAgents(IPrincipal principal, DescribeInstanceCloudWatchAgentsRequest request) {
        return execute(principal, request, CW_AGENT_LIST_RESULT);
    }

    @Override
    public M3Result<Void> installCloudWatchAgent(IPrincipal principal, InstallInstanceCloudWatchAgentRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> uninstallCloudWatchAgent(IPrincipal principal, UninstallInstanceCloudWatchAgentRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<SdkImage>> describeImage(IPrincipal principal, DescribeImageRequest request) {
        return execute(principal, request, IMAGE_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkImage>> createImage(IPrincipal principal, CreateImageRequest request) {
        return execute(principal, request, IMAGE_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkImage>> deleteImage(IPrincipal principal, DeleteImageRequest request) {
        return execute(principal, request, IMAGE_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkVolume>> describeVolume(IPrincipal principal, DescribeVolumeRequest request) {
        return execute(principal, request, VOLUME_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkVolume>> createVolume(IPrincipal principal, CreateVolumeRequest request) {
        return execute(principal, request, VOLUME_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkVolume>> createAndAttachVolume(IPrincipal principal, CreateAndAttachVolumeRequest request) {
        return execute(principal, request, VOLUME_LIST_RESULT);
    }

    @Override
    public M3Result<Void> attachVolume(IPrincipal principal, AttachVolumeRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> detachVolume(IPrincipal principal, DetachVolumeRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> deleteVolume(IPrincipal principal, RemoveVolumeRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> resizeVolume(IPrincipal principal, ResizeVolumeRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<SdkKeyPair>> describeKeys(IPrincipal principal, DescribeKeysRequest request) {
        return execute(principal, request, KEY_LIST_RESULT);
    }

    @Override
    public M3Result<SdkKeyPair> addKey(IPrincipal principal, AddKeyRequest request) {
        return execute(principal, request, KEY_RESULT);
    }

    @Override
    public M3Result<SdkKeyPair> addSingleKeySync(IPrincipal principal, AddSingleKeySyncRequest request) {
        return execute(principal, request, KEY_RESULT);
    }

    @Override
    public M3Result<Void> updateKey(IPrincipal principal, UpdateKeyRequest request) {
        Assert.notEmpty(request.getKeys(), "requests");
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> deleteKey(IPrincipal principal, DeleteKeyRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> renameKey(IPrincipal principal, RenameKeyRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> changeSshKeyStatus(IPrincipal principal, ChangeKeyStatusRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> changeKeyOwner(IPrincipal principal, ChangeKeyOwnerRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<SdkTenantInfo>> describeTenants(IPrincipal principal, DescribeTenantsRequest request) {
        return execute(principal, request, TENANTS_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkRegionInfo>> describeRegions(IPrincipal principal, DescribeRegionsRequest request) {
        return execute(principal, request, REGIONS_LIST_RESULT);
    }

    @Override
    public M3Result<List<SdkShapeInfo>> describeRegionShapes(IPrincipal principal, DescribeShapesRequest request) {
        return execute(principal, request, REGIONS_SHAPES_LIST_RESULT);
    }

    @Override
    public M3Result<Void> manageInstanceTerminationProtection(IPrincipal principal, ManageInstanceTerminationProtectionRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<SdkRecommendation>> getRecommendations(IPrincipal principal, DescribeRecommendationsRequest request) {
        return execute(principal, request, RECOMMENDATION_RESULT);
    }

    @Override
    public M3Result<List<SdkCustodianResourceScanResults>> getCustodianLastResourceScanResults(IPrincipal principal, CustodianLastResourceScanRequest request) {
        return execute(principal, request, CUSTODIAN_LAST_RESOURCE_SCAN_RESULT);
    }

    @Override
    public M3Result<List<SdkRecommendationSetting>> getRecommendationSettings(IPrincipal principal, DescribeRecommendationSettingsRequest request) {
        return execute(principal, request, RECOMMENDATION_SETTINGS_RESULT);
    }

    @Override
    public M3Result<Void> updateRecommendationSettings(IPrincipal principal, UpdateRecommendationSettingsRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<SdkHashedPassword> obtainInstancePassword(IPrincipal principal, GetInstanceHashedPasswordRequest request) {
        return execute(principal, request, PASS_RESULT);
    }

    @Override
    public M3Result<SdkKubernetesClusters> describeKubernetesCluster(IPrincipal principal, DescribeKubernetesClusterRequest request) {
        return execute(principal, request, KUBERNETES_CLUSTERS_RESULT);
    }

    @Override
    public M3Result<List<SdkInstance>> describeSshRelatedInstances(IPrincipal principal, DescribeKeyInstancesRequest request) {
        return execute(principal, request, INSTANCES_LIST_RESULT);
    }
}
