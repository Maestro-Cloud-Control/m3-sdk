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

package io.maestro3.sdk.v3.model.audit;

import io.maestro3.sdk.v3.request.ownership.ResourceIdRequest;

import java.util.Objects;

public class ResourceIdRequestOnSdkAuditEventPair {

    private ResourceIdRequest resourceIdRequest;
    private SdkAuditEvent sdkAuditEvent;

    public ResourceIdRequestOnSdkAuditEventPair() {
    }

    public ResourceIdRequestOnSdkAuditEventPair(ResourceIdRequest resourceIdRequest, SdkAuditEvent sdkAuditEvent) {
        this.resourceIdRequest = resourceIdRequest;
        this.sdkAuditEvent = sdkAuditEvent;
    }

    public ResourceIdRequest getResourceIdRequest() {
        return resourceIdRequest;
    }

    public void setResourceIdRequest(ResourceIdRequest resourceIdRequest) {
        this.resourceIdRequest = resourceIdRequest;
    }

    public SdkAuditEvent getSdkAuditEvent() {
        return sdkAuditEvent;
    }

    public void setSdkAuditEvent(SdkAuditEvent sdkAuditEvent) {
        this.sdkAuditEvent = sdkAuditEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceIdRequestOnSdkAuditEventPair that = (ResourceIdRequestOnSdkAuditEventPair) o;
        return Objects.equals(resourceIdRequest, that.resourceIdRequest) &&
                Objects.equals(sdkAuditEvent, that.sdkAuditEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceIdRequest, sdkAuditEvent);
    }

    @Override
    public String toString() {
        return "ResourceIdRequestOnSdkAuditEventPair{" +
                "resourceIdRequest=" + resourceIdRequest +
                ", sdkAuditEvent=" + sdkAuditEvent +
                '}';
    }
}
