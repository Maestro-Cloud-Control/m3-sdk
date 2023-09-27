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
import io.maestro3.sdk.v3.model.paas.SdkTemplateVariableValidationDto;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.List;

@JsonDeserialize(builder = ValidatePlatformServiceVariablesRequest.Builder.class)
public class ValidatePlatformServiceVariablesRequest implements IRequest {

    private final List<SdkTemplateVariableValidationDto> dtoList;

    private ValidatePlatformServiceVariablesRequest(Builder builder) {
        this.dtoList = builder.dtoList;
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<SdkTemplateVariableValidationDto> getDtoList() {
        return dtoList;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.VALIDATE_SERVICE_VARIABLES;
    }

    public static final class Builder {
        private List<SdkTemplateVariableValidationDto> dtoList;

        public Builder withDtoList(List<SdkTemplateVariableValidationDto> dtoList) {
            this.dtoList = dtoList;
            return this;
        }

        public ValidatePlatformServiceVariablesRequest build() {
            return new ValidatePlatformServiceVariablesRequest(this);
        }
    }
}
