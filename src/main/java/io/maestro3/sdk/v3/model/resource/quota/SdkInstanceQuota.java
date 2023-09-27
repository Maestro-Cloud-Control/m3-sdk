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

package io.maestro3.sdk.v3.model.resource.quota;

public class SdkInstanceQuota implements IInstanceQuota {

    private int creationIntervalHours = DefaultValues.CREATION_INTERVAL_HOURS;
    private int creationIntervalCount = DefaultValues.CREATION_INTERVAL_COUNT;

    public SdkInstanceQuota() {
        //json
    }

    public SdkInstanceQuota(IInstanceQuota clone) {
        this.creationIntervalHours = clone.getCreationIntervalHours();
        this.creationIntervalCount = clone.getCreationIntervalCount();
    }

    @Override
    public int getCreationIntervalHours() {
        return creationIntervalHours;
    }

    public void setCreationIntervalHours(int creationIntervalHours) {
        this.creationIntervalHours = creationIntervalHours;
    }

    @Override
    public int getCreationIntervalCount() {
        return creationIntervalCount;
    }

    @Override
    public void setCreationIntervalCount(int creationIntervalCount) {
        this.creationIntervalCount = creationIntervalCount;
    }

    public static SdkInstanceQuota defaultInstanceQuota() {
        SdkInstanceQuota instanceQuota = new SdkInstanceQuota();
        instanceQuota.setCreationIntervalCount(DefaultValues.CREATION_INTERVAL_COUNT);
        instanceQuota.setCreationIntervalHours(DefaultValues.CREATION_INTERVAL_HOURS);
        return instanceQuota;
    }
}
