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

import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.request.IRequest;

public abstract class AbstractPlatformServiceSectionRequest implements IRequest {

    private final String serviceName;
    private final String sectionType;
    private final String blockTitle;

    protected AbstractPlatformServiceSectionRequest(AbstractPlatformServiceSectionRequestBuilder<?, ?> builder) {
        this.serviceName = builder.serviceName;
        this.sectionType = builder.sectionType;
        this.blockTitle = builder.blockTitle;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getSectionType() {
        return sectionType;
    }

    public String getBlockTitle() {
        return blockTitle;
    }

    public abstract static class AbstractPlatformServiceSectionRequestBuilder
        <B extends AbstractPlatformServiceSectionRequest.AbstractPlatformServiceSectionRequestBuilder<B, R>, R extends AbstractPlatformServiceSectionRequest> {

        private String serviceName;
        private String sectionType;
        private String blockTitle;

        protected abstract B getThis();

        public abstract R build();

        public B withServiceName(String serviceName) {
            this.serviceName = serviceName;
            return getThis();
        }

        public B withSectionType(String sectionType) {
            this.sectionType = sectionType;
            return getThis();
        }

        public B withBlockTitle(String blockTitle) {
            this.blockTitle = blockTitle;
            return getThis();
        }

        protected void checkFields() {
            Assert.hasText(serviceName, "serviceName must not be null or empty");
            Assert.hasText(sectionType, "sectionType must not be null or empty");
        }
    }
}
