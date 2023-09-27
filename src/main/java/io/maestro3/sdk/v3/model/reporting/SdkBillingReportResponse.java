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

package io.maestro3.sdk.v3.model.reporting;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.maestro3.sdk.v3.model.instance.SdkResourceTag;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SdkBillingReportResponse {

    private List<ReportRecord> records;
    private String s3ReportLink;
    private List<SdkResourceTag> tags;
    private BigDecimal grandTotal;
    private String message;

    public SdkBillingReportResponse() {
    }

    public SdkBillingReportResponse(String s3ReportLink, String message) {
        this.s3ReportLink = s3ReportLink;
        this.message = message;
    }

    public SdkBillingReportResponse(String message) {
        this.message = message;
    }

    public SdkBillingReportResponse(List<ReportRecord> records, BigDecimal grandTotal) {
        this.records = records;
        this.grandTotal = grandTotal;
    }

    public SdkBillingReportResponse(List<ReportRecord> records, BigDecimal grandTotal, List<SdkResourceTag> tags) {
        this.records = records;
        this.grandTotal = grandTotal;
        this.tags = tags;
    }

    public List<ReportRecord> getRecords() {
        return records;
    }

    public void setRecords(List<ReportRecord> records) {
        this.records = records;
    }

    public String getS3ReportLink() {
        return s3ReportLink;
    }

    public void setS3ReportLink(String s3ReportLink) {
        this.s3ReportLink = s3ReportLink;
    }

    public List<SdkResourceTag> getTags() {
        return tags;
    }

    public void setTags(List<SdkResourceTag> tags) {
        this.tags = tags;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SdkBillingReportResponse that = (SdkBillingReportResponse) o;

        if (records != null ? !records.equals(that.records) : that.records != null) return false;
        if (grandTotal != null ? !grandTotal.equals(that.grandTotal) : that.grandTotal != null) return false;
        if (s3ReportLink != null ? !s3ReportLink.equals(that.s3ReportLink) : that.s3ReportLink != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = records != null ? records.hashCode() : 0;
        result = 31 * result + (grandTotal != null ? grandTotal.hashCode() : 0);
        result = 31 * result + (s3ReportLink != null ? s3ReportLink.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BillingReportResponse{" +
            "records=" + records +
            ", s3ReportLink='" + s3ReportLink + '\'' +
            ", tags=" + tags +
            ", grandTotal=" + grandTotal +
            ", message='" + message + '\'' +
            '}';
    }
}
