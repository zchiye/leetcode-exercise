package io.zchiye.leetcode.exercise.top150.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Lc76MinWindowSubstring {

    static public String minWindow(String s, String t) {
        int[] arr = new int[128];
        Set<Character> set = new HashSet<>();
        for (char c : t.toCharArray()) {
            arr[c]++;
            set.add(c);
        }
        int target = t.length();
        int left = 0;
        int cur = 0;
        String ans = "";
        char[] ss = s.toCharArray();
        for (int right = 0; right < ss.length; right++) {
            char c = ss[right];
            if (arr[c] > 0) {
                arr[c]--;
                cur++;
            }
            while (left <= right && cur >= target) {
                char c1 = ss[left];
                if (set.contains(c1)) {
                    cur--;
                    arr[c1]++;
                }
                left++;
            }
            // TODO
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
