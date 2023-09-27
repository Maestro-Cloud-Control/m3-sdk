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
    defaultImpl = AzureCertificateCredentials.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = AzureCertificateCredentials.class, name = "AZURE_CERTIFICATE"),
})
@JsonDeserialize(builder = AzureCertificateCredentials.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzureCertificateCredentials implements IAzureCredentials {

    @JsonProperty("tenant_id")
    private final String tenantId;
    @JsonProperty("client_id")
    private final String clientId;
    @JsonProperty("certificate_base64")
    private final String certificateBase64;
    @JsonProperty("certificate_password")
    private final String certificatePassword;

    protected AzureCertificateCredentials(Builder builder) {
        this.tenantId = builder.tenantId;
        this.clientId = builder.clientId;
        this.certificateBase64 = builder.certificateBase64;
        this.certificatePassword = builder.certificatePassword;
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

    public String getCertificateBase64() {
        return certificateBase64;
    }

    public String getCertificatePassword() {
        return certificatePassword;
    }

    public static class Builder {

        private String tenantId;
        private String clientId;
        private String certificateBase64;
        private String certificatePassword;

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

        @JsonProperty("certificate_base64")
        public Builder withCertificateBase64(String certificateBase64) {
            this.certificateBase64 = certificateBase64;
            return this;
        }

        @JsonProperty("certificate_password")
        public Builder withCertificatePassword(String certificatePassword) {
            this.certificatePassword = certificatePassword;
            return this;
        }

        public AzureCertificateCredentials build() {
            Assert.hasText(certificateBase64, "certificateBase64");
            return new AzureCertificateCredentials(this);
        }
    }
}
