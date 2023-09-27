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

package io.maestro3.sdk.v3.model.audit;

import io.maestro3.sdk.exception.M3SdkException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AuditEventGroupTypeTest {

    private static final String EXPECTED_QUALIFIER = "aud_exp;native_audit";

    @Test(expected = M3SdkException.class)
    public void getQualifier_fromNull_exception() {
        AuditEventGroupType groupType = null;
        AuditEventGroupType.getQualifier(groupType);
    }

    @Test
    public void getQualifier_fromString() {
        String expected = AuditEventGroupType.BILLING_AUDIT.getGroupTypeName();
        String actual = AuditEventGroupType.getQualifier(AuditEventGroupType.BILLING_AUDIT);
        assertEquals(expected, actual);
    }

    @Test
    public void getQualifier_fromStringAndVarargs() {
        String actual = AuditEventGroupType.getQualifier(AuditEventGroupType.BILLING_AUDIT, AuditEventGroupType.NATIVE_AUDIT);
        assertEquals(EXPECTED_QUALIFIER, actual);
    }

    @Test(expected = M3SdkException.class)
    public void getQualifier_fromEmptyList_exception() {
        AuditEventGroupType.getQualifier(new ArrayList<>());
    }

    @Test
    public void getQualifier_fromList() {
        String actual = AuditEventGroupType.getQualifier(Arrays.asList(AuditEventGroupType.BILLING_AUDIT, AuditEventGroupType.NATIVE_AUDIT));
        assertEquals(EXPECTED_QUALIFIER, actual);
    }
}
