package io.zchiye.leetcode.exercise.top150arrays;

import java.util.Arrays;

public class Lc27RemoveElement {

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int result = 0;
            int left = 0;
            int right = nums.length - 1;

            while (right >= left) {
                if (nums[left] == val) {
                    while (right > left && nums[right] == val) {
                        right--;
                    }
                    if (right > left) {
                        nums[left] = nums[right];
                        right--;
                        left++;
                        result++;
                    } else {
                        break;
                    }
                } else {
                    left++;
                    result++;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,2,3};
        System.out.println(solution.removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

}
