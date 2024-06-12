package com.adolfoeloy.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (idx.containsKey(c) && idx.get(c) != i) {
                return new int[] { idx.get(c), i };
            } else {
                idx.put(nums[i], i);
            }
        }
        return null;
    }
}
