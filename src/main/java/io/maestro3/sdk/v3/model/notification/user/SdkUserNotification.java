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

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SdkUserNotification {

    private String subject;
    private String content;
    private String from;
    private String type;
    private String summary;
    private String fileInfoId;
    private String description;
    private long processedTime;
    private SdkNotificationStatus status;
    private SdkNotificationPriority priority;
    private Set<SdkNotificationGroup> groups;
    private List<SdkUserPlacement> receivers;
    private List<SdkNotificationAction> actions;
    private List<SdkNotificationAttachmentInfo> attachments;
    private Map<String, String> optionalParams;
    private Map<String, String> summaryParams;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFileInfoId() {
        return fileInfoId;
    }

    public void setFileInfoId(String fileInfoId) {
        this.fileInfoId = fileInfoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getProcessedTime() {
        return processedTime;
    }

    public void setProcessedTime(long processedTime) {
        this.processedTime = processedTime;
    }

    public SdkNotificationStatus getStatus() {
        return status;
    }

    public void setStatus(SdkNotificationStatus status) {
        this.status = status;
    }

    public SdkNotificationPriority getPriority() {
        return priority;
    }

    public void setPriority(SdkNotificationPriority priority) {
        this.priority = priority;
    }

    public Set<SdkNotificationGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<SdkNotificationGroup> groups) {
        this.groups = groups;
    }

    public List<SdkUserPlacement> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<SdkUserPlacement> receivers) {
        this.receivers = receivers;
    }

    public List<SdkNotificationAction> getActions() {
        return actions;
    }

    public void setActions(List<SdkNotificationAction> actions) {
        this.actions = actions;
    }

    public List<SdkNotificationAttachmentInfo> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<SdkNotificationAttachmentInfo> attachments) {
        this.attachments = attachments;
    }

    public Map<String, String> getOptionalParams() {
        return optionalParams;
    }

    public void setOptionalParams(Map<String, String> optionalParams) {
        this.optionalParams = optionalParams;
    }

    public Map<String, String> getSummaryParams() {
        return summaryParams;
    }

    public void setSummaryParams(Map<String, String> summaryParams) {
        this.summaryParams = summaryParams;
    }
}
