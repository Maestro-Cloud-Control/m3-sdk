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

package io.maestro3.sdk.v3.model.status;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class M3BillingStatus {

    @JsonProperty
    private Map<Date, String> billingMonths = new HashMap<>();

    private M3BillingStatus() {
    }

    private M3BillingStatus(Map<Date, String> billingMonths) {
        this.billingMonths = billingMonths;
    }

    public static M3BillingStatusBuilder builder() {
        return new M3BillingStatusBuilder();
    }

    @JsonIgnore
    public Map<Date, String> getBillingMonths() {
        return billingMonths;
    }

    public static class M3BillingStatusBuilder {

        private Map<Date, String> billingMonths = new HashMap<>();

        public M3BillingStatusBuilder withAdditionalBillingData(Map<Date, String> billingMonths) {
            this.billingMonths = billingMonths;
            return this;
        }

        public M3BillingStatus build() {
            return new M3BillingStatus(billingMonths);
        }
    }
}
