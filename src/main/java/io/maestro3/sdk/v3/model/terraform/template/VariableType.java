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

package io.maestro3.sdk.v3.model.terraform.template;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.maestro3.sdk.internal.util.CollectionUtils;
import io.maestro3.sdk.internal.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PAY ATTENTION: order of enums is important, map should be before list!
 */
public enum VariableType {
    BOOL(CollectionUtils.newSet("bool", "${bool}")) {
        @Override
        public boolean isCurrentType(Object defaultValues) {
            return defaultValues instanceof Boolean;
        }

        @Override
        public String validateVariable(Object value) {
            if (!isCurrentType(value)) {
                return "Value is not a boolean";
            }
            return StringUtils.EMPTY_STRING;
        }
    },

    STRING(CollectionUtils.newSet("string", "${string}", "number", "${number}")) {
        @Override
        public boolean isCurrentType(Object defaultValues) {
            return !(defaultValues instanceof Map || defaultValues instanceof List);
        }

        @Override
        public Object cast(Object defaultValues) {
            return String.valueOf(defaultValues);
        }

        @Override
        public String validateVariable(Object value) {
            if (!isCurrentType(value)) {
                return "Value is not a string";
            }
            if (value == null || String.valueOf(value).isEmpty()) {
                return "Value is empty";
            }
            return StringUtils.EMPTY_STRING;
        }
    },
    MAP(CollectionUtils.newSet("map", "${map", "${object")) {
        @Override
        public boolean isCurrentType(Object defaultValues) {
            return defaultValues instanceof Map;
        }

        @Override
        public String validateVariable(Object value) {
            if (!isCurrentType(value)) {
                return "Value is not a map";
            }
            if (CollectionUtils.isEmpty((Map) value)) {
                return "Value is empty map";
            }
            return StringUtils.EMPTY_STRING;
        }
    },
    LIST(CollectionUtils.newSet("list", "${list}", "${list(string)}", "${list(number)}", "${list(bool)}", "${set}", "${set(string)}", "${set(number)}", "${set(bool)}")) {
        @Override
        public boolean isCurrentType(Object defaultValues) {
            return defaultValues instanceof List;
        }

        @Override
        public String validateVariable(Object value) {
            if (!isCurrentType(value)) {
                return "Value is not a list";
            }
            if (CollectionUtils.isEmpty((List) value)) {
                return "Value is empty list";
            }
            return StringUtils.EMPTY_STRING;
        }
    },

    // must be the last option in ENUM
    COMPLEX(Collections.emptySet()) {
        @Override
        public boolean isCurrentType(Object defaultValues) {
            return true;
        }

        @Override
        public String validateVariable(Object value) {
            if (value == null) {
                return "Empty variable value";
            }
            return StringUtils.EMPTY_STRING;
        }
    };


    private static final VariableType[] VALUES = values();
    private Set<String> prefixes;


    VariableType(Set<String> prefixes) {
        this.prefixes = prefixes;
    }

    @JsonCreator
    public static VariableType fromValue(String name) {
        if (StringUtils.isBlank(name)) {
            return STRING;
        }
        for (VariableType variableType : values()) {
            for (String prefix : variableType.prefixes) {
                if (StringUtils.isEqualsIgnoreCase(prefix, name)) {
                    return variableType;
                }
            }
        }
        return COMPLEX;
    }

    public abstract boolean isCurrentType(Object defaultValues);

    public abstract String validateVariable(Object value);

    public Object cast(Object defaultValues) {
        return defaultValues;
    }
}

