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

package io.maestro3.sdk.v3.request.status;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.audit.AuditEventGroupType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = AuditForHourRequest.Builder.class)
public class AuditForHourRequest implements IRequest {

    private final long hourTimestamp;
    private final AuditEventGroupType groupType;
    private final ActionType actionType;

    private AuditForHourRequest(Builder builder) {
        this.hourTimestamp = builder.hourTimestamp;
        this.groupType = builder.groupType;
        this.actionType = builder.actionType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getHourTimestamp() {
        return hourTimestamp;
    }

    public AuditEventGroupType getGroupType() {
        return groupType;
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    public static final class Builder {

        private long hourTimestamp;
        private AuditEventGroupType groupType;
        private ActionType actionType;

        public Builder withHourTimestamp(long hourTimestamp) {
            this.hourTimestamp = hourTimestamp;
            return this;
        }

        public Builder withGroupType(AuditEventGroupType groupType) {
            this.groupType = groupType;
            return this;
        }

        public Builder withActionType(ActionType actionType) {
            this.actionType = actionType;
            return this;
        }

        public AuditForHourRequest build() {
            Assert.notNull(actionType, "actionType");
            return new AuditForHourRequest(this);
        }
    }
}
