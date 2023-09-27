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

package io.maestro3.sdk.v3.request.metric;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = GetAllUserDashboardActionRequest.Builder.class)
public class GetAllUserDashboardActionRequest implements IRequest {

    private final String userIdentifier;
    private final String email;
    private final String cloudName;

    private GetAllUserDashboardActionRequest(Builder builder) {
        this.userIdentifier = builder.userIdentifier;
        this.email = builder.email;
        this.cloudName = builder.cloudName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getEmail() {
        return email;
    }

    public String getCloudName() {
        return cloudName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_ALL_USER_DASHBOARD_ACTION;
    }

    public static final class Builder {

        private String userIdentifier;
        private String email;
        private String cloudName;

        public Builder withUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withCloudName(String cloudName) {
            this.cloudName = cloudName;
            return this;
        }

        public GetAllUserDashboardActionRequest build() {
            return new GetAllUserDashboardActionRequest(this);
        }
    }
}
