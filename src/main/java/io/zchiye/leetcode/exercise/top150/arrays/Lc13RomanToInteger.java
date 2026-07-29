package io.zchiye.leetcode.exercise.top150.arrays;

import io.zchiye.utils.test.OneInputTestCase;
import io.zchiye.utils.test.TestCase;

import java.util.List;

public class Lc13RomanToInteger {

    static class Solution {
        public int romanToInt(String s) {
            int total = 0;
            char lastChar = ' ';
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                switch (ch) {
                    case 'I':
                        total += 1;
                        break;
                    case 'V':
                        total += lastChar == 'I' ? 3 : 5;
                        break;
                    case 'X':
                        total += lastChar == 'I' ? 8 : 10;
                        break;
                    case 'L':
                        total += lastChar == 'X' ? 30 : 50;
                        break;
                    case 'C':
                        total += lastChar == 'X' ? 80 : 100;
                        break;
                    case 'D':
                        total += lastChar == 'C' ? 300 : 500;
                        break;
                    case 'M':
                        total += lastChar == 'C' ? 800 : 1000;
                        break;
                }
                lastChar = ch;
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<OneInputTestCase.Params<String, Integer>> params = List.of(
                new OneInputTestCase.Params<>("III", 3),
                new OneInputTestCase.Params<>("IV", 4),
                new OneInputTestCase.Params<>("IX", 9),
                new OneInputTestCase.Params<>("LVIII", 58),
                new OneInputTestCase.Params<>("MCMXCIV", 1994)
        );
        TestCase testCase = new OneInputTestCase<>(params, s::romanToInt, null, null, null);
        testCase.test();
    }
}
