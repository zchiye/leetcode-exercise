package io.zchiye.leetcode.exercise.top150arrays;

import java.util.Arrays;

public class Lc55CanJump {

    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return true;
            }
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (max < i) {
                    return false;
                }
                max = Math.max(max, i + nums[i]);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        testCase(new int[]{2, 3, 1, 1, 4}, true);
        testCase(new int[]{3, 2, 1, 0, 4}, false);
    }

    private static void testCase(int[] nums, boolean expect) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(nums));
        boolean result = solution.canJump(nums);
        System.out.println(result);
        System.out.println(result == expect);
    }

}
