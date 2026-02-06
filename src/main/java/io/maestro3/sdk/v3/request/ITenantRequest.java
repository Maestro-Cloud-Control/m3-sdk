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

package io.maestro3.sdk.v3.request;

import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.Objects;

public interface ITenantRequest extends IRequest {

    default String getAccountId() {
        return null;
    }

    default String getTenantId() {
        return null;
    }

    // tenant display name
    String getTenantName();

    SdkCloud getCloud();

    static void validateRequest(String tenantId, String accountId, String tenantName, SdkCloud cloud) {
        boolean tenantIsValid = false;
        if (StringUtils.isNotBlank(tenantId)) {
            tenantIsValid = true;
        } else if (StringUtils.isNotBlank(accountId) && Objects.nonNull(cloud)) {
            tenantIsValid = true;
        } else if (StringUtils.isNotBlank(tenantName) && Objects.nonNull(cloud)) {
            tenantIsValid = true;
        }
        if (!tenantIsValid) {
            throw new M3SdkException("Request should either have valid: tenantId OR (accountId AND cloud) OR (tenantName AND cloud). " +
                    "Same order is used when the tenant will be resolved from request.");
        }
    }
}
