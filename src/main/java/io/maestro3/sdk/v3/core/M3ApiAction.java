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

package io.maestro3.sdk.v3.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class M3ApiAction {

    private String id;
    private ActionType type;
    protected Map<String, Object> params = new HashMap<>();
    private int customTimeoutMillis;

    protected M3ApiAction() { }

    public M3ApiAction(ActionType type, Map<String, Object> params) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
        this.params = params;
    }

    public M3ApiAction(ActionType type, Map<String, Object> params, int customTimeoutMillis) {
        this(type, params);
        this.customTimeoutMillis = customTimeoutMillis;
    }

    @JsonCreator
    public M3ApiAction(@JsonProperty("id") String id,
                       @JsonProperty("type") ActionType type,
                       @JsonProperty("params") Map<String, Object> params) {
        this.id = id;
        this.type = type;
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public ActionType getType() {
        return type;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public int getCustomTimeoutMillis() {
        return customTimeoutMillis;
    }
}


