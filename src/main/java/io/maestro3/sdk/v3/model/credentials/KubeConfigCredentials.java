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
    defaultImpl = KubeConfigCredentials.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = KubeConfigCredentials.class, name = "KUBE_CONFIG"),
})
@JsonDeserialize(builder = KubeConfigCredentials.Builder.class)
public class KubeConfigCredentials implements ICredentials {

    private final String kubeConfigYamlString;

    public KubeConfigCredentials(Builder builder) {
        this.kubeConfigYamlString = builder.kubeConfigYamlString;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getKubeConfigYamlString() {
        return kubeConfigYamlString;
    }

    public static class Builder {

        private String kubeConfigYamlString;

        public Builder withKubeConfigYamlString(String kubeConfigYamlString) {
            this.kubeConfigYamlString = kubeConfigYamlString;
            return this;
        }

        public KubeConfigCredentials build() {
            return new KubeConfigCredentials(this);
        }
    }
}
