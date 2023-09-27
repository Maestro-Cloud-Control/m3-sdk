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

package io.maestro3.sdk.v3.model.notification;

import java.util.Map;

public class TenantSubscriptionConfiguration {

    private Map<TenantSubscriptionAudience, TenantSubscriptionAudienceConfig> audienceConfig;

    public TenantSubscriptionConfiguration() {
        // for json deserializer
    }

    public TenantSubscriptionConfiguration(Map<TenantSubscriptionAudience, TenantSubscriptionAudienceConfig>
                                               audienceConfig) {
        this.audienceConfig = audienceConfig;
    }

    public Map<TenantSubscriptionAudience, TenantSubscriptionAudienceConfig> getAudienceConfig() {
        return audienceConfig;
    }

    public void setAudienceConfig(Map<TenantSubscriptionAudience, TenantSubscriptionAudienceConfig> audienceConfig) {
        this.audienceConfig = audienceConfig;
    }
}
