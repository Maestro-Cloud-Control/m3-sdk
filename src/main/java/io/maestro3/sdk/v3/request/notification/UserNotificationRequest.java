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

@JsonDeserialize(builder = UserNotificationRequest.Builder.class)
public class UserNotificationRequest implements IRequest {

    private final String notificationId;

    private UserNotificationRequest(Builder builder) {
        this.notificationId = builder.notificationId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNotificationId() {
        return notificationId;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_USER_NOTIFICATION;
    }

    public static final class Builder {

        private String notificationId;

        public Builder withNotificationId(String notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public UserNotificationRequest build() {
            return new UserNotificationRequest(this);
        }
    }
}
