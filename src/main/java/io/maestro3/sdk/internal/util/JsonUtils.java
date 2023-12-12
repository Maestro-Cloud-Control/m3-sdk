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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import io.maestro3.sdk.exception.M3SdkException;

import java.io.IOException;
import java.util.Map;

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new JodaModule())
        .configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)
        .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        .configure(DeserializationFeature.WRAP_EXCEPTIONS, false)
        .configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private JsonUtils() {
    }

    public static String convertObjectToJson(Object object) {
        return convertObjectToJson(object, false);
    }

    public static String convertObjectToJson(Object object, boolean isPretty) {
        try {
            if (isPretty) {
                return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            } else {
                return objectMapper.writer().writeValueAsString(object);
            }
        } catch (JsonProcessingException e) {
            throw new M3SdkException("Error while serializing request, cause: " + e.getMessage());
        }
    }

    public static <T> T parseJson(String str, Class<T> clazz) {
        try {
            return objectMapper.readValue(str, clazz);
        } catch (IOException ex) {
            throw new M3SdkException("Exception in parsing JSON from String -> " + str
                    + " Error message from cause " + ex.getMessage(), ex);
        }
    }

    public static <T> T parseJson(String input, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(input, typeReference);
        } catch (IOException var3) {
            throw new M3SdkException("Exception in parsing JSON from String ->" + input
                    + "Error message from cause: " + var3.getMessage(), var3);
        }
    }

    public static <T> T parseMap(Map<String, ?> params, TypeReference<T> clazz) {
        try {
            return objectMapper.convertValue(params, clazz);
        } catch (M3SdkException e) {
            throw e;
        } catch (Exception e) {
            throw new M3SdkException("Cannot parse json from map", e);
        }
    }

    public static <T> T parseMap(Map<String, ?> params, Class<T> clazz) {
        try {
            return objectMapper.convertValue(params, clazz);
        } catch (Exception e) {
            throw new M3SdkException("Cannot parse json from map", e);
        }
    }

    public static <T> T parseObject(Object object, TypeReference<T> clazz) {
        String json = convertObjectToJson(object, false);
        return parseJson(json, clazz);
    }
}
