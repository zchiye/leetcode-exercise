package io.zchiye.leetcode.exercise.top150.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Lc453MinArrowNumber {

    static public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(i -> i[0]));
        int count = 1;
        int left = points[0][0];
        int right = points[0][1];
        int i = 1;
        while (i < points.length) {
            // 因为已经按照左边界排过序了，所以其实只需要比较右边界，可以减少比较次数
            if (points[i][0] <= right && points[i][1] >= left) {
                left = Math.max(left, points[i][0]);
                right = Math.min(right, points[i][1]);
            } else {
                count++;
                left = points[i][0];
                right = points[i][1];
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
