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
import io.maestro3.sdk.M3SdkVersion;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.exception.M3SdkHostConnectException;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.internal.util.JsonUtils;
import io.maestro3.sdk.internal.util.SdkUtils;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3ApiAction;
import io.maestro3.sdk.v3.core.M3BatchResult;
import io.maestro3.sdk.v3.core.M3RawResult;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.manager.IManager;
import io.maestro3.sdk.v3.request.IRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Set;

abstract class AbstractManager implements IManager {

    protected static final TypeReference<Void> VOID_RESULT = new TypeReference<Void>() {};
    protected static final TypeReference<Object> OBJECT_RESULT = new TypeReference<Object>() {};
    protected static final TypeReference<String> STRING_RESULT = new TypeReference<String>() {};
    protected static final TypeReference<Boolean> BOOL_RESULT = new TypeReference<Boolean>() {};
    protected static final TypeReference<List<String>> LIST_STRING_RESULT = new TypeReference<List<String>>() {};
    protected static final TypeReference<Set<String>> SET_STRING_RESULT = new TypeReference<Set<String>>() {};
    protected final Logger LOG = LoggerFactory.getLogger(getClass());
    protected final IM3ApiActionExecutor actionExecutor;
    protected final boolean isAsync;

    AbstractManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        this.actionExecutor = actionExecutor;
        this.isAsync = isAsync;
    }

    @Override
    public final M3SdkVersion getVersion() {
        return M3SdkVersion.V3;
    }

    protected final <R extends IRequest, RESP> M3Result<RESP> execute(IPrincipal principal, R request, TypeReference<RESP> responseType) {
        M3ApiAction apiAction = SdkUtils.convert(request);

        M3RawResult result;
        try {
            if (isAsync) {
                result = actionExecutor.executeAsyncAction(principal, getVersion(), apiAction);
            } else {
                result = actionExecutor.executeAction(principal, getVersion(), apiAction);
            }
        } catch (M3SdkHostConnectException e) {
            throw e;
        } catch (Exception e) {
            throw new M3SdkException("Cannot execute action: " + apiAction.getType() + " with request: " + apiAction.getParams().get("body"), e);
        }

        if (result == null || result.getStatus() == null) {
            throw new M3SdkException("Received malformed result: " + result);
        }

        switch (result.getStatus()) {
            case SUCCESS: {
                RESP responseModel = JsonUtils.parseJson(result.getData(), responseType);
                return M3Result.success(result.getId(), result.getData(), responseModel);
            }
            case PENDING:
            case PROCESSING: {
                return M3Result.pending(result.getId());
            }
            case FAILED:
            default: {
                if (StringUtils.isNotBlank(result.getReadableError())){
                    return M3Result.error(result.getId(), result.getError(), result.getReadableError(), result.getLocalizableError(), result.getStatusCode());
                }
                return M3Result.error(result.getId(), result.getError());
            }
        }
    }

    protected final <R extends IRequest> M3BatchResult executeBatch(IPrincipal principal, Collection<R> requests) {
        Assert.batchSizeLimitNotExceeded(requests);
        M3ApiAction[] requestData = SdkUtils.convert(requests);
        if (isAsync) {
            return actionExecutor.executeAsyncBatch(principal, getVersion(), requestData);
        }
        return actionExecutor.executeBatch(principal, getVersion(), requestData);
    }
}
