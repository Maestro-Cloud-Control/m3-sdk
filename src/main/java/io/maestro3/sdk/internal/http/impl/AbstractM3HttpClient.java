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

package io.maestro3.sdk.internal.http.impl;

import io.maestro3.sdk.internal.M3SdkConstants;
import io.maestro3.sdk.internal.http.IM3HttpClient;
import io.maestro3.sdk.v3.core.M3ApiRequest;
import io.maestro3.sdk.v3.core.M3ServerContext;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

public abstract class AbstractM3HttpClient implements IM3HttpClient {

    private M3ServerContext serverContext;

    protected AbstractM3HttpClient(M3ServerContext serverContext) {
        this.serverContext = serverContext;
    }

    protected HttpPost getHttpRequest(M3ApiRequest request, boolean isAsync) throws UnsupportedEncodingException {
        HttpPost httpRequest = new HttpPost(serverContext.getServerUrl());
        httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpRequest.addHeader(HttpHeaders.ACCEPT, "application/json");
        httpRequest.addHeader(M3SdkConstants.AUTHENTICATION_HEADER, request.getSignature());
        httpRequest.addHeader(M3SdkConstants.USER_IDENTIFIER_HEADER, request.getUserIdentifier());
        httpRequest.addHeader(M3SdkConstants.DATE_HEADER, String.valueOf(request.getTimestamp()));
        httpRequest.addHeader(M3SdkConstants.ACCESS_KEY_HEADER, request.getAccessKey());
        httpRequest.addHeader(M3SdkConstants.SDK_VERSION_HEADER, request.getSdkVersion());
        httpRequest.addHeader(M3SdkConstants.IS_ASYNC, String.valueOf(isAsync));

        httpRequest.setEntity(new StringEntity(request.getRequestBody()));
        return httpRequest;
    }
}
