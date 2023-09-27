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

package io.maestro3.sdk.v3.model.analytics;

import java.util.Date;

public class SdkAzureBillingConfig {

    private Date lastBillingUpdate;
    private Date nextBillingUpdate;
    private Date mostRecentRecordDate;

    public Date getLastBillingUpdate() {
        return lastBillingUpdate;
    }

    public void setLastBillingUpdate(Date lastBillingUpdate) {
        this.lastBillingUpdate = lastBillingUpdate;
    }

    public Date getNextBillingUpdate() {
        return nextBillingUpdate;
    }

    public void setNextBillingUpdate(Date nextBillingUpdate) {
        this.nextBillingUpdate = nextBillingUpdate;
    }

    public Date getMostRecentRecordDate() {
        return mostRecentRecordDate;
    }

    public void setMostRecentRecordDate(Date mostRecentRecordDate) {
        this.mostRecentRecordDate = mostRecentRecordDate;
    }
}