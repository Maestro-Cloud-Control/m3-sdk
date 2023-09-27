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

package io.maestro3.sdk.v3.core;

import io.maestro3.sdk.internal.util.Assert;

import java.util.Objects;

public class M3ServerContext {

    private final String serverUrl;

    public M3ServerContext(String host, Integer port, String endpoint) {
        Assert.hasText(host, "host");
        Assert.isPositive(port, "port");
        Assert.hasText(endpoint, "endpoint");
        this.serverUrl = host + ":" + port + endpoint;
    }

    public M3ServerContext(String serverUrl) {
        Assert.hasText(serverUrl, "serverUrl");
        this.serverUrl = serverUrl;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        M3ServerContext that = (M3ServerContext) o;
        return Objects.equals(serverUrl, that.serverUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverUrl);
    }

    @Override
    public String toString() {
        return "M3ServerContext{" +
                "serverUrl='" + serverUrl + '\'' +
                '}';
    }
}
