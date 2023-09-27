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

package io.maestro3.sdk.v3.model.quota;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SdkPriceQuotaTest {

    @Test
    public void getUsage() {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
        String date1 = "04/02/2011 20:27:05";
        String date2 = "04/03/2011 20:27:05";
        String date3 = "04/04/2011 20:27:05";
        String date4 = "04/05/2011 20:27:05";
        String target = "04/06/2011 20:27:05";
        SdkPriceQuota quota = new SdkPriceQuota();
        IPriceQuotaMonthUsage monthUsage1 = new SdkPriceQuotaMonthUsage(formatter.parseDateTime(date1));
        monthUsage1.setValue(new BigDecimal(10));
        IPriceQuotaMonthUsage monthUsage2 = new SdkPriceQuotaMonthUsage(formatter.parseDateTime(date2));
        monthUsage2.setValue(new BigDecimal(11));
        IPriceQuotaMonthUsage monthUsage3 = new SdkPriceQuotaMonthUsage(formatter.parseDateTime(date3));
        monthUsage3.setValue(new BigDecimal(12));
        IPriceQuotaMonthUsage monthUsage4 = new SdkPriceQuotaMonthUsage(formatter.parseDateTime(date4));
        monthUsage4.setValue(new BigDecimal(13));
        quota.setMonthUsages(new ArrayList<>(Arrays.asList(monthUsage1, monthUsage2, monthUsage3, monthUsage4)));

        IPriceQuotaMonthUsage usage = quota.getUsage(formatter.parseDateTime(target));

        assertEquals(new BigDecimal(13), usage.getValue());
    }
}