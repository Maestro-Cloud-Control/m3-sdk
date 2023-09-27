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

package io.maestro3.sdk.v3.request.instance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = UninstallInstanceCloudWatchAgentRequest.UninstallInstanceCloudWatchAgentRequestBuilder.class)
    public class UninstallInstanceCloudWatchAgentRequest extends InstanceActionRequest {
    private UninstallInstanceCloudWatchAgentRequest(UninstallInstanceCloudWatchAgentRequestBuilder builder) {
        super(builder);
    }

    public static UninstallInstanceCloudWatchAgentRequestBuilder builder() {
        return new UninstallInstanceCloudWatchAgentRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UNINSTALL_INSTANCE_CW_AGENT;
    }

    public static final class UninstallInstanceCloudWatchAgentRequestBuilder extends
        AbstractInstanceActionBuilder<UninstallInstanceCloudWatchAgentRequestBuilder, UninstallInstanceCloudWatchAgentRequest> {

        @Override
        protected UninstallInstanceCloudWatchAgentRequestBuilder getThis() {
            return this;
        }

        @Override
        public UninstallInstanceCloudWatchAgentRequest build() {
            validateCommonParams();
            return new UninstallInstanceCloudWatchAgentRequest(this);
        }
    }
}
