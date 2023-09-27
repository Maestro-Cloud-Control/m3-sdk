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

package io.maestro3.sdk.v3.request.audit;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IRequest;

@JsonDeserialize(builder = GetEventsRequest.Builder.class)
public class GetEventsRequest implements IRequest {

    private final String searchType;
    private final String tenantName;
    private final SdkCloud cloud;
    private final String region;
    private final Long latestEventDate;
    private final int count;
    private final int pageNumber;
    private final String eventId;
    private final String resourceId;
    private final String customerName;

    private GetEventsRequest(Builder builder) {
        this.searchType = builder.searchType;
        this.tenantName = builder.tenantName;
        this.cloud = builder.cloud;
        this.region = builder.region;
        this.latestEventDate = builder.latestEventDate;
        this.count = builder.count;
        this.pageNumber = builder.pageNumber;
        this.eventId = builder.eventId;
        this.resourceId = builder.resourceId;
        this.customerName = builder.customerName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getSearchType() {
        return searchType;
    }

    public String getTenantName() {
        return tenantName;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public String getRegion() {
        return region;
    }

    public Long getLatestEventDate() {
        return latestEventDate;
    }

    public int getCount() {
        return count;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getEventId() {
        return eventId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.GET_EVENTS;
    }

    public static final class Builder {

        private String searchType;
        private String tenantName;
        private SdkCloud cloud;
        private String region;
        private Long latestEventDate;
        private int count;
        private int pageNumber;
        private String eventId;
        private String resourceId;
        private String customerName;

        public Builder withSearchType(String searchType) {
            this.searchType = searchType;
            return this;
        }

        public Builder withTenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder withCloud(SdkCloud cloud) {
            this.cloud = cloud;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }

        public Builder withLatestEventDate(Long latestEventDate) {
            this.latestEventDate = latestEventDate;
            return this;
        }

        public Builder withCount(int count) {
            this.count = count;
            return this;
        }

        public Builder withPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public Builder withEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder withResourceId(String resourceId) {
            this.resourceId = resourceId;
            return this;
        }

        public Builder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public GetEventsRequest build() {
            return new GetEventsRequest(this);
        }
    }
}
