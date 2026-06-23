/*
 * Copyright 2025 Maestro Cloud Control LLC
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

package io.maestro3.sdk.v3.model.agent;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

/**
 * Response indicating whether requested resources are available.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkResourceAvailabilityCheckResponse {

    private boolean available;
    private String message;
    private List<String> unavailableDetails;

    public SdkResourceAvailabilityCheckResponse() {
        this.unavailableDetails = new ArrayList<>();
    }

    public SdkResourceAvailabilityCheckResponse(boolean available, String message, List<String> unavailableDetails) {
        this.available = available;
        this.message = message;
        this.unavailableDetails = unavailableDetails != null ? unavailableDetails : new ArrayList<>();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getUnavailableDetails() {
        return unavailableDetails;
    }

    public void setUnavailableDetails(List<String> unavailableDetails) {
        this.unavailableDetails = unavailableDetails;
    }

    @Override
    public String toString() {
        return "SdkResourceAvailabilityCheckResponse{" +
                "available=" + available +
                ", message='" + message + '\'' +
                ", unavailableDetails=" + unavailableDetails +
                '}';
    }
}
