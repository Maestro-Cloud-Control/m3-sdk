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

@JsonDeserialize(builder = AddPlatformSectionRequest.AddPlatformSectionRequestBuilder.class)
public class AddPlatformSectionRequest extends AbstractPlatformServiceSectionRequest {

    private final String blockValue;

    private AddPlatformSectionRequest(AddPlatformSectionRequestBuilder builder) {
        super(builder);
        this.blockValue = builder.blockValue;
    }

    public String getBlockValue() {
        return blockValue;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ADD_PLATFORM_SERVICE_SECTION;
    }

    public static final class AddPlatformSectionRequestBuilder extends AbstractPlatformServiceSectionRequest.
        AbstractPlatformServiceSectionRequestBuilder<AddPlatformSectionRequest.AddPlatformSectionRequestBuilder, AddPlatformSectionRequest> {

        private String blockValue;

        public AddPlatformSectionRequestBuilder withBlockValue(String blockValue) {
            this.blockValue = blockValue;
            return getThis();
        }

        @Override
        protected AddPlatformSectionRequestBuilder getThis() {
            return this;
        }

        @Override
        public AddPlatformSectionRequest build() {
            super.checkFields();
            return new AddPlatformSectionRequest(this);
        }
    }
}
