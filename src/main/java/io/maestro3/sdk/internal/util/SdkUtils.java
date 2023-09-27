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

package io.maestro3.sdk.internal.util;

import io.maestro3.sdk.v3.core.ActionType;
import io.maestro3.sdk.v3.core.M3ApiAction;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class SdkUtils {

    private SdkUtils() {
        throw new UnsupportedOperationException("Instantiation is forbidden.");
    }

    public static boolean allNotNull(Object... values) {
        if (values == null) {
            return false;
        }

        for (Object val : values) {
            if (val == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean atLeastOneNotNull(Object... values) {
        if (values == null) {
            return false;
        }

        for (Object object : values) {
            if (object != null) {
                return true;
            }
        }
        return false;
    }

    public static M3ApiAction[] convert(Collection<? extends IRequest> requestData) {
        List<M3ApiAction> apiActions = new ArrayList<>();
        for (IRequest request : requestData) {
            M3ApiAction apiAction = convert(request);
            apiActions.add(apiAction);
        }
        return apiActions.toArray(new M3ApiAction[]{});
    }

    public static <R extends IRequest> M3ApiAction convert(R requestData) {
        String requestJson  = JsonUtils.convertObjectToJson(requestData);
        ActionType actionType = requestData.getActionType();
        return new M3ApiAction(actionType, Collections.singletonMap("body", requestJson), requestData.getCustomTimeoutMillis());
    }
}
