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

public class UserSubscription {
    private String email;
    private String cloud;
    private String tenantDisplayName;
    private String regionName;
    private Map<String, UserSubscriptionConfiguration> subscriptionsConfiguration;
    private UserSubscriptionRule subscriptionRule;
    private Map<String, ReceiversMappingConfiguration> receiversConfiguration;

    public UserSubscription() {
        // for json deserializer
    }

    public UserSubscription(String email,
                            String cloud,
                            String tenantDisplayName,
                            String regionName,
                            Map<String, UserSubscriptionConfiguration> subscriptionsConfiguration,
                            UserSubscriptionRule subscriptionRule,
                            Map<String, ReceiversMappingConfiguration> receiversConfiguration) {
        this.email = email;
        this.cloud = cloud;
        this.tenantDisplayName = tenantDisplayName;
        this.regionName = regionName;
        this.subscriptionsConfiguration = subscriptionsConfiguration;
        this.subscriptionRule = subscriptionRule;
        this.receiversConfiguration = receiversConfiguration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Map<String, UserSubscriptionConfiguration> getSubscriptionsConfiguration() {
        return subscriptionsConfiguration;
    }

    public void setSubscriptionsConfiguration(Map<String, UserSubscriptionConfiguration> subscriptionsConfiguration) {
        this.subscriptionsConfiguration = subscriptionsConfiguration;
    }

    public UserSubscriptionRule getSubscriptionRule() {
        return subscriptionRule;
    }

    public UserSubscription setSubscriptionRule(UserSubscriptionRule subscriptionRule) {
        this.subscriptionRule = subscriptionRule;
        return this;
    }

    public Map<String, ReceiversMappingConfiguration> getReceiversConfiguration() {
        return receiversConfiguration;
    }

    public void setReceiversConfiguration(Map<String, ReceiversMappingConfiguration> receiversConfiguration) {
        this.receiversConfiguration = receiversConfiguration;
    }
}
