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

public class SdkEpcBillingConfig {

    private Date resourceLastBilledTime;
    private Date tagLastBilledTime;
    private Date dailyProjectTagLastAggregationTime;
    private Date dailyProjectInZoneLastAggregationTime;
    private Date projectInZoneLastAggregationTime;
    private Date resourceTagLastAggregationTime;
    private Date resourceLastAggregationTime;
    private Date projectTagLastAggregationTime;
    private Date lastHardwareCreditsUpdatingDate;
    private Date lastProjectCreditsUpdatingTime;
    private Date yearlyRecordsAggregationYear;

    public Date getResourceLastBilledTime() {
        return resourceLastBilledTime;
    }

    public void setResourceLastBilledTime(Date resourceLastBilledTime) {
        this.resourceLastBilledTime = resourceLastBilledTime;
    }

    public Date getTagLastBilledTime() {
        return tagLastBilledTime;
    }

    public void setTagLastBilledTime(Date tagLastBilledTime) {
        this.tagLastBilledTime = tagLastBilledTime;
    }

    public Date getDailyProjectTagLastAggregationTime() {
        return dailyProjectTagLastAggregationTime;
    }

    public void setDailyProjectTagLastAggregationTime(Date dailyProjectTagLastAggregationTime) {
        this.dailyProjectTagLastAggregationTime = dailyProjectTagLastAggregationTime;
    }

    public Date getDailyProjectInZoneLastAggregationTime() {
        return dailyProjectInZoneLastAggregationTime;
    }

    public void setDailyProjectInZoneLastAggregationTime(Date dailyProjectInZoneLastAggregationTime) {
        this.dailyProjectInZoneLastAggregationTime = dailyProjectInZoneLastAggregationTime;
    }

    public Date getProjectInZoneLastAggregationTime() {
        return projectInZoneLastAggregationTime;
    }

    public void setProjectInZoneLastAggregationTime(Date projectInZoneLastAggregationTime) {
        this.projectInZoneLastAggregationTime = projectInZoneLastAggregationTime;
    }

    public Date getResourceTagLastAggregationTime() {
        return resourceTagLastAggregationTime;
    }

    public void setResourceTagLastAggregationTime(Date resourceTagLastAggregationTime) {
        this.resourceTagLastAggregationTime = resourceTagLastAggregationTime;
    }

    public Date getResourceLastAggregationTime() {
        return resourceLastAggregationTime;
    }

    public void setResourceLastAggregationTime(Date resourceLastAggregationTime) {
        this.resourceLastAggregationTime = resourceLastAggregationTime;
    }

    public Date getProjectTagLastAggregationTime() {
        return projectTagLastAggregationTime;
    }

    public void setProjectTagLastAggregationTime(Date projectTagLastAggregationTime) {
        this.projectTagLastAggregationTime = projectTagLastAggregationTime;
    }

    public Date getLastHardwareCreditsUpdatingDate() {
        return lastHardwareCreditsUpdatingDate;
    }

    public void setLastHardwareCreditsUpdatingDate(Date lastHardwareCreditsUpdatingDate) {
        this.lastHardwareCreditsUpdatingDate = lastHardwareCreditsUpdatingDate;
    }

    public Date getLastProjectCreditsUpdatingTime() {
        return lastProjectCreditsUpdatingTime;
    }

    public void setLastProjectCreditsUpdatingTime(Date lastProjectCreditsUpdatingTime) {
        this.lastProjectCreditsUpdatingTime = lastProjectCreditsUpdatingTime;
    }

    public Date getYearlyRecordsAggregationYear() {
        return yearlyRecordsAggregationYear;
    }

    public void setYearlyRecordsAggregationYear(Date yearlyRecordsAggregationYear) {
        this.yearlyRecordsAggregationYear = yearlyRecordsAggregationYear;
    }
}