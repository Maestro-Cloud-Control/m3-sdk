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

import io.maestro3.sdk.v3.request.agent.SdkPrivateAgentGitExecutionRequest;

public class SdkPrivateAgentGitExecutionResponse {
    private SdkPrivateAgentGitExecutionRequest.Type type;
    private boolean partialCloneRepo;
    private String setupWebhook;
    private boolean deleteWebhook;
    private String resolvePushHash;
    private boolean canAuthorize;
    private boolean checkRepoExist;

    private String error;

    public SdkPrivateAgentGitExecutionResponse() {
        // for JSON
    }

    public SdkPrivateAgentGitExecutionResponse withType(SdkPrivateAgentGitExecutionRequest.Type type) {
        this.type = type;
        return this;
    }

    public SdkPrivateAgentGitExecutionResponse withPartialCloneRepo(boolean partialCloneRepo) {
        this.partialCloneRepo = partialCloneRepo;
        return this;
    }

    public SdkPrivateAgentGitExecutionResponse withSetupWebhook(String setupWebhook) {
        this.setupWebhook = setupWebhook;
        return this;
    }

    public SdkPrivateAgentGitExecutionResponse withDeleteWebhook(boolean deleteWebhook) {
        this.deleteWebhook = deleteWebhook;
        return this;
    }

    public SdkPrivateAgentGitExecutionResponse withResolvePushHash(String resolvePushHash) {
        this.resolvePushHash = resolvePushHash;
        return this;
    }

    public SdkPrivateAgentGitExecutionResponse withCanAuthorize(boolean canAuthorize) {
        this.canAuthorize = canAuthorize;
        return this;
    }

    public SdkPrivateAgentGitExecutionResponse withCheckRepoExist(boolean checkRepoExist) {
        this.checkRepoExist = checkRepoExist;
        return this;
    }

    public SdkPrivateAgentGitExecutionResponse withError(String error) {
        this.error = error;
        return this;
    }

    public SdkPrivateAgentGitExecutionRequest.Type getType() {
        return type;
    }

    public void setType(SdkPrivateAgentGitExecutionRequest.Type type) {
        this.type = type;
    }

    public boolean isPartialCloneRepo() {
        return partialCloneRepo;
    }

    public void setPartialCloneRepo(boolean partialCloneRepo) {
        this.partialCloneRepo = partialCloneRepo;
    }

    public String getSetupWebhook() {
        return setupWebhook;
    }

    public void setSetupWebhook(String setupWebhook) {
        this.setupWebhook = setupWebhook;
    }

    public boolean isDeleteWebhook() {
        return deleteWebhook;
    }

    public void setDeleteWebhook(boolean deleteWebhook) {
        this.deleteWebhook = deleteWebhook;
    }

    public String getResolvePushHash() {
        return resolvePushHash;
    }

    public void setResolvePushHash(String resolvePushHash) {
        this.resolvePushHash = resolvePushHash;
    }

    public boolean isCanAuthorize() {
        return canAuthorize;
    }

    public void setCanAuthorize(boolean canAuthorize) {
        this.canAuthorize = canAuthorize;
    }

    public boolean isCheckRepoExist() {
        return checkRepoExist;
    }

    public void setCheckRepoExist(boolean checkRepoExist) {
        this.checkRepoExist = checkRepoExist;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "SdkPrivateAgentGitExecutionResponse{" +
            "type=" + type +
            ", partialCloneRepo=" + partialCloneRepo +
            ", setupWebhook='" + setupWebhook + '\'' +
            ", deleteWebhook=" + deleteWebhook +
            ", resolvePushHash='" + resolvePushHash + '\'' +
            ", canAuthorize=" + canAuthorize +
            ", checkRepoExist=" + checkRepoExist +
            ", error='" + error + '\'' +
            '}';
    }
}
