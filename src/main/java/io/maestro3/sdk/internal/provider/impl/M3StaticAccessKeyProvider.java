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

package io.maestro3.sdk.internal.provider.impl;

import io.maestro3.sdk.internal.provider.IM3AccessKeyProvider;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.IPrincipal;

/**
 * Default implementation, mainly used for testing purposes
 */
public class M3StaticAccessKeyProvider implements IM3AccessKeyProvider {

    private final String accessKey;

    public M3StaticAccessKeyProvider(String accessKey) {
        Assert.hasText(accessKey, "accessKey");
        this.accessKey = accessKey;
    }

    @Override
    public String getAccessKey(IPrincipal principal) {
        return accessKey;
    }

}
