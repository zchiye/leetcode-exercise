package io.zchiye.leetcode.exercise.top150.hash;

import java.util.HashMap;
import java.util.Map;

public class Lc128LongestConsecutive {

    static public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            int leftBound = map.getOrDefault(num - 1, 0);
            int rightBound = map.getOrDefault(num + 1, 0);
            int len = leftBound + rightBound + 1;
            res = Math.max(res, len);
            if (leftBound == 0 && rightBound == 0) {
                map.put(num, 1);
            } else if (leftBound == 0) {
                map.put(num, len);
                map.put(num + len - 1, len);
            } else if (rightBound == 0) {
                map.put(num, len);
                map.put(num - len + 1, len);
            } else {
                map.put(num + rightBound, len);
                map.put(num - leftBound, len);
                map.put(num, len);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 2, 4, 5, 3, 0, 3, 6, 7}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2}));
    }
}
