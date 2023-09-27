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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationRequest implements IRequest {

    protected static final int ON_DEMAND_NOTIFICATION_PRIORITY = 4;
    protected static final int DEFAULT_NOTIFICATION_PRIORITY = 3;
    protected static final int SCHEDULED_NOTIFICATION_PRIORITY = 2;

    private final String notificationType;
    private final List<String> notificationProcessorTypes;
    private Map<String, String> optionalParams = new HashMap<>();
    protected Map<String, String> summaryParams = new HashMap<>();
    private final Integer priority;
    private String language;

    protected NotificationRequest(String notificationType, List<String> notificationProcessorTypes) {
        this(notificationType, notificationProcessorTypes, DEFAULT_NOTIFICATION_PRIORITY);
    }

    protected NotificationRequest(String notificationType, List<String> notificationProcessorTypes, Integer priority) {
        Assert.hasText(notificationType, "notificationType");
        Assert.notEmpty(notificationProcessorTypes, "notificationProcessorTypes");
        this.notificationType = notificationType;
        this.notificationProcessorTypes = notificationProcessorTypes;
        this.priority = priority;
    }

    @JsonCreator
    protected NotificationRequest(@JsonProperty("notificationType") String notificationType,
                                  @JsonProperty("notificationProcessorTypes") List<String> notificationProcessorTypes,
                                  @JsonProperty("optionalParams") Map<String, String> optionalParams,
                                  @JsonProperty("summaryParams") Map<String, String> summaryParams,
                                  @JsonProperty("priority") Integer priority) {
        this(notificationType, notificationProcessorTypes, priority);
        this.optionalParams = optionalParams;
        this.summaryParams = summaryParams;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNotificationType() {
        return notificationType;
    }

    public List<String> getNotificationProcessorTypes() {
        return notificationProcessorTypes;
    }

    public Map<String, String> getOptionalParams() {
        return optionalParams;
    }

    public Map<String, String> getSummaryParams() {
        return summaryParams;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SEND_NOTIFICATION;
    }

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "notificationType='" + notificationType + '\'' +
                ", notificationProcessorTypes=" + notificationProcessorTypes +
                ", optionalParams=" + optionalParams +
                ", summaryParams=" + summaryParams +
                ", priority=" + priority +
                '}';
    }

    public static final class Builder {

        private String notificationType;
        private List<String> notificationProcessorTypes;
        private Integer priority;

        public Builder withNotificationType(String notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        public Builder withNotificationProcessorTypes(List<String> notificationProcessorTypes) {
            this.notificationProcessorTypes = notificationProcessorTypes;
            return this;
        }

        public Builder withPriority(Integer priority) {
            this.priority = priority;
            return this;
        }

        public NotificationRequest build() {
            return new NotificationRequest(notificationType, notificationProcessorTypes, priority);
        }
    }
}
