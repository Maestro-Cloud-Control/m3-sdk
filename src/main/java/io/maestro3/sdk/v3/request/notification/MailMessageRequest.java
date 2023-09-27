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
import io.maestro3.sdk.v3.model.notification.MailMessageAction;
import io.maestro3.sdk.v3.model.notification.MailMessageAttachmentInfo;
import io.maestro3.sdk.v3.model.notification.MailMessageGroup;
import io.maestro3.sdk.v3.model.notification.MailMessagePriority;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@JsonDeserialize(builder = MailMessageRequest.Builder.class)
public class MailMessageRequest implements IRequest {

    private final String from;
    private final Set<String> to;
    private final Set<String> cc;
    private final Set<String> bcc;
    private final String viewName;
    private final String viewType;
    private final Object model;
    private final Set<String> mailAttachments;
    private final Set<MailMessageAttachmentInfo> mailAttachmentsInfo;
    private final MailMessagePriority priority;
    private final Integer orderPriority;
    private final String body;
    private final String subject;
    private final String description;
    private final Date replyBy;
    private final String summary;
    private final Map<String, String> summaryParams;
    private final Set<MailMessageGroup> groups;
    private final List<MailMessageAction> actions;
    private final String language;
    private final String customer;
    private final ActionType actionType;

    private MailMessageRequest(Builder builder) {
        this.from = builder.from;
        this.to = builder.to;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
        this.viewName = builder.viewName;
        this.viewType = builder.viewType;
        this.model = builder.model;
        this.mailAttachments = builder.mailAttachments;
        this.mailAttachmentsInfo = builder.mailAttachmentsInfo;
        this.priority = builder.priority;
        this.orderPriority = builder.orderPriority;
        this.body = builder.body;
        this.subject = builder.subject;
        this.description = builder.description;
        this.replyBy = builder.replyBy;
        this.summary = builder.summary;
        this.summaryParams = builder.summaryParams;
        this.groups = builder.groups;
        this.actions = builder.actions;
        this.language = builder.language;
        this.customer = builder.customer;
        this.actionType = builder.actionType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFrom() {
        return from;
    }

    public Set<String> getTo() {
        return to;
    }

    public Set<String> getCc() {
        return cc;
    }

    public Set<String> getBcc() {
        return bcc;
    }

    public String getViewName() {
        return viewName;
    }

    public String getViewType() {
        return viewType;
    }

    public Object getModel() {
        return model;
    }

    public Set<String> getMailAttachments() {
        return mailAttachments;
    }

    public Set<MailMessageAttachmentInfo> getMailAttachmentsInfo() {
        return mailAttachmentsInfo;
    }

    public MailMessagePriority getPriority() {
        return priority;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public Date getReplyBy() {
        return replyBy;
    }

    public String getSummary() {
        return summary;
    }

    public Map<String, String> getSummaryParams() {
        return summaryParams;
    }

    public Set<MailMessageGroup> getGroups() {
        return groups;
    }

    public List<MailMessageAction> getActions() {
        return actions;
    }

    public Integer getOrderPriority() {
        return orderPriority;
    }

    public String getCustomer() {
        return customer;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    public static final class Builder {

        private ActionType actionType = ActionType.SEND_MAIL;
        private String from;
        private Set<String> to;
        private Set<String> cc;
        private Set<String> bcc;
        private String viewName;
        private String viewType;
        private Object model;
        private Set<String> mailAttachments;
        private Set<MailMessageAttachmentInfo> mailAttachmentsInfo;
        private MailMessagePriority priority;
        private Integer orderPriority;
        private String body;
        private String subject;
        private String description;
        private Date replyBy;
        private String summary;
        private Map<String, String> summaryParams;
        private Set<MailMessageGroup> groups;
        private List<MailMessageAction> actions;
        private String language;
        private String customer;

        public Builder withFrom(String from) {
            this.from = from;
            return this;
        }

        public Builder withTo(Set<String> to) {
            this.to = to;
            return this;
        }

        public Builder withCc(Set<String> cc) {
            this.cc = cc;
            return this;
        }

        public Builder withBcc(Set<String> bcc) {
            this.bcc = bcc;
            return this;
        }

        public Builder withViewName(String viewName) {
            this.viewName = viewName;
            return this;
        }

        public Builder withViewType(String viewType) {
            this.viewType = viewType;
            return this;
        }

        public Builder withModel(Object model) {
            this.model = model;
            return this;
        }

        public Builder withMailAttachments(Set<String> mailAttachments) {
            this.mailAttachments = mailAttachments;
            return this;
        }

        public Builder withMailAttachmentsInfo(Set<MailMessageAttachmentInfo> mailAttachmentsInfo) {
            this.mailAttachmentsInfo = mailAttachmentsInfo;
            return this;
        }

        public Builder withPriority(MailMessagePriority priority) {
            this.priority = priority;
            return this;
        }

        public Builder withOrderPriority(Integer orderPriority) {
            this.orderPriority = orderPriority;
            return this;
        }

        public Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withReplyBy(Date replyBy) {
            this.replyBy = replyBy;
            return this;
        }

        public Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Builder withSummaryParams(Map<String, String> summaryParams) {
            this.summaryParams = summaryParams;
            return this;
        }

        public Builder withGroups(Set<MailMessageGroup> groups) {
            this.groups = groups;
            return this;
        }

        public Builder withActions(List<MailMessageAction> actions) {
            this.actions = actions;
            return this;
        }

        public Builder withLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder withCustomer(String customer) {
            this.customer = customer;
            return this;
        }

        public Builder withRaw(boolean raw) {
            this.actionType = raw ? ActionType.SEND_RAW_MAIL : ActionType.SEND_MAIL;
            return this;
        }

        public MailMessageRequest build() {
            return new MailMessageRequest(this);
        }
    }
}
