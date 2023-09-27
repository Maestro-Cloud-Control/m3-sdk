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

import java.util.Objects;

public class StaticPrincipal implements IPrincipal {

    private static final String ID = "static";

    private static final IPrincipal STATIC_PRINCIPAL = new StaticPrincipal();

    private StaticPrincipal() {
    }

    public static IPrincipal getPrincipal() {
        return STATIC_PRINCIPAL;
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof StaticPrincipal)) return false;
        IPrincipal objP = (IPrincipal) obj;
        return Objects.equals(this.getId(), objP.getId());
    }
}
