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

package io.maestro3.sdk.v3.request.terraform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = DescribeTemplateStackByServiceEntryIdRequest.DescribeTemplateStackRequestBuilder.class)
public class DescribeTemplateStackByServiceEntryIdRequest extends AbstractDescribeTemplateStackRequest {

    private DescribeTemplateStackByServiceEntryIdRequest(DescribeTemplateStackRequestBuilder builder) {
        super(builder);
    }

    public static DescribeTemplateStackRequestBuilder builder() {
        return new DescribeTemplateStackRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_TERRAFORM_STACK_BY_ENTRY_ID;
    }

    public static final class DescribeTemplateStackRequestBuilder extends AbstractDescribeTemplateStackRequestBuilder
        <DescribeTemplateStackRequestBuilder, DescribeTemplateStackByServiceEntryIdRequest> {

        @Override
        protected DescribeTemplateStackRequestBuilder getThis() {
            return this;
        }

        @Override
        public DescribeTemplateStackByServiceEntryIdRequest build() {
            return new DescribeTemplateStackByServiceEntryIdRequest(this);
        }
    }
}
