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

package io.maestro3.sdk.v3.request.audit;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.cadf.model.CadfAuditEvent;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;


@JsonDeserialize(builder = SaveCadfEventRequest.Builder.class)
public class SaveCadfEventRequest implements IRequest {

    private final CadfAuditEvent event;
    private final String qualifier;

    private SaveCadfEventRequest(Builder builder) {
        this.event = builder.event;
        this.qualifier = builder.qualifier;
    }

    public static Builder builder() {
        return new Builder();
    }

    public CadfAuditEvent getEvent() {
        return event;
    }

    public String getQualifier() {
        return qualifier;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SAVE_CADF_EVENT;
    }

    @Override
    public String toString() {
        return "SaveCadfAuditEventRequest{" +
                "event=" + event +
                ", qualifier='" + qualifier + '\'' +
                '}';
    }

    public static final class Builder {
        private CadfAuditEvent event;
        private String qualifier;

        public Builder withEvent(CadfAuditEvent event) {
            this.event = event;
            return this;
        }

        public Builder withQualifier(String qualifier) {
            this.qualifier = qualifier;
            return this;
        }

        public SaveCadfEventRequest build() {
            Assert.notNull(event, "event");
            Assert.hasText(qualifier, "qualifier");
            return new SaveCadfEventRequest(this);
        }
    }
}
