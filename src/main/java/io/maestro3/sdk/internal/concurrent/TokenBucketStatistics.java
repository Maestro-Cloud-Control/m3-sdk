/*
 * Copyright 2024 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.internal.concurrent;

public class TokenBucketStatistics {

    private final int corePoolSize;
    private final TokenBucket.BucketStatistics statistics;

    TokenBucketStatistics(int corePoolSize, TokenBucket.BucketStatistics statistics) {
        this.corePoolSize = corePoolSize;
        this.statistics = statistics;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public long getTotalSubmittedTasksCnt() {
        return statistics.getTotalSubmittedTasksCnt();
    }

    public long getStillRunningTasksCnt() {
        return statistics.getStillRunningTasksCnt();
    }

    public long getTotalFinishedTasksCnt() {
        return statistics.getTotalFinishedTasksCnt();
    }

    public long getTotalTasksDuration() {
        return statistics.getTotalTasksDuration();
    }

    public long getAvgDuration() {
        return statistics.getAvgDuration();
    }

    public long getMinDuration() {
        return statistics.getMinDuration();
    }

    public long getMaxDuration() {
        return statistics.getMaxDuration();
    }

    public long getPotentiallyLeaked() {
        return statistics.getPotentiallyLeaked();
    }
}
