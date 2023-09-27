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

import java.util.List;

@JsonDeserialize(builder = UpdateKeyRequest.Builder.class)
public class UpdateKeyRequest implements IRequest {

    private final String name;
    private final List<UpdateKeyEntity> keys;
    private final boolean allRegions;

    private UpdateKeyRequest(Builder builder) {
        this.name = builder.name;
        this.keys = builder.keys;
        this.allRegions = builder.allRegions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public List<UpdateKeyEntity> getKeys() {
        return keys;
    }

    public boolean isAllRegions() {
        return allRegions;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_KEYS;
    }

    public static final class Builder {

        private String name;
        private List<UpdateKeyEntity> keys;
        private boolean allRegions;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withKeys(List<UpdateKeyEntity> keys) {
            this.keys = keys;
            return this;
        }

        public Builder withAllRegions(boolean allRegions) {
            this.allRegions = allRegions;
            return this;
        }

        public UpdateKeyRequest build() {
            Assert.hasText(name, "name");
            Assert.notEmpty(keys, "keys");
            if (!allRegions) {
                keys.forEach(k -> Assert.hasText(k.getRegion(), "region"));
            }
            return new UpdateKeyRequest(this);
        }
    }

    public enum UpdateKeyState {
        ADD, REMOVE, ERROR
    }
}
