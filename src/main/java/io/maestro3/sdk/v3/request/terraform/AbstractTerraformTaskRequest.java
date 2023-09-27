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

package io.maestro3.sdk.v3.request.terraform;

import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateType;
import io.maestro3.sdk.v3.request.approval.ApprovalRule;

import java.util.List;

public abstract class AbstractTerraformTaskRequest extends BaseTerraformStackRequest {

    private final String terraformVersion;
    private final String description;
    private final boolean multistack;
    private final boolean needReview;
    private final List<String> reviewers;
    private final ApprovalRule approvalRule;
    private final String templateActivity;
    private final boolean partModificationProtected;

    protected AbstractTerraformTaskRequest(AbstractBuilder<?, ?> builder) {
        super(builder);
        this.terraformVersion = builder.terraformVersion;
        this.description = builder.description;
        this.multistack = builder.multistack;
        this.needReview = builder.needReview;
        this.reviewers = builder.reviewers;
        this.approvalRule = builder.approvalRule;
        this.templateActivity = builder.templateActivity;
        this.partModificationProtected = builder.partModificationProtected;
    }

    public boolean isMultistack() {
        return multistack;
    }

    public String getTerraformVersion() {
        return terraformVersion;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNeedReview() {
        return needReview;
    }

    public List<String> getReviewers() {
        return reviewers;
    }

    public ApprovalRule getApprovalRule() {
        return approvalRule;
    }

    public String getTemplateActivity() {
        return templateActivity;
    }

    public boolean isPartModificationProtected() {
        return partModificationProtected;
    }

    public abstract static class AbstractBuilder<B extends AbstractBuilder<B, R>, R extends AbstractTerraformTaskRequest>
        extends BaseTerraformStackRequestBuilder<B, R> {

        protected String terraformVersion;
        private String description;
        private boolean multistack;
        private boolean needReview;
        private List<String> reviewers;
        private ApprovalRule approvalRule;
        private String templateActivity;
        private boolean partModificationProtected;

        public B withMultistack(boolean multistack) {
            this.multistack = multistack;
            return getThis();
        }

        public B withTerraformVersion(String terraformVersion) {
            this.terraformVersion = terraformVersion;
            return getThis();
        }

        public B withDescription(String description) {
            this.description = description;
            return getThis();
        }

        public B withNeedReview(Boolean needReview) {
            this.needReview = needReview;
            return getThis();
        }

        public B withReviewers(List<String> reviewers) {
            this.reviewers = reviewers;
            return getThis();
        }

        public B withApprovalRule(ApprovalRule approvalRule) {
            this.approvalRule = approvalRule;
            return getThis();
        }

        public B withPartModificationProtected(Boolean partModificationProtected) {
            this.partModificationProtected = partModificationProtected;
            return getThis();
        }

        public B withTemplateActivity(String templateActivity) {
            this.templateActivity = templateActivity;
            return getThis();
        }

        @Override
        protected void assertAllFieldsSet() {
            super.assertAllFieldsSet();
            if (templateType == SdkTemplateType.TERRAFORM) {
                Assert.hasText(terraformVersion, "terraformVersion");
            }
        }
    }
}
