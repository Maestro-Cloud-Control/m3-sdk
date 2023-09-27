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

package io.maestro3.sdk.v3.model.terraform;

public enum WebHookAction {
    NONE("None", "Do nothing after receiving the push-webhook", true),
    AUTO_PLAN("Auto plan", "Automatically execute PLAN command after receiving the push-webhook", false),
    AUTO_APPLY("Auto apply", "Automatically execute APPLY command after receiving the push-webhook", false);

    private String title;
    private String description;
    private boolean availableForMultiStack;

    WebHookAction(String title, String description, boolean availableForMultiStack) {
        this.title = title;
        this.description = description;
        this.availableForMultiStack = availableForMultiStack;
    }

    public static WebHookAction fromValue(String name) {
        for (WebHookAction action : values()) {
            if (action.name().equalsIgnoreCase(name)) {
                return action;
            }
        }
        return NONE;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailableForMultiStack() {
        return availableForMultiStack;
    }
}
