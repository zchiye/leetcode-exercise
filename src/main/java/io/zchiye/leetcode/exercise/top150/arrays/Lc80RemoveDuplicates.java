package io.zchiye.leetcode.exercise.top150.arrays;

import java.util.Arrays;

public class Lc80RemoveDuplicates {

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int result = 0;
            if (nums.length <= 0) {
                return result;
            }

            boolean hasSame = false;
            int last = nums[result++];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if (num == last) {
                    if (!hasSame) {
                        hasSame = true;
                        nums[result++] = num;
                    }
                } else {
                    hasSame = false;
                    nums[result++] = num;
                }
                last = num;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        testCase(new int[]{1, 1, 1, 2, 2, 3});
        testCase(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
    }

    private static void testCase(int[] nums) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
