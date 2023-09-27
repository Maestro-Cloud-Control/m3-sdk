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

@JsonDeserialize(builder = SdkPrivateAgentGitExecutionRequest.Builder.class)
public class SdkPrivateAgentGitExecutionRequest implements IRequest {

    public enum GitType {
        GITHUB,
        GITLAB,
    }

    public enum Type {
        PARTIAL_CLONE,
        SETUP_WEBHOOK,
        DELETE_WEBHOOK,
        RESOLVE_PUSH_HASH,
        CAN_AUTHORIZE,
        CHECK_REPO_EXISTS,
    }
    private final GitType gitType;
    private final Type type;
    private final String username;
    private final String password;
    private final String gitRepoUri;
    private final String destinationDirectoryPath;
    private final String shortBranchName;
    private final String hash;
    private final String subPath;
    private final String webhookCallbackUrl;
    private final String secret;
    private final int hookId;
    private final String gitWebHookJson;

    private SdkPrivateAgentGitExecutionRequest(Builder builder) {
        this.gitType = builder.gitType;
        this.type = builder.type;
        this.username = builder.username;
        this.password = builder.password;
        this.gitRepoUri = builder.gitRepoUri;
        this.destinationDirectoryPath = builder.destinationDirectoryPath;
        this.shortBranchName = builder.shortBranchName;
        this.hash = builder.hash;
        this.subPath = builder.subPath;
        this.webhookCallbackUrl = builder.webhookCallbackUrl;
        this.secret = builder.secret;
        this.hookId = builder.hookId;
        this.gitWebHookJson = builder.gitWebHookJson;
    }

    public static Builder builder() {
        return new Builder();
    }

    public GitType getGitType() {
        return gitType;
    }

    public Type getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGitRepoUri() {
        return gitRepoUri;
    }

    public String getDestinationDirectoryPath() {
        return destinationDirectoryPath;
    }

    public String getShortBranchName() {
        return shortBranchName;
    }

    public String getHash() {
        return hash;
    }

    public String getSubPath() {
        return subPath;
    }

    public String getWebhookCallbackUrl() {
        return webhookCallbackUrl;
    }

    public String getSecret() {
        return secret;
    }

    public int getHookId() {
        return hookId;
    }

    public String getGitWebHookJson() {
        return gitWebHookJson;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GIT_EXECUTION;
    }

    @Override
    public int getCustomTimeoutMillis() {
        return 30 * 60 * 1000;
    }

    @Override
    public String toString() {
        return "SdkPrivateAgentGitExecutionRequest{" +
            "gitType=" + gitType +
            ", type='" + type + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", gitRepoUri='" + gitRepoUri + '\'' +
            ", destinationDirectoryPath='" + destinationDirectoryPath + '\'' +
            ", shortBranchName='" + shortBranchName + '\'' +
            ", hash='" + hash + '\'' +
            ", subPath='" + subPath + '\'' +
            ", webhookCallbackUrl='" + webhookCallbackUrl + '\'' +
            ", secret='" + secret + '\'' +
            ", hookId=" + hookId +
            ", gitWebHookJson='" + gitWebHookJson + '\'' +
            '}';
    }

    public static final class Builder {

        private GitType gitType;
        private Type type;
        private String username;
        private String password;
        private String gitRepoUri;
        private String destinationDirectoryPath;
        private String shortBranchName;
        private String hash;
        private String subPath;
        private String webhookCallbackUrl;
        private String secret;
        private int hookId;
        private String gitWebHookJson;

        public Builder withGitType(GitType gitType) {
            this.gitType = gitType;
            return this;
        }

        public Builder withType(Type type) {
            this.type = type;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withGitRepoUri(String gitRepoUri) {
            this.gitRepoUri = gitRepoUri;
            return this;
        }

        public Builder withDestinationDirectoryPath(String destinationDirectoryPath) {
            this.destinationDirectoryPath = destinationDirectoryPath;
            return this;
        }

        public Builder withShortBranchName(String shortBranchName) {
            this.shortBranchName = shortBranchName;
            return this;
        }

        public Builder withHash(String hash) {
            this.hash = hash;
            return this;
        }

        public Builder withSubPath(String subPath) {
            this.subPath = subPath;
            return this;
        }

        public Builder withWebhookCallbackUrl(String webhookCallbackUrl) {
            this.webhookCallbackUrl = webhookCallbackUrl;
            return this;
        }

        public Builder withSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public Builder withHookId(int hookId) {
            this.hookId = hookId;
            return this;
        }

        public Builder withGitWebHookJson(String gitWebHookJson) {
            this.gitWebHookJson = gitWebHookJson;
            return this;
        }

        public SdkPrivateAgentGitExecutionRequest build() {
            return new SdkPrivateAgentGitExecutionRequest(this);
        }
    }
}
