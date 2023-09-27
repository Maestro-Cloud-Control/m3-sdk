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

import io.maestro3.sdk.internal.Pair;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class MapUtils {

    private MapUtils() {
        throw new UnsupportedOperationException("Instantiation is forbidden.");
    }

    public static <KEY, VALUE> MapBuilder<KEY, VALUE> builder() {
        return new MapBuilder<>();
    }

    public static class MapBuilder<KEY, VALUE> {
        private final Map<KEY, VALUE> map;

        private MapBuilder(Map<KEY, VALUE> map) {
            this.map = new LinkedHashMap<>(map);
        }

        private MapBuilder() {
            map = new HashMap<>();
        }

        public MapBuilder<KEY, VALUE> withPair(KEY key, VALUE value) {
            this.map.put(key, value);
            return this;
        }

        public MapBuilder<KEY, VALUE> withListOfPairs(List<Pair<KEY, VALUE>> pairs) {
            if (pairs == null || pairs.isEmpty()) {
                return this;
            }
            pairs.forEach(pair -> this.map.put(pair.getKey(), pair.getValue()));
            return this;
        }


        public Map<KEY, VALUE> build() {
            return map;
        }
    }
}
