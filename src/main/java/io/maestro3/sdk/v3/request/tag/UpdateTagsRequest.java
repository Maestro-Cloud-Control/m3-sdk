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

package io.maestro3.sdk.v3.request.tag;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;

import java.util.Map;
import java.util.Set;

@JsonDeserialize(builder = UpdateTagsRequest.UpdateTagsRequestBuilder.class)
public class UpdateTagsRequest extends TagsActionRequest {

    private final Map<String, String> tags;
    private final Set<String> volumeIds;
    private final boolean overwrite;

    private UpdateTagsRequest(UpdateTagsRequestBuilder builder) {
        super(builder);
        this.tags = builder.tags;
        this.volumeIds = builder.volumeIds;
        this.overwrite = builder.overwrite;
    }

    public Set<String> getVolumeIds() {
        return volumeIds;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public static UpdateTagsRequestBuilder builder() {
        return new UpdateTagsRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_TAGS;
    }

    public static final class UpdateTagsRequestBuilder
        extends AbstractTagsActionRequestBuilder<UpdateTagsRequestBuilder, UpdateTagsRequest> {

        private Set<String> volumeIds;
        private Map<String, String> tags;
        private boolean overwrite;

        public UpdateTagsRequestBuilder withVolumeIds(Set<String> volumeIds) {
            this.volumeIds = volumeIds;
            return getThis();
        }

        public UpdateTagsRequestBuilder withTags(Map<String, String> tags) {
            this.tags = tags;
            return getThis();
        }

        public UpdateTagsRequestBuilder withOverwrite(boolean overwrite) {
            this.overwrite = overwrite;
            return getThis();
        }

        @Override
        protected UpdateTagsRequestBuilder getThis() {
            return this;
        }

        @Override
        public UpdateTagsRequest build() {
            super.checkFields();
            Assert.notNull(tags, "tags");
            return new UpdateTagsRequest(this);
        }
    }
}
