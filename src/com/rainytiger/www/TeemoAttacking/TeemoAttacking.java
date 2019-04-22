package com.rainytiger.www.TeemoAttacking;

public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;
        int time = 0, i = 0, length = timeSeries.length;
        int left = timeSeries[i++];
        int right = left + duration;
        while (i < length) {
            if (right >= timeSeries[i]) right = timeSeries[i] + duration;
            else {
                time += right - left;
                left = timeSeries[i];
                right = left + duration;
            }
            i++;
        }
        return time + right - left;
    }
}
