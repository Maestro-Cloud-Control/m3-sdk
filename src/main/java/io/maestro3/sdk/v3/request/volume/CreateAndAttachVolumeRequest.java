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
import io.maestro3.sdk.v3.request.IRequest;
import io.maestro3.sdk.v3.request.instance.InstanceActionRequest;

@JsonDeserialize(builder = CreateAndAttachVolumeRequest.VolumeRequestBuilder.class)
public class CreateAndAttachVolumeRequest extends InstanceActionRequest implements IRequest {

    private final String volumeName;
    private final String volumeId;
    private final Integer sizeInGB;

    private CreateAndAttachVolumeRequest(VolumeRequestBuilder builder) {
        super(builder);
        this.volumeId = builder.volumeId;
        this.volumeName = builder.volumeName;
        this.sizeInGB = builder.sizeInGB;
    }

    public static VolumeRequestBuilder builder() {
        return new VolumeRequestBuilder();
    }

    public String getVolumeName() {
        return volumeName;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public Integer getSizeInGB() {
        return sizeInGB;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.CREATE_AND_ATTACH_VOLUME;
    }

    public static final class VolumeRequestBuilder
        extends AbstractInstanceActionBuilder<VolumeRequestBuilder, CreateAndAttachVolumeRequest> {

        private String volumeName;
        private String volumeId;
        private Integer sizeInGB;

        public VolumeRequestBuilder withVolumeId(String volumeId) {
            this.volumeId = volumeId;
            return this;
        }

        public VolumeRequestBuilder withVolumeName(String volumeName) {
            this.volumeName = volumeName;
            return this;
        }

        public VolumeRequestBuilder withSizeInGB(Integer sizeInGB) {
            this.sizeInGB = sizeInGB;
            return this;
        }

        @Override
        protected VolumeRequestBuilder getThis() {
            return this;
        }

        public CreateAndAttachVolumeRequest build() {
            validateCommonParams();
            Assert.hasText(volumeName, "volumeName");
            Assert.notNull(sizeInGB, "sizeInGB");
            return new CreateAndAttachVolumeRequest(this);
        }
    }
}
