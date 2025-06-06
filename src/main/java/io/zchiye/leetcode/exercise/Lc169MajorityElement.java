package io.zchiye.leetcode.exercise;

import java.util.Arrays;

public class Lc169MajorityElement {

    static class Solution {
        public int majorityElement(int[] nums) {
            int maj = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count <= 0) {
                    maj = nums[i];
                    count = 1;
                    continue;
                }
                if (nums[i] == maj) {
                    count++;
                } else {
                    count--;
                }
            }
            return maj;
        }
    }

    public static void main(String[] args) {
        testCase(new int[]{3, 2, 3});
        testCase(new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    private static void testCase(int[] nums) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.majorityElement(nums));
    }
}
