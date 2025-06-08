package io.zchiye.leetcode.exercise.top150.slidingwindow;

import io.zchiye.utils.TestCaseUtils;

import java.util.Arrays;

public class Lc269MinSubArrayLen {

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            if (nums[0] >= target) {
                return 1;
            } else if (nums.length == 1) {
                return 0;
            }

            int i1 = 0;
            int i2 = 1;
            int sum = nums[0] + nums[1];
            int min = 0;

            while (i2 < nums.length && i1 < nums.length) {
                if (sum == target) {
                    min = min == 0 ? i2 - i1 + 1 : Math.min(min, i2 - i1 + 1);
                    if (i1 < nums.length - 1 && i2 < nums.length - 1) {
                        sum = sum + nums[i2 + 1] - nums[i1];
                    }
                    i1++;
                    i2++;
                } else if (sum < target) {
                    if (i2 < nums.length - 1) {
                        sum = sum + nums[i2 + 1];
                    }
                    i2++;
                } else {
                    min = min == 0 ? i2 - i1 + 1 : Math.min(min, i2 - i1 + 1);
                    sum = sum - nums[i1];
                    i1++;
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCaseUtils.testCase(7, new int[]{2, 3, 1, 2, 4, 3}, solution::minSubArrayLen, 2, null, Arrays::toString, null);
        TestCaseUtils.testCase(4, new int[]{1, 4, 4}, solution::minSubArrayLen, 1, null, Arrays::toString, null);
        TestCaseUtils.testCase(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}, solution::minSubArrayLen, 0, null, Arrays::toString, null);
        TestCaseUtils.testCase(11, new int[]{1, 2, 3, 4, 5}, solution::minSubArrayLen, 3, null, Arrays::toString, null);
    }

}
