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

package io.maestro3.sdk.v3.model.agent;

import io.maestro3.sdk.v3.model.SdkCloud;

public class SdkPrivateAgentRegion {
    private String agentName;
    private String syncQueue;
    private String asyncQueue;
    private String responseQueue;
    private String sdkKey;
    private String customer;
    private String exchangeName;
    private SdkCloud cloud;
    private String regionNativeName;
    private boolean isAvailable;

    public boolean isAvailable() {
        return isAvailable;
    }

    public SdkPrivateAgentRegion setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getSyncQueue() {
        return syncQueue;
    }

    public String getAsyncQueue() {
        return asyncQueue;
    }

    public String getResponseQueue() {
        return responseQueue;
    }

    public String getSdkKey() {
        return sdkKey;
    }

    public String getCustomer() {
        return customer;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getRegionNativeName() {
        return regionNativeName;
    }

    public SdkPrivateAgentRegion setAgentName(String agentName) {
        this.agentName = agentName;
        return this;
    }

    public SdkPrivateAgentRegion setSyncQueue(String syncQueue) {
        this.syncQueue = syncQueue;
        return this;
    }

    public SdkPrivateAgentRegion setAsyncQueue(String asyncQueue) {
        this.asyncQueue = asyncQueue;
        return this;
    }

    public SdkPrivateAgentRegion setResponseQueue(String responseQueue) {
        this.responseQueue = responseQueue;
        return this;
    }

    public SdkPrivateAgentRegion setSdkKey(String sdkKey) {
        this.sdkKey = sdkKey;
        return this;
    }

    public SdkPrivateAgentRegion setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public SdkPrivateAgentRegion setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
        return this;
    }

    public SdkPrivateAgentRegion setCloud(SdkCloud cloud) {
        this.cloud = cloud;
        return this;
    }

    public SdkPrivateAgentRegion setRegionNativeName(String regionNativeName) {
        this.regionNativeName = regionNativeName;
        return this;
    }

}
