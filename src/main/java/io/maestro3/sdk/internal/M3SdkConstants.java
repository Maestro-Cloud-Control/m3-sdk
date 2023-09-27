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

package io.maestro3.sdk.internal;

public final class M3SdkConstants {

    public static final String ACCESS_KEY_HEADER = "maestro-accesskey";
    public static final String AUTHENTICATION_HEADER = "maestro-authentication";
    public static final String DATE_HEADER = "maestro-date";
    public static final String SDK_VERSION_HEADER = "maestro-sdk-version";
    public static final String IS_ASYNC = "maestro-sdk-async";
    public static final String USER_IDENTIFIER_HEADER = "maestro-user-identifier";
    public static final String ENCRYPTION_HEADER = "maestro-encryption-algorithm";
    public static final String COMPRESSED_HEADER = "compressed";

    private M3SdkConstants() {
    }
}
