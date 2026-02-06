/*
 * Copyright 2024 Softline Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.model.support;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SdkSupportCase {
    private String id;
    private String number;
    private SdkSupportProvider support;

    private SdkSupportCaseStatus status;
    private String severity;

    private String service;
    private String category;

    private String subject;
    private String description;

    private String submittedBy;
    private String url;
    private Set<String> watchList = Collections.emptySet();
    private long submittedOn;

    private List<SdkSupportCaseComment> comments = Collections.emptyList();
    private Collection<SdkSupportCaseAttachment> attachments = Collections.emptyList();

    public SdkSupportCase() {
        // For JSON
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public SdkSupportProvider getSupport() {
        return support;
    }

    public void setSupport(SdkSupportProvider support) {
        this.support = support;
    }

    public SdkSupportCaseStatus getStatus() {
        return status;
    }

    public void setStatus(SdkSupportCaseStatus status) {
        this.status = status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<String> getWatchList() {
        return watchList;
    }

    public void setWatchList(Set<String> watchList) {
        this.watchList = watchList;
    }

    public long getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(long submittedOn) {
        this.submittedOn = submittedOn;
    }

    public List<SdkSupportCaseComment> getComments() {
        return comments;
    }

    public void setComments(List<SdkSupportCaseComment> comments) {
        this.comments = comments;
    }

    public Collection<SdkSupportCaseAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Collection<SdkSupportCaseAttachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "SdkSupportCase{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", support='" + support + '\'' +
                ", status=" + status +
                ", severity='" + severity + '\'' +
                ", service='" + service + '\'' +
                ", category='" + category + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", submittedBy='" + submittedBy + '\'' +
                ", url='" + url + '\'' +
                ", watchList=" + watchList +
                ", submittedOn=" + submittedOn +
                ", comments=" + comments +
                ", attachments=" + attachments +
                '}';
    }
}
