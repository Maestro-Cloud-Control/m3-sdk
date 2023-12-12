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

package io.maestro3.sdk.v3.request.custodian;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(builder = CustodianLastK8sClusterScanRequest.Builder.class)
public class CustodianLastK8sClusterScanRequest extends AbstractCustodianLastScanRequest {

    private final String clusterId;

    private CustodianLastK8sClusterScanRequest(Builder builder) {
        super(builder);
        this.clusterId = builder.clusterId;
    }

    public String getClusterId() {
        return clusterId;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_CUSTODIAN_LAST_K8S_CLUSTER_SCAN_RESULTS;
    }

    public static final class Builder extends AbstractCustodianLastScanRequest.Builder<Builder, CustodianLastK8sClusterScanRequest> {

        private String clusterId;

        public Builder withClusterId(String clusterId) {
            this.clusterId = clusterId;
            return this;
        }

        @Override
        protected Builder getThis() {
            return this;
        }

        @Override
        public CustodianLastK8sClusterScanRequest build() {
            super.validateParams();
            Assert.hasText(clusterId, "clusterId");
            return new CustodianLastK8sClusterScanRequest(this);
        }

    }

}
