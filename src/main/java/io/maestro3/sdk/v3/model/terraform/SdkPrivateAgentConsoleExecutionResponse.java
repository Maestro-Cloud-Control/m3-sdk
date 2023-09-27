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

import java.util.Map;
import java.util.Set;

public class SdkPrivateAgentConsoleExecutionResponse {
    private String positiveResult;
    private String negativeResult;
    private int exitCode;
    private Map<String, String> fullFileNamesWithContent;
    private Set<String> syncedFullFilenames;
    private Set<String> deletedFullFileNames;
    private boolean dirExists;

    public SdkPrivateAgentConsoleExecutionResponse() {
        // for JSON
    }

    public SdkPrivateAgentConsoleExecutionResponse withPositiveResult(String positiveResult) {
        this.positiveResult = positiveResult;
        return this;
    }

    public SdkPrivateAgentConsoleExecutionResponse withNegativeResult(String negativeResult) {
        this.negativeResult = negativeResult;
        return this;
    }

    public SdkPrivateAgentConsoleExecutionResponse withExitCode(int exitCode) {
        this.exitCode = exitCode;
        return this;
    }

    public SdkPrivateAgentConsoleExecutionResponse withFullFileNamesWithContent(Map<String, String> fullFileNamesWithContent) {
        this.fullFileNamesWithContent = fullFileNamesWithContent;
        return this;
    }

    public SdkPrivateAgentConsoleExecutionResponse withSyncedFullFilenames(Set<String> syncedFullFilenames) {
        this.syncedFullFilenames = syncedFullFilenames;
        return this;
    }

    public SdkPrivateAgentConsoleExecutionResponse withDeletedFullFileNames(Set<String> deletedFullFileNames) {
        this.deletedFullFileNames = deletedFullFileNames;
        return this;
    }

    public SdkPrivateAgentConsoleExecutionResponse withDirExists(boolean dirExists) {
        this.dirExists = dirExists;
        return this;
    }

    public String getPositiveResult() {
        return positiveResult;
    }

    public void setPositiveResult(String positiveResult) {
        this.positiveResult = positiveResult;
    }

    public String getNegativeResult() {
        return negativeResult;
    }

    public void setNegativeResult(String negativeResult) {
        this.negativeResult = negativeResult;
    }

    public int getExitCode() {
        return exitCode;
    }

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }

    public Map<String, String> getFullFileNamesWithContent() {
        return fullFileNamesWithContent;
    }

    public void setFullFileNamesWithContent(Map<String, String> fullFileNamesWithContent) {
        this.fullFileNamesWithContent = fullFileNamesWithContent;
    }

    public Set<String> getSyncedFullFilenames() {
        return syncedFullFilenames;
    }

    public void setSyncedFullFilenames(Set<String> syncedFullFilenames) {
        this.syncedFullFilenames = syncedFullFilenames;
    }

    public Set<String> getDeletedFullFileNames() {
        return deletedFullFileNames;
    }

    public void setDeletedFullFileNames(Set<String> deletedFullFileNames) {
        this.deletedFullFileNames = deletedFullFileNames;
    }

    public boolean isDirExists() {
        return dirExists;
    }

    public void setDirExists(boolean dirExists) {
        this.dirExists = dirExists;
    }

    @Override
    public String toString() {
        return "SdkPrivateAgentConsoleExecutionResponse{" +
            "positiveResult='" + positiveResult + '\'' +
            ", negativeResult='" + negativeResult + '\'' +
            ", exitCode=" + exitCode +
            ", fullFileNamesWithContent=" + fullFileNamesWithContent +
            ", syncedFullFilenames=" + syncedFullFilenames +
            ", deletedFullFileNames=" + deletedFullFileNames +
            ", dirExists=" + dirExists +
            '}';
    }
}
