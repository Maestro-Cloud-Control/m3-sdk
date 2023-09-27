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

package io.maestro3.sdk.v3.model.ownership;

import io.maestro3.sdk.v3.request.ownership.ResourceIdRequest;

import java.util.Objects;

public class ResourceIdRequestOnOwnerPair {

    private ResourceIdRequest resourceIdRequest;
    private String owner;
    private long date;

    public ResourceIdRequestOnOwnerPair() {
    }

    public ResourceIdRequestOnOwnerPair(ResourceIdRequest resourceIdRequest, String owner, long date) {
        this.resourceIdRequest = resourceIdRequest;
        this.owner = owner;
        this.date = date;
    }

    public ResourceIdRequest getResourceIdRequest() {
        return resourceIdRequest;
    }

    public void setResourceIdRequest(ResourceIdRequest resourceIdRequest) {
        this.resourceIdRequest = resourceIdRequest;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceIdRequestOnOwnerPair that = (ResourceIdRequestOnOwnerPair) o;
        return Objects.equals(resourceIdRequest, that.resourceIdRequest)
                && Objects.equals(owner, that.owner)
                && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceIdRequest, owner, date);
    }

    @Override
    public String toString() {
        return "ResourceIdRequestOnOwnershipPair{" +
                "resourceIdRequest=" + resourceIdRequest +
                ", sdkResourceOwnership=" + owner +
                ", date=" + date +
                '}';
    }
}
