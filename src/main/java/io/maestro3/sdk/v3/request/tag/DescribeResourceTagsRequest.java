package io.maestro3.sdk.v3.request.tag;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.request.IResourceRequest;
import io.maestro3.sdk.v3.request.ownership.ResourceIdRequest;

@JsonDeserialize(builder = DescribeResourceTagsRequest.Builder.class)
public class DescribeResourceTagsRequest implements IResourceRequest {

    private final ResourceIdRequest resourceIdRequest;
    private final boolean systemTagsIncluded;

    private DescribeResourceTagsRequest(Builder builder) {
        this.resourceIdRequest = builder.resourceIdRequest;
        this.systemTagsIncluded = builder.systemTagsIncluded;
    }

    public boolean isSystemTagsIncluded() {
        return systemTagsIncluded;
    }

    @Override
    public ResourceIdRequest getResourceIdRequest() {
        return resourceIdRequest;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.DESCRIBE_RESOURCE_TAGS;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ResourceIdRequest resourceIdRequest;
        private boolean systemTagsIncluded;

        public Builder withResourceIdRequest(ResourceIdRequest resourceIdRequest) {
            this.resourceIdRequest = resourceIdRequest;
            return this;
        }

        public Builder withSystemTagsIncluded(boolean systemTagsIncluded) {
            this.systemTagsIncluded = systemTagsIncluded;
            return this;
        }

        public DescribeResourceTagsRequest build() {
            Assert.notNull(resourceIdRequest, "resourceIdRequest");
            return new DescribeResourceTagsRequest(this);
        }
    }
}
