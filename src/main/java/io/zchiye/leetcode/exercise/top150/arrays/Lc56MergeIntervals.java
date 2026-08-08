package io.zchiye.leetcode.exercise.top150.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lc56MergeIntervals {

    static public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int i = 0;
        List<int[]> list = new ArrayList<>();
        while (i < intervals.length) {
            int max = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= max) {
                max = Math.max(intervals[j][1], max);
                j++;
            }
            list.add(new int[]{intervals[i][0], max});
            i = j;
        }
        int[][] result = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
