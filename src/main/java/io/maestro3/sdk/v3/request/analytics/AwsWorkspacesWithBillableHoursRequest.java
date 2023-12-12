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

package io.maestro3.sdk.v3.request.analytics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = AwsWorkspacesWithBillableHoursRequest.Builder.class)
public class AwsWorkspacesWithBillableHoursRequest implements IRequest {
    private final long month;

    private AwsWorkspacesWithBillableHoursRequest(Builder builder) {
        this.month = builder.month;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getMonth() {
        return month;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_AWS_WORKSPACES_FOR_LAST_TWO_WEEKS;
    }

    public static final class Builder {

        private long month;

        public Builder withMonth(long month) {
            this.month = month;
            return this;
        }

        public AwsWorkspacesWithBillableHoursRequest build() {
            return new AwsWorkspacesWithBillableHoursRequest(this);
        }
    }
}
