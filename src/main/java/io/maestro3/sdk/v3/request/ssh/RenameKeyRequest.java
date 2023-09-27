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

import java.util.Objects;

@JsonDeserialize(builder = RenameKeyRequest.Builder.class)
public class RenameKeyRequest implements IRequest {

    private final String name;
    private final String newName;

    private RenameKeyRequest(Builder builder) {
        this.name = builder.name;
        this.newName = builder.newName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getNewName() {
        return newName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.RENAME_KEYS;
    }

    public static final class Builder {

        private String name;
        private String newName;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withNewName(String newName) {
            this.newName = newName;
            return this;
        }

        public RenameKeyRequest build() {
            Assert.hasText(name, "name");
            Assert.hasText(newName, "newName");
            Assert.isTrue(!newName.equals(name), "name is not newName");
            return new RenameKeyRequest(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RenameKeyRequest that = (RenameKeyRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(newName, that.newName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, newName);
    }
}
