package io.zchiye.leetcode.exercise;

import java.util.Arrays;

public class Lc88MergeSorted {

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i1 = m - 1;
            int i2 = n - 1;

            for (int i = nums1.length - 1; i >= 0; i--) {
                if (i2 < 0) {
                    break;
                }
                if (i1 < 0) {
                    nums1[i] = nums2[i2--];
                    continue;
                }
                int num1 = nums1[i1];
                int num2 = nums2[i2];
                if (num2 > num1) {
                    nums1[i] = num2;
                    i2--;
                } else {
                    nums1[i] = num1;
                    i1--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{0};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;
        solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
