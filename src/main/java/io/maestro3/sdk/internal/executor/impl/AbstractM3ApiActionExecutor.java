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

package io.maestro3.sdk.internal.executor.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.maestro3.sdk.M3SdkVersion;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.internal.provider.IM3AccessKeyProvider;
import io.maestro3.sdk.internal.signer.IM3Signer;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.JsonUtils;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3ApiAction;
import io.maestro3.sdk.v3.core.M3ApiRequest;
import io.maestro3.sdk.v3.core.M3BatchResult;
import io.maestro3.sdk.v3.core.M3RawResult;
import io.maestro3.sdk.v3.core.M3Result;

public abstract class AbstractM3ApiActionExecutor implements IM3ApiActionExecutor {

    private final IM3Signer signer;
    private final IM3AccessKeyProvider accessKeyProvider;

    protected AbstractM3ApiActionExecutor(IM3AccessKeyProvider accessKeyProvider,
                                          IM3Signer signer) {
        this.accessKeyProvider = accessKeyProvider;
        this.signer = signer;
    }

    @Override
    public M3BatchResult executeBatch(IPrincipal principal, M3SdkVersion version, M3ApiAction... requestData) throws M3SdkException {
        return requestSyncExecution(principal, version, requestData);
    }

    @Override
    public M3BatchResult executeAsyncBatch(IPrincipal principal, M3SdkVersion version, M3ApiAction... requestData) throws M3SdkException {
        return requestAsyncExecution(principal, version, requestData);
    }

    @Override
    public M3RawResult executeAction(IPrincipal principal, M3SdkVersion version, M3ApiAction action) throws M3SdkException {
        return requestSyncExecution(principal, version, action).getFirst();
    }

    @Override
    public M3RawResult executeAsyncAction(IPrincipal principal, M3SdkVersion version, M3ApiAction action) throws M3SdkException {
        return requestAsyncExecution(principal, version, action).getFirst();
    }

    private M3BatchResult requestSyncExecution(IPrincipal principal, M3SdkVersion version, M3ApiAction... requestData) {
        String accessKey = accessKeyProvider.getAccessKey(principal);
        M3ApiRequest request = getM3ApiRequest(version, accessKey, requestData, principal);
        String encryptedResponseJson = execute(request);
        String responseJson = signer.decrypt(encryptedResponseJson, accessKey);
        return JsonUtils.parseJson(responseJson, new TypeReference<M3BatchResult>() {
        });
    }

    private M3BatchResult requestAsyncExecution(IPrincipal principal, M3SdkVersion version, M3ApiAction... requestData) {
        String accessKey = accessKeyProvider.getAccessKey(principal);
        M3ApiRequest request = getM3ApiRequest(version, accessKey, requestData, principal);
        executeAsync(request);
        M3BatchResult m3ApiResponse = new M3BatchResult();
        m3ApiResponse.addResponse(M3Result.pending("Your request will be processed asynchronously"));
        return m3ApiResponse;
    }

    private M3ApiRequest getM3ApiRequest(M3SdkVersion version, String accessKey, M3ApiAction[] requestData, IPrincipal principal) {
        long totalTimeoutMillis = calculateTotalTimeout(requestData);
        String requestDataJson = JsonUtils.convertObjectToJson(requestData);
        String encryptedRequestBody = signer.encrypt(requestDataJson, accessKey);

        M3ApiRequest request = new M3ApiRequest(encryptedRequestBody);
        request.setSdkVersion(version.getVersion());
        request.setUserIdentifier(principal.getId());
        request.setCustomTimeoutMillis(totalTimeoutMillis);
        request = signer.sign(request, accessKey);

        preValidateRequest(request);

        Assert.hasText(accessKey, "accessKey");
        return request;
    }

    private long calculateTotalTimeout(M3ApiAction[] requestData) {
        if (requestData == null) {
            return 0L;
        }

        long totalTimeout = 0L;
        for (M3ApiAction apiAction : requestData) {
            if (apiAction == null) {
                continue;
            }

            if (apiAction.getCustomTimeoutMillis() != 0) {
                totalTimeout += apiAction.getCustomTimeoutMillis();
            }
        }
        return totalTimeout;
    }

    private void preValidateRequest(M3ApiRequest request) {
        Assert.hasText(request.getSdkVersion(), "sdkVersion");
        Assert.hasText(request.getUserIdentifier(), "userIdentifier");
        Assert.hasText(request.getRequestBody(), "requestBody");
    }

    protected abstract String execute(M3ApiRequest request);

    protected abstract void executeAsync(M3ApiRequest m3ApiRequest);

}
