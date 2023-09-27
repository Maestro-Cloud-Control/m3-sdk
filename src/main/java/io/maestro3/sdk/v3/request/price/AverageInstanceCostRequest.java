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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Map;

@JsonDeserialize(builder = AverageInstanceCostRequest.Builder.class)
public class AverageInstanceCostRequest implements IRequest {

    private final String zoneName;
    private final Map<String, String> paramsMap;

    private AverageInstanceCostRequest(Builder builder) {
        this.zoneName = builder.zoneName;
        this.paramsMap = builder.paramsMap;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getZoneName() {
        return zoneName;
    }

    public Map<String, String> getParamsMap() {
        return paramsMap;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_AVERAGE_INSTANCE_COST;
    }

    public static final class Builder {

        private String zoneName;
        private Map<String, String> paramsMap;

        public Builder withZoneName(String zoneName) {
            this.zoneName = zoneName;
            return this;
        }

        public Builder withParamsMap(Map<String, String> paramsMap) {
            this.paramsMap = paramsMap;
            return this;
        }

        public AverageInstanceCostRequest build() {
            Assert.hasText(zoneName, "zoneName");
            Assert.notNull(paramsMap, "paramsMap");
            return new AverageInstanceCostRequest(this);
        }
    }
}
