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

package io.maestro3.sdk.v3.request.approval;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ApprovalStep {

    private String description;
    private String approvalType;
    private ApprovalRule rule;
    private List<Approver> approvers;
    private boolean allowedApprovalAction;

    public ApprovalStep() {
    }

    public ApprovalStep(String approvalType, String description, List<String> approvers) {
        this.approvalType = approvalType;
        this.description = description;
        this.rule = ApprovalRule.ONE;
        this.approvers = approvers.stream().map(email -> new Approver(email.toLowerCase(Locale.US))).collect(Collectors.toList());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public ApprovalRule getRule() {
        return rule;
    }

    public void setRule(ApprovalRule rule) {
        this.rule = rule;
    }

    public List<Approver> getApprovers() {
        return approvers;
    }

    public void setApprovers(List<Approver> approvers) {
        this.approvers = approvers;
    }

    public boolean isAllowedApprovalAction() {
        return allowedApprovalAction;
    }

    public void setAllowedApprovalAction(boolean allowedApprovalAction) {
        this.allowedApprovalAction = allowedApprovalAction;
    }
}
