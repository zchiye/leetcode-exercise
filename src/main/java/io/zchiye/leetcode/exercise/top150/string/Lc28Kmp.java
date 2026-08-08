package io.zchiye.leetcode.exercise.top150.string;

import java.util.Arrays;

public class Lc28Kmp {

    static class Solution {
        public int strStr(String haystack, String needle) {
            int[] next = getNext(needle);
            int i = 0, j = 0;
            for (; i < haystack.length(); i++) {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i - needle.length() + 1;
                }
            }
            return -1;
        }

        public int[] getNext(String needle) {
            int[] next = new int[needle.length()];
            next[0] = 0;
            int j = 0;
            for (int i = 1; i < next.length; i++) {
                while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                    j = next[j - 1];
                }
                if (needle.charAt(j) == needle.charAt(i)) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String p = "issip";
        int[] next = s.getNext(p);
        System.out.println(Arrays.toString(next));
        int result = s.strStr("mississippi", p);
        System.out.println(result);
    }
}
