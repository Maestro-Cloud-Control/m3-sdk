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

package io.maestro3.sdk.v3.model.notification.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.maestro3.sdk.v3.model.notification.MailMessageGroup;
import io.maestro3.sdk.v3.model.notification.MailMessagePriority;

import java.util.Set;

public class SdkNotificationAudit {

    public static final String FIELD_EMAIL = "e";
    public static final String FIELD_TRUNCATED_TIME = "d";
    public static final String FIELD_NOTIFICATION_ID = "n";
    public static final String FIELD_NOTIFICATION_PRIORITY = "p";
    public static final String FIELD_NOTIFICATION_TYPE = "t";
    public static final String FIELD_NOTIFICATION_CLOUD = "cn";
    public static final String FIELD_NOTIFICATION_TENANT = "tn";
    public static final String FIELD_NOTIFICATION_REGION = "rn";
    public static final String FIELD_NOTIFICATION_GROUPS = "gr";

    @JsonProperty(FIELD_EMAIL)
    private String userEmail;

    @JsonProperty(FIELD_TRUNCATED_TIME)
    private long notificationTime;

    @JsonProperty(FIELD_NOTIFICATION_ID)
    private String notificationId;

    @JsonProperty(FIELD_NOTIFICATION_GROUPS)
    private Set<MailMessageGroup> groups;

    @JsonProperty(FIELD_NOTIFICATION_PRIORITY)
    private MailMessagePriority priority;

    @JsonProperty(FIELD_NOTIFICATION_TYPE)
    private String type;

    @JsonProperty(FIELD_NOTIFICATION_CLOUD)
    private String cloud;

    @JsonProperty(FIELD_NOTIFICATION_TENANT)
    private String tenant;

    @JsonProperty(FIELD_NOTIFICATION_REGION)
    private String region;

    private SdkUserNotification notification;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(long notificationTime) {
        this.notificationTime = notificationTime;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public Set<MailMessageGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<MailMessageGroup> groups) {
        this.groups = groups;
    }

    public MailMessagePriority getPriority() {
        return priority;
    }

    public void setPriority(MailMessagePriority priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public SdkUserNotification getNotification() {
        return notification;
    }

    public void setNotification(SdkUserNotification notification) {
        this.notification = notification;
    }
}
