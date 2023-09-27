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

package io.maestro3.sdk.v3.request.paas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = GetPlatformServiceVariablesInfoRequest.Builder.class)
public class GetPlatformServiceVariablesInfoRequest implements IRequest {

    private final String serviceName;

    private GetPlatformServiceVariablesInfoRequest(Builder builder) {
        this.serviceName = builder.serviceName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_SERVICE_VARIABLES_INFO;
    }

    public static final class Builder {

        private String serviceName;

        public Builder withServiceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public GetPlatformServiceVariablesInfoRequest build() {
            return new GetPlatformServiceVariablesInfoRequest(this);
        }
    }
}
