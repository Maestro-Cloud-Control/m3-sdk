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

import java.util.Set;

@JsonDeserialize(builder = DeleteTagsRequest.DeleteTagsRequestBuilder.class)
public class DeleteTagsRequest extends TagsActionRequest {

    private final Set<String> tags;

    private DeleteTagsRequest(DeleteTagsRequestBuilder builder) {
        super(builder);
        this.tags = builder.tags;
    }

    public Set<String> getTags() {
        return tags;
    }

    public static DeleteTagsRequestBuilder builder() {
        return new DeleteTagsRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DELETE_TAGS;
    }

    public static final class DeleteTagsRequestBuilder
        extends AbstractTagsActionRequestBuilder<DeleteTagsRequestBuilder, DeleteTagsRequest> {

        private Set<String> tags;

        public DeleteTagsRequestBuilder withTags(Set<String> tags) {
            this.tags = tags;
            return getThis();
        }

        @Override
        protected DeleteTagsRequestBuilder getThis() {
            return this;
        }

        @Override
        public DeleteTagsRequest build() {
            super.checkFields();
            Assert.notEmpty(tags, "tags must not be null or empty");
            return new DeleteTagsRequest(this);
        }
    }
}
