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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionUtils {

    private CollectionUtils() {
        throw new UnsupportedOperationException("Instantiation is forbidden.");
    }

    public static <T> List<T> newList(T... items) {
        return Arrays.asList(items);
    }
    public static <T> Set<T> newSet(T... items) {
        return new HashSet<>(Arrays.asList(items));
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static <T, R, C extends Collection<T>> List<R> map(C coll, Function<T, R> mapping) {
        if (isEmpty(coll) || mapping == null) {
            return new ArrayList<>();
        }
        return coll.stream()
            .map(mapping)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    public static <T> List<T> singletonOrEmptyList(T element) {
        if (element == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(element);
    }
}
