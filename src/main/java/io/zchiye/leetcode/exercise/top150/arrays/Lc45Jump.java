package io.zchiye.leetcode.exercise.top150.arrays;

import io.zchiye.utils.TestCaseUtils;

import java.util.Arrays;

public class Lc45Jump {

    static class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return 0;
            }
            int cur = 1;
            int next = 1;
            int max = nums[0];
            while (max < nums.length - 1) {
                int target = Math.min(max, nums.length - 1);
                for (int i = next; i <= target; i++) {
                    int num = i + nums[i];
                    max = Math.max(max, num);
                }
                cur++;
                next = target + 1;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCaseUtils.testCase(new int[]{2, 3, 1, 1, 4}, solution::jump, 2, Arrays::toString);
        TestCaseUtils.testCase(new int[]{2, 3, 0, 1, 4}, solution::jump, 2, Arrays::toString);
        TestCaseUtils.testCase(new int[]{1, 2, 3}, solution::jump, 2, Arrays::toString);
        TestCaseUtils.testCase(new int[]{1, 1, 1, 1}, solution::jump, 3, Arrays::toString);
    }

}
