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

public class SdkBillingAuditEvent {

    private String id;
    private String group;
    private String subGroup;
    private String type;

    private String internalIdentifier;
    private String identifier;
    private String operationalIdentifier;

    private String message;
    private Date date;
    private String status;

    private String projectName;
    private String projectCode;
    private String zoneId;
    private String zoneName;

    private Boolean forTimeLine;

    //ResourceInformation
    private String state;
    private String operationalSearchId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInternalIdentifier() {
        return internalIdentifier;
    }

    public void setInternalIdentifier(String internalIdentifier) {
        this.internalIdentifier = internalIdentifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getOperationalIdentifier() {
        return operationalIdentifier;
    }

    public void setOperationalIdentifier(String operationalIdentifier) {
        this.operationalIdentifier = operationalIdentifier;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Boolean getForTimeLine() {
        return forTimeLine;
    }

    public void setForTimeLine(Boolean forTimeLine) {
        this.forTimeLine = forTimeLine;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOperationalSearchId() {
        return operationalSearchId;
    }

    public void setOperationalSearchId(String operationalSearchId) {
        this.operationalSearchId = operationalSearchId;
    }
}
