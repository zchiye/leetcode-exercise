package io.zchiye.leetcode.exercise.top150.slidingwindow;

import java.util.Arrays;

public class Lc209MinSizeSubarraySum {

    static class Solution {

        public int minSubArrayLen(int target, int[] nums) {
            // 长度最小 子数组的长度
            int left = 0;
            int ans = Integer.MAX_VALUE;
            int sum = 0;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];

                while (sum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }

        public int minSubArrayLen1(int target, int[] nums) {
            if (nums.length == 1) {
                return nums[0] >= target ? 1 : 0;
            }
            int left = 0, right = 0;
            int min = 0;
            int sum = nums[left];

            while (left <= right) {
                if (sum >= target) {
                    int len = right - left + 1;
                    min = min == 0 ? len : Math.min(min, len);
                    if (min == 1) {
                        return min;
                    }
                }

                if (sum > target) {
                    sum -= nums[left];
                    left++;
                } else {
                    if (right == nums.length - 1) {
                        return min;
                    }
                    if (sum == target) {
                        sum -= nums[left];
                        left++;
                    }
                    right++;
                    sum += nums[right];
                }
            }

            return min;
        }

        public int minSubArrayLen2(int target, int[] nums) {
            // 理解错了，子数组需要不改变原来的顺序，且连续
            Arrays.sort(nums);
            int right = nums.length - 1;
            int left = nums.length - 2;
            int sum = nums[right];
            while (sum < target && left >= 0) {
                sum += nums[left];
                left--;
            }
            return left >= 0 ? right - left : (sum >= target ? right - left : 0);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
