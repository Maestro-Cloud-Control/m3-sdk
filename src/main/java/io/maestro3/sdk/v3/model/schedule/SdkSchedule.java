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

package io.maestro3.sdk.v3.model.schedule;

import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.instance.SdkResourceTag;

import java.util.List;
import java.util.Map;

public class SdkSchedule {

    private String tenantName;
    private String scheduleName;
    private String displayName;
    private String cron;
    private String secondCrone;
    private String description;
    private String action;
    private String scheduleType;
    private String region;
    private String scheduleOwner;
    private Long lastRun;
    private Long nextRun;
    private SdkResourceTag tag;
    private SdkCloud cloud;
    private String executeProperty;
    private String whenToExecute;
    private List<Map> instances;
    private String serviceEntryId;
    private boolean periodical;

    public String getServiceEntryId() {
        return serviceEntryId;
    }

    public SdkSchedule setServiceEntryId(String serviceEntryId) {
        this.serviceEntryId = serviceEntryId;
        return this;
    }

    public String getTenantName() {
        return tenantName;
    }

    public SdkSchedule setTenantName(String tenantName) {
        this.tenantName = tenantName;
        return this;
    }

    public boolean isPeriodical() {
        return periodical;
    }

    public SdkSchedule setPeriodical(boolean periodical) {
        this.periodical = periodical;
        return this;
    }

    public String getSecondCrone() {
        return secondCrone;
    }

    public SdkSchedule setSecondCrone(String secondCrone) {
        this.secondCrone = secondCrone;
        return this;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public SdkSchedule setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public SdkSchedule setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getCron() {
        return cron;
    }

    public SdkSchedule setCron(String cron) {
        this.cron = cron;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SdkSchedule setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getAction() {
        return action;
    }

    public SdkSchedule setAction(String action) {
        this.action = action;
        return this;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public SdkSchedule setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public SdkSchedule setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getScheduleOwner() {
        return scheduleOwner;
    }

    public SdkSchedule setScheduleOwner(String scheduleOwner) {
        this.scheduleOwner = scheduleOwner;
        return this;
    }

    public Long getLastRun() {
        return lastRun;
    }

    public SdkSchedule setLastRun(Long lastRun) {
        this.lastRun = lastRun;
        return this;
    }

    public Long getNextRun() {
        return nextRun;
    }

    public SdkSchedule setNextRun(Long nextRun) {
        this.nextRun = nextRun;
        return this;
    }

    public SdkResourceTag getTag() {
        return tag;
    }

    public SdkSchedule setTag(SdkResourceTag tag) {
        this.tag = tag;
        return this;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public SdkSchedule setCloud(SdkCloud cloud) {
        this.cloud = cloud;
        return this;
    }

    public String getExecuteProperty() {
        return executeProperty;
    }

    public SdkSchedule setExecuteProperty(String executeProperty) {
        this.executeProperty = executeProperty;
        return this;
    }

    public String getWhenToExecute() {
        return whenToExecute;
    }

    public SdkSchedule setWhenToExecute(String whenToExecute) {
        this.whenToExecute = whenToExecute;
        return this;
    }

    public List<Map> getInstances() {
        return instances;
    }

    public SdkSchedule setInstances(List<Map> instances) {
        this.instances = instances;
        return this;
    }
}
