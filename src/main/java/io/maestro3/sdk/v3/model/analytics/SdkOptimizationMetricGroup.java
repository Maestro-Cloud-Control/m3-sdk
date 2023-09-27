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

import java.util.ArrayList;
import java.util.List;

public class SdkOptimizationMetricGroup {

    private int lessThanTen;
    private int tenToThirty;
    private int thirtyToFifty;
    private int fiftyToSeventy;
    private int seventyToNinety;
    private int moreThanNinety;

    private List<String> lessThanTenInstancesIds = new ArrayList<>();
    private List<String> tenToThirtyInstancesIds = new ArrayList<>();
    private List<String> thirtyToFiftyInstancesIds = new ArrayList<>();
    private List<String> fiftyToSeventyInstancesIds = new ArrayList<>();
    private List<String> seventyToNinetyInstancesIds = new ArrayList<>();
    private List<String> moreThanNinetyInstancesIds = new ArrayList<>();

    public int getLessThanTen() {
        return lessThanTen;
    }

    public void setLessThanTen(int lessThanTen) {
        this.lessThanTen = lessThanTen;
    }

    public int getTenToThirty() {
        return tenToThirty;
    }

    public void setTenToThirty(int tenToThirty) {
        this.tenToThirty = tenToThirty;
    }

    public int getThirtyToFifty() {
        return thirtyToFifty;
    }

    public void setThirtyToFifty(int thirtyToFifty) {
        this.thirtyToFifty = thirtyToFifty;
    }

    public int getFiftyToSeventy() {
        return fiftyToSeventy;
    }

    public void setFiftyToSeventy(int fiftyToSeventy) {
        this.fiftyToSeventy = fiftyToSeventy;
    }

    public int getSeventyToNinety() {
        return seventyToNinety;
    }

    public void setSeventyToNinety(int seventyToNinety) {
        this.seventyToNinety = seventyToNinety;
    }

    public int getMoreThanNinety() {
        return moreThanNinety;
    }

    public void setMoreThanNinety(int moreThanNinety) {
        this.moreThanNinety = moreThanNinety;
    }

    public List<String> getLessThanTenInstancesIds() {
        return lessThanTenInstancesIds;
    }

    public void setLessThanTenInstancesIds(List<String> lessThanTenInstancesIds) {
        this.lessThanTenInstancesIds = lessThanTenInstancesIds;
    }

    public List<String> getTenToThirtyInstancesIds() {
        return tenToThirtyInstancesIds;
    }

    public void setTenToThirtyInstancesIds(List<String> tenToThirtyInstancesIds) {
        this.tenToThirtyInstancesIds = tenToThirtyInstancesIds;
    }

    public List<String> getThirtyToFiftyInstancesIds() {
        return thirtyToFiftyInstancesIds;
    }

    public void setThirtyToFiftyInstancesIds(List<String> thirtyToFiftyInstancesIds) {
        this.thirtyToFiftyInstancesIds = thirtyToFiftyInstancesIds;
    }

    public List<String> getFiftyToSeventyInstancesIds() {
        return fiftyToSeventyInstancesIds;
    }

    public void setFiftyToSeventyInstancesIds(List<String> fiftyToSeventyInstancesIds) {
        this.fiftyToSeventyInstancesIds = fiftyToSeventyInstancesIds;
    }

    public List<String> getSeventyToNinetyInstancesIds() {
        return seventyToNinetyInstancesIds;
    }

    public void setSeventyToNinetyInstancesIds(List<String> seventyToNinetyInstancesIds) {
        this.seventyToNinetyInstancesIds = seventyToNinetyInstancesIds;
    }

    public List<String> getMoreThanNinetyInstancesIds() {
        return moreThanNinetyInstancesIds;
    }

    public void setMoreThanNinetyInstancesIds(List<String> moreThanNinetyInstancesIds) {
        this.moreThanNinetyInstancesIds = moreThanNinetyInstancesIds;
    }
}
