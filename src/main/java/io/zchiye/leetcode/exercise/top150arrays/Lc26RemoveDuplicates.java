package io.zchiye.leetcode.exercise.top150arrays;

import java.util.Arrays;

public class Lc26RemoveDuplicates {

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int result = 0;
            if (nums.length <= 0) {
                return result;
            }
            int last = nums[result++];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != last) {
                    nums[result++] = nums[i];
                }
                last = nums[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        testCase(new int[]{1, 1, 2});
        testCase(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    private static void testCase(int[] nums) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
