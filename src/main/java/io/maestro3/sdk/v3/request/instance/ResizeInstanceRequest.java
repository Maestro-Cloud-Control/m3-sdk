package io.maestro3.sdk.v3.request.instance;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.maestro3.sdk.internal.util.Assert;
import io.maestro3.sdk.v3.core.ActionType;

@JsonDeserialize(builder = ResizeInstanceRequest.ResizeInstanceRequestBuilder.class)
public class ResizeInstanceRequest extends InstanceActionRequest {
    /**
     * New type of the instance. Example: t3.large
     */
    private final String newType;
    /**
     * Flag is used to indicate if we need to start instance after resize.
     */
    private final boolean startAfterResize;
    private ResizeInstanceRequest(ResizeInstanceRequestBuilder builder) {
        super(builder);
        this.newType = builder.newType;
        this.startAfterResize = builder.startAfterResize;
    }

    public static ResizeInstanceRequestBuilder builder() {
        return new ResizeInstanceRequestBuilder();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.RESIZE_INSTANCE;
    }

    public String getNewType() {
        return newType;
    }

    public boolean isStartAfterResize() {
        return startAfterResize;
    }

    public static final class ResizeInstanceRequestBuilder extends AbstractInstanceActionBuilder<ResizeInstanceRequestBuilder, ResizeInstanceRequest> {
        private String newType;
        private boolean startAfterResize;
        
        @Override
        protected ResizeInstanceRequestBuilder getThis() {
            return this;
        }

        /**
         * Set the new type of the instance. Example: t3.large
         */
        public ResizeInstanceRequestBuilder withNewType(String newType) {
            this.newType = newType;
            return this;
        }

        public ResizeInstanceRequestBuilder withStartAfterResize(boolean startAfterResize) {
            this.startAfterResize = startAfterResize;
            return this;
        }

        @Override
        public ResizeInstanceRequest build() {
            validateCommonParams();
            Assert.hasText(newType, "newType");
            return new ResizeInstanceRequest(this);
        }
    }
}
