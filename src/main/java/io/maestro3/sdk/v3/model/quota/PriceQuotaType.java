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

package io.maestro3.sdk.v3.model.quota;


import com.fasterxml.jackson.annotation.JsonCreator;
import io.maestro3.sdk.internal.util.CollectionUtils;
import io.maestro3.sdk.v3.model.SdkCloud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.maestro3.sdk.internal.util.CollectionUtils.newList;

public enum PriceQuotaType {

    SINGLE(null, "Single", "Single"),
    ALL(null, "All", Constants.ALL_CLOUDS),
    ALL_AWS(SdkCloud.AWS, "All AWS", "All AWS regions"),
    ALL_AZURE(SdkCloud.AZURE, "All Azure", "All Azure regions"),
    ALL_GOOGLE(SdkCloud.GOOGLE, "All Google", "All Google regions"),
    ALL_YANDEX(SdkCloud.YANDEX, "All Yandex", "All Yandex regions"),
    DAILY_ALL_AWS(SdkCloud.AWS, "Total AWS Daily", "Total AWS Daily"),
    DAILY_ALL_AZURE(SdkCloud.AZURE, "Total Azure Daily", "Total Azure Daily"),
    DAILY_ALL_GOOGLE(SdkCloud.GOOGLE, "Total Google Daily", "Total Google Daily"),
    DAILY_ALL_OPENSTACK(SdkCloud.OPEN_STACK, "Total Open_Stack Daily", "Total Open_Stack Daily"),
    ALL_PRIVATE(null, "All Private", "All private regions"),
    EACH(null, "Each", Constants.EACH_REGION),
    EACH_AWS(SdkCloud.AWS, "Each AWS", "Each AWS region"),
    EACH_AZURE(SdkCloud.AZURE, "Each Azure", "Each Azure region"),
    EACH_GOOGLE(SdkCloud.GOOGLE, "Each Google", "Each Google region"),
    EACH_YANDEX(SdkCloud.YANDEX, "Each Yandex", "Each Yandex region"),
    EACH_PRIVATE(null, "Each Private", "Each private region");

    private final SdkCloud cloud;
    private final String title;
    private final String uiTitle;

    private static final List<PriceQuotaType> VALUES = Arrays.asList(values());

    private static final Set<PriceQuotaType> DAILY_TYPES = Collections.unmodifiableSet(
        CollectionUtils.newSet(DAILY_ALL_AWS, DAILY_ALL_AZURE, DAILY_ALL_GOOGLE, DAILY_ALL_OPENSTACK));

    PriceQuotaType(SdkCloud cloud, String title, String uiTitle) {
        this.cloud = cloud;
        this.title = title;
        this.uiTitle = uiTitle;
    }

    public static List<PriceQuotaType> getEachTypes() {
        return CollectionUtils.newList(EACH, EACH_AWS, EACH_AZURE, EACH_GOOGLE, EACH_PRIVATE, EACH_YANDEX);
    }

    public static List<PriceQuotaType> getCloudRelated(SdkCloud cloud) {

        switch (cloud) {
            case AWS:
                return newList(ALL_AWS, DAILY_ALL_AWS, EACH_AWS);
            case AZURE:
                return newList(ALL_AZURE, DAILY_ALL_AZURE, EACH_AZURE);
            case GOOGLE:
                return newList(ALL_GOOGLE, DAILY_ALL_GOOGLE, EACH_GOOGLE);
            case YANDEX:
                return newList(ALL_YANDEX, EACH_YANDEX);
            case OPEN_STACK:
                return newList(ALL_PRIVATE, EACH_PRIVATE, DAILY_ALL_OPENSTACK);
            case CSA:
            case VMWARE:
            case VSPHERE:
            case NUTANIX:
                return newList(ALL_PRIVATE, EACH_PRIVATE);
            default:
                throw new IllegalArgumentException(cloud + " is not supported");
        }
    }

    public static PriceQuotaType getCloudRelatedDaily(SdkCloud cloud) {
        return getAllDaily().stream()
            .filter(type -> type.getNullableCloud() == cloud)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(cloud + " is not supported"));
    }

    public static PriceQuotaType getAllByCloud(SdkCloud cloud) {
        switch (cloud) {
            case AWS:
                return ALL_AWS;
            case GOOGLE:
                return ALL_GOOGLE;
            case AZURE:
                return ALL_AZURE;
            case OPEN_STACK:
            case VSPHERE:
            case VMWARE:
            case CSA:
            case NUTANIX:
                return ALL_PRIVATE;
            case YANDEX:
                return ALL_YANDEX;
            default:
                throw new IllegalArgumentException(cloud + " is not supported");
        }
    }

    public static boolean isNotSupportedCloud(SdkCloud cloud) {
        switch (cloud) {
            case AWS:
            case GOOGLE:
            case AZURE:
            case OPEN_STACK:
            case VSPHERE:
            case VMWARE:
            case CSA:
            case NUTANIX:
            case YANDEX:
                return false;
            default:
                return true;
        }
    }

    public static List<PriceQuotaType> getNotCloudRelated() {
        return newList(ALL, EACH);
    }

    public static Set<PriceQuotaType> getAllDaily() {
        return DAILY_TYPES;
    }

    public static List<PriceQuotaType> getAllNonDaily() {
        List<PriceQuotaType> priceQuotaTypes = new ArrayList<>(VALUES);
        priceQuotaTypes.removeAll(getAllDaily());
        return priceQuotaTypes;
    }

    public boolean isDaily() {
        return getAllDaily().contains(this);
    }

    public static PriceQuotaType tryToFindByTitle(String cloudSelect, String uiTitle) {
        SdkCloud cloud = "ALL".equalsIgnoreCase(cloudSelect) ? null : SdkCloud.fromValue(cloudSelect);
        return VALUES.stream()
            .filter(type -> type.cloud == cloud && type.uiTitle.equalsIgnoreCase(uiTitle))
            .findFirst()
            .orElse(null);
    }

    @JsonCreator
    public static PriceQuotaType fromValue(String name) {
        for (PriceQuotaType value : values()) {
            if (name.equalsIgnoreCase(value.name())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Price quota not found by name: " + name);
    }

    public static PriceQuotaType fromTitle(String title) {
        for (PriceQuotaType value : values()) {
            if (title.equalsIgnoreCase(value.title)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Price quota not found by title: " + title);
    }

    public static PriceQuotaType fromValueNullable(String value) {
        try {
            return fromValue(value);
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    public static boolean isEachQuota(IPriceQuota quota) {
        return isEach(quota.getType());
    }

    public static boolean isEach(PriceQuotaType type) {
        switch (type) {
            case EACH_PRIVATE:
            case EACH_AZURE:
            case EACH_GOOGLE:
            case EACH_YANDEX:
            case EACH_AWS:
            case EACH:
                return true;
            default:
                return false;
        }
    }

    public static boolean isAll(PriceQuotaType type) {
        switch (type) {
            case ALL_AWS:
            case ALL_AZURE:
            case ALL_PRIVATE:
            case ALL_YANDEX:
            case ALL_GOOGLE:
            case ALL:
                return true;
            default:
                return false;
        }
    }

    public static String resolveQuotaScope(IPriceQuota priceQuota) {
        PriceQuotaType type = priceQuota.getType();
        if (type == PriceQuotaType.SINGLE) {
            return priceQuota.getRegionName();
        } else if (PriceQuotaType.isEach(type)) {
            return String.format("%s (%s)", type.getUiTitle(), priceQuota.getRegionName());
        } else {
            return type.name();
        }
    }

    public static String resolveLocalizableQuotaScope(IPriceQuota priceQuota) {
        PriceQuotaType type = priceQuota.getType();
        if (type == PriceQuotaType.SINGLE) {
            return priceQuota.getRegionName();
        } else if (PriceQuotaType.isEach(type)) {
            return String.format("${scope} (%s)", priceQuota.getRegionName());
        } else {
            return type.getUiTitle();
        }
    }

    public static Map<String, Object> resolveLocalizableQuotaScopePlaceholders(IPriceQuota priceQuota) {
        PriceQuotaType type = priceQuota.getType();
        if (PriceQuotaType.isEach(type)) {
            Map<String, Object> placeholders = new HashMap<>();
            placeholders.put("scope", type.getUiTitle());
            return placeholders;
        } else {
            return Collections.emptyMap();
        }
    }

    public String getTitle() {
        return title;
    }

    public String getUiTitle() {
        return uiTitle;
    }

    public SdkCloud getNullableCloud() {
        return cloud;
    }

    public static final class Constants {

        public static final String ALL_CLOUDS = "All clouds";
        public static final String EACH_REGION = "Each region";

        private Constants() {
            throw new UnsupportedOperationException("Instantiation is forbidden.");
        }
    }

    public QuotaPeriod period() {
        return isDaily() ? QuotaPeriod.DAILY : QuotaPeriod.MONTHLY;
    }
}
