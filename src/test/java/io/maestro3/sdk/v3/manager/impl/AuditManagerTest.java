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

package io.maestro3.sdk.v3.manager.impl;

import io.maestro3.cadf.model.CadfActions;
import io.maestro3.cadf.model.CadfAuditEvent;
import io.maestro3.cadf.model.CadfEventType;
import io.maestro3.cadf.model.CadfOutcomes;
import io.maestro3.cadf.model.CadfResource;
import io.maestro3.cadf.model.CadfResourceTypes;
import io.maestro3.sdk.M3SdkVersion;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.core.ResultStatus;
import io.maestro3.sdk.v3.core.StaticPrincipal;
import io.maestro3.sdk.v3.request.audit.SaveCadfEventRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class AuditManagerTest {

    private IM3ApiActionExecutor actionExecutor = Mockito.mock(IM3ApiActionExecutor.class);

    private AuditManager auditManager;

    @Before
    public void init() {
        auditManager = new AuditManager(actionExecutor, false);
    }

    @Test
    public void test_shouldThrowExceptionIfResultIsNull() {
        IPrincipal principal = StaticPrincipal.getPrincipal();

        SaveCadfEventRequest saveCadfEventRequest = SaveCadfEventRequest.builder()
                .withQualifier("qualifier")
                .withEvent(CadfAuditEvent.builder()
                        .withId("id")
                        .withEventTime("time")
                        .withEventType(CadfEventType.ACTIVITY)
                        .withAction(CadfActions.create())
                        .withOutcome(CadfOutcomes.success())
                        .withInitiator(CadfResource.builder()
                                .withId("id")
                                .ofType(CadfResourceTypes.data())
                                .build())
                        .withTarget(CadfResource.builder()
                                .withId("id")
                                .ofType(CadfResourceTypes.data())
                                .build())
                        .withObserver(CadfResource.builder()
                                .withId("id")
                                .ofType(CadfResourceTypes.data())
                                .build())
                        .build())
                .build();

        M3Result<Void> rawResult = M3Result.success("id", null);
        when(actionExecutor.executeAction(eq(principal), eq(M3SdkVersion.V3), any())).thenReturn(rawResult);
        M3Result<Void> result = auditManager.saveCadfEvent(principal, saveCadfEventRequest);
        Assert.assertSame(ResultStatus.SUCCESS, result.getStatus());
    }

}
