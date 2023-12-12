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

package io.maestro3.sdk.v3.manager;

import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
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
import io.maestro3.sdk.v3.request.custodian.CustodianLastK8sClusterScanRequest;
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
import io.maestro3.sdk.v3.request.tag.DescribeResourceTagsRequest;
import io.maestro3.sdk.v3.request.tag.DescribeTagRequest;
import io.maestro3.sdk.v3.request.tag.UpdateResourceTagsRequest;
import io.maestro3.sdk.v3.request.tag.UpdateTagsRequest;
import io.maestro3.sdk.v3.request.volume.AttachVolumeRequest;
import io.maestro3.sdk.v3.request.volume.CreateAndAttachVolumeRequest;
import io.maestro3.sdk.v3.request.volume.CreateVolumeRequest;
import io.maestro3.sdk.v3.request.volume.DescribeVolumeRequest;
import io.maestro3.sdk.v3.request.volume.DetachVolumeRequest;
import io.maestro3.sdk.v3.request.volume.RemoveVolumeRequest;
import io.maestro3.sdk.v3.request.volume.ResizeVolumeRequest;

import java.util.List;

public interface IResourceManager {

    M3Result<List<SdkResource>> listResources(IPrincipal principal, ResourceRequest request);

    M3Result<List<SdkResourceTagDto>> describeTags(IPrincipal principal, DescribeTagRequest request);

    M3Result<List<SdkResourceTagDto>> describeResourceTags(IPrincipal principal, DescribeResourceTagsRequest request);

    M3Result<List<SdkResourceTagDto>> updateTags(IPrincipal principal, UpdateTagsRequest request);

    M3Result<List<SdkResourceTagDto>> updateResourceTags(IPrincipal principal, UpdateResourceTagsRequest request);

    M3Result<List<SdkResourceTagDto>> deleteTags(IPrincipal principal, DeleteTagsRequest request);

    // instance actions

    M3Result<SdkInstances> describeInstance(IPrincipal principal, DescribeInstanceRequest request);

    M3Result<SdkInstances> runInstance(IPrincipal principal, RunInstanceRequest request);

    M3Result<SdkInstances> startInstance(IPrincipal principal, StartInstanceRequest request);

    M3Result<SdkInstances> stopInstance(IPrincipal principal, StopInstanceRequest request);

    M3Result<SdkInstances> rebootInstance(IPrincipal principal, RebootInstanceRequest request);

    M3Result<SdkInstances> terminateInstance(IPrincipal principal, TerminateInstanceRequest request);

    M3Result<List<SdkCloudWatchAgentInstanceInfo>> describeCloudWatchAgents(IPrincipal principal, DescribeInstanceCloudWatchAgentsRequest request);

    M3Result<Void> installCloudWatchAgent(IPrincipal principal, InstallInstanceCloudWatchAgentRequest request);

    M3Result<Void> uninstallCloudWatchAgent(IPrincipal principal, UninstallInstanceCloudWatchAgentRequest request);

    // image actions

    M3Result<List<SdkImage>> describeImage(IPrincipal principal, DescribeImageRequest request);

    M3Result<List<SdkImage>> createImage(IPrincipal principal, CreateImageRequest request);

    M3Result<List<SdkImage>> deleteImage(IPrincipal principal, DeleteImageRequest request);

    // volume actions

    M3Result<List<SdkVolume>> describeVolume(IPrincipal principal, DescribeVolumeRequest request);

    M3Result<List<SdkVolume>> createVolume(IPrincipal principal, CreateVolumeRequest request);

    M3Result<List<SdkVolume>> createAndAttachVolume(IPrincipal principal, CreateAndAttachVolumeRequest request);

    M3Result<Void> attachVolume(IPrincipal principal, AttachVolumeRequest request);

    M3Result<Void> detachVolume(IPrincipal principal, DetachVolumeRequest request);

    M3Result<Void> deleteVolume(IPrincipal principal, RemoveVolumeRequest request);

    M3Result<Void> resizeVolume(IPrincipal principal, ResizeVolumeRequest request);

    // ssh keys actions

    M3Result<List<SdkKeyPair>> describeKeys(IPrincipal principal, DescribeKeysRequest request);

    M3Result<SdkKeyPair> addKey(IPrincipal principal, AddKeyRequest request);

    M3Result<SdkKeyPair> addSingleKeySync(IPrincipal principal, AddSingleKeySyncRequest request);

    M3Result<Void> updateKey(IPrincipal principal, UpdateKeyRequest request);

    M3Result<Void> deleteKey(IPrincipal principal, DeleteKeyRequest request);

    M3Result<Void> renameKey(IPrincipal principal, RenameKeyRequest request);

    M3Result<Void> changeSshKeyStatus(IPrincipal principal, ChangeKeyStatusRequest request);

    M3Result<Void> changeKeyOwner(IPrincipal principal, ChangeKeyOwnerRequest request);

    M3Result<List<SdkTenantInfo>> describeTenants(IPrincipal principal, DescribeTenantsRequest request);

    M3Result<List<SdkRegionInfo>> describeRegions(IPrincipal principal, DescribeRegionsRequest request);

    M3Result<List<SdkShapeInfo>> describeRegionShapes(IPrincipal principal, DescribeShapesRequest request);

    M3Result<Void> manageInstanceTerminationProtection(IPrincipal principal, ManageInstanceTerminationProtectionRequest request);

    M3Result<List<SdkRecommendation>> getRecommendations(IPrincipal principal, DescribeRecommendationsRequest request);

    M3Result<List<SdkCustodianResourceScanResults>> getCustodianLastResourceScanResults(IPrincipal principal, CustodianLastResourceScanRequest request);

    M3Result<List<SdkCustodianResourceScanResults>> getCustodianLastK8sClusterScanResults(IPrincipal principal, CustodianLastK8sClusterScanRequest request);

    M3Result<List<SdkRecommendationSetting>> getRecommendationSettings(IPrincipal principal, DescribeRecommendationSettingsRequest request);

    M3Result<Void> updateRecommendationSettings(IPrincipal principal, UpdateRecommendationSettingsRequest request);

    M3Result<SdkHashedPassword> obtainInstancePassword(IPrincipal principal, GetInstanceHashedPasswordRequest request);

    M3Result<SdkKubernetesClusters> describeKubernetesCluster(IPrincipal principal, DescribeKubernetesClusterRequest request);


    M3Result<List<SdkInstance>> describeSshRelatedInstances(IPrincipal principal, DescribeKeyInstancesRequest request);
}
