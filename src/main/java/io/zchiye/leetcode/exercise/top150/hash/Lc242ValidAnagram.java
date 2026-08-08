package io.zchiye.leetcode.exercise.top150.hash;

public class Lc242ValidAnagram {

    static public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt =  new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (cnt[c - 'a']<= 0) {
                return false;
            }
            cnt[c - 'a']--;
        }
        return true;
    }
}
