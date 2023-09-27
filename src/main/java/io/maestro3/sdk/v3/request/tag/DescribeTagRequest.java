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
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = DescribeTagRequest.DescribeTagRequestBuilder.class)
public class DescribeTagRequest extends TagsActionRequest {

    private final boolean systemTagsIncluded;

    private DescribeTagRequest(DescribeTagRequestBuilder builder) {
        super(builder);
        this.systemTagsIncluded = builder.systemTagsIncluded;
    }

    public boolean isSystemTagsIncluded() {
        return systemTagsIncluded;
    }

    public static DescribeTagRequestBuilder builder() {
        return new DescribeTagRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_TAGS;
    }

    public static final class DescribeTagRequestBuilder extends
        AbstractTagsActionRequestBuilder<DescribeTagRequest.DescribeTagRequestBuilder, DescribeTagRequest> {

        private boolean systemTagsIncluded;

        @Override
        protected DescribeTagRequest.DescribeTagRequestBuilder getThis() {
            return this;
        }

        public DescribeTagRequest.DescribeTagRequestBuilder withSystemTagsIncluded(boolean systemTagsIncluded) {
            this.systemTagsIncluded = systemTagsIncluded;
            return getThis();
        }

        public DescribeTagRequest build() {
            super.checkFields();
            return new DescribeTagRequest(this);
        }
    }
}
