package io.zchiye.leetcode.exercise.top150.arrays;

import io.zchiye.utils.test.OneInputTestCase;
import io.zchiye.utils.test.TestCase;

import java.util.Arrays;
import java.util.List;

public class Lc135Candy {

    static class Solution {
        public int candy(int[] ratings) {
            int total = 1;
            int last = ratings[0];
            int cur = 1;
            boolean desc = false;
            int descStart = 0;
            int descMax = 0;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > last) {
                    cur++;
                    desc = false;
                } else if (ratings[i] == last) {
                    cur = 1;
                    desc = false;
                } else {
                    if (!desc) {
                        desc = true;
                        descStart = i - 1;
                        descMax = cur;
                    }
                    if (i - descStart + 1 > descMax) {
                        total += i - descStart;
                    } else {
                        total += i - descStart - 1;
                    }
                    cur = 1;
                }
                total += cur;
                last = ratings[i];
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<OneInputTestCase.Params<int[], Integer>> params = List.of(
                new OneInputTestCase.Params<int[], Integer>(new int[]{1, 0, 2}, 5),
                new OneInputTestCase.Params<int[], Integer>(new int[]{0, 1, 2, 7, 6, 5, 4, 3}, 21),
                new OneInputTestCase.Params<int[], Integer>(new int[]{1, 2, 2}, 4)
        );
        TestCase testCase = new OneInputTestCase<int[], Integer>(params, s::candy, Arrays::toString, null, null);
        testCase.test();
    }
}
