package io.zchiye.leetcode.exercise.top150.arrays;

import io.zchiye.utils.test.TestCase;
import io.zchiye.utils.test.TwoInputTestCase;

import java.util.Arrays;
import java.util.List;

public class Lc134GasStationCanCompleteCircuit {

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int i = 0;
            while (i < n) {
                int count = 0;
                int totalGas = 0;
                int totalCost = 0;
                while (count < n) {
                    int j = (i + count) % n;
                    totalGas += gas[j];
                    totalCost += cost[j];
                    if (totalGas < totalCost) {
                        break;
                    }
                    count++;
                }
                if (count == n) {
                    return i;
                }
                i = i + count + 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TwoInputTestCase.Params<int[], int[], Integer>> params = List.of(
                new TwoInputTestCase.Params<>(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3),
                new TwoInputTestCase.Params<>(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1)
        );
        TestCase testCase = new TwoInputTestCase<>(params, solution::canCompleteCircuit, Arrays::toString, Arrays::toString, null, null);
        testCase.test();
    }
}
