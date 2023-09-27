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

package io.maestro3.sdk.v3.model.instance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SdkInstanceState {

    PENDING("pending", true),
    STARTING("starting", true),
    RUNNING("running", false),
    STOPPING("stopping", true),
    STOPPED("stopped", false),
    REBOOTING("rebooting", true),
    REBOOTED("rebooted", false),
    SUSPENDING("suspending", true),
    SUSPENDED("suspended", false),
    SHUTTING_DOWN("shutting-down", true),
    TERMINATED("terminated", false),
    MISSING("missing", false),
    ERROR("error", false),
    PAUSED("paused", false),
    RESCUE("rescue", false),
    UNKNOWN("unknown", false);

    private String stateName;
    private boolean transitive;

    SdkInstanceState(String stateName, boolean transitive) {
        this.stateName = stateName;
        this.transitive = transitive;
    }

    @JsonCreator
    public static SdkInstanceState fromValue(String stateName) {
        for (SdkInstanceState instanceState : SdkInstanceState.values()) {
            if (instanceState.getStateName().equalsIgnoreCase(stateName)) {
                return instanceState;
            }
        }
        return SdkInstanceState.UNKNOWN;
    }

    public boolean isTransitive() {
        return transitive;
    }

    @JsonValue
    public String getStateName() {
        return stateName;
    }
}
