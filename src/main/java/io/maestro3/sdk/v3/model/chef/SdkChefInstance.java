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

public class SdkChefInstance {
    private String instanceId;
    private String chefServer;
    private String autoConfigurationState;
    private Set<String> roles;
    private String initDate;

    public SdkChefInstance() {
    }

    public SdkChefInstance(String instanceId, String chefServer, String autoConfigurationState, Set<String> roles, String initDate) {
        this.instanceId = instanceId;
        this.chefServer = chefServer;
        this.autoConfigurationState = autoConfigurationState;
        this.roles = roles;
        this.initDate = initDate;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getChefServer() {
        return chefServer;
    }

    public void setChefServer(String chefServer) {
        this.chefServer = chefServer;
    }

    public String getAutoConfigurationState() {
        return autoConfigurationState;
    }

    public void setAutoConfigurationState(String autoConfigurationState) {
        this.autoConfigurationState = autoConfigurationState;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdkChefInstance that = (SdkChefInstance) o;
        return Objects.equals(instanceId, that.instanceId) && Objects.equals(chefServer, that.chefServer) && Objects.equals(autoConfigurationState, that.autoConfigurationState) && Objects.equals(roles, that.roles) && Objects.equals(initDate, that.initDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceId, chefServer, autoConfigurationState, roles, initDate);
    }

    @Override
    public String toString() {
        return "SdkChefInstance{" +
            "instanceId='" + instanceId + '\'' +
            ", chefServer='" + chefServer + '\'' +
            ", autoConfigurationState='" + autoConfigurationState + '\'' +
            ", roles=" + roles +
            ", initDate='" + initDate + '\'' +
            '}';
    }
}
