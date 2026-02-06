/*
 *
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

package io.maestro3.sdk.v3.request.support;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.support.SdkSupportCaseAttachment;
import io.maestro3.sdk.v3.model.support.SdkSupportProvider;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@JsonDeserialize(builder = CreateSupportCaseRequest.Builder.class)
public class CreateSupportCaseRequest extends AbstractSupportRequest {

    private final String service;
    private final String category;
    private final String subject;
    private final String description;
    private final List<SdkSupportCaseAttachment> attachments;

    private CreateSupportCaseRequest(Builder builder) {
        super(builder);
        this.service = builder.service;
        this.category = builder.category;
        this.subject = builder.subject;
        this.description = builder.description;
        this.attachments = Objects.isNull(builder.attachments)
                ? Collections.emptyList()
                : builder.attachments;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getService() {
        return service;
    }

    public String getCategory() {
        return category;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public List<SdkSupportCaseAttachment> getAttachments() {
        return attachments;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CREATE_SUPPORT_REQUEST;
    }

    @Override
    public Set<SdkSupportProvider> getAllowedProviders() {
        return Set.of(SdkSupportProvider.AWS, SdkSupportProvider.SERVICE_NOW);
    }

    public static final class Builder
            extends AbstractSupportRequestBuilder<Builder, CreateSupportCaseRequest> {

        private String service;
        private String category;
        private String subject;
        private String description;
        private List<SdkSupportCaseAttachment> attachments;

        public Builder withService(String service) {
            this.service = service;
            return getThis();
        }

        public Builder withCategory(String category) {
            this.category = category;
            return getThis();
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return getThis();
        }

        public Builder withDescription(String description) {
            this.description = description;
            return getThis();
        }

        public Builder withAttachments(List<SdkSupportCaseAttachment> attachments) {
            this.attachments = attachments;
            return getThis();
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        public CreateSupportCaseRequest build() {
            super.checkFields();
            Assert.hasText(service, "service");
            Assert.hasText(category, "category");
            Assert.hasText(subject, "subject");
            Assert.hasText(description, "description");
            return new CreateSupportCaseRequest(this);
        }
    }
}
