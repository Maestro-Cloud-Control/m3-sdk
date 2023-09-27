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

import io.maestro3.sdk.v3.request.IRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractExecuteActionRequest implements IRequest {

    private final String actionName;

    /**
     * Params which will be visible for end user
     */
    private final Map<String, String> params;

    /**
     * Params which will be not visible for end user
     */
    private final Map<String, String> additionalParams;

    private final List<ApprovalStep> approvalSteps;

    private final ApprovalStep executedApprovalStep;

    private final boolean isSequential;

    private final String action;
    private final String performer;

    protected AbstractExecuteActionRequest(AbstractExecuteActionRequestBuilder<?, ?> builder) {
        this.actionName = builder.actionName;
        this.params = builder.params;
        this.additionalParams = builder.additionalParams;
        this.approvalSteps = builder.approvalSteps;
        this.executedApprovalStep = builder.executedApprovalStep;
        this.isSequential = builder.isSequential;
        this.action = builder.action;
        this.performer = builder.performer;
    }

    public String getActionName() {
        return actionName;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, String> getAdditionalParams() {
        return additionalParams;
    }

    public List<ApprovalStep> getApprovalSteps() {
        return approvalSteps;
    }

    public ApprovalStep getExecutedApprovalStep() {
        return executedApprovalStep;
    }

    public boolean isSequential() {
        return isSequential;
    }

    public String getAction() {
        return action;
    }

    public String getPerformer() {
        return performer;
    }

    public abstract static class AbstractExecuteActionRequestBuilder
        <B extends AbstractExecuteActionRequestBuilder<B, R>, R extends AbstractExecuteActionRequest> {

        private String actionName;
        private Map<String, String> params = new LinkedHashMap<>();
        private Map<String, String> additionalParams = new HashMap<>();
        private List<ApprovalStep> approvalSteps = new ArrayList<>();
        private ApprovalStep executedApprovalStep;
        private boolean isSequential;
        private String action;
        private String performer;

        protected abstract B getThis();

        public abstract R build();

        public B withActionName(String actionName) {
            this.actionName = actionName;
            return getThis();
        }

        public B withParams(Map<String, String> params) {
            this.params = params;
            return getThis();
        }

        public B withAdditionalParams(Map<String, String> additionalParams) {
            this.additionalParams = additionalParams;
            return getThis();
        }

        public B withApprovalSteps(List<ApprovalStep> approvalSteps) {
            this.approvalSteps = approvalSteps;
            return getThis();
        }

        public B withExecutedApprovalStep(ApprovalStep executedApprovalStep) {
            this.executedApprovalStep = executedApprovalStep;
            return getThis();
        }

        public B withSequential(boolean isSequential) {
            this.isSequential = isSequential;
            return getThis();
        }

        public B withAction(String action) {
            this.action = action;
            return getThis();
        }

        public B withPerformer(String performer) {
            this.performer = performer;
            return getThis();
        }
    }
}
