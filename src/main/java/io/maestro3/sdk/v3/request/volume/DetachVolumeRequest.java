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

package io.maestro3.sdk.v3.request.volume;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.instance.InstanceActionRequest;

@JsonDeserialize(builder = DetachVolumeRequest.VolumeRequestBuilder.class)
public class DetachVolumeRequest extends InstanceActionRequest {

    private final String volumeId;

    private DetachVolumeRequest(VolumeRequestBuilder builder) {
        super(builder);
        this.volumeId = builder.volumeId;
    }

    public static VolumeRequestBuilder builder() {
        return new VolumeRequestBuilder();
    }

    public String getVolumeId() {
        return volumeId;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DETACH_VOLUME;
    }

    public static final class VolumeRequestBuilder
        extends AbstractInstanceActionBuilder<VolumeRequestBuilder, DetachVolumeRequest> {

        private String volumeId;

        public VolumeRequestBuilder withVolumeId(String volumeId) {
            this.volumeId = volumeId;
            return this;
        }

        @Override
        protected VolumeRequestBuilder getThis() {
            return this;
        }

        public DetachVolumeRequest build() {
            validateTenantAndRegion();
            Assert.hasText(volumeId, "volumeId");
            return new DetachVolumeRequest(this);
        }
    }
}
