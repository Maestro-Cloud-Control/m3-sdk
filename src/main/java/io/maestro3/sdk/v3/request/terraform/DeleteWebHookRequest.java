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
@JsonDeserialize(builder = DeleteWebHookRequest.DeleteWebHookRequestBuilder.class)
public class DeleteWebHookRequest extends WebHookRequest {

    private DeleteWebHookRequest(DeleteWebHookRequestBuilder builder) {
        super(builder);
    }

    public static DeleteWebHookRequestBuilder builder() {
        return new DeleteWebHookRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DELETE_WEBHOOK;
    }

    public static final class DeleteWebHookRequestBuilder extends WebHookRequestBuilder<DeleteWebHookRequestBuilder, DeleteWebHookRequest> {


        @Override
        protected DeleteWebHookRequestBuilder getThis() {
            return this;
        }

        @Override
        public DeleteWebHookRequest build() {
            return new DeleteWebHookRequest(this);
        }
    }
}
