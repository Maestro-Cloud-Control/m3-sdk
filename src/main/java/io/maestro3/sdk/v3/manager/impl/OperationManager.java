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
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.internal.util.JsonUtils;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.core.ResultStatus;
import io.maestro3.sdk.v3.manager.IOperationManager;
import io.maestro3.sdk.v3.model.operation.SdkOperation;
import io.maestro3.sdk.v3.request.operation.GetOperationRequest;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class OperationManager extends AbstractManager implements IOperationManager {

    private static final int DEFAULT_MAX_RETRIES = 7;

    public OperationManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<SdkOperation> getOperation(IPrincipal principal, GetOperationRequest request) {
        return execute(principal, request, new TypeReference<>() {});
    }

    @Override
    public <T> M3Result<T> getResultByOperation(IPrincipal principal, GetOperationRequest request) {
        CompletableFuture<M3Result<T>> future = CompletableFuture.supplyAsync(() -> {
            for (int retryCount = 1; retryCount <= DEFAULT_MAX_RETRIES; retryCount++) {
                M3Result<SdkOperation> sdkResult = getOperation(principal, request);
                if (ResultStatus.SUCCESS.equals(sdkResult.getStatus())) {
                    SdkOperation operation = sdkResult.getModel();
                    if (operation.isDone()) {
                        if (ResultStatus.SUCCESS.equals(operation.getStatus())) {
                            T resultObject = JsonUtils.parseObject(operation.getResponse(), new TypeReference<>() {});
                            return M3Result.success(sdkResult.getId(), resultObject);
                        } else {
                            return M3Result.error(sdkResult.getId(), operation.getError());
                        }
                    } else {
                        sleep(retryCount);
                    }
                } else if (ResultStatus.FAILED.equals(sdkResult.getStatus())) {
                    return M3Result.error(sdkResult.getId(), sdkResult.getReadableError());
                } else {
                    sleep(retryCount);
                }
            }
            return M3Result.error(UUID.randomUUID().toString(), "Could not get the operation result in the provided time.");
        });
        try {
            return future.join();
        } catch (Exception ex) {
            return M3Result.error(UUID.randomUUID().toString(), ex.getMessage());
        }
    }

    private static void sleep(int retryCount) throws M3SdkException {
        try {
            int delay = retryCount * retryCount * retryCount;
            TimeUnit.SECONDS.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new M3SdkException("Interrupted.", e);
        }
    }
}
