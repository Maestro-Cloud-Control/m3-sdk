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

package io.maestro3.sdk.v3.request.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = GetUserPositionRequest.Builder.class)
public class GetUserPositionRequest implements IRequest {

    private final String email;

    public GetUserPositionRequest(Builder builder) {
        this.email = builder.email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_USER_POSITIONS;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String email;

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public GetUserPositionRequest build() {
            return new GetUserPositionRequest(this);
        }
    }
}
