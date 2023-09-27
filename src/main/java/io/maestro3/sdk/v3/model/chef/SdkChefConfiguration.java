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

package io.maestro3.sdk.v3.model.chef;

import java.util.Objects;
import java.util.Set;

public class SdkChefConfiguration {
    private String serverId;
    private Set<SdkChefRoleInfo> roles;
    private Set<String> zones;
    private String chefOrganization;

    public SdkChefConfiguration() {
    }

    public SdkChefConfiguration(String serverId, Set<SdkChefRoleInfo> roles, Set<String> zones, String chefOrganization) {
        this.serverId = serverId;
        this.roles = roles;
        this.zones = zones;
        this.chefOrganization = chefOrganization;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public Set<SdkChefRoleInfo> getRoles() {
        return roles;
    }

    public void setRoles(Set<SdkChefRoleInfo> roles) {
        this.roles = roles;
    }

    public Set<String> getZones() {
        return zones;
    }

    public void setZones(Set<String> zones) {
        this.zones = zones;
    }

    public String getChefOrganization() {
        return chefOrganization;
    }

    public void setChefOrganization(String chefOrganization) {
        this.chefOrganization = chefOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdkChefConfiguration that = (SdkChefConfiguration) o;
        return Objects.equals(serverId, that.serverId) &&
            Objects.equals(roles, that.roles) &&
            Objects.equals(zones, that.zones) &&
            Objects.equals(chefOrganization, that.chefOrganization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverId, roles, zones, chefOrganization);
    }

    @Override
    public String toString() {
        return "SdkChefConfiguration{" +
            "serverId='" + serverId + '\'' +
            ", roles=" + roles +
            ", zones=" + zones +
            ", chefOrganization='" + chefOrganization + '\'' +
            '}';
    }
}
