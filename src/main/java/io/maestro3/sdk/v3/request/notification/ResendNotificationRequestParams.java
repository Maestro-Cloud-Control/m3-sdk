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
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = ResendNotificationRequestParams.Builder.class)
public class ResendNotificationRequestParams implements IRequest {

    private final String uuid;
    private final String requester;
    private final String notificationProcessorType;

    private ResendNotificationRequestParams(Builder builder) {
        this.uuid = builder.uuid;
        this.requester = builder.requester;
        this.notificationProcessorType = builder.notificationProcessorType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUuid() {
        return uuid;
    }

    public String getRequester() {
        return requester;
    }

    public String getNotificationProcessorType() {
        return notificationProcessorType;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.RESEND_NOTIFICATION;
    }

    public static final class Builder {

        private String uuid;
        private String requester;
        private String notificationProcessorType;

        public Builder withUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder withRequester(String requester) {
            this.requester = requester;
            return this;
        }

        public Builder withNotificationProcessorType(String notificationProcessorType) {
            this.notificationProcessorType = notificationProcessorType;
            return this;
        }

        public ResendNotificationRequestParams build() {
            return new ResendNotificationRequestParams(this);
        }
    }
}
