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

import io.maestro3.sdk.internal.http.CacheableM3HttpClientFactory;
import io.maestro3.sdk.internal.http.EnumRequestConfig;
import io.maestro3.sdk.internal.http.EnumRetryPolicy;
import io.maestro3.sdk.internal.http.IM3HttpClient;
import io.maestro3.sdk.internal.provider.IM3ServerContextProvider;
import io.maestro3.sdk.internal.provider.impl.M3StaticServerContextProvider;
import org.junit.Assert;
import org.junit.Test;

public class CacheableM3HttpClientFactoryTest {

    @Test
    public void should_return_same_http_client_for_one_server_context() {
        IM3ServerContextProvider m3ServerContextProvider = new M3StaticServerContextProvider("test");
        IM3HttpClient client = CacheableM3HttpClientFactory.getClient(m3ServerContextProvider,
                EnumRetryPolicy.DEFAULT_RETRY_POLICY, EnumRequestConfig.DEFAULT_REQUEST_CONFIG);
        IM3HttpClient anotherClient = CacheableM3HttpClientFactory.getClient(m3ServerContextProvider,
                EnumRetryPolicy.DEFAULT_RETRY_POLICY, EnumRequestConfig.DEFAULT_REQUEST_CONFIG);
        Assert.assertEquals(client, anotherClient);
    }
}
