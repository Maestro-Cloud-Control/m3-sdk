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

@JsonDeserialize(builder = AttachVolumeRequest.Builder.class)
public class AttachVolumeRequest extends InstanceActionRequest {

    private final String volumeId;
    private final Boolean deleteOnTermination;

    private AttachVolumeRequest(Builder builder) {
        super(builder);
        this.volumeId = builder.volumeId;
        this.deleteOnTermination = builder.deleteOnTermination;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getVolumeId() {
        return volumeId;
    }

    public Boolean isDeleteOnTermination() {
        return deleteOnTermination;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ATTACH_VOLUME;
    }

    public static final class Builder
            extends AbstractInstanceActionBuilder<Builder, AttachVolumeRequest> {

        private String volumeId;
        private Boolean deleteOnTermination;

        public Builder withVolumeId(String volumeId) {
            this.volumeId = volumeId;
            return this;
        }

        public Builder withDeleteOnTermination(Boolean deleteOnTermination) {
            this.deleteOnTermination = deleteOnTermination;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        public AttachVolumeRequest build() {
            validateCommonParams();
            Assert.hasText(volumeId, "volumeId");
            return new AttachVolumeRequest(this);
        }
    }
}
