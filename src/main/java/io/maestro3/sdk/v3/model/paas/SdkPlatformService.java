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

package io.maestro3.sdk.v3.model.paas;

import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.model.terraform.template.SdkTemplateType;

import java.util.List;
import java.util.Map;

public class SdkPlatformService {

    private String name;
    private String title;
    private boolean paasInstruction;
    private String description;
    private String discoverableUrl;
    private String databagName;
    private String templateName;
    private SdkTemplateType templateType;
    private boolean supportProxy;
    private String providerVersion;
    private String summaryDescription;
    private double price;
    private long activationsCount;
    private String serviceProvider;
    private String productVersion;
    private List<String> categories;
    private Map<String, String> additionalNotificationParams;
    private String operatingSystem;
    private String deliveryMethod;
    private String iconUrl;
    private String icon;
    private List<SdkCloud> clouds;
    private List<String> tenants;
    private String customer;
    private Map<String, String> usage;
    private Map<String, String> support;
    private long creationTimestamp;

    public String getName() {
        return name;
    }

    public SdkPlatformService setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isPaasInstruction() {
        return paasInstruction;
    }

    public void setPaasInstruction(boolean paasInstruction) {
        this.paasInstruction = paasInstruction;
    }

    public boolean isSupportProxy() {
        return supportProxy;
    }

    public void setSupportProxy(boolean supportProxy) {
        this.supportProxy = supportProxy;
    }

    public String getDatabagName() {
        return databagName;
    }

    public void setDatabagName(String databagName) {
        this.databagName = databagName;
    }

    public String getDiscoverableUrl() {
        return discoverableUrl;
    }

    public void setDiscoverableUrl(String discoverableUrl) {
        this.discoverableUrl = discoverableUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Map<String, String> getUsage() {
        return usage;
    }

    public void setUsage(Map<String, String> usage) {
        this.usage = usage;
    }

    public Map<String, String> getSupport() {
        return support;
    }

    public void setSupport(Map<String, String> support) {
        this.support = support;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public long getActivationsCount() {
        return activationsCount;
    }

    public void setActivationsCount(long activationsCount) {
        this.activationsCount = activationsCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProviderVersion() {
        return providerVersion;
    }

    public void setProviderVersion(String providerVersion) {
        this.providerVersion = providerVersion;
    }

    public String getSummaryDescription() {
        return summaryDescription;
    }

    public void setSummaryDescription(String summaryDescription) {
        this.summaryDescription = summaryDescription;
    }

    public String getDescription() {
        return description;
    }

    public SdkPlatformService setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public SdkTemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(SdkTemplateType templateType) {
        this.templateType = templateType;
    }

    public List<SdkCloud> getClouds() {
        return clouds;
    }

    public void setClouds(List<SdkCloud> clouds) {
        this.clouds = clouds;
    }

    public List<String> getTenants() {
        return tenants;
    }

    public void setTenants(List<String> tenants) {
        this.tenants = tenants;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Map<String, String> getAdditionalNotificationParams() {
        return additionalNotificationParams;
    }

    public void setAdditionalNotificationParams(Map<String, String> additionalNotificationParams) {
        this.additionalNotificationParams = additionalNotificationParams;
    }
}
