package io.zchiye.leetcode.exercise.top150.arrays;

import io.zchiye.utils.ArrayUtils;
import io.zchiye.utils.TestCaseUtils;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Lc189Rotate {

    static class Solution {
        public void rotate(int[] nums, int k) {
            int total = nums.length;
            int count = 0;
            int start = 0;
            while (count < total) {
                int cur = start;
                int next = (cur + k) % nums.length;
                int temp;
                int last = nums[cur];
                while (next != start) {
                    temp = nums[next];
                    nums[next] = last;
                    last = temp;
                    count++;
                    next = (next + k) % nums.length;
                }
                nums[next] = last;
                count++;
                start++;
            }
        }

        public void rotateUseReverse(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end && end < nums.length) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input1 = {1, 2, 3, 4, 5, 6, 7};
        int[] expect1 = {5, 6, 7, 1, 2, 3, 4};
        TestCaseUtils.testCaseVoid(input1, 3, s::rotateUseReverse, expect1, Arrays::toString, null, ArrayUtils::equals);

        int[] input2 = {1,2,3};
        int[] expect2 = {3,1,2};
        TestCaseUtils.testCaseVoid(input2, 4, s::rotateUseReverse, expect2, Arrays::toString, null, ArrayUtils::equals);
//        testCase(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
//        testCase(new int[]{-1, -100, 3, 99}, 2);
//        testCase(new int[]{-1}, 2);
//        testCase(new int[]{1, 2}, 3);
    }

    private static void testCase(int[] nums, int k) {
        Solution solution = new Solution();
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
