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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class StringUtils {

    public static final String EMPTY_STRING = "";

    private StringUtils() {
        throw new UnsupportedOperationException("Instantiation is forbidden.");
    }

    public static boolean isBlank(final String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotBlank(final String str) {
        return !isBlank(str);
    }

    public static boolean isNotBlank(final String... args) {
        return !isBlank(args);
    }

    public static boolean isBlank(final String... args) {
        if (args.length == 0) {
            return true;
        }
        for (String arg : args) {
            if (isNotBlank(arg)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> toLowerCaseList(Collection<String> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return new LinkedList<>();
        }

        List<String> resultList = new LinkedList<>();
        for (String item : collection) {
            if (item != null) {
                resultList.add(item.toLowerCase());
            }
        }
        return resultList;
    }

    public static boolean isEquals(String oneValue, String anotherValue) {
        return oneValue != null && oneValue.equals(anotherValue);
    }

    public static boolean isNotEquals(String oneValue, String anotherValue) {
        return !isEquals(oneValue, anotherValue);
    }

    public static boolean isEqualsIgnoreCase(String oneValue, String anotherValue) {
        String v1 = oneValue == null ? null : oneValue.toLowerCase(Locale.US);
        String v2 = anotherValue == null ? null : anotherValue.toLowerCase(Locale.US);
        return isEquals(v1, v2);
    }

}
