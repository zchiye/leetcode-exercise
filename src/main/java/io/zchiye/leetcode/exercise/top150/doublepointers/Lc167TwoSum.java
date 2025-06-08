package io.zchiye.leetcode.exercise.top150.doublepointers;

import io.zchiye.utils.TestCaseUtils;

import java.util.Arrays;

public class Lc167TwoSum {

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i1 = 1;
            int i2 = numbers.length;
            while (i2 > i1) {
                int s = numbers[i1 - 1] + numbers[i2 - 1];
                if (s > target) {
                    i2--;
                } else if (s < target) {
                    i1++;
                } else {
                    break;
                }
            }
            return new int[]{i1, i2};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCaseUtils.testCase(new int[]{2, 7, 11, 15}, 9, solution::twoSum, new int[]{1, 2}, Arrays::toString, null, Arrays::toString);
        TestCaseUtils.testCase(new int[]{2, 3, 4}, 6, solution::twoSum, new int[]{1, 3}, Arrays::toString, null, Arrays::toString);
        TestCaseUtils.testCase(new int[]{-1, 0}, -1, solution::twoSum, new int[]{1, 2}, Arrays::toString, null, Arrays::toString);
    }
}
