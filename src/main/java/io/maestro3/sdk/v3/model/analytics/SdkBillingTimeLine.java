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

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SdkBillingTimeLine {
    private String id;
    private String zoneId;
    private String projectCode;
    private String zoneName;
    private String resource;
    private String linkedTo;
    private String type;

    private Date startDate;
    private String startEventId;
    private Date stopDate;
    private String stopEventId;

    private List<String> tags;

    private Map<String, BigDecimal> usage;

    private Map<String, Object> additionalInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getLinkedTo() {
        return linkedTo;
    }

    public void setLinkedTo(String linkedTo) {
        this.linkedTo = linkedTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartEventId() {
        return startEventId;
    }

    public void setStartEventId(String startEventId) {
        this.startEventId = startEventId;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public String getStopEventId() {
        return stopEventId;
    }

    public void setStopEventId(String stopEventId) {
        this.stopEventId = stopEventId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Map<String, BigDecimal> getUsage() {
        return usage;
    }

    public void setUsage(Map<String, BigDecimal> usage) {
        this.usage = usage;
    }

    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
