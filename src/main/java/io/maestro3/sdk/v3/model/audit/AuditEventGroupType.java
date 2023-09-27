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

package io.maestro3.sdk.v3.model.audit;

import io.maestro3.sdk.internal.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public enum AuditEventGroupType {

    //m2 audit
    AWS_ACCOUNT_ACTIVITY("aws_account_activity"),
    AZURE_ENROLMENT_ACTIVITY("azure_enrolment_activity"),
    AZURE_SUBSCRIPTION_ACTIVITY("azure_subscription_activity"),
    AZURE_TENANT_ACTIVITY("azure_tenant_activity"),
    GOOGLE_ACCOUNT_ACTIVITY("google_account_activity"),
    BILLING_AUDIT("aud_exp"),
    BUSINESS_UNIT_ACTIVITY("business_unit_activity"),
    EO_ACCOUNT_ACTIVITY("eo_account_activity"),
    INSTANCE_PROPERTIES_DATA("instance_properties_data"),
    QUOTA_UPDATE("quota_update"),
    PROJECT_ACTIVITY("project_activity"),
    HARDWARE_MAINTENANCE("hardware_maintenance"),
    ZONE_ACTIVITY("zone_activity"),

    ADMIN_AUDIT("admin_audit"),
    INSTANCE_DATA("instance_data"),
    IMAGE_DATA("image_data"),
    NATIVE_AUDIT("native_audit"),
    PRIVATE_AGENT("private_agent"),
    VOLUME_DATA("volume_data"),
    ONBOARDING_DATA("onboarding_data"),
    CUSTODIAN_DATA("custodian_data");

    private String groupTypeName;

    AuditEventGroupType(String groupTypeName) {
        this.groupTypeName = groupTypeName;
    }

    public String getGroupTypeName() {
        return groupTypeName;
    }

    public static String getQualifier(AuditEventGroupType group, AuditEventGroupType... groups) {
        Assert.notNull(group, "Group can not be null");
        StringBuilder sb = new StringBuilder(group.getGroupTypeName());
        if (groups != null && groups.length > 0) {
            for (AuditEventGroupType iGroup : groups) {
                sb.append(";").append(iGroup.getGroupTypeName());
            }
        }
        return sb.toString();
    }

    public static String getQualifier(List<AuditEventGroupType> groups) {
        Assert.notEmpty(groups, "groups can not be empty");

        List<String> groupNames = groups.stream()
                .map(AuditEventGroupType::getGroupTypeName)
                .collect(Collectors.toList());

        return String.join(";", groupNames);
    }

    public static AuditEventGroupType fromGroupTypeName(String groupTypeName) {
        for (AuditEventGroupType groupType : AuditEventGroupType.values()) {
            if (groupType.getGroupTypeName().equalsIgnoreCase(groupTypeName)) {
                return groupType;
            }
        }
        return null;
    }
}
