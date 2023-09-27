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

package io.maestro3.sdk.v3.request.instance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = StopInstanceRequest.StopInstanceRequestBuilder.class)
public class StopInstanceRequest extends InstanceActionRequest {

    private StopInstanceRequest(StopInstanceRequestBuilder builder) {
        super(builder);
    }

    public static StopInstanceRequestBuilder builder() {
        return new StopInstanceRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.STOP_INSTANCE;
    }

    public static final class StopInstanceRequestBuilder
        extends AbstractInstanceActionBuilder<StopInstanceRequestBuilder, StopInstanceRequest> {

        @Override
        protected StopInstanceRequestBuilder getThis() {
            return this;
        }

        @Override
        public StopInstanceRequest build() {
            validateCommonParams();
            return new StopInstanceRequest(this);
        }
    }
}
