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

@JsonDeserialize(builder = RebootInstanceRequest.RebootInstanceRequestBuilder.class)
public class RebootInstanceRequest extends InstanceActionRequest {

    private RebootInstanceRequest(RebootInstanceRequestBuilder builder) {
        super(builder);
    }

    public static RebootInstanceRequestBuilder builder() {
        return new RebootInstanceRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.REBOOT_INSTANCE;
    }

    public static final class RebootInstanceRequestBuilder
        extends AbstractInstanceActionBuilder<RebootInstanceRequestBuilder, RebootInstanceRequest> {

        @Override
        protected RebootInstanceRequestBuilder getThis() {
            return this;
        }

        @Override
        public RebootInstanceRequest build() {
            validateCommonParams();
            return new RebootInstanceRequest(this);
        }
    }
}
