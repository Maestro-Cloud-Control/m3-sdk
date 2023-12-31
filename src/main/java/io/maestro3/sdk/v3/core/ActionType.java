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

package io.maestro3.sdk.v3.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Full list of actions, available via maestro sdk
 */
public enum ActionType {

    //INSTANCES
    RUN_INSTANCE,
    DESCRIBE_INSTANCE,
    START_INSTANCE,
    STOP_INSTANCE,
    TERMINATE_INSTANCE,
    REBOOT_INSTANCE,
    DESCRIBE_INSTANCE_CW_AGENTS,
    INSTALL_INSTANCE_CW_AGENT,
    UNINSTALL_INSTANCE_CW_AGENT,

    SCHEDULE_ADD_INSTANCES,
    SCHEDULE_REMOVE_INSTANCES,

    MANAGE_TERMINATION_PROTECTION,

    //RESOURCES
    LIST_RESOURCES,

    //TAGS
    SET_TAG,
    DELETE_TAG,
    DESCRIBE_TAGS,
    DESCRIBE_RESOURCE_TAGS,
    UPDATE_TAGS,
    UPDATE_RESOURCE_TAGS,
    DELETE_TAGS,

    //PRIVATE AGENT
    LIST_PRIVATE_AGENT_INFO,
    CREATE_PRIVATE_AGENT,
    LIST_PRIVATE_AGENT_REGIONS,
    LIST_PRIVATE_REGION_SHAPES,
    LIST_PRIVATE_REGION_IMAGES,
    RESEND_INSTANCE_AUDIT,
    RESEND_VOLUME_AUDIT,
    WIZARD_ACTION,
    ADDITIONAL_PARAM_ACTION,
    GET_AGENT_STATE_ACTION,
    AGENT_DIAGNOSTIC,
    AGENT_DIAGNOSTIC_FIX,
    CONSOLE_EXECUTION,
    GIT_EXECUTION,

    //OWNERSHIP
    DESCRIBE_OWNERSHIP,
    UPDATE_OWNERSHIP,
    FINISH_OWNERSHIP,
    GET_RESOURCE_ID,
    GET_CREATOR,
    SAVE_CREATOR,
    SAVE_CREATORS,
    GET_OWNERS,
    GET_CURRENT_OWNER,
    GET_POSSIBLE_OWNERS,
    CHANGE_OWNER,
    BATCH_GET_CURRENT_OWNER_BY_RESOURCE_ID_REQUESTS,

    //VOLUME
    DESCRIBE_VOLUME,
    CREATE_AND_ATTACH_VOLUME,
    CREATE_VOLUME,
    ATTACH_VOLUME,
    DETACH_VOLUME,
    REMOVE_VOLUME,
    RESIZE_VOLUME,

    //CHEF
    GET_CHEF_PROFILES,
    GET_DEFAULT_REGION_CHEF_PROFILES,
    GET_INSTANCE_CHEF_INFO,
    GET_INSTANCE_CHEF_ROLES,
    UPDATE_NODE_STATE,

    //NETWORK
    ACTIVATE_VLAN,
    ALLOCATE_IP,
    RELEASE_IP,
    ASSOCIATE_IP,
    DISASSOCIATE_IP,
    DESCRIBE_IPS,
    DEACTIVATE_VLAN,
    DESCRIBE_VLAN,
    CONFIGURE_PRIVATE_NETWORK,
    UPDATE_VLAN,
    MOVE_VM_TO_DMZ,
    MOVE_VM_TO_VLAN,

    //AUDIT
    DESCRIBE_AUDIT,
    SAVE_CADF_EVENT,
    GET_CREATION_AUDIT_EVENT,
    BATCH_GET_LIST_CREATION_AUDIT_EVENT,
    GET_EVENTS,

    //METRICS
    GET_USER_ACTIONS,
    GET_COMMON_DASHBOARD_ACTIONS,
    GET_USER_SPECIFIC_ACTIONS_FOR_ALL_DASHBOARDS,
    UPDATE_USER_SPECIFIC_DASHBOARD_ACTION,
    UPDATE_USER_SPECIFIC_INSTANCE_DASHBOARD_ACTION,
    DELETE_ACTIONS,
    UPDATE_USER_ACTIONS_WITH_SKIP_EXISTING,
    IS_METRIC_ENABLED,
    GET_ALL_USER_DASHBOARD_ACTION,
    GET_REAL_TIME_DASHBOARD_ACTION,
    GET_CUSTOM_METRICS,
    GET_GRAPH_IMAGE,
    GENERATE_GRAPH_URLS,
    GET_CUSTOM_METRIC_VALUE,

    //SECURITY
    INIT_NESSUS_SECURITY_SCAN,
    INIT_QUALYS_SECURITY_SCAN,
    GET_AVAILABLE_TEMPLATE_POLICIES,
    GET_LAST_NESSUS_SCAN,
    GET_LAST_QUALYS_SCAN,

    //IMAGES
    DESCRIBE_IMAGE,
    CREATE_IMAGE,
    DELETE_IMAGE,

    //REPORTING
    GET_TOTAL_BILLING_REPORT,
    GET_SUBTOTAL_BILLING_REPORT,
    GET_HOURLY_BILLING_REPORT,
    GET_RESOURCE_BILLING_REPORT,
    GET_MULTIPROJECT_BILLING_REPORT,
    GET_DAILY_TOTAL_REPORT,
    GET_MONTHLY_TOTAL_REPORT,
    GET_COST_OBJECT_DETAILS,
    GET_COST_AND_USAGE_REPORT,
    GET_TAGS,
    GET_INVOICES,

    //CONSUMPTION
    GET_CONSUMPTION,
    ADD_CONSUMPTION,
    DELETE_CONSUMPTION,
    GET_CONSUMPTION_DETAILS,
    ADD_CONSUMPTION_DETAILS,
    DELETE_CONSUMPTION_DETAILS,
    GET_ADJUSTMENT,
    ADD_ADJUSTMENT,
    DELETE_ADJUSTMENT,
    CHECK_TENANT_STATUS,

    //PRICE
    GET_PRICE_MODEL,
    GET_PRICING_POLICY,
    REMOVE_PRICING_POLICY_AOS,
    GET_LIST_PRICING_POLICY_AOS,
    GET_COST_ESTIMATION,
    GET_AVERAGE_INSTANCE_COST,
    SAVE_PRICING_POLICY,

    //NOTIFICATIONS
    SEND_MAIL,
    SEND_RAW_MAIL,
    SEND_NOTIFICATION,
    RESEND_NOTIFICATION,
    GET_USER_SUBSCRIPTIONS,
    GET_TENANT_SUBSCRIPTIONS,
    UPDATE_USER_SUBSCRIPTIONS,
    UPDATE_TENANT_SUBSCRIPTIONS,
    GET_SUBSCRIPTION_GROUPS_DESCRIPTION,
    GET_USER_NOTIFICATION,
    LIST_USER_NOTIFICATIONS,
    INSTANCE_DETAILS_REPORT,
    DESCRIBE_NOTIFICATION_GROUPS,
    GET_NOTIFICATION_RECEIVERS_MAPPING,
    UPDATE_NOTIFICATION_RECEIVERS_MAPPING,
    DELETE_NOTIFICATION_RECEIVERS_MAPPING,
    RESOURCE_DIAGNOSTICS_REPORT,

    //SSH
    ADD_KEY,
    ADD_SINGLE_KEY_SYNC,
    DELETE_KEY,
    UPDATE_KEYS,
    RENAME_KEYS,
    CHANGE_KEYS_OWNER,
    DESCRIBE_KEYS,
    CHANGE_KEY_STATUS,
    DESCRIBE_KEY_RELATED_INSTANCES,

    //QUOTA
    CREATE_QUOTA,
    UPDATE_QUOTA,
    REMOVE_QUOTA,
    GET_QUOTA_BY_TENANT_AND_REGION,
    GET_QUOTA_BY_TENANT_AND_TYPE,
    GET_QUOTAS_BY_TENANTS_AND_CRITERIA,
    GET_QUOTAS_BY_TENANT,
    QUOTA_EXISTS_BY_TENANT,
    GET_DEPLETED_QUOTA_BY_TENANT,
    GET_DEPLETED_ACTIVE_QUOTA_BY_TENANT_AND_REGION,
    GET_DEPLETED_ACTIVE_QUOTA_ACTIONS,
    QUOTA_EXISTS_IN_CURRENT_TENANT,

    //RESOURCE_QUOTA
    GET_INSTANCE_QUOTA,
    GET_VOLUME_QUOTA,
    UPDATE_INSTANCE_QUOTA,
    UPDATE_VOLUME_QUOTA,
    REMOVE_INSTANCE_QUOTA,
    REMOVE_VOLUME_QUOTA,
    VALIDATE_RESOURCE_QUOTA,

    //SERVICE
    ACTIVATE_BILLING,
    DEACTIVATE_BILLING,
    ACTIVATE_CUSTODIAN,
    DEACTIVATE_CUSTODIAN,
    ACTIVATE_RIGHTSIZER,
    DEACTIVATE_RIGHTSIZER,
    ACTIVATE_K8S,
    DEACTIVATE_K8S,
    ROTATE_SERVICE_CREDENTIALS,

    //TERRAFORM
    ACTIVATE_TERRAFORM,
    DEACTIVATE_TERRAFORM,
    DESCRIBE_TERRAFORM_POLICIES,
    DESCRIBE_TERRAFORM_TEMPLATE_RESOURCES,
    UPDATE_TERRAFORM_POLICIES,

    EXECUTE_TERRAFORM_TASK,
    SEND_TERRAFORM_TASK,

    SETUP_TERRAFORM_TEMPLATE_WITH_GITHUB,
    SETUP_TERRAFORM_TEMPLATE_WITH_S3,
    START_APPROVAL_PROCESS_FOR_APPLY_TEMPLATE,

    HANDLE_WEBHOOK,
    SETUP_WEBHOOK,
    DELETE_WEBHOOK,

    PLAN_TERRAFORM_TEMPLATE,
    APPLY_TERRAFORM_TEMPLATE,
    DESTROY_TERRAFORM_TEMPLATE,
    SHOW_TERRAFORM_TEMPLATE,

    GET_TERRAFORM_TEMPLATE_LOCK,
    GET_TERRAFORM_TEMPLATE_LOCK_STATUS,

    LOCK_TERRAFORM_TEMPLATE,
    UNLOCK_TERRAFORM_TEMPLATE,
    PROLONG_TERRAFORM_TEMPLATE_LOCK,

    DELETE_TERRAFORM_TEMPLATE,
    DELETE_TERRAFORM_TEMPLATES,
    DESCRIBE_TERRAFORM_TEMPLATE,
    UPDATE_TERRAFORM_TEMPLATE,
    DESCRIBE_TERRAFORM_TEMPLATE_BY_FILTERS,
    DESCRIBE_TERRAFORM_STACK,
    DESCRIBE_TERRAFORM_STACK_BY_ENTRY_ID,
    DESCRIBE_TERRAFORM_TEMPLATE_STACK,

    DOWNLOAD_TERRAFORM_LOGS,
    GET_TERRAFORM_COST_ESTIMATION,
    DOWNLOAD_LAST_TERRAFORM_LOG_BY_TASK,
    DOWNLOAD_TERRAFORM_RESOURCES_FILE,
    EXPORT_TERRAFORM_TEMPLATE,

    //STATUS

    M3_STATUS,
    M3_BILLING_STATUS,
    M3_BILLING_HISTORY,
    OWNERSHIP_AVAILABILITY,
    TERRAFORM_AVAILABILITY,
    MAILS_AVAILABILITY,
    LAST_EVENT_FOR_HOUR,
    EVENTS_FOR_HOUR,
    BILLING_HEALTH_CHECK,

    //ANALYTICS
    MONITORING_REPORT,
    CLOUD_RADAR_REPORT,
    GET_BILLING_CONFIG,
    GET_BILLING_TIME_LINES,
    GET_INSTANCES_ANALYTIC,
    GET_AUDIT_EVENTS,
    GET_LOW_UTILIZED_INSTANCES,
    GET_NOT_OPTIMAL_AWS_WORKSPACES,
    GET_AWS_WORKSPACES_FOR_LAST_TWO_WEEKS,

    //SCHEDULES
    CREATE_SCHEDULE,
    DESCRIBE_SCHEDULES,
    DELETE_SCHEDULE,

    //APPROVALS
    EXECUTE_APPROVAL_ACTION,
    EXECUTE_NOTIFICATION_ACTION,
    SEND_EXPAND_PERMISSIONS_REQUEST,

    //SCRIPTS
    UPLOAD_SCRIPT,
    DESCRIBE_SCRIPT,
    REMOVE_SCRIPT,

    //ACCOUNT
    SEND_MANAGEMENT_CONSOLE_ACCESS,

    // ONBOARDING
    ONBOARDING_AZURE_CUSTOMER_AND_TENANT,
    ONBOARDING_GOOGLE_CUSTOMER_AND_TENANT,
    ONBOARDING_AWS_TENANT,
    ONBOARDING_OPENSTACK_TENANT,
    ONBOARDING_VMWARE_TENANT,
    ONBOARDING_VSPHERE_TENANT,

    // PAAS
    REGISTER_PLATFORM_SERVICE,
    PENDING_REGISTER_PLATFORM_SERVICE,
    ACTIVATE_PLATFORM_SERVICE,
    ADD_PLATFORM_SERVICE_SECTION,
    DESCRIBE_PLATFORM_SERVICE_SECTION,
    DELETE_PLATFORM_SERVICE_SECTION,
    REMOVE_PLATFORM_SERVICE,
    UPDATE_PLATFORM_SERVICE,
    DEACTIVATE_PLATFORM_SERVICE,
    DESCRIBE_PLATFORM_SERVICE_AVAILABILITY,
    GET_SERVICE_VARIABLES_INFO,
    VALIDATE_SERVICE_VARIABLES,
    LIST_PLATFORM_SERVICE_ENTRIES,
    LIST_PLATFORM_SERVICES,
    LIST_TERRAFORM_CONTEXT_VARIABLES,

    // PERMISSIONS
    GET_USER_PERMISSIONS,
    GET_USER_POSITIONS,

    // FILE
    GET_FILE_FROM_SERVER,

    DESCRIBE_TENANTS,
    DESCRIBE_REGIONS,

    ACTIVATE_TENANT_IN_REGION,
    EXECUTE_ADMIN_COMMAND,

    LIST_REGION_SHAPES,

    GET_INSTANCE_HASHED_PASSWORD,

    DESCRIBE_RECOMMENDATIONS,
    DESCRIBE_RECOMMENDATION_SETTINGS,
    UPDATE_RECOMMENDATION_SETTINGS,
    GET_CUSTODIAN_LAST_RESOURCE_SCAN_RESULTS,
    GET_CUSTODIAN_LAST_K8S_CLUSTER_SCAN_RESULTS,

    //Operation
    GET_OPERATION_STATUS,

    //Kubernetes
    DESCRIBE_KUBERNETES_CLUSTER
    ;

    public static final Map<String, ActionType> ALL_VALUES = Arrays.stream(ActionType.values())
            .collect(Collectors.toUnmodifiableMap(Enum::name, a -> a));

    public M3apiActionBuilder builder() {
        return new M3apiActionBuilder(this);
    }

    public static class M3apiActionBuilder {
        private final ActionType type;
        private final Map<String, Object> params = new HashMap<>();

        public M3apiActionBuilder(ActionType type) {
            this.type = type;
        }

        public M3apiActionBuilder addParam(String key, Object value) {
            this.params.put(key, value);
            return this;
        }

        public M3apiActionBuilder addParams(Map<String, Object> params) {
            this.params.putAll(params);
            return this;
        }

        public M3ApiAction build() {
            return new M3ApiAction(type, params);
        }
    }
}
