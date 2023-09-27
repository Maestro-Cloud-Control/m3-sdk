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

package io.maestro3.sdk.v3.request.account;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@JsonDeserialize(builder = OnboardingGoogleRequest.OnboardingGoogleRequestBuilder.class)
public class OnboardingGoogleRequest extends AbstractOnboardingRequest {

    private final List<ProjectInfo> projectInfos;

    private OnboardingGoogleRequest(OnboardingGoogleRequestBuilder builder) {
        super(builder);
        this.projectInfos = Optional.ofNullable(builder.projectInfos).orElse(Collections.emptyList());
    }

    public static OnboardingGoogleRequestBuilder builder() {
        return new OnboardingGoogleRequestBuilder();
    }

    public List<ProjectInfo> getProjectInfos() {
        return projectInfos;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.ONBOARDING_GOOGLE_CUSTOMER_AND_TENANT;
    }

    @Override
    public String toString() {
        return "OnboardingGoogleRequest{" +
            "adminEmail='" + getAdminEmail() + '\'' +
            ", customerId='" + getCustomerId() + '\'' +
            ", customerName='" + getCustomerName() + '\'' +
            ", projectInfos=" + projectInfos +
            '}';
    }

    public static final class OnboardingGoogleRequestBuilder
        extends AbstractOnboardingRequestBuilder<OnboardingGoogleRequestBuilder, OnboardingGoogleRequest> {

        private List<ProjectInfo> projectInfos;

        public OnboardingGoogleRequestBuilder withProjectInfos(List<ProjectInfo> projectInfos) {
            this.projectInfos = projectInfos;
            return getThis();
        }

        @Override
        protected OnboardingGoogleRequestBuilder getThis() {
            return this;
        }

        @Override
        public OnboardingGoogleRequest build() {
            return new OnboardingGoogleRequest(this);
        }
    }

    @JsonDeserialize(builder = ProjectInfo.ProjectInfoBuilder.class)
    public static class ProjectInfo {

        private final String projectId;
        private final String regionNativeName;

        private ProjectInfo(ProjectInfoBuilder builder) {
            this.projectId = builder.projectId;
            this.regionNativeName = builder.regionNativeName;
        }

        public String getProjectId() {
            return projectId;
        }

        public String getRegionNativeName() {
            return regionNativeName;
        }

        public static ProjectInfoBuilder builder() {
            return new ProjectInfoBuilder();
        }

        @Override
        public String toString() {
            return "ProjectInfo{" +
                ", projectId='" + projectId + '\'' +
                ", regionNativeName='" + regionNativeName + '\'' +
                '}';
        }

        public static class ProjectInfoBuilder {

            private String projectId;
            private String regionNativeName;

            public ProjectInfoBuilder withProjectId(String projectId) {
                this.projectId = projectId;
                return this;
            }

            public ProjectInfoBuilder withRegionNativeName(String regionNativeName) {
                this.regionNativeName = regionNativeName;
                return this;
            }

            public ProjectInfo build() {
                return new ProjectInfo(this);
            }
        }
    }
}
