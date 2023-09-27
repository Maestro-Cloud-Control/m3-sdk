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

public class SubscriptionGroupDescription {

    private String group;
    private String title;
    private String description;
    private boolean tenantSpecific;
    private boolean regionSpecific;
    private boolean critical;
    private boolean financial;
    private boolean withoutPush;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTenantSpecific() {
        return tenantSpecific;
    }

    public void setTenantSpecific(boolean tenantSpecific) {
        this.tenantSpecific = tenantSpecific;
    }

    public boolean isRegionSpecific() {
        return regionSpecific;
    }

    public void setRegionSpecific(boolean regionSpecific) {
        this.regionSpecific = regionSpecific;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    public boolean isFinancial() {
        return financial;
    }

    public void setFinancial(boolean financial) {
        this.financial = financial;
    }

    public boolean isWithoutPush() {
        return withoutPush;
    }

    public void setWithoutPush(boolean withoutPush) {
        this.withoutPush = withoutPush;
    }

    @Override
    public String toString() {
        return "SubscriptionGroupDescription{" +
            "group='" + group + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", tenantSpecific=" + tenantSpecific +
            ", regionSpecific=" + regionSpecific +
            ", isCritical=" + critical +
            ", isFinancial=" + financial +
            ", withoutPush=" + withoutPush +
            '}';
    }
}
