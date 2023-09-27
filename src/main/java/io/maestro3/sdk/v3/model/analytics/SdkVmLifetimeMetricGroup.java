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

package io.maestro3.sdk.v3.model.analytics;

public class SdkVmLifetimeMetricGroup {

    private int lastWeek;
    private int lastMonth;
    private int fromOneToThreeMonth;
    private int fromThreeToSixMonth;
    private int fromSixToTwelveMonth;
    private int moreThanYear;
    private int totalAmount;

    public int getLastWeek() {
        return lastWeek;
    }

    public void setLastWeek(int lastWeek) {
        this.lastWeek = lastWeek;
    }

    public int getLastMonth() {
        return lastMonth;
    }

    public void setLastMonth(int lastMonth) {
        this.lastMonth = lastMonth;
    }

    public int getFromOneToThreeMonth() {
        return fromOneToThreeMonth;
    }

    public void setFromOneToThreeMonth(int fromOneToThreeMonth) {
        this.fromOneToThreeMonth = fromOneToThreeMonth;
    }

    public int getFromThreeToSixMonth() {
        return fromThreeToSixMonth;
    }

    public void setFromThreeToSixMonth(int fromThreeToSixMonth) {
        this.fromThreeToSixMonth = fromThreeToSixMonth;
    }

    public int getFromSixToTwelveMonth() {
        return fromSixToTwelveMonth;
    }

    public void setFromSixToTwelveMonth(int fromSixToTwelveMonth) {
        this.fromSixToTwelveMonth = fromSixToTwelveMonth;
    }

    public int getMoreThanYear() {
        return moreThanYear;
    }

    public void setMoreThanYear(int moreThanYear) {
        this.moreThanYear = moreThanYear;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
