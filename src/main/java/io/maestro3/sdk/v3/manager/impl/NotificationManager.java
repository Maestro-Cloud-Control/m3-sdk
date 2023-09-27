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

package io.maestro3.sdk.v3.manager.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import io.maestro3.sdk.internal.executor.IM3ApiActionExecutor;
import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
import io.maestro3.sdk.v3.manager.INotificationManager;
import io.maestro3.sdk.v3.model.notification.ReceiversMappingConfiguration;
import io.maestro3.sdk.v3.model.notification.SubscriptionGroupDescription;
import io.maestro3.sdk.v3.model.notification.TenantSubscription;
import io.maestro3.sdk.v3.model.notification.UserSubscription;
import io.maestro3.sdk.v3.model.notification.user.SdkNotificationAudit;
import io.maestro3.sdk.v3.model.notification.user.SdkUserNotification;
import io.maestro3.sdk.v3.model.operation.SdkOperation;
import io.maestro3.sdk.v3.request.instance.InstanceDetailsRequest;
import io.maestro3.sdk.v3.request.notification.DeleteNotificationReceiversMappingRequest;
import io.maestro3.sdk.v3.request.notification.GetNotificationGroupsRequest;
import io.maestro3.sdk.v3.request.notification.GetNotificationReceiversMappingRequest;
import io.maestro3.sdk.v3.request.notification.GetSubscriptionGroupsDescriptionRequest;
import io.maestro3.sdk.v3.request.notification.GetTenantSubscriptionRequest;
import io.maestro3.sdk.v3.request.notification.GetUserSubscriptionRequest;
import io.maestro3.sdk.v3.request.notification.ListUserNotificationsRequest;
import io.maestro3.sdk.v3.request.notification.MailMessageRequest;
import io.maestro3.sdk.v3.request.notification.NotificationRequest;
import io.maestro3.sdk.v3.request.notification.ResendNotificationRequestParams;
import io.maestro3.sdk.v3.request.notification.UpdateNotificationReceiversMappingRequest;
import io.maestro3.sdk.v3.request.notification.UpdateTenantSubscriptionRequest;
import io.maestro3.sdk.v3.request.notification.UpdateUserSubscriptionRequest;
import io.maestro3.sdk.v3.request.notification.UserNotificationRequest;
import io.maestro3.sdk.v3.request.resource.template.ResourceDiagnosticsRequest;

import java.util.List;
import java.util.Map;

public class NotificationManager extends AbstractManager implements INotificationManager {

    private static final TypeReference<List<UserSubscription>> USER_SUBSCRIPTION_TYPE
        = new TypeReference<List<UserSubscription>>() {
    };
    private static final TypeReference<TenantSubscription> TENANT_SUBSCRIPTION_TYPE =
        new TypeReference<TenantSubscription>() {
        };
    private static final TypeReference<List<SubscriptionGroupDescription>> SUBSCRIPTION_GROUPS_DESCRIPTION_TYPE =
        new TypeReference<List<SubscriptionGroupDescription>>() {
        };
    private static final TypeReference<SdkUserNotification> USER_NOTIFICATION_TYPE =
        new TypeReference<SdkUserNotification>() {
        };
    private static final TypeReference<List<SdkNotificationAudit>> NOTIFICATION_AUDIT_LIST_TYPE =
        new TypeReference<List<SdkNotificationAudit>>() {
        };
    private static final TypeReference<List<String>> NOTIFICATION_GROUPS_LIST_TYPE = new TypeReference<List<String>>() {
    };
    private static final TypeReference<Map<String, ReceiversMappingConfiguration>> NOTIFICATION_RECEIVERS_INFO_TYPE = new TypeReference<Map<String, ReceiversMappingConfiguration>>() {
    };
    private static final TypeReference<SdkOperation> OPERATION_TYPE = new TypeReference<SdkOperation>() {
    };

    public NotificationManager(IM3ApiActionExecutor actionExecutor, boolean isAsync) {
        super(actionExecutor, isAsync);
    }

    @Override
    public M3Result<SdkOperation> sendEmail(IPrincipal principal, MailMessageRequest request) {
        return execute(principal, request, OPERATION_TYPE);
    }

    @Override
    public M3Result<Void> sendNotification(IPrincipal principal, NotificationRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> resendNotification(IPrincipal principal, ResendNotificationRequestParams request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<UserSubscription>> getUserSubscriptions(IPrincipal principal, GetUserSubscriptionRequest request) {
        return execute(principal, request, USER_SUBSCRIPTION_TYPE);
    }

    @Override
    public M3Result<TenantSubscription> getTenantSubscription(IPrincipal principal, GetTenantSubscriptionRequest request) {
        return execute(principal, request, TENANT_SUBSCRIPTION_TYPE);
    }

    @Override
    public M3Result<Void> updateUserSubscription(IPrincipal principal, UpdateUserSubscriptionRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> updateTenantSubscription(IPrincipal principal, UpdateTenantSubscriptionRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<List<SubscriptionGroupDescription>> getSubscriptionGroupsDescription(
        IPrincipal principal, GetSubscriptionGroupsDescriptionRequest request) {
        return execute(principal, request, SUBSCRIPTION_GROUPS_DESCRIPTION_TYPE);
    }

    @Override
    public M3Result<List<String>> getNotificationGroups(IPrincipal principal, GetNotificationGroupsRequest request) {
        return execute(principal, request, NOTIFICATION_GROUPS_LIST_TYPE);
    }

    @Override
    public M3Result<Map<String, ReceiversMappingConfiguration>> getNotificationReceiversMapping(IPrincipal principal, GetNotificationReceiversMappingRequest request) {
        return execute(principal, request, NOTIFICATION_RECEIVERS_INFO_TYPE);
    }

    @Override
    public M3Result<Void> updateNotificationReceiversMapping(IPrincipal principal, UpdateNotificationReceiversMappingRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<Void> deleteNotificationReceiversMapping(IPrincipal principal, DeleteNotificationReceiversMappingRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<SdkUserNotification> getUserNotification(IPrincipal principal, UserNotificationRequest request) {
        return execute(principal, request, USER_NOTIFICATION_TYPE);
    }

    @Override
    public M3Result<List<SdkNotificationAudit>> listUserNotifications(IPrincipal principal, ListUserNotificationsRequest request) {
        return execute(principal, request, NOTIFICATION_AUDIT_LIST_TYPE);
    }

    @Override
    public M3Result<Void> sendInstanceDetailsReport(IPrincipal principal, InstanceDetailsRequest request) {
        return execute(principal, request, VOID_RESULT);
    }

    @Override
    public M3Result<String> sendResourceDiagnosticsReport(IPrincipal principal, ResourceDiagnosticsRequest request) {
        return execute(principal, request, STRING_RESULT);
    }
}
