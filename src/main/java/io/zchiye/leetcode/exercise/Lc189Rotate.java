package io.zchiye.leetcode.exercise;

import java.util.Arrays;

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
    }

    public static void main(String[] args) {
        testCase(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        testCase(new int[]{-1, -100, 3, 99}, 2);
        testCase(new int[]{-1}, 2);
        testCase(new int[]{1, 2}, 3);
    }

    private static void testCase(int[] nums, int k) {
        Solution solution = new Solution();
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
