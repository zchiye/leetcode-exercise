package io.zchiye.leetcode.exercise.top150.string;

import io.zchiye.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Lc68TextJustification {

    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> res = new ArrayList<>();
            int start = 0;
            int curLength = 0;
            for (int i = 0; i < words.length; i++) {
                if (curLength + words[i].length() + i - start > maxWidth) {
                    res.add(concatLine(words, maxWidth, start, i, curLength, false));
                    start = i;
                    curLength = words[i].length();
                } else {
                    curLength += words[i].length();
                }
            }
            res.add(concatLine(words, maxWidth, start, words.length, curLength, true));
            return res;
        }

        public String concatLine(String[] words, int maxWidth, int start, int end, int curLength, boolean isLastLine) {
            int spaces = end - start - 1;
            int single = isLastLine ? 1 : (spaces > 0 ? (maxWidth - curLength) / spaces : 0);
            int append = isLastLine ? 0 : (spaces > 0 ? (maxWidth - curLength) % spaces : 0);
            StringBuilder sb = new StringBuilder();
            for (int i = start, j = 0; i < end; i++, j++) {
                if (j > 0) {
                    sb.append(" ".repeat(j <= append ? single + 1 : single));
                }
                sb.append(words[i]);
            }
            if (sb.length() < maxWidth) {
                sb.append(" ".repeat(maxWidth - sb.length()));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String[] texts = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth = 16;
        Solution solution = new Solution();
        ArrayUtils.printStringLines(solution.fullJustify(texts, maxWidth));
    }
}
