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

package io.maestro3.sdk.v3.request.ssh;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = ChangeKeyOwnerRequest.Builder.class)
public class ChangeKeyOwnerRequest implements IRequest {

    private final String email;
    private final String name;
    private final String newOwnerEmail;

    private ChangeKeyOwnerRequest(Builder builder) {
        this.email = builder.email;
        this.name = builder.name;
        this.newOwnerEmail = builder.newOwnerEmail;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNewOwnerEmail() {
        return newOwnerEmail;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CHANGE_KEYS_OWNER;
    }

    public static final class Builder {

        private String email;
        private String name;
        private String newOwnerEmail;

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withNewOwnerEmail(String newOwnerEmail) {
            this.newOwnerEmail = newOwnerEmail;
            return this;
        }

        public ChangeKeyOwnerRequest build() {
            Assert.hasText(name, "name");
            Assert.hasText(newOwnerEmail, "newOwnerEmail");
            Assert.isTrue(!newOwnerEmail.equals(email), "email is not newOwnerEmail");
            return new ChangeKeyOwnerRequest(this);
        }
    }
}
