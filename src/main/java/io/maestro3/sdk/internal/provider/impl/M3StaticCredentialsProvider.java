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

import io.maestro3.sdk.internal.provider.IM3CredentialsProvider;
import io.maestro3.sdk.v3.core.M3Credentials;

/**
 * Default implementation, mainly used for testing purposes
 */
public class M3StaticCredentialsProvider implements IM3CredentialsProvider {

    private final M3Credentials credentials;

    public M3StaticCredentialsProvider(String accessKey, String secretKey) {
        this.credentials = new M3Credentials(accessKey, secretKey);
    }

    @Override
    public M3Credentials getCredentials(String accessKey) {
        if (!this.credentials.getAccessKey().equals(accessKey)) {
            throw new IllegalArgumentException("Provided access key has no secretKey pair");
        }
        return credentials;
    }
}
