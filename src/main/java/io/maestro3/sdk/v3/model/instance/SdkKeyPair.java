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

package io.maestro3.sdk.v3.model.instance;

import io.maestro3.sdk.v3.model.SdkCloud;

public class SdkKeyPair {

    private SdkCloud cloud;
    private String tenant;
    private String region;
    private String name;
    private String status;
    private String publicPart;
    private String privatePart;
    private String email;
    private String fingerprint;
    private String maestroStatus;

    public SdkKeyPair() {
        //json
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public SdkKeyPair setCloud(SdkCloud cloud) {
        this.cloud = cloud;
        return this;
    }

    public String getTenant() {
        return tenant;
    }

    public SdkKeyPair setTenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public SdkKeyPair setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getName() {
        return name;
    }

    public SdkKeyPair setName(String name) {
        this.name = name;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public SdkKeyPair setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getPrivatePart() {
        return privatePart;
    }

    public SdkKeyPair setPrivatePart(String privatePart) {
        this.privatePart = privatePart;
        return this;
    }

    public String getPublicPart() {
        return publicPart;
    }

    public SdkKeyPair setPublicPart(String publicPart) {
        this.publicPart = publicPart;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SdkKeyPair setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public SdkKeyPair setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }

    public String getMaestroStatus() {
        return maestroStatus;
    }

    public SdkKeyPair setMaestroStatus(String maestroStatus) {
        this.maestroStatus = maestroStatus;
        return this;
    }
}
