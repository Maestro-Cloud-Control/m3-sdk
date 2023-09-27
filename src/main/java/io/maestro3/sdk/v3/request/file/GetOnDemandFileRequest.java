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

package io.maestro3.sdk.v3.request.file;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = GetOnDemandFileRequest.Builder.class)
public class GetOnDemandFileRequest implements IRequest {

    private final String fileInfoId;
    private final String fileInfoType;
    private final Long expiration;

    private GetOnDemandFileRequest(Builder builder) {
        this.fileInfoId = builder.fileInfoId;
        this.fileInfoType = builder.fileInfoType;
        this.expiration = builder.expiration;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFileInfoId() {
        return fileInfoId;
    }

    public String getFileInfoType() {
        return fileInfoType;
    }

    public Long getExpiration() {
        return expiration;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_FILE_FROM_SERVER;
    }

    public static final class Builder {
        private String fileInfoId;
        private String fileInfoType;
        private Long expiration;

        public Builder withFileInfoId(String fileInfoId) {
            Assert.hasText(fileInfoId, "fileInfoId");
            this.fileInfoId = fileInfoId;
            return this;
        }

        public Builder withFileInfoType(String fileInfoType) {
            this.fileInfoType = fileInfoType;
            return this;
        }

        public Builder withExpiration(Long expiration) {
            this.expiration = expiration;
            return this;
        }

        public GetOnDemandFileRequest build() {
            Assert.hasText(fileInfoId, "fileInfoId");
            return new GetOnDemandFileRequest(this);
        }
    }
}
