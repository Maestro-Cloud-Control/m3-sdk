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

package io.maestro3.sdk.v3.model.notification;

import java.util.Objects;

public class MailMessageAttachmentInfo {

    private String filename;
    private MailMessageAttachmentInfoType type;
    private String data;

    private MailMessageAttachmentInfo() {
    }

    private MailMessageAttachmentInfo(String filename, MailMessageAttachmentInfoType type, String data) {
        this.filename = filename;
        this.type = type;
        this.data = data;
    }

    public static MailMessageAttachmentInfo base64(String filename, String encodedContent) {
        return new MailMessageAttachmentInfo(filename, MailMessageAttachmentInfoType.BASE64, encodedContent);
    }

    public static MailMessageAttachmentInfo url(String filename, String fileUrl) {
        return new MailMessageAttachmentInfo(filename, MailMessageAttachmentInfoType.URL, fileUrl);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getData() {
        return data;
    }

    public MailMessageAttachmentInfoType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MailMessageAttachmentInfo)) return false;
        MailMessageAttachmentInfo that = (MailMessageAttachmentInfo) o;
        return Objects.equals(filename, that.filename) &&
                type == that.type &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, type, data);
    }

    @Override
    public String toString() {
        return "MailMessageAttachmentInfo{" +
                "filename='" + filename + '\'' +
                ", type=" + type +
                ", data='" + data + '\'' +
                '}';
    }
}
