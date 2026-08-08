package io.zchiye.leetcode.exercise.top150.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Lc3LongestSubstringWithoutRepeating {

    static public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty())
            return 0;
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int ans = 1;
        int left = 0, right = 1;
        while (right < arr.length) {
            char c = arr[right];
            int lastC = map.getOrDefault(c, -1);
            map.put(c, right);
            if (lastC >= left) {
                ans = Math.max(ans, right - left);
                left = lastC + 1;
            }
            right++;
            if (right == arr.length) {
                ans = Math.max(ans, right - left);
            }
        }

        return ans;
    }

    static public int lengthOfLongestSubstring1(String S) {
        char[] s = S.toCharArray(); // 转换成 char[] 加快效率（忽略带来的空间消耗）
        int n = s.length;
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128]; // 也可以用 HashMap<Character, Integer>，这里为了效率用的数组
        for (int right = 0; right < n; right++) {
            char c = s[right];
            cnt[c]++;
            while (cnt[c] > 1) { // 窗口内有重复字母
                cnt[s[left]]--; // 移除窗口左端点字母
                left++; // 缩小窗口
            }
            ans = Math.max(ans, right - left + 1); // 更新窗口长度最大值
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("eea"));
    }
}
