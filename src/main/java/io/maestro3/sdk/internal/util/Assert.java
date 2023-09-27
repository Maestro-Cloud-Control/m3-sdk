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

import io.maestro3.sdk.exception.M3SdkException;
import io.maestro3.sdk.v3.request.IRequest;

import java.util.Collection;
import java.util.Optional;

public final class Assert {

    private static final int MAX_REQUESTS_PER_BATCH = 20;

    private Assert() {
    }

    public static void notNull(Object value, String fieldName) {
        if (value == null) {
            throw new M3SdkException(fieldName + " must not be null");
        }
    }

    public static void isNull(Object value, String fieldName) {
        if (value != null) {
            throw new M3SdkException(fieldName + " must not be specified");
        }
    }

    public static void isTrue(Boolean value, String fieldName) {
        if (!Optional.ofNullable(value).orElse(false)) {
            throw new M3SdkException(fieldName + " must be true");
        }
    }

    public static void isPositive(long value, String fieldName) {
        if (value <= 0) {
            throw new M3SdkException(fieldName + " must be positive, actual: '" + value + "'");
        }
    }

    public static void isPositive(Number value, String fieldName) {
        if (value == null || value.doubleValue() <= 0) {
            throw new M3SdkException(fieldName + " must be positive, actual: '" + value + "'");
        }
    }

    public static void inRange(long value, long from, long to, String fieldName) {
        if (value < from || value > to) {
            throw new M3SdkException(fieldName + " must be in range [" + from + ", " + to + "] , actual: '" + value + "'");
        }
    }

    public static void hasText(String value, String fieldName) {
        if (value == null || value.isEmpty() || value.trim().isEmpty()) {
            throw new M3SdkException(fieldName + " must not be null or empty, actual: '" + value + "'");
        }
    }

    public static void notEmpty(Collection<?> value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new M3SdkException(fieldName + " must not be null or empty");
        }
    }

    public static void batchSizeLimitNotExceeded(Collection<? extends IRequest> requests) {
        if (CollectionUtils.isNotEmpty(requests) && requests.size() > MAX_REQUESTS_PER_BATCH) {
            throw new M3SdkException(String.format("Batch size limit is exceeded. Maximum number of requests per batch is %d", MAX_REQUESTS_PER_BATCH));
        }
    }
}
