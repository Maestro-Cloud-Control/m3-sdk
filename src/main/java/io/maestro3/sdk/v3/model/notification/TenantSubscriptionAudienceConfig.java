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

public class TenantSubscriptionAudienceConfig {

    private boolean subscribed;
    private boolean allowCustomization;

    public TenantSubscriptionAudienceConfig() {
        // for json deserializer
    }

    public TenantSubscriptionAudienceConfig(boolean subscribed, boolean allowCustomization) {
        this.subscribed = subscribed;
        this.allowCustomization = allowCustomization;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public boolean isAllowCustomization() {
        return allowCustomization;
    }

    public void setAllowCustomization(boolean allowCustomization) {
        this.allowCustomization = allowCustomization;
    }
}
