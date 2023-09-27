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

package io.maestro3.sdk.v3.model.credentials;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
    property = "credentials_type",
    visible = true,
    defaultImpl = GoogleUserCredentials.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = GoogleUserCredentials.class, name = "GCP_USER_CREDENTIALS"),
})
@JsonDeserialize(builder = GoogleUserCredentials.Builder.class)
public class GoogleUserCredentials implements IGoogleCredentials {

    @JsonProperty("access_token")
    private final String accessToken;
    @JsonProperty("client_secret")
    private final String clientSecret;
    @JsonProperty("client_id")
    private final String clientId;
    @JsonProperty("refresh_token")
    private final String refreshToken;
    @JsonProperty("project_id")
    private final String projectId;

    protected GoogleUserCredentials(Builder builder) {
        this.accessToken = builder.accessToken;
        this.clientSecret = builder.clientSecret;
        this.clientId = builder.clientId;
        this.refreshToken = builder.refreshToken;
        this.projectId = builder.projectId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getProjectId() {
        return projectId;
    }

    public static class Builder {

        private String accessToken;
        private String clientSecret;
        private String clientId;
        private String refreshToken;
        private String projectId;
        @JsonProperty("type")
        private final String type = "GCP_USER_CREDENTIALS";

        @JsonProperty("access_token")
        public Builder withAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        @JsonProperty("client_secret")
        public Builder withClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        @JsonProperty("client_id")
        public Builder withClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        @JsonProperty("refresh_token")
        public Builder withRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        @JsonProperty("project_id")
        public Builder withProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public GoogleUserCredentials build() {
            Assert.hasText(accessToken, "accessToken");
            Assert.hasText(clientSecret, "clientSecret");
            Assert.hasText(clientId, "clientId");
            Assert.hasText(refreshToken, "refreshToken");
            return new GoogleUserCredentials(this);
        }
    }

    @Override
    public String toString() {
        return "GoogleUserCredentials{" +
            "accessToken='" + accessToken + '\'' +
            ", clientSecret='" + clientSecret + '\'' +
            ", clientId='" + clientId + '\'' +
            ", refreshToken='" + refreshToken + '\'' +
            ", projectId='" + projectId + '\'' +
            '}';
    }
}
