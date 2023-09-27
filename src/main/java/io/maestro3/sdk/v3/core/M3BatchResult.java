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

package io.maestro3.sdk.v3.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.internal.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class M3BatchResult {

    protected List<M3RawResult> results = new ArrayList<>();

    public M3BatchResult() {
    }

    public M3BatchResult(M3RawResult data) {
        this.addResponse(data);
    }

    public List<M3RawResult> getResults() {
        return results;
    }

    public void setResults(List<M3RawResult> results) {
        this.results = results;
    }

    public M3BatchResult addResponse(M3RawResult data) {
        Assert.notNull(data, "data");
        results.add(data);
        return this;
    }

    @JsonIgnore
    public M3RawResult getFirst() {
        return results.stream()
                .findFirst()
                .orElseThrow(() -> new M3SdkException("Result is unavailable"));
    }

    @JsonIgnore
    public M3RawResult getByRequestId(String id) {
        Assert.hasText(id, "id");
        return results.stream()
                .filter(responseData -> id.equals(responseData.getId()))
                .findFirst()
                .orElseThrow(() -> new M3SdkException("Result with specified id is not found: " + id));
    }

    @Override
    public String toString() {
        return "M3BatchResult{" +
                "results=" + results +
                '}';
    }
}
