package io.zchiye.leetcode.exercise.top150.doublepointers;

import io.zchiye.utils.TestCaseUtils;

import java.util.Arrays;

public class Lc11MaxArea {

    static class Solution {
        public int maxArea(int[] height) {
            if (height == null || height.length <= 1) {
                return 0;
            }
            int i1 = 0;
            int i2 = height.length - 1;
            int max = 0;
            while (i2 > i1) {
                max = Math.max(max, area(height, i1, i2));
                int cur1 = height[i1];
                int cur2 = height[i2];
                if (cur1 >= cur2) {
                    for (i2--; i2 > i1; i2--) {
                        if (height[i2] > cur2) {
                            break;
                        }
                    }
                } else {
                    for (i1++; i1 < i2; i1++) {
                        if (height[i1] > cur1) {
                            break;
                        }
                    }
                }
            }
            return max;
        }

        private int area(int[] height, int i1, int i2) {
            if (i2 <= i1) {
                return 0;
            }
            return Math.min(height[i1], height[i2]) * (i2 - i1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCaseUtils.testCase(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, solution::maxArea, 49, Arrays::toString);
        TestCaseUtils.testCase(new int[]{1, 1}, solution::maxArea, 1, Arrays::toString);
    }
}
