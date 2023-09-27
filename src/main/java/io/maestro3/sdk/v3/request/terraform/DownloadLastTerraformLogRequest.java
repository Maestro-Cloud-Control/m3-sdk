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
import io.maestro3.sdk.v3.model.terraform.TerraformTask;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = DownloadLastTerraformLogRequest.Builder.class)
public class DownloadLastTerraformLogRequest extends AbstractTemplateLogRequest {

    private final String executorName;
    private final TerraformTask terraformTask;

    private DownloadLastTerraformLogRequest(Builder builder) {
        super(builder);
        this.executorName = builder.executorName;
        this.terraformTask = builder.terraformTask;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getExecutorName() {
        return executorName;
    }

    public TerraformTask getTerraformTask() {
        return terraformTask;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DOWNLOAD_LAST_TERRAFORM_LOG_BY_TASK;
    }

    public static final class Builder extends AbstractTemplateLogRequestBuilder<Builder, DownloadLastTerraformLogRequest> {

        private String executorName;
        private TerraformTask terraformTask;

        public Builder withExecutorName(String executorName) {
            this.executorName = executorName;
            return this;
        }

        public Builder withTerraformTask(TerraformTask terraformTask) {
            this.terraformTask = terraformTask;
            return this;
        }

        @Override
        protected void assertAllFieldsSet() {
            super.assertAllFieldsSet();
            Assert.hasText(executorName, "executorName");
            Assert.notNull(terraformTask, "terraformTask");
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public DownloadLastTerraformLogRequest build() {
            this.assertAllFieldsSet();
            withDefaultTemplateType();
            return new DownloadLastTerraformLogRequest(this);
        }
    }
}
