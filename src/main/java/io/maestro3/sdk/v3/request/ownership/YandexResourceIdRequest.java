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

package io.maestro3.sdk.v3.request.ownership;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.HashMap;
import java.util.Map;

@JsonDeserialize(builder = YandexResourceIdRequest.Builder.class)
public class YandexResourceIdRequest extends ResourceIdRequest {

    private final String cloudResourceId;

    private YandexResourceIdRequest(Builder builder) {
        super(builder, SdkCloud.YANDEX);
        this.cloudResourceId = builder.cloudResourceId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getCloudResourceId() {
        return cloudResourceId;
    }

    @Override
    public String getAccountId() {
        return cloudResourceId;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put(OwnershipCloudParamNames.TENANT, getTenant());
        paramsMap.put(OwnershipCloudParamNames.RESOURCE_ID, getResourceId());
        paramsMap.put(OwnershipCloudParamNames.CLOUD_RESOURCE_ID, getCloudResourceId());
        paramsMap.put(OwnershipCloudParamNames.REGION, getRegion());
        return paramsMap;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static final class Builder extends ResourceIdRequestBuilder<Builder, YandexResourceIdRequest> {

        private String cloudResourceId;

        public Builder withCloudResourceId(String cloudResourceId) {
            this.cloudResourceId = cloudResourceId;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public YandexResourceIdRequest build() {
            Assert.hasText(cloudResourceId, "cloudResourceId");
            validateCommonParams();
            return new YandexResourceIdRequest(this);
        }
    }
}
