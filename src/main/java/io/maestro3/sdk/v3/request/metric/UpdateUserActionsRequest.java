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

package io.maestro3.sdk.v3.request.metric;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = UpdateUserActionsRequest.Builder.class)
public class UpdateUserActionsRequest implements IRequest {

    private final String userIdentifier;
    private final Object actions;

    private UpdateUserActionsRequest(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.actions = builder.actions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public Object getActions() {
        return actions;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_USER_ACTIONS_WITH_SKIP_EXISTING;
    }

    public static final class Builder {

        private String userIdentifier;
        private Object actions;

        public Builder withUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return this;
        }

        public Builder withActions(Object actions) {
            this.actions = actions;
            return this;
        }

        public UpdateUserActionsRequest build() {
            return new UpdateUserActionsRequest(this);
        }
    }
}
