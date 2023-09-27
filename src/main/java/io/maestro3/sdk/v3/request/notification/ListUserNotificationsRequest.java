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

package io.maestro3.sdk.v3.request.notification;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.notification.user.SdkNotificationGroup;
import io.maestro3.sdk.v3.model.notification.user.SdkNotificationPriority;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Collection;

@JsonDeserialize(builder = ListUserNotificationsRequest.Builder.class)
public class ListUserNotificationsRequest implements IRequest {

    private final SdkNotificationGroup group;
    private final SdkNotificationPriority priority;
    private final Collection<String> tenants;
    private final Collection<String> regions;
    private final Collection<SdkCloud> clouds;
    private final Collection<String> excludedTypes;
    private final Long toDate;
    private final Integer limit;

    private ListUserNotificationsRequest(Builder builder) {
        this.group = builder.group;
        this.priority = builder.priority;
        this.tenants = builder.tenants;
        this.regions = builder.regions;
        this.clouds = builder.clouds;
        this.excludedTypes = builder.excludedTypes;
        this.toDate = builder.toDate;
        this.limit = builder.limit;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SdkNotificationGroup getGroup() {
        return group;
    }

    public SdkNotificationPriority getPriority() {
        return priority;
    }

    public Collection<String> getTenants() {
        return tenants;
    }

    public Collection<String> getRegions() {
        return regions;
    }

    public Collection<SdkCloud> getClouds() {
        return clouds;
    }

    public Collection<String> getExcludedTypes() {
        return excludedTypes;
    }

    public Long getToDate() {
        return toDate;
    }

    public Integer getLimit() {
        return limit;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.LIST_USER_NOTIFICATIONS;
    }

    public static final class Builder {

        private SdkNotificationGroup group;
        private SdkNotificationPriority priority;
        private Collection<String> tenants;
        private Collection<String> regions;
        private Collection<SdkCloud> clouds;
        private Collection<String> excludedTypes;
        private Long toDate;
        private Integer limit;

        public Builder withClouds(Collection<SdkCloud> clouds) {
            this.clouds = clouds;
            return this;
        }

        public Builder withTenants(Collection<String> tenants) {
            this.tenants = tenants;
            return this;
        }

        public Builder withRegions(Collection<String> regions) {
            this.regions = regions;
            return this;
        }

        public Builder withGroup(SdkNotificationGroup group) {
            this.group = group;
            return this;
        }

        public Builder withPriority(SdkNotificationPriority priority) {
            this.priority = priority;
            return this;
        }

        public Builder withExcludedTypes(Collection<String> excludedTypes) {
            this.excludedTypes = excludedTypes;
            return this;
        }

        public Builder withToDate(Long toDate) {
            this.toDate = toDate;
            return this;
        }

        public Builder withLimit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public ListUserNotificationsRequest build() {
            if (limit != null) {
                Assert.isPositive(limit, "limit");
            }
            if (toDate != null) {
                Assert.isPositive(toDate, "toDate");
            }
            return new ListUserNotificationsRequest(this);
        }
    }
}
