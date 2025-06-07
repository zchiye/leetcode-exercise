package io.zchiye.leetcode.exercise.top150.arrays;

import java.util.Arrays;

public class Lc121MaxProfit {

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }
            int result = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int price = prices[i];
                if (price > min) {
                    result = Math.max(result, price - min);
                }
                if (price < min) {
                    min = price;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        testCase(new int[]{7, 1, 5, 3, 6, 4}, 5);
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
