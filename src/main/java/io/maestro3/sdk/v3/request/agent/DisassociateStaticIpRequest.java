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

package io.maestro3.sdk.v3.request.agent;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = DisassociateStaticIpRequest.Builder.class)
public class DisassociateStaticIpRequest extends StaticIpRequest {

    private DisassociateStaticIpRequest(Builder builder) {
        super(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DISASSOCIATE_IP;
    }

    public static final class Builder extends AbstractBuilder<Builder, DisassociateStaticIpRequest> {

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public DisassociateStaticIpRequest build() {
            return new DisassociateStaticIpRequest(this);
        }
    }
}
