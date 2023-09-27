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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = SetupWebHookRequest.SetupWebHookRequestBuilder.class)
public class SetupWebHookRequest extends WebHookRequest {

    private SetupWebHookRequest(SetupWebHookRequestBuilder builder) {
        super(builder);
    }

    public static SetupWebHookRequestBuilder builder() {
        return new SetupWebHookRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SETUP_WEBHOOK;
    }

    public static final class SetupWebHookRequestBuilder extends WebHookRequestBuilder<SetupWebHookRequestBuilder, SetupWebHookRequest> {

        @Override
        protected SetupWebHookRequestBuilder getThis() {
            return this;
        }

        @Override
        public SetupWebHookRequest build() {
            return new SetupWebHookRequest(this);
        }
    }
}
