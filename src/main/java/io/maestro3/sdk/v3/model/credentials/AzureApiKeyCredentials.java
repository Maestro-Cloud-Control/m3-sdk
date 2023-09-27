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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
    property = "credentials_type",
    visible = true,
    defaultImpl = AzureApiKeyCredentials.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = AzureApiKeyCredentials.class, name = "AZURE_API_KEY"),
})
@JsonDeserialize(builder = AzureApiKeyCredentials.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzureApiKeyCredentials implements IAzureCredentials {

    @JsonProperty("tenant_id")
    private final String tenantId;
    @JsonProperty("client_id")
    private final String clientId;
    @JsonProperty("api_key")
    private final String apiKey;

    protected AzureApiKeyCredentials(Builder builder) {
        this.tenantId = builder.tenantId;
        this.clientId = builder.clientId;
        this.apiKey = builder.apiKey;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public static class Builder {

        private String tenantId;
        private String clientId;
        private String apiKey;

        @JsonProperty("tenant_id")
        public Builder withTenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        @JsonProperty("client_id")
        public Builder withClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        @JsonProperty("api_key")
        public Builder withApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public AzureApiKeyCredentials build() {
            Assert.hasText(apiKey, "apiKey");
            return new AzureApiKeyCredentials(this);
        }
    }
}
