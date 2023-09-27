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

package io.maestro3.sdk.v3.request.schedule;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.schedule.SdkSchedule;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = CreateScheduleRequest.Builder.class)
public class CreateScheduleRequest implements IRequest {

    private final SdkSchedule schedule;
    private final boolean overwrite;

    private CreateScheduleRequest(Builder builder) {
        this.schedule = builder.schedule;
        this.overwrite = builder.overwrite;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SdkSchedule getSchedule() {
        return schedule;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CREATE_SCHEDULE;
    }

    public static final class Builder {

        private SdkSchedule schedule;
        private boolean overwrite;

        public Builder withSchedule(SdkSchedule schedule) {
            this.schedule = schedule;
            return this;
        }

        public Builder withOverwrite(boolean overwrite) {
            this.overwrite = overwrite;
            return this;
        }

        public CreateScheduleRequest build() {
            return new CreateScheduleRequest(this);
        }
    }
}
