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

import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.exception.M3SdkHostConnectException;
import io.maestro3.sdk.internal.http.EnumPoolingConnectionManager;
import io.maestro3.sdk.internal.http.EnumRequestConfig;
import io.maestro3.sdk.internal.http.EnumRetryPolicy;
import io.maestro3.sdk.v3.core.M3ApiRequest;
import io.maestro3.sdk.v3.core.M3ServerContext;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class M3HttpClient extends AbstractM3HttpClient {

    private static final Logger LOG = LoggerFactory.getLogger(M3HttpClient.class);

    private HttpClient httpClient;

    public M3HttpClient(M3ServerContext serverContext,
                        EnumRetryPolicy retryPolicy,
                        EnumRequestConfig requestConfig) {
        this(serverContext, EnumPoolingConnectionManager.DEFAULT_POOLING_CONNECTION_MANAGER,
                retryPolicy, requestConfig);
    }

    private M3HttpClient(M3ServerContext serverContext,
                         EnumPoolingConnectionManager poolingConnectionManager,
                         EnumRetryPolicy retryPolicy,
                         EnumRequestConfig requestConfig) {
        super(serverContext);
        this.httpClient = HttpClientBuilder.create()
                .setConnectionManager(poolingConnectionManager.getManager())
                .setRetryHandler(retryPolicy.getPolicy())
                .setDefaultRequestConfig(requestConfig.getConfig())
                .build();
    }

    @Override
    public String executePost(M3ApiRequest request) {
        HttpPost httpRequest = null;
        try {
            httpRequest = getHttpRequest(request, false);

            HttpResponse response = httpClient.execute(httpRequest);
            checkResponse(response);
            return EntityUtils.toString(response.getEntity());
        } catch (HttpHostConnectException ex) {
            throw new M3SdkHostConnectException("Error during request execution", ex);
        } catch (Exception ex) {
            throw new M3SdkException("Error during request execution", ex);
        } finally {
            if (Objects.nonNull(httpRequest)) {
                httpRequest.releaseConnection();
            }
        }
    }

    private void checkResponse(HttpResponse response) {
        int statusCode = response.getStatusLine().getStatusCode();
        LOG.debug("Request executed with status code: {}", statusCode);
        if (statusCode != HttpStatus.SC_OK) {
            throw new M3SdkException("Failed to execute request with code: " + statusCode);
        }
    }
}
