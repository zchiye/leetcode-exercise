package io.zchiye.leetcode.exercise.top150.doublepointers;

import io.zchiye.utils.TestCaseUtils;

public class Lc125IsPalindrome {

    static class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return true;
            }
            char[] cs = s.toCharArray();
            int start = 0;
            int end = cs.length - 1;
            while (start < end) {
                char c1 = toLower(cs[start]);
                char c2 = toLower(cs[end]);
                if (c1 == ' ') {
                    start++;
                } else if (c2 == ' ') {
                    end--;
                } else if (c1 != c2) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }
            return true;
        }

        static char toLower(char c) {
            if ((c >= '0' && c <= '9')
                    || (c >= 'a' && c <= 'z')) {
                return c;
            }
            if (c >= 'A' && c <= 'Z') {
                return (char) (c + 32);
            }
            return ' ';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCaseUtils.testCase("A man, a plan, a canal: Panama", solution::isPalindrome, true);
        TestCaseUtils.testCase(" ", solution::isPalindrome, true);
        TestCaseUtils.testCase("race a car", solution::isPalindrome, false);
    }
}
