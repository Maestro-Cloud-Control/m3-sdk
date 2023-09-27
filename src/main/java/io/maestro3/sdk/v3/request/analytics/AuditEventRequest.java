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
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Date;
import java.util.List;

@JsonDeserialize(builder = AuditEventRequest.Builder.class)
public class AuditEventRequest implements IRequest {

    private final Date checkFrom;
    private final List<String> groups;

    private AuditEventRequest(Builder builder) {
        this.checkFrom = builder.checkFrom;
        this.groups = builder.groups;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Date getCheckFrom() {
        return checkFrom;
    }

    public List<String> getGroups() {
        return groups;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_AUDIT_EVENTS;
    }

    public static final class Builder {

        private Date checkFrom;
        private List<String> groups;

        public Builder withCheckFrom(Date checkFrom) {
            this.checkFrom = checkFrom;
            return this;
        }

        public Builder withGroups(List<String> groups) {
            this.groups = groups;
            return this;
        }

        public AuditEventRequest build() {
            Assert.notNull(checkFrom, "checkFrom can not be null");
            Assert.notEmpty(groups, "groups can not be empty");
            return new AuditEventRequest(this);
        }
    }
}
