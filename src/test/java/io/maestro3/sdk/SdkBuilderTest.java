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

package io.maestro3.sdk;

import io.maestro3.sdk.internal.provider.IM3AccessKeyProvider;
import io.maestro3.sdk.internal.provider.IM3CredentialsProvider;
import io.maestro3.sdk.internal.provider.IM3ServerContextProvider;
import io.maestro3.sdk.internal.provider.impl.M3StaticAccessKeyProvider;
import io.maestro3.sdk.internal.provider.impl.M3StaticCredentialsProvider;
import io.maestro3.sdk.internal.provider.impl.M3StaticServerContextProvider;
import io.maestro3.sdk.v3.client.IM3Client;
import org.junit.Assert;
import org.junit.Test;

public class SdkBuilderTest {


    private static final String ACCESS_KEY = "test";
    private static final String SECRET_KEY = "test";

    private static final String SERVER_URL = "http://test";
    private static final String SERVER_ENDPOINT = SERVER_URL + M3SdkVersion.V3.getEndpoint();

    @Test
    public void verifyThatBuilderCreatesClient() {
        IM3CredentialsProvider credentialsProvider = new M3StaticCredentialsProvider(ACCESS_KEY, SECRET_KEY);
        IM3AccessKeyProvider accessKeyProvider = new M3StaticAccessKeyProvider(ACCESS_KEY);
        IM3ServerContextProvider serverContextProvider = new M3StaticServerContextProvider(SERVER_ENDPOINT);
        IM3Client client = M3Sdk.clientBuilder()
                .withVersion(M3SdkVersion.V3)
                .async()
                .withAccessKeyProvider(accessKeyProvider)
                .withCredentialsProvider(credentialsProvider)
                .withHttpExecutor()
                .withServerContextProvider(serverContextProvider)
                .build();
        Assert.assertNotNull(client);
        Assert.assertNotNull("analytics manager can not be null", client.analyticsManager());
        Assert.assertNotNull("billing manager can not be null", client.billingManager());
        Assert.assertNotNull("terraform manager can not be null", client.terraformManager());
        Assert.assertNotNull("security manager can not be null", client.securityManager());
        Assert.assertNotNull("audit manager can not be null", client.auditManager());
        Assert.assertNotNull("metric manager can not be null", client.metricManager());
        Assert.assertNotNull("notification manager can not be null", client.notificationManager());
        Assert.assertNotNull("ownership manager can not be null", client.ownershipManager());
        Assert.assertNotNull("quota manager can not be null", client.quotaManager());
        Assert.assertNotNull("status manager can not be null", client.statusManager());
        Assert.assertNotNull("price manager can not be null", client.priceManager());
    }
}
