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

package io.maestro3.sdk.v3.request.instance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = ScheduleRemoveInstancesRequest.ScheduleRemoveInstancesRequestBuilder.class)
public class ScheduleRemoveInstancesRequest extends ScheduleInstancesRequest {
    private ScheduleRemoveInstancesRequest(ScheduleRemoveInstancesRequestBuilder builder) {
        super(builder);
    }

    public static ScheduleRemoveInstancesRequestBuilder builder() {
        return new ScheduleRemoveInstancesRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.SCHEDULE_REMOVE_INSTANCES;
    }

    public static class ScheduleRemoveInstancesRequestBuilder extends
            AbstractScheduleInstanceRequestBuilder<ScheduleRemoveInstancesRequestBuilder, ScheduleRemoveInstancesRequest> {

        @Override
        protected ScheduleRemoveInstancesRequestBuilder getThis() {
            return this;
        }

        @Override
        public ScheduleRemoveInstancesRequest build() {
            return new ScheduleRemoveInstancesRequest(this);
        }
    }
}
