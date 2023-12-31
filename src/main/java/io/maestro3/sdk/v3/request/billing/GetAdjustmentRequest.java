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

package io.maestro3.sdk.v3.request.billing;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = GetAdjustmentRequest.GetAdjustmentRequestBuilder.class)
public class GetAdjustmentRequest extends AbstractAdjustmentRequest {

    private GetAdjustmentRequest(GetAdjustmentRequestBuilder builder) {
        super(builder);
    }

    public static GetAdjustmentRequestBuilder builder() {
        return new GetAdjustmentRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_ADJUSTMENT;
    }

    public static final class GetAdjustmentRequestBuilder
        extends AbstractAdjustmentRequestBuilder<GetAdjustmentRequestBuilder, GetAdjustmentRequest> {

        @Override
        protected GetAdjustmentRequestBuilder getThis() {
            return this;
        }

        @Override
        public GetAdjustmentRequest build() {
            validateParams();
            return new GetAdjustmentRequest(this);
        }
    }
}
