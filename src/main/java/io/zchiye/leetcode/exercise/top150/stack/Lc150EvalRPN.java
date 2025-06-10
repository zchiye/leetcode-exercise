package io.zchiye.leetcode.exercise.top150.stack;

import io.zchiye.utils.TestCaseUtils;

import java.util.Arrays;

public class Lc150EvalRPN {

    static class Solution {
        public int evalRPN(String[] tokens) {
            if (tokens == null || tokens.length == 0) {
                return 0;
            }
            int size = 0;
            int[] values = new int[tokens.length];

            for (String token : tokens) {
                int v1, v2;
                switch (token) {
                    case "+":
                        v2 = values[--size];
                        v1 = values[--size];
                        values[size++] = v1 + v2;
                        break;
                    case "-":
                        v2 = values[--size];
                        v1 = values[--size];
                        values[size++] = v1 - v2;
                        break;
                    case "*":
                        v2 = values[--size];
                        v1 = values[--size];
                        values[size++] = v1 * v2;
                        break;
                    case "/":
                        v2 = values[--size];
                        v1 = values[--size];
                        values[size++] = v1 / v2;
                        break;
                    default:
                        values[size++] = Integer.parseInt(token);
                        break;
                }
            }

            return values[0];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCaseUtils.testCase(new String[]{"2", "1", "+", "3", "*"}, solution::evalRPN, 9, Arrays::toString);
        TestCaseUtils.testCase(new String[]{"4", "13", "5", "/", "+"}, solution::evalRPN, 6, Arrays::toString);
        TestCaseUtils.testCase(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, solution::evalRPN, 22, Arrays::toString);
    }
}
