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

package io.maestro3.sdk.v3.manager;

import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.model.schedule.SdkSchedule;
import io.maestro3.sdk.v3.request.schedule.CreateScheduleRequest;
import io.maestro3.sdk.v3.request.schedule.DeleteScheduleRequest;
import io.maestro3.sdk.v3.request.schedule.DescribeSchedulesRequest;

import java.util.List;

public interface IScheduleManager {

    M3Result<SdkSchedule> createSchedule(IPrincipal principal, CreateScheduleRequest createScheduleRequest);

    M3Result<Void> removeSchedule(IPrincipal principal, DeleteScheduleRequest deleteScheduleRequest);

    M3Result<List<SdkSchedule>> describeSchedules(IPrincipal principal, DescribeSchedulesRequest describeSchedulesRequest);
}
