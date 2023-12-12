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

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
    property = "credentials_type",
    visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = AwsCredentials.class, name = "AWS_CREDENTIALS"),
    @JsonSubTypes.Type(value = AwsRoleAccess.class, name = "AWS_ROLE_ARN"),
    @JsonSubTypes.Type(value = AzureApiKeyCredentials.class, name = "AZURE_API_KEY"),
    @JsonSubTypes.Type(value = AzureCertificateCredentials.class, name = "AZURE_CERTIFICATE"),
    @JsonSubTypes.Type(value = GoogleUserCredentials.class, name = "GCP_USER_CREDENTIALS"),
    @JsonSubTypes.Type(value = GoogleServiceAccountCredentials.class, name = "GCP_SERVICE_CREDENTIALS"),
    @JsonSubTypes.Type(value = YandexAuthorizedKeys.class, name = "YANDEX"),
    @JsonSubTypes.Type(value = KubeConfigCredentials.class, name = "KUBE_CONFIG"),
})
public interface ICredentials {

}

