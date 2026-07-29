package io.zchiye.leetcode.exercise.top150.arrays;

import io.zchiye.utils.test.OneInputTestCase;
import io.zchiye.utils.test.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Lc42TrappingRainWater {

    static class Solution {
        public int trap(int[] height) {
            int[] leftMaxHeight = new int[height.length];
            leftMaxHeight[0] = 0;
            int cur = height[0];
            for (int i = 1; i < height.length; i++) {
                leftMaxHeight[i] = cur;
                if (height[i] > cur) {
                    cur = height[i];
                }
            }

            int[] rightMaxHeight = new int[height.length];
            rightMaxHeight[height.length - 1] = 0;
            cur = height[height.length - 1];
            for (int i = height.length - 2; i >= 0; i--) {
                rightMaxHeight[i] = cur;
                if (height[i] > cur) {
                    cur = height[i];
                }
            }

            int total = 0;
            for (int i = 1; i < height.length - 1; i++) {
                int maxHeight = Math.min(leftMaxHeight[i], rightMaxHeight[i]);
                if (maxHeight > height[i]) {
                    total += maxHeight - height[i];
                }
            }
            return total;
        }

        public int trapStack(int[] height) {
            int total = 0;
            Stack<Integer> s = new Stack<>();   //  栈内元素需要保持递减
            s.push(0);
            for (int i = 1; i < height.length; i++) {
                while (!s.empty() && height[s.peek()] < height[i]) {
                    int curHeight = s.pop();
                    if (s.empty())
                        break;
                    int rheight = Math.min(height[i], height[s.peek()]) - height[curHeight];
                    int distance = i - s.peek() - 1;
                    total += rheight * distance;
                }
                s.push(i);
            }
            return total;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<OneInputTestCase.Params<int[], Integer>> params = List.of(
                new OneInputTestCase.Params<int[], Integer>(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                new OneInputTestCase.Params<int[], Integer>(new int[]{4, 2, 0, 3, 2, 5}, 9)
//                new OneInputTestCase.Params<int[], Integer>(new int[]{1, 2, 2}, 4)
        );
        TestCase testCase = new OneInputTestCase<int[], Integer>(params, s::trapStack, Arrays::toString, null, null);
        testCase.test();
    }
}
