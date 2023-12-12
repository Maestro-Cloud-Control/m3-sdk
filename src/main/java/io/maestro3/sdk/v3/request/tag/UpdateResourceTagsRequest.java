package io.maestro3.sdk.v3.request.tag;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.IResourceRequest;
import io.maestro3.sdk.v3.request.ownership.ResourceIdRequest;

import java.util.Map;
import java.util.Set;

@JsonDeserialize(builder = UpdateResourceTagsRequest.Builder.class)
public class UpdateResourceTagsRequest implements IResourceRequest {

    public static final Set<SdkCloud> SUPPORTED_CLOUDS = Set.of(SdkCloud.AWS, SdkCloud.AZURE);

    private final ResourceIdRequest resourceIdRequest;
    private final Map<String, String> tags;
    private final boolean overwrite;

    private UpdateResourceTagsRequest(Builder builder) {
        this.resourceIdRequest = builder.resourceIdRequest;
        this.tags = builder.tags;
        this.overwrite = builder.overwrite;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public ResourceIdRequest getResourceIdRequest() {
        return resourceIdRequest;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.UPDATE_RESOURCE_TAGS;
    }

    public static final class Builder {
        private ResourceIdRequest resourceIdRequest;
        private Map<String, String> tags;
        private boolean overwrite;

        public Builder withResourceIdRequest(ResourceIdRequest resourceIdRequest) {
            this.resourceIdRequest = resourceIdRequest;
            return this;
        }

        public Builder withTags(Map<String, String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder withOverwrite(boolean overwrite) {
            this.overwrite = overwrite;
            return this;
        }

        public UpdateResourceTagsRequest build() {
            if (!SUPPORTED_CLOUDS.contains(resourceIdRequest.getCloud())) {
                throw new M3SdkException(String.format("Request supports only %s providers.", SUPPORTED_CLOUDS));
            }
            Assert.notNull(resourceIdRequest, "resourceIdRequest");
            Assert.notNull(tags, "tags");
            return new UpdateResourceTagsRequest(this);
        }
    }
}
