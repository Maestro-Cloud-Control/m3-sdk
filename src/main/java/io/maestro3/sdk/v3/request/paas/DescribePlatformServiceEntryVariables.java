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

package io.maestro3.sdk.v3.request.paas;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;
import java.util.Objects;

@JsonDeserialize(builder = DescribePlatformServiceEntryVariables.Builder.class)
public class DescribePlatformServiceEntryVariables implements IRequest {

    private final String serviceId;
    private final boolean all;

    private DescribePlatformServiceEntryVariables(Builder builder) {
        this.serviceId = Objects.requireNonNull(builder.serviceId, "serviceId must not be null");
        this.all = builder.all;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getServiceId() {
        return serviceId;
    }

    public boolean isAll() {
        return all;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_PLATFORM_SERVICE_ENTRY_SECRETS;
    }

    public static final class Builder {
        private String serviceId;
        private boolean all;

        public Builder withServiceId(String serviceId) {
            this.serviceId = serviceId;
            return this;
        }

        public Builder withAll(boolean all) {
            this.all = all;
            return this;
        }

        public DescribePlatformServiceEntryVariables build() {
            return new DescribePlatformServiceEntryVariables(this);
        }
    }
}
