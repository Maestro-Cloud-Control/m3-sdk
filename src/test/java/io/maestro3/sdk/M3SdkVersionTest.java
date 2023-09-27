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

package io.maestro3.sdk;

import org.junit.Assert;
import org.junit.Test;

public class M3SdkVersionTest {

    @Test
    public void shouldReturnInstanceFromValue() {
        String v3 = "v3";
        Assert.assertNotNull(M3SdkVersion.fromValue(v3));
    }

    @Test
    public void shouldReturnInstanceFromVersion() {
        int major3 = 3;
        int minor3 = 2;
        int micro3 = 80;

        String version1 = String.format("%s.%s.%s", major3, minor3, micro3);
        Assert.assertNotNull(M3SdkVersion.fromVersion(version1));
    }
}
