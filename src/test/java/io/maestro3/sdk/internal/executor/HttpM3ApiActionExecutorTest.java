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
import io.maestro3.sdk.internal.executor.impl.HttpM3ApiActionExecutor;
import io.maestro3.sdk.internal.provider.IM3AccessKeyProvider;
import io.maestro3.sdk.internal.provider.IM3ServerContextProvider;
import io.maestro3.sdk.internal.signer.IM3Signer;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3ApiAction;
import io.maestro3.sdk.v3.core.M3ApiRequest;
import io.maestro3.sdk.v3.core.StaticPrincipal;
import org.junit.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class HttpM3ApiActionExecutorTest {

    private IM3AccessKeyProvider accessKeyProvider = Mockito.mock(IM3AccessKeyProvider.class);
    private IM3Signer signer = Mockito.mock(IM3Signer.class);
    private IM3ServerContextProvider serverContextProvider = Mockito.mock(IM3ServerContextProvider.class);

    private HttpM3ApiActionExecutor executor = new HttpM3ApiActionExecutor(accessKeyProvider, signer, serverContextProvider);



    @Test(expected = M3SdkException.class)
    public void executeAction() {
        IPrincipal principal = StaticPrincipal.getPrincipal();
        Mockito.when(accessKeyProvider.getAccessKey(principal)).thenReturn("accessKey");
        Mockito.when(signer.sign(Mockito.any(M3ApiRequest.class), Mockito.anyString())).thenAnswer(AdditionalAnswers.returnsFirstArg());
        Mockito.when(signer.encrypt(Mockito.anyString(), Mockito.anyString())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        Map<String, Object> params = new HashMap<>();
        params.put("requestBody", "{\"test\":true}");
        M3ApiAction action = new M3ApiAction("1", ActionType.ADD_KEY, params);
        executor.executeAction(principal, M3SdkVersion.V3, action);
    }

    @Test(expected = M3SdkException.class)
    public void executeAsyncAction() {
        IPrincipal principal = StaticPrincipal.getPrincipal();
        Mockito.when(accessKeyProvider.getAccessKey(principal)).thenReturn("accessKey");
        Mockito.when(signer.sign(Mockito.any(M3ApiRequest.class), Mockito.anyString())).thenAnswer(AdditionalAnswers.returnsFirstArg());
        Mockito.when(signer.encrypt(Mockito.anyString(), Mockito.anyString())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        Map<String, Object> params = new HashMap<>();
        params.put("requestBody", "{\"test\":true}");
        M3ApiAction action = new M3ApiAction("1", ActionType.ADD_KEY, params);
        executor.executeAsyncAction(principal, M3SdkVersion.V3, action);
    }
}