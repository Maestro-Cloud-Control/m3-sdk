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

package io.maestro3.sdk.v3.request.security;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = GetLastInstanceNessusScanRequest.GetLastInstanceNessusScanRequestBuilder.class)
public class GetLastInstanceNessusScanRequest extends GetLastInstanceScanRequest {
    private GetLastInstanceNessusScanRequest(GetLastInstanceNessusScanRequestBuilder builder) {
        super(builder);
    }

    public static GetLastInstanceNessusScanRequestBuilder builder() {
        return new GetLastInstanceNessusScanRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_LAST_NESSUS_SCAN;
    }

    public static class GetLastInstanceNessusScanRequestBuilder extends
        AbstractGetLastInstanceScanRequestBuilder<GetLastInstanceNessusScanRequestBuilder, GetLastInstanceNessusScanRequest> {

        @Override
        protected GetLastInstanceNessusScanRequestBuilder getThis() {
            return this;
        }

        @Override
        public GetLastInstanceNessusScanRequest build() {
            validateCommonParams();
            return new GetLastInstanceNessusScanRequest(this);
        }
    }
}
