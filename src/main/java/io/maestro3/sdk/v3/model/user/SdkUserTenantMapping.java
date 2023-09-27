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

package io.maestro3.sdk.v3.model.user;

import java.util.List;
import java.util.Objects;

public class SdkUserTenantMapping {

    private String tenant;
    private List<String> positions;

    public String getTenant() {
        return tenant;
    }

    public SdkUserTenantMapping setTenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    public List<String> getPositions() {
        return positions;
    }

    public SdkUserTenantMapping setPositions(List<String> positions) {
        this.positions = positions;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SdkUserTenantMapping)) return false;
        SdkUserTenantMapping that = (SdkUserTenantMapping) o;
        return Objects.equals(tenant, that.tenant) && Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenant, positions);
    }

    @Override
    public String toString() {
        return "SdkUserTenantMapping{" +
            "tenant='" + tenant + '\'' +
            ", positions=" + positions +
            '}';
    }
}
