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

import java.util.Map;
import java.util.Objects;

public class MailMessageAction {
    private MailMessageActionType type;
    private String identifier;
    private Map<String, String> links;

    public MailMessageAction() {}

    public MailMessageAction(MailMessageActionType type,
                             String identifier,
                             Map<String, String> links) {
        this.type = type;
        this.identifier = identifier;
        this.links = links;
    }

    public MailMessageActionType getType() {
        return type;
    }

    public void setType(MailMessageActionType type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "MailMessageAction{" +
                "type=" + type +
                ", identifier='" + identifier + '\'' +
                ", links=" + links +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailMessageAction that = (MailMessageAction) o;
        return type == that.type &&
                Objects.equals(identifier, that.identifier) &&
                Objects.equals(links, that.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, identifier, links);
    }
}
