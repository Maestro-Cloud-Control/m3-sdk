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
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Map;

@JsonDeserialize(builder = UpdateNotificationReceiversMappingRequest.Builder.class)
public class UpdateNotificationReceiversMappingRequest implements IRequest {

    private final SdkCloud cloud;
    private final String tenantName;
    private final String group;
    private final Map<String, Long> receivers;
    private final boolean unsubscribed;

    private UpdateNotificationReceiversMappingRequest(Builder builder) {
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
        this.group = builder.group;
        this.receivers = builder.receivers;
        this.unsubscribed = builder.unsubscribed;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getGroup() {
        return group;
    }

    public Map<String, Long> getReceivers() {
        return receivers;
    }

    public boolean isUnsubscribed() {
        return unsubscribed;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_NOTIFICATION_RECEIVERS_MAPPING;
    }

    public static final class Builder {
        private SdkCloud cloud;
        private String tenantName;
        private String group;
        private Map<String, Long> receivers;
        private boolean unsubscribed;

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withGroup(String group) {
            this.group = group;
            return this;
        }

        public Builder withReceivers(Map<String, Long> receivers) {
            this.receivers = receivers;
            return this;
        }

        public Builder withUnsubscribed(boolean unsubscribed) {
            this.unsubscribed = unsubscribed;
            return this;
        }

        public UpdateNotificationReceiversMappingRequest build() {
            Assert.hasText(group, "group");
            Assert.notNull(receivers, "receivers");
            return new UpdateNotificationReceiversMappingRequest(this);
        }
    }
}
