package io.zchiye.leetcode.exercise.top150.arrays;

import java.util.Arrays;

public class Lc122MaxProfit {

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int result = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    result += (prices[i] - prices[i - 1]);
                } else {
//                    result += (prices[i - 1] - min);
                    min = prices[i];
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        testCase(new int[]{7, 1, 5, 3, 6, 4}, 7);
        testCase(new int[]{1, 2, 3, 4, 5}, 4);
        testCase(new int[]{7, 6, 4, 3, 1}, 0);
    }

    private static void testCase(int[] prices, int expect) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(prices));
        int result = solution.maxProfit(prices);
        System.out.println(result);
        System.out.println(result == expect);
    }

}
