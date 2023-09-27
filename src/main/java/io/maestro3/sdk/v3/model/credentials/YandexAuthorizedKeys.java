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

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
    property = "credentials_type",
    visible = true,
    defaultImpl = YandexAuthorizedKeys.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = YandexAuthorizedKeys.class, name = "YANDEX"),
})
@JsonDeserialize(builder = YandexAuthorizedKeys.Builder.class)
public class YandexAuthorizedKeys implements ICredentials {

    private final String privateKey;
    private final KeyInfo key;

    protected YandexAuthorizedKeys(Builder builder) {
        this.privateKey = builder.privateKey;
        this.key = builder.key;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public KeyInfo getKey() {
        return key;
    }

    public static class Builder {

        private String privateKey;
        private KeyInfo key;

        public Builder withPrivateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        public Builder withKey(KeyInfo key) {
            this.key = key;
            return this;
        }
        
        public YandexAuthorizedKeys build() {
            return new YandexAuthorizedKeys(this);
        }
    }

    public static class KeyInfo {

        private final String id;
        private final String serviceAccountId;
        private final String keyAlgorithm;
        private final String createdAt;
        private final String publicKey;

        protected KeyInfo(Builder builder) {
            this.id = builder.id;
            this.serviceAccountId = builder.serviceAccountId;
            this.createdAt = builder.createdAt;
            this.keyAlgorithm = builder.keyAlgorithm;
            this.publicKey = builder.publicKey;
        }

        public static Builder builder() {
            return new Builder();
        }

        public String getId() {
            return id;
        }

        public String getServiceAccountId() {
            return serviceAccountId;
        }

        public String getKeyAlgorithm() {
            return keyAlgorithm;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public static class Builder {

            private String id;
            private String serviceAccountId;
            private String keyAlgorithm;
            private String createdAt;
            private String publicKey;

            public Builder withId(String id) {
                this.id = id;
                return this;
            }

            public Builder withServiceAccountId(String serviceAccountId) {
                this.serviceAccountId = serviceAccountId;
                return this;
            }

            public Builder withCreatedAt(String createdAt) {
                this.createdAt = createdAt;
                return this;
            }

            public Builder withKeyAlgorithm(String keyAlgorithm) {
                this.keyAlgorithm = keyAlgorithm;
                return this;
            }

            public Builder withPublicKey(String publicKey) {
                this.publicKey = publicKey;
                return this;
            }

            public KeyInfo build() {
                return new KeyInfo(this);
            }
        }
    }
}
