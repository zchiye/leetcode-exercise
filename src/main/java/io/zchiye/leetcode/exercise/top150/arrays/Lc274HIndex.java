package io.zchiye.leetcode.exercise.top150.arrays;

import io.zchiye.utils.TestCaseUtils;

import java.util.Arrays;

public class Lc274HIndex {

    static class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int low = 0;
            int high = citations.length - 1;
            int max = Math.min(citations[0], citations.length);
            while (high >= low) {
                int mid = low + (high - low) / 2;
                int count = citations.length - mid;
                if (citations[mid] == count) {
                    return citations[mid];
                }
                if (citations[mid] > count) {
                    high = mid - 1;
                    max = Math.max(max, count);
                } else {
                    low = mid + 1;
                    max = Math.max(max, citations[mid]);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TestCaseUtils.testCase(new int[]{0, 0, 2}, s::hIndex, 1);
        TestCaseUtils.testCase(new int[]{3, 0, 6, 1, 5}, s::hIndex, 3);
        TestCaseUtils.testCase(new int[]{1, 3, 1}, s::hIndex, 1);
    }
}
