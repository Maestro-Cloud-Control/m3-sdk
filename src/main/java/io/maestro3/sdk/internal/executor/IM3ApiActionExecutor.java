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

package io.maestro3.sdk.internal.executor;

import io.maestro3.sdk.M3SdkVersion;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3ApiAction;
import io.maestro3.sdk.v3.core.M3BatchResult;
import io.maestro3.sdk.v3.core.M3RawResult;

public interface IM3ApiActionExecutor extends AutoCloseable {

    M3RawResult executeAction(IPrincipal principal, M3SdkVersion version, M3ApiAction action) throws M3SdkException;

    M3RawResult executeAsyncAction(IPrincipal principal, M3SdkVersion version, M3ApiAction action) throws M3SdkException;

    M3BatchResult executeBatch(IPrincipal principal, M3SdkVersion version, M3ApiAction... requestData) throws M3SdkException;

    M3BatchResult executeAsyncBatch(IPrincipal principal, M3SdkVersion version, M3ApiAction... requestData) throws M3SdkException;
}
