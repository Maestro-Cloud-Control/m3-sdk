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
    defaultImpl = AwsCredentials.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = AwsCredentials.class, name = "AWS_CREDENTIALS"),
})
@JsonDeserialize(builder = AwsCredentials.Builder.class)
public class AwsCredentials implements ICredentials {

    private final String accessKeyId;
    private final String secretAccessKey;
    private final String defaultRegion;

    public AwsCredentials(Builder builder) {
        this.accessKeyId = builder.accessKeyId;
        this.secretAccessKey = builder.secretAccessKey;
        this.defaultRegion = builder.defaultRegion;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public String getDefaultRegion() {
        return defaultRegion;
    }

    public static class Builder {
        
        private String accessKeyId;
        private String secretAccessKey;
        private String defaultRegion;
    
        public Builder withAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }
    
        public Builder withSecretAccessKey(String secretAccessKey) {
            this.secretAccessKey = secretAccessKey;
            return this;
        }
    
        public Builder withDefaultRegion(String defaultRegion) {
            this.defaultRegion = defaultRegion;
            return this;
        }
    
        public AwsCredentials build() {
            Assert.hasText(accessKeyId, "accessKeyId");
            Assert.hasText(secretAccessKey, "secretAccessKey");
            return new AwsCredentials(this);
        }
    }
}
