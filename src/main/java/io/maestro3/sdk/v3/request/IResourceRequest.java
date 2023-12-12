package io.maestro3.sdk.v3.request;

import io.maestro3.sdk.v3.request.ownership.ResourceIdRequest;

public interface IResourceRequest extends IRequest {

    ResourceIdRequest getResourceIdRequest();
}
