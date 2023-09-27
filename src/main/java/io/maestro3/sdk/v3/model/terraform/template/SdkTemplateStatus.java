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

package io.maestro3.sdk.v3.model.terraform.template;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.maestro3.sdk.exception.M3SdkException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SdkTemplateStatus {
    PENDING_VALIDATION("Pending validation", false),
    VALIDATING("Validating", true),
    FAILED_TO_VALIDATE("Failed to validate", false),
    VALID("Valid", false),
    INVALID("Invalid", false),

    PENDING_PLANNING("Pending planning", false),
    FAILED_TO_PLAN("Failed to plan", false),
    PLANNING("Planning", true),
    PLANNED("Planned", false),

    PENDING_APPROVAL("Pending approval", true),
    APPROVAL_FAILED("Failed to start approval", false),
    APPROVAL_REJECTED("Approve request rejected", false),
    PRICE_QUOTA_EXCEEDED("Price quota exceeded", false),

    PENDING_CREATION("Pending creation", false),
    STACK_CREATING("Stack creating", true),
    CREATED("Created", false),
    FAILED_TO_CREATE("Failed to create", false),
    PARTIALLY_CREATED("Partially created", false),

    PENDING_DESTROY("Pending destroy", false),
    STACK_DESTROYING("Stack destroying", true),
    DESTROYED("Destroyed", false),
    FAILED_TO_DESTROY("Failed to destroy", false);

    private String title;
    private boolean transitional;

    SdkTemplateStatus(String title, boolean transitional) {
        this.title = title;
        this.transitional = transitional;
    }

    @JsonCreator
    public static SdkTemplateStatus fromValue(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new UnsupportedOperationException("Status name should not be null or empty.");
        }
        for (SdkTemplateStatus templateStatus : values()) {
            if (templateStatus.name().equalsIgnoreCase(name)) {
                return templateStatus;
            }
        }
        throw new M3SdkException("Failed to find job status by specified name: " + name);
    }

    public static List<SdkTemplateStatus> getNonTransitionalStatuses() {
        return Arrays.stream(values())
                .filter(status -> !status.isTransitional())
                .collect(Collectors.toList());
    }

    public String getTitle() {
        return title;
    }

    public boolean isTransitional() {
        return transitional;
    }
}
