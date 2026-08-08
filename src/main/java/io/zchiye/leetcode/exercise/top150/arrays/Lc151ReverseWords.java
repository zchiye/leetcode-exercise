package io.zchiye.leetcode.exercise.top150.arrays;

import io.zchiye.utils.test.OneInputTestCase;
import io.zchiye.utils.test.TestCase;

import java.util.List;

public class Lc151ReverseWords {

    static class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();
            int start = -1;
            int end = -1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    if (start != -1 && end != -1) {
                        if (!sb.isEmpty()) {
                            sb.append(' ');
                        }
                        sb.append(s.substring(start, end + 1));
                    }
                    start = -1;
                    end = -1;
                    continue;
                }
                if (end == -1) {
                    end = i;
                }
                start = i;
            }
            if (start != -1 && end != -1) {
                if (!sb.isEmpty()) {
                    sb.append(' ');
                }
                sb.append(s.substring(start, end + 1));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<OneInputTestCase.Params<String, String>> params = List.of(new OneInputTestCase.Params<>("the sky is blue", "blue is sky the"));
        TestCase testCase = new OneInputTestCase<>(params, solution::reverseWords);
        testCase.test();
    }

}
