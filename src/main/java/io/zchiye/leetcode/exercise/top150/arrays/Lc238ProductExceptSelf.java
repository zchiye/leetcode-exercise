package io.zchiye.leetcode.exercise.top150.arrays;

import io.zchiye.utils.ArrayUtils;
import io.zchiye.utils.TestCaseUtils;

public class Lc238ProductExceptSelf {

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] prefix = new int[nums.length];
            int[] suffix = new int[nums.length];
            prefix[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = prefix[i - 1] * nums[i - 1];
            }
            suffix[nums.length - 1] = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                suffix[i] = suffix[i + 1] * nums[i + 1];
            }
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                res[i] = prefix[i] * suffix[i];
            }
            return res;
        }

        public int[] productExceptSelfO1(int[] nums) {
            int[] answer =  new int[nums.length];
            answer[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                answer[i] = answer[i - 1] * nums[i - 1];
            }
            int right = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                answer[i] = answer[i] * right;
                right *= nums[i];
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TestCaseUtils.testCaseEq(new int[]{1, 2, 3, 4}, s::productExceptSelfO1, new int[]{24, 12, 8, 6}, ArrayUtils::equals);
    }
}
