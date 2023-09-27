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

package io.maestro3.sdk.v3.request.agent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

@JsonDeserialize(builder = SdkPrivateAgentConsoleExecutionRequest.Builder.class)
public class SdkPrivateAgentConsoleExecutionRequest implements IRequest {
    private final String workingDirectoryFullPathName;
    private final Map<String, String> envVariables;
    private final List<String> commandTokens;
    private final Map<String, String> fullFileNamesWithContent;
    private final Set<String> requestedFullFileNames;
    private final Set<String> toBeDeletedFullFileNames;
    private final String dirExists;

    private SdkPrivateAgentConsoleExecutionRequest(Builder builder) {
        this.workingDirectoryFullPathName = builder.workingDirectoryFullPathName;
        this.envVariables = builder.envVariables;
        this.commandTokens = builder.commandTokens;
        this.fullFileNamesWithContent = builder.fullFileNamesWithContent;
        this.requestedFullFileNames = builder.requestedFullFileNames;
        this.toBeDeletedFullFileNames = builder.toBeDeletedFullFileNames;
        this.dirExists = builder.dirExists;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getWorkingDirectoryFullPathName() {
        return workingDirectoryFullPathName;
    }

    public Map<String, String> getEnvVariables() {
        return envVariables;
    }

    public List<String> getCommandTokens() {
        return commandTokens;
    }

    public Map<String, String> getFullFileNamesWithContent() {
        return fullFileNamesWithContent;
    }

    public Set<String> getRequestedFullFileNames() {
        return requestedFullFileNames;
    }

    public Set<String> getToBeDeletedFullFileNames() {
        return toBeDeletedFullFileNames;
    }

    public String getDirExists() {
        return dirExists;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CONSOLE_EXECUTION;
    }

    @Override
    public int getCustomTimeoutMillis() {
        return 30 * 60 * 1000;
    }

    @Override
    public String toString() {
        return "SdkPrivateAgentConsoleExecutionRequest{" +
            "workingDirectoryFullPathName='" + workingDirectoryFullPathName + '\'' +
            ", envVariables=" + envVariables +
            ", commandTokens=" + commandTokens +
            ", fullFileNamesWithContent=" + fullFileNamesWithContent +
            ", requestedFullFileNames=" + requestedFullFileNames +
            ", toBeDeletedFullFileNames=" + toBeDeletedFullFileNames +
            ", dirExists=" + dirExists +
            '}';
    }

    public static final class Builder {

        private String workingDirectoryFullPathName;
        private Map<String, String> envVariables;
        private List<String> commandTokens;
        private Map<String, String> fullFileNamesWithContent;
        private Set<String> requestedFullFileNames;
        private Set<String> toBeDeletedFullFileNames;
        private String dirExists;

        public Builder withWorkingDirectoryFullPathName(String workingDirectoryFullPathName) {
            this.workingDirectoryFullPathName = workingDirectoryFullPathName;
            return this;
        }

        public Builder withEnvVariables(Map<String, String> envVariables) {
            this.envVariables = envVariables;
            return this;
        }

        public Builder withCommandTokens(List<String> commandTokens) {
            this.commandTokens = commandTokens;
            return this;
        }

        public Builder withFullFileNamesWithContent(Map<String, String> fullFileNamesWithContent) {
            this.fullFileNamesWithContent = fullFileNamesWithContent;
            return this;
        }

        public Builder withRequestedFullFileNames(Set<String> requestedFullFileNames) {
            this.requestedFullFileNames = requestedFullFileNames;
            return this;
        }

        public Builder withToBeDeletedFullFileNames(Set<String> toBeDeletedFullFileNames) {
            this.toBeDeletedFullFileNames = toBeDeletedFullFileNames;
            return this;
        }

        public Builder withDirExists(String dirExists) {
            this.dirExists = dirExists;
            return this;
        }

        public SdkPrivateAgentConsoleExecutionRequest build() {
            return new SdkPrivateAgentConsoleExecutionRequest(this);
        }
    }
}
