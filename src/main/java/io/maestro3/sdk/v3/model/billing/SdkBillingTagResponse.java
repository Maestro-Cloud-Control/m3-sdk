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

package io.maestro3.sdk.v3.model.billing;

import io.maestro3.sdk.v3.model.instance.SdkResourceTag;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SdkBillingTagResponse {

    private List<SdkResourceTag> tags;
    private Map<String, List<SdkResourceTag>> tagsByTenantNames;

    public SdkBillingTagResponse() {
        //json
    }

    public SdkBillingTagResponse(List<SdkResourceTag> tags) {
        this.tags = tags;
    }

    public SdkBillingTagResponse(Map<String, List<SdkResourceTag>> tagsByTenantNames) {
        this.tagsByTenantNames = tagsByTenantNames;
    }

    public List<SdkResourceTag> getTags() {
        return tags;
    }

    public void setTags(List<SdkResourceTag> tags) {
        this.tags = tags;
    }

    public Map<String, List<SdkResourceTag>> getTagsByTenantNames() {
        return tagsByTenantNames;
    }

    public void setTagsByTenantNames(Map<String, List<SdkResourceTag>> tagsByTenantNames) {
        this.tagsByTenantNames = tagsByTenantNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SdkBillingTagResponse)) return false;
        SdkBillingTagResponse response = (SdkBillingTagResponse) o;
        return Objects.equals(tags, response.tags) && Objects.equals(tagsByTenantNames, response.tagsByTenantNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, tagsByTenantNames);
    }

    @Override
    public String toString() {
        return "BillingTagResponse{" +
            "sdkTags=" + tags +
            ", sdkTagsByTenantNames=" + tagsByTenantNames +
            '}';
    }
}
