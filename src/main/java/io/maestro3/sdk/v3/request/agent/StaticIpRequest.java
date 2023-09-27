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

package io.maestro3.sdk.v3.request.agent;

public abstract class StaticIpRequest extends BaseStaticIpRequest {
    private final String ip;

    protected StaticIpRequest(AbstractBuilder<?, ?> builder) {
        super(builder);
        this.ip = builder.ip;
    }

    public String getIp() {
        return ip;
    }

    public abstract static class AbstractBuilder<B extends AbstractBuilder<B, R>, R extends StaticIpRequest>
        extends AbstractStaticIpRequestBuilder<B, R> {

        private String ip;

        public B withIp(String ip) {
            this.ip = ip;
            return getThis();
        }
    }
}
