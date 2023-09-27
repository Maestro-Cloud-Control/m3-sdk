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

import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.manager.IFileManager;
import io.maestro3.sdk.v3.request.file.GetOnDemandFileRequest;

public class FileManager extends AbstractManager implements IFileManager {

    public FileManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<String> getOnDemandFile(IPrincipal principal, GetOnDemandFileRequest request) {
        return execute(principal, request, STRING_RESULT);
    }
}
