package com.adolfoeloy.array;

/**
 * Easy two-pointers problem.
 */
class RemoveElement {
    public int removeElement(int[] nums, int val) {
        var read = 0;
        var write = 0;
        while (read < nums.length) {
            if (nums[read] != val) {
                nums[write++] = nums[read++];
            } else {
                read++;
            }
        }
        return write;
    }

}