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

package io.maestro3.sdk.v3.request.terraform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = WebHookActionRequest.Builder.class)
public class WebHookActionRequest implements IRequest {

    private final String templateId;
    private final String gitWebHookParams;
    private final String providerType;

    private WebHookActionRequest(Builder builder) {
        this.templateId = builder.templateId;
        this.gitWebHookParams = builder.gitWebHookParams;
        this.providerType = builder.providerType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getGitWebHookParams() {
        return gitWebHookParams;
    }

    public String getProviderType() {
        return providerType;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.HANDLE_WEBHOOK;
    }

    public static final class Builder {

        private String templateId;
        private String gitWebHookParams;
        private String providerType;

        public Builder withTemplateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Builder withGitWebHookParams(String gitWebHookParams) {
            this.gitWebHookParams = gitWebHookParams;
            return this;
        }

        public Builder withProviderType(String providerType) {
            this.providerType = providerType;
            return this;
        }

        public WebHookActionRequest build() {
            return new WebHookActionRequest(this);
        }
    }
}
