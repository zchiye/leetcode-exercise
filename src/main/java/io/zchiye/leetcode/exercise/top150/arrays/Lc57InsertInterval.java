package io.zchiye.leetcode.exercise.top150.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc57InsertInterval {

    static public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> list = new ArrayList<>();
        int min =  newInterval[0];
        int max = newInterval[1];
        boolean flag = false;
        while (i < intervals.length) {
            if (!flag && intervals[i][0] > newInterval[1]) {
                list.add(new int[]{newInterval[0], newInterval[1]});
                flag = true;
                continue;
            }
            if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
                list.add(intervals[i]);
                i++;
                continue;
            }
            min = Math.min(intervals[i][0], newInterval[0]);
            max = Math.max(intervals[i][1], newInterval[1]);
            while (i + 1 < intervals.length && intervals[i + 1][0] <= max) {
                i++;
            }
            max = Math.max(max, intervals[i][1]);
            list.add(new int[]{min, max});
            flag = true;
            i++;
        }
        if (!flag) {
            list.add(new int[]{min, max});
        }

        int[][] result = new int[list.size()][2];
        for (i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{};
//                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = new int[]{4, 8};
        int[][] result = insert(intervals, newInterval);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }
}
