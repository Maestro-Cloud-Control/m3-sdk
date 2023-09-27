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
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = DownloadTemplateLogsRequest.Builder.class)
public class DownloadTemplateLogsRequest extends AbstractTemplateLogRequest {

    private final String terraformActionType;
    private final String initiator;
    private final long timestamp;

    private DownloadTemplateLogsRequest(Builder builder) {
        super(builder);
        this.initiator = builder.initiator;
        this.timestamp = builder.timestamp;
        this.terraformActionType = builder.terraformActionType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTerraformActionType() {
        return terraformActionType;
    }

    public String getInitiator() {
        return initiator;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DOWNLOAD_TERRAFORM_LOGS;
    }

    public static final class Builder extends AbstractTemplateLogRequestBuilder<Builder, DownloadTemplateLogsRequest> {

        private String terraformActionType;
        private String initiator;
        private long timestamp;

        public Builder withTerraformActionType(String terraformActionType) {
            this.terraformActionType = terraformActionType;
            return this;
        }

        public Builder withInitiator(String initiator) {
            this.initiator = initiator;
            return this;
        }

        public Builder withTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @Override
        protected void assertAllFieldsSet() {
            super.assertAllFieldsSet();
            Assert.hasText(terraformActionType, "terraformActionType");
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public DownloadTemplateLogsRequest build() {
            this.assertAllFieldsSet();
            return new DownloadTemplateLogsRequest(this);
        }
    }
}
