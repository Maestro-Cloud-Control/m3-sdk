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

import io.maestro3.sdk.internal.util.StringUtils;

import java.util.function.Predicate;

public enum UserSubscriptionScope {
    ALL(null, null, 1),
    CLOUD(ALL, null, 2),
    ALL_TENANT_CLOUDS(ALL, null, 2),
    TENANT(ALL, SubscriptionGroupDescription::isTenantSpecific, 3),
    TENANT_IN_REGION(TENANT, SubscriptionGroupDescription::isRegionSpecific, 4);

    private final UserSubscriptionScope parentScope;
    private final Predicate<SubscriptionGroupDescription> subscriptionScopePredicate;
    private int priority;

    UserSubscriptionScope(UserSubscriptionScope parentScope, Predicate<SubscriptionGroupDescription> subscriptionScopePredicate, int priority) {
        this.parentScope = parentScope;
        this.subscriptionScopePredicate = subscriptionScopePredicate;
        this.priority = priority;
    }

    public UserSubscriptionScope getParentScope() {
        return parentScope;
    }

    public boolean isAcceptable(SubscriptionGroupDescription subscriptionGroupDescription) {
        return subscriptionScopePredicate == null || subscriptionScopePredicate.test(subscriptionGroupDescription);
    }

    public int getPriority() {
        return priority;
    }

    public boolean isHighestPriority(UserSubscriptionScope userSubscriptionScope) {
        return priority > userSubscriptionScope.getPriority();
    }

    public static UserSubscriptionScope determineSubscriptionScope(String cloud, String tenantName, String region) {
        if (StringUtils.isBlank(cloud) || StringUtils.isBlank(tenantName)) {
            return UserSubscriptionScope.ALL;
        }
        return StringUtils.isNotBlank(region) ? UserSubscriptionScope.TENANT_IN_REGION : UserSubscriptionScope.TENANT;
    }

    public static UserSubscriptionScope determineDetailedSubscriptionScope(String cloud, String tenantName) {
        if (StringUtils.isBlank(tenantName)) {
            return StringUtils.isBlank(cloud) ? UserSubscriptionScope.ALL : UserSubscriptionScope.CLOUD;
        }
        return StringUtils.isBlank(cloud) ? UserSubscriptionScope.ALL_TENANT_CLOUDS : UserSubscriptionScope.TENANT;
    }
}
