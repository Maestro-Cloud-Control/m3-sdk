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

import java.util.Objects;

public class SdkResourceOwnership implements IResourceOwnership {

    private String id;

    private String resourceId;

    private String owner;

    private OwnerType ownerType;

    private String reason;

    private String initiator;

    private long startDate;

    private Boolean actual;

    public SdkResourceOwnership() {
    }

    public SdkResourceOwnership(String resourceId, String owner, OwnerType ownerType,
                                String reason, String initiator,
                                long startDate) {
        this.resourceId = resourceId;
        this.owner = owner;
        this.ownerType = ownerType;
        this.reason = reason;
        this.initiator = initiator;
        this.startDate = startDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getResourceId() {
        return resourceId;
    }

    @Override
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public OwnerType getOwnerType() {
        return ownerType;
    }

    @Override
    public void setOwnerType(OwnerType ownerType) {
        this.ownerType = ownerType;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public long getStartDate() {
        return startDate;
    }

    @Override
    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    @Override
    public String getInitiator() {
        return initiator;
    }

    @Override
    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    @Override
    public Boolean isActual() {
        return actual;
    }

    @Override
    public void setActual(Boolean actual) {
        this.actual = actual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdkResourceOwnership that = (SdkResourceOwnership) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(resourceId, that.resourceId) &&
                Objects.equals(owner, that.owner) &&
                ownerType == that.ownerType &&
                Objects.equals(reason, that.reason) &&
                Objects.equals(initiator, that.initiator) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, resourceId, owner, ownerType, reason, initiator, startDate);
    }

    @Override
    public String toString() {
        return "SdkResourceOwnership{" +
                "id='" + id + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", owner='" + owner + '\'' +
                ", ownerType=" + ownerType +
                ", reason='" + reason + '\'' +
                ", initiator='" + initiator + '\'' +
                ", startDate=" + startDate +
                '}';
    }

}
