package io.zchiye.leetcode.exercise.top150.tree;

import io.zchiye.utils.TestCaseUtils;

public class Lc104MaxDepth {

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree1 = TreeNode.buildFromArray(new Integer[]{3, 9, 20, null, null, 15, 7});
        TestCaseUtils.testCase(tree1, solution::maxDepth, 3, TreeUtils::toString);
        TreeNode tree2 = TreeNode.buildFromArray(new Integer[]{1, null, 2});
        TestCaseUtils.testCase(tree2, solution::maxDepth, 2, TreeUtils::toString);
    }

}
