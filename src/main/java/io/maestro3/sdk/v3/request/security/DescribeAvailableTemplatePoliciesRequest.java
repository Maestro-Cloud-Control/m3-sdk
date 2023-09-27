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

package io.maestro3.sdk.v3.request.security;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = DescribeAvailableTemplatePoliciesRequest.Builder.class)
public class DescribeAvailableTemplatePoliciesRequest implements IRequest {

    private final String nessusServerIdentifier;

    private DescribeAvailableTemplatePoliciesRequest(Builder builder) {
        this.nessusServerIdentifier = builder.nessusServerIdentifier;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNessusServerIdentifier() {
        return nessusServerIdentifier;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_AVAILABLE_TEMPLATE_POLICIES;
    }

    public static final class Builder {

        private String nessusServerIdentifier;

        public Builder withNessusServerIdentifier(String nessusServerIdentifier) {
            this.nessusServerIdentifier = nessusServerIdentifier;
            return this;
        }

        public DescribeAvailableTemplatePoliciesRequest build() {
            return new DescribeAvailableTemplatePoliciesRequest(this);
        }
    }
}
