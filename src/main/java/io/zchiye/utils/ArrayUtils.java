package io.zchiye.utils;

import java.util.List;

public class ArrayUtils {

    public static boolean equals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end && end < nums.length) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void printStringLines(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
