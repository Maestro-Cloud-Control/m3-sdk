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

package io.maestro3.sdk.dev;

import io.maestro3.sdk.M3Sdk;
import io.maestro3.sdk.M3SdkVersion;
import io.maestro3.sdk.internal.provider.IM3AccessKeyProvider;
import io.maestro3.sdk.internal.provider.IM3CredentialsProvider;
import io.maestro3.sdk.internal.provider.IM3ServerContextProvider;
import io.maestro3.sdk.internal.provider.impl.M3StaticAccessKeyProvider;
import io.maestro3.sdk.internal.provider.impl.M3StaticCredentialsProvider;
import io.maestro3.sdk.internal.provider.impl.M3StaticServerContextProvider;
import io.maestro3.sdk.v3.client.IM3Client;
import io.maestro3.sdk.v3.core.StaticPrincipal;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SdkDevTest {


    private static final String ACCESS_KEY = "";
    private static final String SECRET_KEY = "";
    private static final String SERVER_URL = "";
    private static final String SERVER_ENDPOINT = SERVER_URL + M3SdkVersion.V3.getEndpoint();

    @Test
    public void sdkTest() throws Exception {
        IM3CredentialsProvider credentialsProvider = new M3StaticCredentialsProvider(ACCESS_KEY, SECRET_KEY);
        IM3AccessKeyProvider accessKeyProvider = new M3StaticAccessKeyProvider(ACCESS_KEY);
        IM3ServerContextProvider serverContextProvider = new M3StaticServerContextProvider(SERVER_ENDPOINT);
        IM3Client client = M3Sdk.clientBuilder()
                .withVersion(M3SdkVersion.V3)
                .withAccessKeyProvider(accessKeyProvider)
                .withCredentialsProvider(credentialsProvider)
                .withHttpExecutor()
                .withServerContextProvider(serverContextProvider)
                .build();

        System.out.println(client.statusManager().checkStatus(StaticPrincipal.getPrincipal()));
    }
}
