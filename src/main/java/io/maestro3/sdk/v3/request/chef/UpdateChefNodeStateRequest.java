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

package io.maestro3.sdk.v3.request.chef;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.List;

@JsonDeserialize(builder = UpdateChefNodeStateRequest.UpdateChefNodeStateRequestBuilder.class)
public class UpdateChefNodeStateRequest implements IRequest {
    private final String nodeId;
    private final String sourceIp;
    private final String chefServer;
    private final String state;
    private final List<String> receivedRoles;

    private UpdateChefNodeStateRequest(UpdateChefNodeStateRequestBuilder builder) {
        this.nodeId = builder.nodeId;
        this.chefServer = builder.chefServer;
        this.state = builder.state;
        this.sourceIp = builder.sourceIp;
        this.receivedRoles = builder.receivedRoles;
    }

    public static UpdateChefNodeStateRequestBuilder builder() {
        return new UpdateChefNodeStateRequestBuilder();
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getChefServer() {
        return chefServer;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public String getState() {
        return state;
    }

    public List<String> getReceivedRoles() {
        return receivedRoles;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_NODE_STATE;
    }

    public static final class UpdateChefNodeStateRequestBuilder {
        private String nodeId;
        private String chefServer;
        private String sourceIp;
        private String state;
        private List<String> receivedRoles;

        public UpdateChefNodeStateRequestBuilder withNodeId(String nodeId) {
            this.nodeId = nodeId;
            return this;
        }

        public UpdateChefNodeStateRequestBuilder withChefServer(String chefServer) {
            this.chefServer = chefServer;
            return this;
        }

        public UpdateChefNodeStateRequestBuilder withSourceIp(String sourceIp) {
            this.sourceIp = sourceIp;
            return this;
        }

        public UpdateChefNodeStateRequestBuilder withState(String state) {
            this.state = state;
            return this;
        }

        public UpdateChefNodeStateRequestBuilder withReceivedRoles(List<String> receivedRoles) {
            this.receivedRoles = receivedRoles;
            return this;
        }

        public UpdateChefNodeStateRequest build() {
            Assert.hasText(nodeId, "nodeId");
            Assert.hasText(chefServer, "chefServer");
            Assert.hasText(state, "state");
            Assert.hasText(sourceIp, "sourceIp");
            Assert.notNull(receivedRoles, "receivedRoles");
            return new UpdateChefNodeStateRequest(this);
        }
    }
}
