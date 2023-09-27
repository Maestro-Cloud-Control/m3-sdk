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

package io.maestro3.sdk.v3.manager;

import io.maestro3.sdk.v3.core.IPrincipal;
import io.maestro3.sdk.v3.core.M3Result;
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

public interface INotificationManager extends IManager {

    M3Result<SdkOperation> sendEmail(IPrincipal principal, MailMessageRequest request);

    M3Result<Void> sendNotification(IPrincipal principal, NotificationRequest request);

    M3Result<Void> resendNotification(IPrincipal principal, ResendNotificationRequestParams request);

    M3Result<List<UserSubscription>> getUserSubscriptions(IPrincipal principal, GetUserSubscriptionRequest request);

    M3Result<TenantSubscription> getTenantSubscription(IPrincipal principal, GetTenantSubscriptionRequest request);

    M3Result<Void> updateUserSubscription(IPrincipal principal, UpdateUserSubscriptionRequest request);

    M3Result<Void> updateTenantSubscription(IPrincipal principal, UpdateTenantSubscriptionRequest request);

    M3Result<List<SubscriptionGroupDescription>> getSubscriptionGroupsDescription(
        IPrincipal principal, GetSubscriptionGroupsDescriptionRequest request);

    M3Result<List<String>> getNotificationGroups(IPrincipal principal, GetNotificationGroupsRequest request);

    M3Result<Map<String, ReceiversMappingConfiguration>> getNotificationReceiversMapping(IPrincipal principal, GetNotificationReceiversMappingRequest request);

    M3Result<Void> updateNotificationReceiversMapping(IPrincipal principal, UpdateNotificationReceiversMappingRequest request);

    M3Result<Void> deleteNotificationReceiversMapping(IPrincipal principal, DeleteNotificationReceiversMappingRequest request);

    M3Result<SdkUserNotification> getUserNotification(IPrincipal principal, UserNotificationRequest request);

    M3Result<List<SdkNotificationAudit>> listUserNotifications(IPrincipal principal, ListUserNotificationsRequest request);

    M3Result<Void> sendInstanceDetailsReport(IPrincipal principal, InstanceDetailsRequest request);

    M3Result<String> sendResourceDiagnosticsReport(IPrincipal principal, ResourceDiagnosticsRequest request);
}
