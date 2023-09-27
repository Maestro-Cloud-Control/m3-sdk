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

public enum TenantSubscriptionRule {
    DEFAULT(new TenantSubscriptionAudienceConfig(true, true)),
    ALLOW_ALL_DENY_CUSTOMIZATION(new TenantSubscriptionAudienceConfig(true, false)),
    ALLOW_ALL_ALLOW_CUSTOMIZATION(new TenantSubscriptionAudienceConfig(true, true)),
    DISABLE_ALL_DENY_CUSTOMIZATION(new TenantSubscriptionAudienceConfig(false, false)),
    DISABLE_ALL_ALLOW_CUSTOMIZATION(new TenantSubscriptionAudienceConfig(false, true)),
    CUSTOM(ALLOW_ALL_ALLOW_CUSTOMIZATION.defaultAudienceConfig);

    private final TenantSubscriptionAudienceConfig defaultAudienceConfig;

    TenantSubscriptionRule(TenantSubscriptionAudienceConfig defaultAudienceConfig) {
        this.defaultAudienceConfig = defaultAudienceConfig;
    }

    public TenantSubscriptionAudienceConfig getDefaultAudienceConfig() {
        return defaultAudienceConfig;
    }

    public static TenantSubscriptionRule fromName(String name) {
        for (TenantSubscriptionRule rule : TenantSubscriptionRule.values()) {
            if (rule.name().equalsIgnoreCase(name)) {
                return rule;
            }
        }
        throw new IllegalArgumentException("Failed to find tenant subscription rule by name " + name);
    }
}
