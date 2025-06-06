package io.zchiye.leetcode.exercise;

import java.util.Arrays;

public class Lc80RemoveDuplicates {

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int result = 0;

            boolean hasSame = false;
            int last = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (last == Integer.MAX_VALUE) {
                    nums[result++] = num;
                    last = num;
                    continue;
                }
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
