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

import java.util.List;

@JsonDeserialize(builder = DeleteActionsRequest.Builder.class)
public class DeleteActionsRequest implements IRequest {

    private final String userIdentifier;
    private final List<String> actionNames;

    private DeleteActionsRequest(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.actionNames = builder.actionNames;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public List<String> getActionNames() {
        return actionNames;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DELETE_ACTIONS;
    }

    public static final class Builder {

        private String userIdentifier;
        private List<String> actionNames;

        public Builder withUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return this;
        }

        public Builder withActionNames(List<String> actionNames) {
            this.actionNames = actionNames;
            return this;
        }

        public DeleteActionsRequest build() {
            return new DeleteActionsRequest(this);
        }
    }
}
