package io.zchiye.leetcode.exercise.top150arrays;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lc49GroupAnagrams {

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Group, List<String>> resultMap = new HashMap<>();
            for (String s : strs) {
                Group g = new Group(6, 7, s);
                resultMap.computeIfAbsent(g, k -> new ArrayList<>()).add(s);
            }
            return new ArrayList<>(resultMap.values());
        }

        class Group {
            long[] digits;
            int n;
            int unit;

            Group(int n, int unit, String str) {
                this.n = n;
                this.unit = unit;
                this.digits = new long[n];

                if (str == null || str.length() <= 0) {
                    return;
                }

                long[] times = new long[52];
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    int d = c - 'a';
                    if (d < 0) {
                        d = c - 'A' + 26;
                    }
                    times[d] += 1;
                }
                for (int i = 0; i < times.length; i++) {
                    int d = i % n;
                    this.digits[d] = this.digits[d] | (times[i] << ((i / n) * unit));
                }
            }

            @Override
            public int hashCode() {
                long r = 0;
                for (long digit : digits) {
                    r = r ^ digit;
                }
                return (int) r;
            }

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Group)) {
                    return false;
                }
                Group g2 = (Group) o;
                for (int i = 0; i < n; i++) {
                    if (i >= digits.length || i >= g2.digits.length || digits[i] != g2.digits[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "vmuFe", "zAmBe"};
        System.out.println(format(solution.groupAnagrams(input1)));

        int num = 30000;
        String[] input2 = new String[num];
        for (int i = 0; i < num; i++) {
            input2[i] = RandomStringUtils.secure().nextAlphabetic(7);
        }
        System.out.println(format(solution.groupAnagrams(input2)));
    }

    private static List<List<String>> format(List<List<String>> outputs) {
        return outputs.stream().filter(o -> o.size() > 1).collect(Collectors.toList());
    }

}
