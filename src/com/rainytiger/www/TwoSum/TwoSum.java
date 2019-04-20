package com.rainytiger.www.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        int[] ret = new int[2];
        for (int n : nums) {
            if ((ret[0] = map.getOrDefault(target - n, -1)) != -1) {
                ret[1] = index;
                return ret;
            }
            map.put(n, index++);
        }
        return null;
    }
}
