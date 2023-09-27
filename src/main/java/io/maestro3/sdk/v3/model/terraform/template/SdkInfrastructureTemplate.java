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

package io.maestro3.sdk.v3.model.terraform.template;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.maestro3.sdk.internal.util.StringUtils;
import io.maestro3.sdk.v3.model.SdkCloud;
import io.maestro3.sdk.v3.request.approval.ApprovalRule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkInfrastructureTemplate {

    private String tenantName;
    private String templateName;
    private SdkCloud cloud;
    private SdkTemplateType templateType;
    private SdkTemplateStatus status;
    private String description;
    private String owner;
    private long creationTimestamp;
    private long stackCreationTimestamp;
    private long stackModificationTimestamp;
    private String stackId;
    private long lastModificationTimestamp;
    private SdkTerraformTemplateFormat templateFormat;
    private String terraformVersion;
    private SdkTemplateProviderType templateProviderType;
    private Map<String, String> templateProviderParams;
    private String templateUuid;
    private String terraformCredentialsProvider;
    private boolean multistack;
    private boolean m3Template;
    private Map<String, SdkTerraformTemplateVariable> predefinedVariables;
    private Map<String, SdkTerraformTemplateVariable> templateVariables;

    private boolean needReview;
    private List<String> approvers;
    private ApprovalRule approvalRule;

    private BigDecimal minMonthlyCost;
    private BigDecimal maxMonthlyCost;
    private SdkTerraformContext terraformContext;

    public SdkInfrastructureTemplate() {
        this.templateProviderParams = new HashMap<>();
        this.predefinedVariables = new HashMap<>();
        this.templateVariables = new HashMap<>();
        this.approvers = new ArrayList<>();
    }

    public String getTerraformCredentialsProvider() {
        return terraformCredentialsProvider;
    }

    public void setTerraformCredentialsProvider(String terraformCredentialsProvider) {
        this.terraformCredentialsProvider = terraformCredentialsProvider;
    }

    public boolean isMultistack() {
        return multistack;
    }

    public void setMultistack(boolean multistack) {
        this.multistack = multistack;
    }

    public SdkCloud getCloud() {
        return cloud;
    }

    public void setCloud(SdkCloud cloud) {
        this.cloud = cloud;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public boolean isM3Template() {
        return m3Template;
    }

    public void setM3Template(boolean m3Template) {
        this.m3Template = m3Template;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SdkTemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(SdkTemplateType templateType) {
        this.templateType = templateType;
    }

    public SdkTemplateStatus getStatus() {
        return status;
    }

    public void setStatus(SdkTemplateStatus status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public long getLastModificationTimestamp() {
        return lastModificationTimestamp;
    }

    public void setLastModificationTimestamp(long lastModificationTimestamp) {
        this.lastModificationTimestamp = lastModificationTimestamp;
    }

    public SdkTerraformTemplateFormat getTemplateFormat() {
        return templateFormat;
    }

    public void setTemplateFormat(SdkTerraformTemplateFormat templateFormat) {
        this.templateFormat = templateFormat;
    }

    public String getStackId() {
        return stackId;
    }

    public void setStackId(String stackId) {
        this.stackId = stackId;
    }

    public long getStackCreationTimestamp() {
        return stackCreationTimestamp;
    }

    public void setStackCreationTimestamp(long stackCreationTimestamp) {
        this.stackCreationTimestamp = stackCreationTimestamp;
    }

    public long getStackModificationTimestamp() {
        return stackModificationTimestamp;
    }

    public void setStackModificationTimestamp(long stackModificationTimestamp) {
        this.stackModificationTimestamp = stackModificationTimestamp;
    }

    public String getTerraformVersion() {
        return terraformVersion;
    }

    public void setTerraformVersion(String terraformVersion) {
        this.terraformVersion = terraformVersion;
    }

    public Map<String, String> getTemplateProviderParams() {
        return templateProviderParams;
    }

    public void setTemplateProviderParams(Map<String, String> templateProviderParams) {
        if (templateProviderParams == null) {
            this.templateProviderParams = new HashMap<>();
        } else {
            this.templateProviderParams = templateProviderParams;
        }
    }

    public SdkTemplateProviderType getTemplateProviderType() {
        return templateProviderType;
    }

    public void setTemplateProviderType(SdkTemplateProviderType templateProviderType) {
        this.templateProviderType = templateProviderType;
    }

    public String getTemplateUuid() {
        return templateUuid;
    }

    public void setTemplateUuid(String templateUuid) {
        this.templateUuid = templateUuid;
    }

    public boolean isNeedReview() {
        return needReview;
    }

    public void setNeedReview(boolean needReview) {
        this.needReview = needReview;
    }

    public List<String> getApprovers() {
        return approvers;
    }

    public void setApprovers(List<String> approvers) {
        this.approvers = approvers;
    }

    public ApprovalRule getApprovalRule() {
        return approvalRule;
    }

    public void setApprovalRule(ApprovalRule approvalRule) {
        this.approvalRule = approvalRule;
    }

    public BigDecimal getMinMonthlyCost() {
        return minMonthlyCost;
    }

    public void setMinMonthlyCost(BigDecimal minMonthlyCost) {
        this.minMonthlyCost = minMonthlyCost;
    }

    public BigDecimal getMaxMonthlyCost() {
        return maxMonthlyCost;
    }

    public void setMaxMonthlyCost(BigDecimal maxMonthlyCost) {
        this.maxMonthlyCost = maxMonthlyCost;
    }

    @JsonIgnore
    public Map<String, SdkTerraformTemplateVariable> getVariables() {
        Map<String, SdkTerraformTemplateVariable> merged = new HashMap<>(templateVariables);
        merged.putAll(predefinedVariables);
        return merged;
    }

    @JsonIgnore
    public void setVariables(Map<String, SdkTerraformTemplateVariable> variables) {
        if (variables == null || variables.isEmpty()) {
            this.predefinedVariables = new HashMap<>();
        } else {
            variables.forEach((variableName, variable) -> {
                if (StringUtils.isBlank(variableName) || StringUtils.isBlank(variable.getName())) {
                    return;
                }
                SdkTerraformTemplateVariable predefinedVariable = predefinedVariables.get(variableName);
                SdkTerraformTemplateVariable templateVariable = templateVariables.get(variableName);

                SdkTerraformTemplateVariable newPredefined = new SdkTerraformTemplateVariable(variable);

                if (predefinedVariable != null) {
                    newPredefined.setDescription(predefinedVariable.getDescription());
                    predefinedVariables.put(variableName, newPredefined);
                } else if (templateVariable != null) {
                    if (StringUtils.isNotEquals(variable.getName(), templateVariable.getName())
                            || !Objects.equals(variable.getValue(), templateVariable.getValue())) {
                        newPredefined.setDescription(templateVariable.getDescription());
                        predefinedVariables.put(variableName, newPredefined);
                    } else {
                        // do nothing, value is the same as in the template
                    }
                } else {
                    predefinedVariables.put(variableName, newPredefined);
                }
            });
        }
    }

    public Map<String, SdkTerraformTemplateVariable> getPredefinedVariables() {
        return predefinedVariables;
    }

    public void setPredefinedVariables(Map<String, SdkTerraformTemplateVariable> predefinedVariables) {
        this.predefinedVariables = predefinedVariables == null ? new HashMap<>() : predefinedVariables;
    }

    public Map<String, SdkTerraformTemplateVariable> getTemplateVariables() {
        return templateVariables;
    }

    public void setTemplateVariables(Map<String, SdkTerraformTemplateVariable> templateVariables) {
        this.templateVariables = templateVariables == null ? new HashMap<>() : templateVariables;
    }

    @JsonIgnore
    public boolean isNew() {
        return lastModificationTimestamp == 0;
    }

    @JsonIgnore
    public boolean isNewStack() {
        return stackModificationTimestamp == 0;
    }

    @JsonIgnore
    public boolean isCreated() {
        return StringUtils.isNotBlank(stackId);
    }

    @JsonIgnore
    public boolean isNotCreated() {
        return StringUtils.isBlank(stackId);
    }

    @JsonIgnore
    public boolean isInTransitionState() {
        return status.isTransitional();
    }

    public SdkTerraformContext getTerraformContext() {
        return terraformContext;
    }

    public void setTerraformContext(SdkTerraformContext terraformContext) {
        this.terraformContext = terraformContext;
    }

    @Override
    public String toString() {
        return "TerraformTemplate{" +
                "tenantName='" + tenantName + '\'' +
                ", templateName='" + templateName + '\'' +
                ", cloud=" + cloud +
                ", templateType=" + templateType +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                ", creationTimestamp=" + creationTimestamp +
                ", stackCreationTimestamp=" + stackCreationTimestamp +
                ", stackModificationTimestamp=" + stackModificationTimestamp +
                ", stackId='" + stackId + '\'' +
                ", lastModificationTimestamp=" + lastModificationTimestamp +
                ", templateFormat=" + templateFormat +
                ", terraformVersion='" + terraformVersion + '\'' +
                ", templateProviderType=" + templateProviderType +
                ", templateProviderParams=" + templateProviderParams +
                ", templateUuid='" + templateUuid + '\'' +
                ", predefinedVariables=" + predefinedVariables +
                ", templateVariables=" + templateVariables +
                ", terraformContext=" + terraformContext +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SdkInfrastructureTemplate template = (SdkInfrastructureTemplate) o;
        return Objects.equals(tenantName, template.tenantName)
                && Objects.equals(templateName, template.templateName)
                && Objects.equals(templateUuid, template.templateUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenantName, templateName, templateUuid);
    }
}
