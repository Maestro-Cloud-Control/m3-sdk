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

import java.util.List;

@JsonDeserialize(builder = DeleteNotificationReceiversMappingRequest.Builder.class)
public class DeleteNotificationReceiversMappingRequest implements IRequest {

    private final List<String> emails;
    private final SdkCloud cloud;
    private final String tenantName;

    private DeleteNotificationReceiversMappingRequest(Builder builder) {
        this.emails = builder.emails;
        this.cloud = builder.cloud;
        this.tenantName = builder.tenantName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<String> getEmails() {
        return emails;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DELETE_NOTIFICATION_RECEIVERS_MAPPING;
    }

    public static final class Builder {
        private List<String> emails;
        private SdkCloud cloud;
        private String tenantName;

        public Builder withEmails(List<String> emails) {
            this.emails = emails;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public DeleteNotificationReceiversMappingRequest build() {
            Assert.notEmpty(emails, "emails");
            Assert.notNull(cloud, "cloud");
            Assert.hasText(tenantName, "tenantName");
            return new DeleteNotificationReceiversMappingRequest(this);
        }
    }
}