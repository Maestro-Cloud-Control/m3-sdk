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

package io.maestro3.sdk.v3.request.paas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = PlatformServiceActionRequest.Builder.class)
public class PlatformServiceActionRequest extends AbstractPlatformServiceActionRequest {

    private PlatformServiceActionRequest(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.REGISTER_PLATFORM_SERVICE;
    }

    public static final class Builder extends AbstractPlatformServiceActionRequestBuilder<Builder, PlatformServiceActionRequest> {

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public PlatformServiceActionRequest build() {
            return new PlatformServiceActionRequest(this);
        }
    }
}
