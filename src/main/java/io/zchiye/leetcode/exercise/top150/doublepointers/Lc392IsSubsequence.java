package io.zchiye.leetcode.exercise.top150.doublepointers;

import io.zchiye.utils.TestCaseUtils;

public class Lc392IsSubsequence {

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s == null || s.isEmpty()) {
                return true;
            }
            char[] cs1 = s.toCharArray();
            char[] cs2 = t.toCharArray();

            int i2 = 0;
            for (char c1 : cs1) {
                boolean flag = false;
                for (int i = i2; i < cs2.length; i++) {
                    char c2 = cs2[i];
                    if (c1 == c2) {
                        i2 = i + 1;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TestCaseUtils.testCase("abc", "ahbgdc", solution::isSubsequence, true);
        TestCaseUtils.testCase("axc", "ahbgdc", solution::isSubsequence, false);
    }

}
