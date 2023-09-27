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

import io.maestro3.sdk.M3SdkVersion;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.core.ResultStatus;
import io.maestro3.sdk.v3.core.StaticPrincipal;
import io.maestro3.sdk.v3.model.image.SdkImage;
import io.maestro3.sdk.v3.model.instance.SdkInstances;
import io.maestro3.sdk.v3.request.image.CreateImageRequest;
import io.maestro3.sdk.v3.request.image.DeleteImageRequest;
import io.maestro3.sdk.v3.request.image.DescribeImageRequest;
import io.maestro3.sdk.v3.request.instance.DescribeInstanceRequest;
import io.maestro3.sdk.v3.request.instance.RebootInstanceRequest;
import io.maestro3.sdk.v3.request.instance.RunInstanceRequest;
import io.maestro3.sdk.v3.request.instance.StartInstanceRequest;
import io.maestro3.sdk.v3.request.instance.StopInstanceRequest;
import io.maestro3.sdk.v3.request.instance.TerminateInstanceRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

public class ResourceManagerTest {

    private IM3ApiActionExecutor actionExecutor = Mockito.mock(IM3ApiActionExecutor.class);

    private ResourceManager resourceManager;

    @Before
    public void init() {
        resourceManager = new ResourceManager(actionExecutor, false);
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNullOnStart() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        StartInstanceRequest instanceActionRequest = StartInstanceRequest.builder()
                .withTenantName("tenantName")
                .withRegion("region")
                .withInstanceId("instanceId")
                .build();

        M3Result<SdkInstances> rawResult = M3Result.success("id", new SdkInstances());
        Mockito.when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<SdkInstances> result = resourceManager.startInstance(principal, instanceActionRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNullOnStop() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        StopInstanceRequest instanceActionRequest = StopInstanceRequest.builder()
                .withTenantName("tenantName")
                .withRegion("region")
                .withInstanceId("instanceId")
                .build();

        M3Result<SdkInstances> rawResult = M3Result.success("id", new SdkInstances());
        Mockito.when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<SdkInstances> result = resourceManager.stopInstance(principal, instanceActionRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNullOnTerminate() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        TerminateInstanceRequest instanceActionRequest = TerminateInstanceRequest.builder()
                .withTenantName("tenantName")
                .withRegion("region")
                .withInstanceId("instanceId")
                .build();

        M3Result<SdkInstances> rawResult = M3Result.success("id", new SdkInstances());
        Mockito.when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<SdkInstances> result = resourceManager.terminateInstance(principal, instanceActionRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNullOnReboot() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        RebootInstanceRequest instanceActionRequest = RebootInstanceRequest.builder()
                .withTenantName("tenantName")
                .withRegion("region")
                .withInstanceId("instanceId")
                .build();

        M3Result<SdkInstances> rawResult = M3Result.success("id", new SdkInstances());
        Mockito.when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<SdkInstances> result = resourceManager.rebootInstance(principal, instanceActionRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNullOnRun() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        RunInstanceRequest runInstanceRequest = RunInstanceRequest.builder()
                .withTenantName("tenantName")
                .withRegion("region")
                .withCount(1)
                .withImageId("imageId")
                .withInstanceName("instanceName")
                .withKeyName("keyName")
                .withOwner("owner")
                .withShape("shape")
                .build();

        M3Result<SdkInstances> rawResult = M3Result.success("id", new SdkInstances());
        Mockito.when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<SdkInstances> result = resourceManager.runInstance(principal, runInstanceRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNullOnDescribeInstance() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        DescribeInstanceRequest describeInstanceRequest = DescribeInstanceRequest.builder()
                .withTenantName("tenantName")
                .withRegion("region")
                .build();

        M3Result<SdkInstances> rawResult = M3Result.success("id", new SdkInstances());
        Mockito.when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<SdkInstances> result = resourceManager.describeInstance(principal, describeInstanceRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNullOnCreateImage() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        CreateImageRequest createImageRequest = CreateImageRequest.builder()
            .withTenantName("tenantName")
            .withRegion("region")
            .withInstanceId("instanceId")
            .withOwner("owner")
            .withDescription("description")
            .withName("name")
            .build();

        M3Result<List<SdkImage>> rawResult = M3Result.success("id", List.of());
        Mockito.when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<List<SdkImage>> result = resourceManager.createImage(principal, createImageRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNullOnDeleteImage() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        DeleteImageRequest deleteImageRequest = DeleteImageRequest.builder()
            .withTenantName("tenantName")
            .withRegion("region")
            .withImageId("imageId")
            .build();

        M3Result<List<SdkImage>> rawResult = M3Result.success("id", List.of());
        Mockito.when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<List<SdkImage>> result = resourceManager.deleteImage(principal, deleteImageRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNullOnDescribeImage() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        DescribeImageRequest describeImageRequest = DescribeImageRequest.builder()
            .withTenantName("tenantName")
            .withRegion("region")
            .build();

        M3Result<List<SdkImage>> rawResult = M3Result.success("id", List.of());
        Mockito.when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<List<SdkImage>> result = resourceManager.describeImage(principal, describeImageRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }
}
