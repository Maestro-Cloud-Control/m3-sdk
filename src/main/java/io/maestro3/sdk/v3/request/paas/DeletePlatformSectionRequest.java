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

@JsonDeserialize(builder = DeletePlatformSectionRequest.DeletePlatformSectionRequestBuilder.class)
public class DeletePlatformSectionRequest extends AbstractPlatformServiceSectionRequest {

    private final boolean deleteAllBlocks;
    private final boolean deleteBlockWithoutTitle;

    private DeletePlatformSectionRequest(DeletePlatformSectionRequestBuilder builder) {
        super(builder);
        this.deleteAllBlocks = builder.deleteAllBlocks;
        this.deleteBlockWithoutTitle = builder.deleteBlockWithoutTitle;
    }

    public boolean isDeleteAllBlocks() {
        return deleteAllBlocks;
    }

    public boolean isDeleteBlockWithoutTitle() {
        return deleteBlockWithoutTitle;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DELETE_PLATFORM_SERVICE_SECTION;
    }

    public static final class DeletePlatformSectionRequestBuilder
        extends AbstractPlatformServiceSectionRequestBuilder<DeletePlatformSectionRequestBuilder, DeletePlatformSectionRequest> {

        private boolean deleteAllBlocks;
        private boolean deleteBlockWithoutTitle;

        @Override
        protected DeletePlatformSectionRequestBuilder getThis() {
            return this;
        }

        public DeletePlatformSectionRequestBuilder withDeleteAllBlocks(boolean deleteAllBlocks) {
            this.deleteAllBlocks = deleteAllBlocks;
            return getThis();
        }

        public DeletePlatformSectionRequestBuilder withDeleteBlockWithoutTitle(boolean deleteBlockWithoutTitle) {
            this.deleteBlockWithoutTitle = deleteBlockWithoutTitle;
            return getThis();
        }

        @Override
        public DeletePlatformSectionRequest build() {
            super.checkFields();
            return new DeletePlatformSectionRequest(this);
        }
    }
}
