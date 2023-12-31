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

package io.maestro3.sdk.v3.model.agent.wizard;

public class SdkAdminCommand {

    private String command;
    private String result;
    private String type;
    private boolean success;

    public String getCommand() {
        return command;
    }

    public SdkAdminCommand setCommand(String command) {
        this.command = command;
        return this;
    }

    public SdkAdminCommand setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getResult() {
        return result;
    }

    public SdkAdminCommand setResult(String result) {
        this.result = result;
        return this;
    }
    public SdkAdminCommand setType(String type) {
        this.type = type;
        return this;
    }

    public String getType() {
        return type;
    }
}
