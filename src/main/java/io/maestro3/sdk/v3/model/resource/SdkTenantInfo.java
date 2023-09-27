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

package io.maestro3.sdk.v3.model.resource;

import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.resource.quota.SdkInstanceQuota;
import io.maestro3.sdk.v3.model.resource.quota.SdkVolumeQuota;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class SdkTenantInfo {

    private SdkCloud cloud;
    private String tenantName;
    private String region;
    private String regionNativeName;
    private boolean active;
    private Date activationDate;
    private Date deactivationDate;
    private Set<String> shapes;
    private List<String> primaryContacts;
    private List<String> secondaryContacts;
    private List<String> tenantManagerContacts;
    private String defaultResourceOwnerContact;
    private SdkInstanceQuota instanceQuota;
    private SdkVolumeQuota volumeQuota;
    private String tenantState;
    private boolean hidden;
    private String tenantGroup;

    public SdkCloud getCloud() {
        return cloud;
    }

    public void setCloud(SdkCloud cloud) {
        this.cloud = cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegionNativeName() {
        return regionNativeName;
    }

    public void setRegionNativeName(String regionNativeName) {
        this.regionNativeName = regionNativeName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getDeactivationDate() {
        return deactivationDate;
    }

    public void setDeactivationDate(Date deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public Set<String> getShapes() {
        return shapes;
    }

    public void setShapes(Set<String> shapes) {
        this.shapes = shapes;
    }

    public List<String> getPrimaryContacts() {
        return primaryContacts;
    }

    public void setPrimaryContacts(List<String> primaryContacts) {
        this.primaryContacts = primaryContacts;
    }

    public List<String> getSecondaryContacts() {
        return secondaryContacts;
    }

    public void setSecondaryContacts(List<String> secondaryContacts) {
        this.secondaryContacts = secondaryContacts;
    }

    public List<String> getTenantManagerContacts() {
        return tenantManagerContacts;
    }

    public void setTenantManagerContacts(List<String> tenantManagerContacts) {
        this.tenantManagerContacts = tenantManagerContacts;
    }

    public String getDefaultResourceOwnerContact() {
        return defaultResourceOwnerContact;
    }

    public void setDefaultResourceOwnerContact(String defaultResourceOwnerContact) {
        this.defaultResourceOwnerContact = defaultResourceOwnerContact;
    }

    public SdkInstanceQuota getInstanceQuota() {
        return instanceQuota;
    }

    public void setInstanceQuota(SdkInstanceQuota instanceQuota) {
        this.instanceQuota = instanceQuota;
    }

    public SdkVolumeQuota getVolumeQuota() {
        return volumeQuota;
    }

    public void setVolumeQuota(SdkVolumeQuota volumeQuota) {
        this.volumeQuota = volumeQuota;
    }

    public String getTenantState() {
        return tenantState;
    }

    public void setTenantState(String tenantState) {
        this.tenantState = tenantState;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setTenantGroup(String tenantGroup) {
        this.tenantGroup = tenantGroup;
    }

    public String getTenantGroup() {
        return tenantGroup;
    }
}
