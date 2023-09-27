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

public class SdkPrivateAgentInfo {

    private String agentId;
    private String displayName;
    private String syncQueue;
    private String asyncQueue;
    private String responseQueue;
    private String sdkKey;
    private String customer;
    private String exchangeName;
    private String info;
    private long activationDate;
    private Long lastEventDate;
    private boolean isAvailable;
    private String ip;
    private String sls;

    public String getAgentId() {
        return agentId;
    }

    public SdkPrivateAgentInfo setAgentId(String agentId) {
        this.agentId = agentId;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public SdkPrivateAgentInfo setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getSyncQueue() {
        return syncQueue;
    }

    public SdkPrivateAgentInfo setSyncQueue(String syncQueue) {
        this.syncQueue = syncQueue;
        return this;
    }

    public String getAsyncQueue() {
        return asyncQueue;
    }

    public SdkPrivateAgentInfo setAsyncQueue(String asyncQueue) {
        this.asyncQueue = asyncQueue;
        return this;
    }

    public String getResponseQueue() {
        return responseQueue;
    }

    public SdkPrivateAgentInfo setResponseQueue(String responseQueue) {
        this.responseQueue = responseQueue;
        return this;
    }

    public String getSdkKey() {
        return sdkKey;
    }

    public SdkPrivateAgentInfo setSdkKey(String sdkKey) {
        this.sdkKey = sdkKey;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public SdkPrivateAgentInfo setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public SdkPrivateAgentInfo setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public SdkPrivateAgentInfo setInfo(String info) {
        this.info = info;
        return this;
    }

    public long getActivationDate() {
        return activationDate;
    }

    public SdkPrivateAgentInfo setActivationDate(long activationDate) {
        this.activationDate = activationDate;
        return this;
    }

    public Long getLastEventDate() {
        return lastEventDate;
    }

    public SdkPrivateAgentInfo setLastEventDate(Long lastEventDate) {
        this.lastEventDate = lastEventDate;
        return this;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public SdkPrivateAgentInfo setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public SdkPrivateAgentInfo setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getSls() {
        return sls;
    }

    public SdkPrivateAgentInfo setSls(String sls) {
        this.sls = sls;
        return this;
    }
}
