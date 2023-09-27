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

package io.maestro3.sdk.v3.model.notification;

import java.util.Map;

public class TenantSubscription {

    private String cloud;
    private String tenantDisplayName;

    private Map<String, TenantSubscriptionConfiguration> subscriptionsConfiguration;
    private Map<TenantSubscriptionAudience, TenantSubscriptionRule> audiencePolicies;
    private boolean allAudience;

    public TenantSubscription() {
        // for json deserializer
    }

    public TenantSubscription(String cloud,
                              String tenantDisplayName,
                              Map<String, TenantSubscriptionConfiguration> subscriptionsConfiguration,
                              Map<TenantSubscriptionAudience, TenantSubscriptionRule> audiencePolicies,
                              boolean allAudience) {
        this.cloud = cloud;
        this.tenantDisplayName = tenantDisplayName;
        this.subscriptionsConfiguration = subscriptionsConfiguration;
        this.audiencePolicies = audiencePolicies;
        this.allAudience = allAudience;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getTenantDisplayName() {
        return tenantDisplayName;
    }

    public void setTenantDisplayName(String tenantDisplayName) {
        this.tenantDisplayName = tenantDisplayName;
    }

    public Map<String, TenantSubscriptionConfiguration> getSubscriptionsConfiguration() {
        return subscriptionsConfiguration;
    }

    public void setSubscriptionsConfiguration(Map<String, TenantSubscriptionConfiguration> subscriptionsConfiguration) {
        this.subscriptionsConfiguration = subscriptionsConfiguration;
    }

    public Map<TenantSubscriptionAudience, TenantSubscriptionRule> getAudiencePolicies() {
        return audiencePolicies;
    }

    public void setAudiencePolicies(Map<TenantSubscriptionAudience, TenantSubscriptionRule> audiencePolicies) {
        this.audiencePolicies = audiencePolicies;
    }

    public boolean isAllAudience() {
        return allAudience;
    }

    public void setAllAudience(boolean allAudience) {
        this.allAudience = allAudience;
    }
}
