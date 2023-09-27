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

package io.maestro3.sdk.v3.model.reseller;


import java.util.List;

public class SdkGoogleResellerCustomer {
    /**
     * Read-only
     */
    private String name;
    /**
     * Read-only
     */
    private long createTimestamp;
    /**
     * Read-only
     */
    private long updateTimestamp;
    private String orgDisplayName;
    private String domain;
    private PostalAddress orgPostalAddress;
    private PrimaryContactInfo primaryContactInfo;


    public SdkGoogleResellerCustomer() {
        // for JSON
    }

    public SdkGoogleResellerCustomer(String orgDisplayName, String domain, PostalAddress orgPostalAddress, PrimaryContactInfo primaryContactInfo) {
        this.orgDisplayName = orgDisplayName;
        this.domain = domain;
        this.orgPostalAddress = orgPostalAddress;
        this.primaryContactInfo = primaryContactInfo;
    }

    public SdkGoogleResellerCustomer withName(String name) {
        this.name = name;
        return this;
    }

    public SdkGoogleResellerCustomer withCreateTimestamp(long createTimestamp) {
        this.createTimestamp = createTimestamp;
        return this;
    }

    public SdkGoogleResellerCustomer withUpdateTimestamp(long updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
        return this;
    }

    public SdkGoogleResellerCustomer withOrgDisplayName(String orgDisplayName) {
        this.orgDisplayName = orgDisplayName;
        return this;
    }

    public SdkGoogleResellerCustomer withDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public SdkGoogleResellerCustomer withOrgPostalAddress(PostalAddress orgPostalAddress) {
        this.orgPostalAddress = orgPostalAddress;
        return this;
    }

    public SdkGoogleResellerCustomer withPrimaryContactInfo(PrimaryContactInfo primaryContactInfo) {
        this.primaryContactInfo = primaryContactInfo;
        return this;
    }

    public String getOrgDisplayName() {
        return orgDisplayName;
    }

    public void setOrgDisplayName(String orgDisplayName) {
        this.orgDisplayName = orgDisplayName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public PostalAddress getOrgPostalAddress() {
        return orgPostalAddress;
    }

    public void setOrgPostalAddress(PostalAddress orgPostalAddress) {
        this.orgPostalAddress = orgPostalAddress;
    }

    public PrimaryContactInfo getPrimaryContactInfo() {
        return primaryContactInfo;
    }

    public void setPrimaryContactInfo(PrimaryContactInfo primaryContactInfo) {
        this.primaryContactInfo = primaryContactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public long getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(long updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @Override
    public String toString() {
        return "SdkGoogleResellerCustomer{" +
            "name='" + name + '\'' +
            ", createTimestamp=" + createTimestamp +
            ", updateTimestamp=" + updateTimestamp +
            ", orgDisplayName='" + orgDisplayName + '\'' +
            ", domain='" + domain + '\'' +
            ", orgPostalAddress=" + orgPostalAddress +
            ", primaryContactInfo=" + primaryContactInfo +
            '}';
    }

    public static class PostalAddress {
        private List<String> addressLines;
        private String postalCode;
        private String regionCode;

        public PostalAddress() {
            // for JSON
        }

        public PostalAddress(List<String> addressLines, String postalCode, String regionCode) {
            this.addressLines = addressLines;
            this.postalCode = postalCode;
            this.regionCode = regionCode;
        }

        public PostalAddress withAddressLines(List<String> addressLines) {
            this.addressLines = addressLines;
            return this;
        }

        public PostalAddress withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public PostalAddress withRegionCode(String resionCode) {
            this.regionCode = resionCode;
            return this;
        }

        public List<String> getAddressLines() {
            return addressLines;
        }

        public void setAddressLines(List<String> addressLines) {
            this.addressLines = addressLines;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getRegionCode() {
            return regionCode;
        }

        public void setRegionCode(String regionCode) {
            this.regionCode = regionCode;
        }

        @Override
        public String toString() {
            return "PostalAddress{" +
                "addressLines=" + addressLines +
                ", postalCode='" + postalCode + '\'' +
                ", regionCode='" + regionCode + '\'' +
                '}';
        }
    }

    public static class PrimaryContactInfo {
        private String lastName;
        private String firstName;
        private String email;
        private String title;
        private String phone;

        public PrimaryContactInfo() {
            // for JSON
        }

        public PrimaryContactInfo(String lastName, String firstName, String email, String title, String phone) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.email = email;
            this.title = title;
            this.phone = phone;
        }

        public PrimaryContactInfo withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PrimaryContactInfo withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PrimaryContactInfo withEmail(String email) {
            this.email = email;
            return this;
        }

        public PrimaryContactInfo withTitle(String title) {
            this.title = title;
            return this;
        }

        public PrimaryContactInfo withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "PrimaryContactInfo{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                '}';
        }
    }
}
