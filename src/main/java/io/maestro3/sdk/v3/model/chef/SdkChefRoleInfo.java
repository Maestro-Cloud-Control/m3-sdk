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

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkChefRoleInfo {
    private String roleName;
    private int minCpu;
    private long minMemoryMb;
    private List<String> requiredParameters;

    public SdkChefRoleInfo() {
    }

    public SdkChefRoleInfo(String roleName, int minCpu, long minMemoryMb, List<String> requiredParameters) {
        this.roleName = roleName;
        this.minCpu = minCpu;
        this.minMemoryMb = minMemoryMb;
        this.requiredParameters = requiredParameters;
    }

    public List<String> getRequiredParameters() {
        return requiredParameters;
    }

    public void setRequiredParameters(List<String> requiredParameters) {
        this.requiredParameters = requiredParameters;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getMinCpu() {
        return minCpu;
    }

    public void setMinCpu(int minCpu) {
        this.minCpu = minCpu;
    }

    public long getMinMemoryMb() {
        return minMemoryMb;
    }

    public void setMinMemoryMb(long minMemoryMb) {
        this.minMemoryMb = minMemoryMb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdkChefRoleInfo that = (SdkChefRoleInfo) o;
        return minCpu == that.minCpu &&
            minMemoryMb == that.minMemoryMb &&
            Objects.equals(roleName, that.roleName) &&
            Objects.equals(requiredParameters, that.requiredParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName, minCpu, minMemoryMb, requiredParameters);
    }

    @Override
    public String toString() {
        return "SdkChefRoleInfo{" +
            "roleName='" + roleName + '\'' +
            ", minCpu=" + minCpu +
            ", minMemoryMb=" + minMemoryMb +
            ", requiredParameters=" + requiredParameters +
            '}';
    }
}
