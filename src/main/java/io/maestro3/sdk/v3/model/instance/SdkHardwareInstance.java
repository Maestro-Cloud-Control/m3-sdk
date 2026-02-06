/*
 * Copyright 2024 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.v3.model.instance;

import io.maestro3.sdk.v3.model.SdkCloud;

import java.math.BigDecimal;
import java.util.Date;

public class SdkHardwareInstance extends SdkInstance {
    private Date registrationDate;//date from which billing will start
    private String location;
    private String costCenter;
    private Integer unitsCount;
    private Integer serverUsage;
    private BigDecimal workingPower;
    private String serverOwner;

    public SdkHardwareInstance() {
        this.cloud = SdkCloud.HARDWARE;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public Integer getUnitsCount() {
        return unitsCount;
    }

    public void setUnitsCount(Integer unitsCount) {
        this.unitsCount = unitsCount;
    }

    public Integer getServerUsage() {
        return serverUsage;
    }

    public void setServerUsage(Integer serverUsage) {
        this.serverUsage = serverUsage;
    }

    public BigDecimal getWorkingPower() {
        return workingPower;
    }

    public void setWorkingPower(BigDecimal workingPower) {
        this.workingPower = workingPower;
    }

    public String getServerOwner() {
        return serverOwner;
    }

    public void setServerOwner(String serverOwner) {
        this.serverOwner = serverOwner;
    }
}
