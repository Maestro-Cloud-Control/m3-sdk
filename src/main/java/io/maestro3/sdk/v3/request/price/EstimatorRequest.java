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

package io.maestro3.sdk.v3.request.price;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.price.estimator.SdkEstimatorInstance;
import io.maestro3.sdk.v3.model.price.estimator.SdkEstimatorStorage;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.List;

@JsonDeserialize(builder = EstimatorRequest.Builder.class)
public class EstimatorRequest implements IRequest {

    private final String zone;
    private final List<SdkEstimatorInstance> instances;
    @JsonProperty("storages")
    private final List<SdkEstimatorStorage> volumes;
    private final List<SdkEstimatorStorage> images;
    private final List<SdkEstimatorStorage> checkpoints;

    private EstimatorRequest(Builder builder) {
        this.zone = builder.zone;
        this.instances = builder.instances;
        this.volumes = builder.volumes;
        this.images = builder.images;
        this.checkpoints = builder.checkpoints;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getZone() {
        return zone;
    }

    public List<SdkEstimatorInstance> getInstances() {
        return instances;
    }

    public List<SdkEstimatorStorage> getVolumes() {
        return volumes;
    }

    public List<SdkEstimatorStorage> getImages() {
        return images;
    }

    public List<SdkEstimatorStorage> getCheckpoints() {
        return checkpoints;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_COST_ESTIMATION;
    }

    public static final class Builder {

        private String zone;
        private List<SdkEstimatorInstance> instances;
        private List<SdkEstimatorStorage> volumes;
        private List<SdkEstimatorStorage> images;
        private List<SdkEstimatorStorage> checkpoints;

        public Builder withZone(String zone) {
            this.zone = zone;
            return this;
        }

        public Builder withInstances(List<SdkEstimatorInstance> instances) {
            this.instances = instances;
            return this;
        }

        @JsonAlias("storages")
        public Builder withVolumes(List<SdkEstimatorStorage> volumes) {
            this.volumes = volumes;
            return this;
        }

        public Builder withImages(List<SdkEstimatorStorage> images) {
            this.images = images;
            return this;
        }

        public Builder withCheckpoints(List<SdkEstimatorStorage> checkpoints) {
            this.checkpoints = checkpoints;
            return this;
        }

        public EstimatorRequest build() {
            return new EstimatorRequest(this);
        }
    }
}
