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

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtils {

    public static final String CADF_FORMAT_TIME = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static final String FORMAT_TIME = "yyyy-MM-dd'T'HH:mm:ss";

    private static final String UTC = "UTC";

    public static String formatDate(Date date, String pattern) {
        return getSimpleFormatter(pattern).format(date);
    }

    public static Date parseDate(String date, String pattern) {
        try {
            return getSimpleFormatter(pattern).parse(date);
        } catch (ParseException ignore) {
            return null;
        }
    }

    private static SimpleDateFormat getSimpleFormatter(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(TimeZone.getTimeZone(UTC));
        return formatter;
    }

    public static LocalDate toLocalDate(long millis) {
        Assert.isPositive(millis, "millis");
        return Instant.ofEpochMilli(millis).atOffset(ZoneOffset.UTC).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(long millis) {
        Assert.isPositive(millis, "millis");
        return Instant.ofEpochMilli(millis).atOffset(ZoneOffset.UTC).toLocalDateTime();
    }

    public static DateTime getCurrentMonth() {
        return new DateTime(DateTimeZone.UTC).dayOfMonth().withMinimumValue().withTimeAtStartOfDay();
    }

    public static DateTime truncateToDay(DateTime dateTime) {
        return dateTime.withMillisOfDay(0);
    }

    private DateUtils() {
    }
}
