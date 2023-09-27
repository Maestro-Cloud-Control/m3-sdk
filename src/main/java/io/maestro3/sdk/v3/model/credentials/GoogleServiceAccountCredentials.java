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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
    property = "credentials_type",
    visible = true,
    defaultImpl = GoogleServiceAccountCredentials.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = GoogleServiceAccountCredentials.class, name = "GCP_SERVICE_CREDENTIALS"),
})
@JsonDeserialize(builder = GoogleServiceAccountCredentials.Builder.class)
public class GoogleServiceAccountCredentials implements IGoogleCredentials {

    /**
     * Expected credentials format:
     * <pre>
     * {
     * "type": "service_account",
     * "project_id": "...",
     * "private_key_id": "...",
     * "private_key": "...",
     * "client_email": "...@....iam.gserviceaccount.com",
     * "client_id": "...",
     * "auth_uri": "https://accounts.google.com/o/oauth2/auth",
     * "token_uri": "https://accounts.google.com/o/oauth2/token",
     * "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
     * "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/email%40project_id.iam.gserviceaccount.com"
     * }
     * </pre>
     */
    private final String credentialsJson;

    protected GoogleServiceAccountCredentials(Builder builder) {
        this.credentialsJson = builder.credentialsJson;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCredentialsJson() {
        return credentialsJson;
    }

    public static class Builder {

        private String credentialsJson;

        public Builder withCredentialsJson(String credentialsJson) {
            this.credentialsJson = credentialsJson;
            return this;
        }

        public GoogleServiceAccountCredentials build() {
            Assert.hasText(credentialsJson, "credentialsJson");
            return new GoogleServiceAccountCredentials(this);
        }
    }
}
